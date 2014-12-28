package algo3.algocity.controller.accionboton;

import java.awt.event.ActionEvent;

import algo3.algocity.model.fabricas.FabricaEstacionDeBomberos;

public class AccionBotonBomberos extends AccionBoton {

	@Override
		public void actionPerformed(ActionEvent e) {
			setChanged();
			notifyObservers(new FabricaEstacionDeBomberos());			
		}


}
