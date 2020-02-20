
#include "cuda_runtime.h"
#include "device_launch_parameters.h"
#include "cuda.h"
#include "./common/book.h"
#include <stdio.h>

#define FILA 16
#define COLUMNA 16
#define DIMENSION FILA*COLUMNA


__global__ void operacionMatriz(int* matriz, int* matrizRes) {

	int posicion = threadIdx.x * FILA + threadIdx.y;
	int* valor = matriz + posicion;
	int* valorRes = matrizRes + posicion;

	//Primera fila -> no se puede sumar arriba
	if (threadIdx.x==0) {
		//POS 0x0 solo sumamos abajo y derecha
		if (threadIdx.y==0){
			*valorRes = *valor + *(valor + 1) + *(valor + FILA);
		}
		//POS 0xcolumnaFinal solo sumamos izquierda y debajo
		else if (threadIdx.y == (COLUMNA - 1)) {
			*valorRes = *valor + *(valor - 1) + *(valor + FILA);
		}
		//POS 0x(1---COLUMNA-1) sumamos izquierda derecha y debajo
		else {
			*valorRes = *valor + *(valor + 1) + *(valor - 1) + *(valor + FILA);
		}
	}
	//Ultima fila -> no se puede sumar abajo
	else if (threadIdx.x == (FILA - 1)) {
		//POS filaFinalx0 sumamos arriba y derecha
		if (threadIdx.y == 0) {
			*valorRes = *valor + *(valor - FILA) + *(valor + 1);
		}
		//POS filaFinalxcolumnaFinal sumamos arriba y izquierda
		else if (threadIdx.y == (COLUMNA-1)) {
			*valorRes = *valor + *(valor - FILA) + *(valor - 1);
		}
		//POS filaFinalx(1---COLUMNA-1) sumamos arriba derecha y izquierda
		else{
			*valorRes = *valor + *(valor + 1) + *(valor - 1) + *(valor - FILA);
		}
	}
	//Primera columna -> no se puede sumar a la izquierda
	else if (threadIdx.y == 0) {
		*valorRes = *valor + *(valor + COLUMNA) + *(valor - COLUMNA) + *(valor + 1);
	}
	//Ultima columna -> no se puede sumar a la derecha
	else if (threadIdx.y == (COLUMNA - 1)) {
		*valorRes = *valor + *(valor + COLUMNA) + *(valor - COLUMNA) + *(valor - 1);
	}
	//Demas posiciones -> se suma todo
	else {
		*valorRes = *valor + *(valor + FILA) + *(valor - FILA) + *(valor + 1) + *(valor - 1);
	}

}

void imprimirMatriz(int* matrizFinal) {
	for (int i = 0; i < DIMENSION; i++) {
		printf("%5i   ", *(matrizFinal + i));
		if ((i+1)%FILA == 0) {
			printf("\n");
		}
	}
}

int main() {
	int matriz[DIMENSION];
	int matrizRes[DIMENSION];

	dim3 blockDim(COLUMNA,FILA);

	int* matriz_d;
	int* matrizRes_d;

	for (int i = 0; i < DIMENSION; i++) {
		matriz[i] = 1 + rand() % (99);
	}

	printf("***MATRIZ INICIAL***\n");
	imprimirMatriz(matriz);

	cudaMalloc(&matriz_d, sizeof(matriz));
	cudaMalloc(&matrizRes_d, sizeof(matrizRes));
	cudaMemcpy(matriz_d,&matriz,sizeof(matriz),cudaMemcpyHostToDevice);
	cudaMemcpy(matrizRes_d,&matrizRes,sizeof(matrizRes),cudaMemcpyHostToDevice);

	operacionMatriz<<< 1, blockDim >>>(matriz_d,matrizRes_d);

	cudaMemcpy(&matrizRes, matrizRes_d, sizeof(matrizRes), cudaMemcpyDeviceToHost);

	cudaFree(matrizRes_d);
	cudaFree(matriz_d);

	printf("\n***MATRIZ FINAL***\n");
	imprimirMatriz(matrizRes);
	return 0;
}

