package algo3.algocity.controller.accionBoton;

import java.awt.event.ActionEvent;

public class AccionBotonBulldozer extends AccionBoton {
	
	public void actionPerformed(ActionEvent e) {
//		setChanged();
//		notifyObservers(null);
		controladorMsj.recibirYNotificar("No funciona");
	}

}
