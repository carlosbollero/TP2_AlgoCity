package algo3.algocity.controller.accionBoton;

import java.awt.event.ActionEvent;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.fabricas.FabricaLineaTension;

public class AccionBotonLineaTension extends AccionBoton {

	
	public void actionPerformed (ActionEvent e){
		setChanged();
		notifyObservers(new FabricaLineaTension());
	}
}
