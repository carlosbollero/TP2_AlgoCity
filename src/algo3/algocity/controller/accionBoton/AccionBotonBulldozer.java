package algo3.algocity.controller.accionBoton;

import java.awt.event.ActionEvent;

public class AccionBotonBulldozer extends AccionBoton {
	
	public void actionPerformed(ActionEvent e) {
		controladorMsj.recibirYNotificar("No funciona");
	}

}
