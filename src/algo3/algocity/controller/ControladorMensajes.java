package algo3.algocity.controller;

import java.util.Observable;

public class ControladorMensajes extends Observable {
	
	public void recibirYNotificar(String mensaje){
		System.out.println(mensaje + "*");
		setChanged();
		notifyObservers(mensaje);
	}

}
