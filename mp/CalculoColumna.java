package mp;

public class CalculoColumna extends Thread {
	private int col;
	private int fila;
	
	public CalculoColumna(int col, int fila) {
		this.col = col;
		this.fila = fila;
	}
	
	public void run(){
		Main.c[fila][col] = 0;
		for (int i = 0; i < Main.N; i++)
			Main.c[fila][col] += Main.a[fila][i] * Main.b[i][col];
			//System.out.println(Main.a[fila][i] * Main.b[i][col]);
	}
}
