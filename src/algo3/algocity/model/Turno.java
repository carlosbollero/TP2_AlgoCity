package algo3.algocity.model;

import java.util.Observable;

public class Turno extends Observable implements Runnable {

	/*
	 * La idea es que turno se ejecute en un thread distinto para poder hacer
	 * que avance cada cierto tiempo de manera automatica
	 */

	int numero;

	public Turno() {
		numero = 1;
	}

	public int getTurno() {
		return numero;
	}

	public void avanzar() {
		// long referencia = System.currentTimeMillis();
		// long actual;
		//
		// do{
		// actual = System.currentTimeMillis();
		// }while(Math.abs(referencia - actual) > 1999);

		numero++;
		setChanged();
		notifyObservers();

	}

	public void run() {
		// avanzarTurno();
	}

	public static void main(String args[]) {
		// (new Thread(new Turno())).start();
	}

	public void iniciar() {
		// TODO Auto-generated method stub

	}

}