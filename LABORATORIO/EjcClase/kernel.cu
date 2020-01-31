#include "cuda_runtime.h"
#include "device_launch_parameters.h"

#include <stdio.h>
#include <cuda.h>
#include <stdlib.h>

__global__ void colonel(int a, int b, int* r_d) {
	*r_d = a + b;
}

int main() {
	int a = 2;
	int b = 3;
	int r = 0, * r_d;

	cudaMalloc((void**)&r_d, sizeof(int));
	cudaMemcpy(r_d, &r, sizeof(int), cudaMemcpyHostToDevice);

	colonel <<<1,1>>> (a, b, r_d);

	cudaMemcpy(&r, r_d, sizeof(int), cudaMemcpyDeviceToHost);

	printf("resultado=%d\n", r);

	cudaFree(r_d);

	system("pause");
	return -1;
}