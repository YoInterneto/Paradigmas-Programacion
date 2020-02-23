
#include "cuda_runtime.h"
#include "device_launch_parameters.h"
#include "cuda.h"
#include "./common/book.h"
#include <stdio.h>

#define FILA 32
#define COLUMNA 32
#define DIMENSION FILA*COLUMNA


__global__ void operacionMatriz(int* matriz, int* matrizRes) {

	int posicion = threadIdx.x * FILA + threadIdx.y;
	int* valor = matriz + posicion;
	int* valorRes = matrizRes + posicion;

	//Primera fila -> todo 0
	if (threadIdx.x == 0) {
		*valorRes = 0;
	}
	//Todas las demas filas menos la ultima
	else{
		*valorRes = *(valor - FILA);
	}
}

void imprimirMatriz(int* matrizFinal) {
	for (int i = 0; i < DIMENSION; i++) {
		printf("%5i   ", *(matrizFinal + i));
		if ((i + 1) % FILA == 0) {
			printf("\n");
		}
	}
}

int main() {
	int matriz[DIMENSION];
	int matrizRes[DIMENSION];

	dim3 blockDim(COLUMNA, FILA);

	int* matriz_d;
	int* matrizRes_d;

	for (int i = 0; i < DIMENSION; i++) {
		matriz[i] = 1 + rand() % (99);
	}

	printf("***MATRIZ INICIAL***\n");
	imprimirMatriz(matriz);


	cudaMalloc(&matriz_d, sizeof(matriz));
	cudaMemcpy(matriz_d, &matriz, sizeof(matriz), cudaMemcpyHostToDevice);
	cudaMalloc(&matrizRes_d, sizeof(matrizRes));
	cudaMemcpy(matrizRes_d, &matrizRes, sizeof(matrizRes), cudaMemcpyHostToDevice);

	for (int i = 0; i < FILA; i++) {

		if (i == 0) {
			operacionMatriz << < 1, blockDim >> > (matriz_d, matrizRes_d);
		}else{
			operacionMatriz << < 1, blockDim >> > (matrizRes_d, matrizRes_d);
		}

		cudaMemcpy(&matrizRes, matrizRes_d, sizeof(matrizRes), cudaMemcpyDeviceToHost);

		printf("\n***MATRIZ %d***\n", i+1);
		imprimirMatriz(matrizRes);
		
	}

	cudaFree(matrizRes_d);
	cudaFree(matriz_d);

	return 0;
}

