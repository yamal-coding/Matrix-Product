package mp;

public class Main {
	public static final int N = 3;
	public static int [][] c = new int[N][N];
	public static int [][] a = new int[N][N];
	public static int [][] b = new int[N][N];
	
	public static void main(String [] args){
		
		a[0][0] = 1; a[0][1] = 2; a[0][2] = 3;
		a[1][0] = 0; a[1][1] = 4; a[1][2] = 4;
		a[2][0] = 5; a[2][1] = 0; a[2][2] = 1;
		
		b[0][0] = 5; b[0][1] = 1; b[0][2] = 5;
		b[1][0] = 0; b[1][1] = 4; b[1][2] = 1;
		b[2][0] = 0; b[2][1] = 2; b[2][2] = 3;
		
		producto();
		
		
		for (int i = 0; i < N; i++){
			for(int j = 0; j < N; j++)
				System.out.print(c[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void producto(){
		CalculoFila [] filas = new CalculoFila[N];
		
		for (int i = 0; i < N; i++){
			filas[i] = new CalculoFila(i);
			filas[i].start();
		}
		
		try {
			for(int i = 0; i < N; i++)
				filas[i].join();
		}
		catch (Exception e){
			e.printStackTrace();
		}		
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