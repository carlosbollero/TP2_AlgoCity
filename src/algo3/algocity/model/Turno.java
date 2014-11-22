package algo3.algocity.model;

public class Turno implements Runnable{
	
	int turnoNumero;
	
	public Turno(){
		turnoNumero = 1;
	}

	public int getTurno() {
		return turnoNumero;
	}

	public void avanzarTurno() {
		long referencia = System.currentTimeMillis();
		long actual;
		
		do{
			actual = System.currentTimeMillis();
		}while(Math.abs(referencia - actual) > 1999);
		
		turnoNumero ++;		
	}
	
	public void run(){
		Thread.sleep(2000);
		avanzarTurno();
	}
	
	public static void main(String args[]) {
        (new Thread(new Turno())).start();
	}

}
