package algo3.algocity.controller.accionBoton;

import java.awt.event.ActionEvent;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.fabricas.FabricaCentralNuclear;

public class AccionBotonCentralNuclear extends AccionBoton {
	
	public void actionPerformed (ActionEvent e){
		setChanged();
		notifyObservers(new FabricaCentralNuclear());
		controladorMsj.recibirYNotificar("$" + Constantes.CAPACIDAD_C_NUCLEAR);
	}

}
