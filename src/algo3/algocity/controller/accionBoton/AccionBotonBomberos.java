package algo3.algocity.controller.accionBoton;

import java.awt.event.ActionEvent;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.fabricas.FabricaEstacionDeBomberos;

public class AccionBotonBomberos extends AccionBoton {

	@Override
		public void actionPerformed(ActionEvent e) {
			setChanged();
			notifyObservers(new FabricaEstacionDeBomberos());
			controladorMsj.recibirYNotificar("$" + Constantes.COSTO_E_BOMBEROS);
		}


}
