package algo3.algocity.controller.accionBoton;

import java.awt.event.ActionEvent;

import algo3.algocity.model.fabricas.FabricaUnidadResidencial;

public class AccionBotonResidencia extends AccionBoton {
	
	public void actionPerformed (ActionEvent e){
		setChanged();
		notifyObservers(new FabricaUnidadResidencial());
	}
}
