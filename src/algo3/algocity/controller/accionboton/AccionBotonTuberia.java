package algo3.algocity.controller.accionboton;

import java.awt.event.ActionEvent;

import algo3.algocity.model.fabricas.FabricaTuberias;

public class AccionBotonTuberia extends AccionBoton{
	
	public void actionPerformed (ActionEvent e){
		setChanged();
		notifyObservers(new FabricaTuberias());
		
	}
}
