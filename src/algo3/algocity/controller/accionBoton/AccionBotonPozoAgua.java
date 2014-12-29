package algo3.algocity.controller.accionBoton;

import java.awt.event.ActionEvent;

import algo3.algocity.model.fabricas.FabricaPozoAgua;

public class AccionBotonPozoAgua extends AccionBoton {

	
	public void actionPerformed (ActionEvent e){
		setChanged();
		notifyObservers(new FabricaPozoAgua());
	}
}
