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
		setChanged();
		notifyObservers();
	}
	
	public void iniciarHilo(){
		hilo = new Thread(this,"TURNO");
		hilo.start();
	}
	
	public void finalizar(){
		jugando = false;
	}
	
	public boolean estaVivo(){
		return hilo.isAlive();
	}

	
	public void join(){
		try {
			hilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("START");
		while (jugando){		
			avanzar();
//			if(numero == 2){
//				jugando = false;
//			}
		}
		System.out.println("EXIT");		
	}
}