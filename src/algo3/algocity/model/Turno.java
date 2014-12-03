package algo3.algocity.model;

import java.util.Observable;

public class Turno extends Observable implements Runnable {

	/*
	 * La idea es que turno se ejecute en un thread distinto para poder hacer
	 * que avance cada cierto tiempo de manera automatica
	 */

	int numero;
	volatile boolean jugando;
	Thread hilo;

	public Turno() {
		numero = 1;
		jugando = true;

	}

	public int getTurno() {
		return numero;
	}

	public void avanzar() {		
		numero++;
	}
	
	public void iniciarHilo(){
		hilo = new Thread(this);
		hilo.start();
	}
	
	public boolean estaVivo(){
		return hilo.isAlive();
	}

	@Override
	public void run() {
		System.out.println("STARTING");
		while (jugando){
			System.out.println("Start at " + (int)((System.currentTimeMillis())/1000.0));
//			Thread.sleep(20000);
			avanzar();
			setChanged();
			notifyObservers();
			if (numero == 2){
				jugando = false;
			}
			
		}
		System.out.println("SALIENDO");		
	}

	public void finalizar(){
		jugando = false;
	}
	

}