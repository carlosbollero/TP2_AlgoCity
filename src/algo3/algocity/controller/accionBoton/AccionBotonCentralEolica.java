package algo3.algocity.controller.accionBoton;

import java.awt.event.ActionEvent;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.fabricas.FabricaCentralEolica;

public class AccionBotonCentralEolica extends AccionBoton {

	public void actionPerformed (ActionEvent e){
		setChanged();
		notifyObservers(new FabricaCentralEolica());
	}
}
