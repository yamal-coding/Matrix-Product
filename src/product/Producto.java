package product;

public class Producto {
	public static final int N = 3;
	private int[][] a;
	private int[][] b;
	private int[][] c;
	
	public Producto(int[][]a, int[] [] b) {
		this.a = a;
		this.b = b;
		this.c = new int[N][N];
	}
	
	private class CalculoFila extends Thread {
		private int fila;
		private CalculoColumna[] cols;
		
		public CalculoFila(int fila){
			this.fila = fila;
			cols = new CalculoColumna[N];
		}
		
		public void run(){
			for (int i = 0; i < N; i++){
				cols[i] = new CalculoColumna(fila, i);
				cols[i].start();
			}
			
			for(CalculoColumna ccol : cols)
				try {
					ccol.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		
		private class CalculoColumna extends Thread {
			private int fila;
			private int col;
			
			public CalculoColumna(int fila, int col){
				this.fila = fila;
				this.col = col;
			}
			
			public void run(){
				c[fila][col] = 0;
				for (int i = 0; i < N; i++)
					c[fila][col] += a[fila][i] * b[i][col];
			}
		}
	}
	
	
	
	public void producto (){
		CalculoFila [] filas = new CalculoFila[N];
		
		for (int i = 0; i < N; i++){
			filas[i] = new CalculoFila(i);
			filas[i].start();
		}
		
		
		try {
			for (int i = 0; i < N; i++)
				filas[i].join();
			for (int[] fila : c){
				for (int dato : fila)
					System.out.print(dato + " ");
				System.out.println();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
