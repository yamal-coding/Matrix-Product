package mp;

public class CalculoFila extends Thread {
	private int fila;
	
	public CalculoFila(int fila){
		this.fila = fila;
	}
	
	public void run(){
		CalculoColumna [] cols = new CalculoColumna[Main.N];
		
		for(int i = 0; i < Main.N; i++){
			cols[i] = new CalculoColumna(i, fila);
			cols[i].start();
		}
		
		try {
			for(int i = 0; i < Main.N; i++)
				cols[i].join();
		}
		catch (Exception e){
			e.printStackTrace();
		}	
	}
}
