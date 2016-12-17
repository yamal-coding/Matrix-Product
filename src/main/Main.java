package main;

import product.Producto;

public class Main {
	public static void main(String [] args){
		int [][] a = new int[Producto.N][Producto.N];
		int [][] b = new int[Producto.N][Producto.N];
		
		//Inicializacion de las matrices
		a[0][0] = 1; a[0][1] = 2; a[0][2] = 3;
		a[1][0] = 0; a[1][1] = 4; a[1][2] = 4;
		a[2][0] = 5; a[2][1] = 0; a[2][2] = 1;
		
		b[0][0] = 5; b[0][1] = 1; b[0][2] = 5;
		b[1][0] = 0; b[1][1] = 4; b[1][2] = 1;
		b[2][0] = 0; b[2][1] = 2; b[2][2] = 3;
		
		Producto p = new Producto(a, b);
		
		p.producto();
	}
	
	
}

/*
for (int i = 0; i < N; i++){
	for (int j = 0; j < N; j++){
		c[i][j] = 0;
		for (int k = 0; k < N; k++)
			c[i][j] += a[i][k] * b[k][j];
	}
}*/