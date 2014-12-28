package algo3.algocity.controller;

import java.util.Observable;

public class ControladorMensajes extends Observable {
	
	public void recibirYNotificar(String mensaje){
		setChanged();
		notifyObservers(mensaje);
	}

}
