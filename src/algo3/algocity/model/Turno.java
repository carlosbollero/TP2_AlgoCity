package algo3.algocity.model;

import java.util.Observable;

public class Turno extends Observable implements Runnable {

/* La idea es que turno se ejecute en un thread distinto
 * para poder hacer que avance cada cierto tiempo de
 * manera automatica
 */
	
	int turnoNumero;
	
	public Turno(){
		turnoNumero = 1;
	}

	public int getTurno() {
		return turnoNumero;
	}

	public void avanzarTurno() {
//		long referencia = System.currentTimeMillis();
//		long actual;
//		
//		do{
//			actual = System.currentTimeMillis();
//		}while(Math.abs(referencia - actual) > 1999);
		
		turnoNumero ++;
		setChanged();
		notifyObservers();
		
	}
	
	public void run(){
//		avanzarTurno();
	}
	
	public static void main(String args[]) {
//        (new Thread(new Turno())).start();
	}

}
