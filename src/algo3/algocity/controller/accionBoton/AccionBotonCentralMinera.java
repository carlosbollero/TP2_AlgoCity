package algo3.algocity.controller.accionBoton;

import java.awt.event.ActionEvent;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.fabricas.FabricaCentralMinera;

public class AccionBotonCentralMinera extends AccionBoton {

	
	public void actionPerformed (ActionEvent e){
		setChanged();
		notifyObservers(new FabricaCentralMinera());
		controladorMsj.recibirYNotificar("$" + Constantes.COSTO_C_MINERA);
	}
}
