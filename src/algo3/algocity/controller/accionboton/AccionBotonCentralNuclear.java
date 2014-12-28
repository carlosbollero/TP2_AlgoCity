package algo3.algocity.controller.accionboton;

import java.awt.event.ActionEvent;

import algo3.algocity.model.fabricas.FabricaCentralNuclear;

public class AccionBotonCentralNuclear extends AccionBoton {
	
	public void actionPerformed (ActionEvent e){
		setChanged();
		notifyObservers(new FabricaCentralNuclear());		
	}

}
