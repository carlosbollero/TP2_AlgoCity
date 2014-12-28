package algo3.algocity.controller.accionBoton;

import java.awt.event.ActionEvent;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.fabricas.FabricaUnidadComercial;

public class AccionBotonComercial extends AccionBoton {

	
	public void actionPerformed (ActionEvent e){
		setChanged();
		notifyObservers(new FabricaUnidadComercial());
		controladorMsj.recibirYNotificar("$" + Constantes.COSTO_U_COMERCIAL);
	}
}
