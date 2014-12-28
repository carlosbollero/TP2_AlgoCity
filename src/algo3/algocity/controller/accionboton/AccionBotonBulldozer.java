package algo3.algocity.controller.accionboton;

import java.awt.event.ActionEvent;

public class AccionBotonBulldozer extends AccionBoton {
	
	public void actionPerformed(ActionEvent e) {
		setChanged();
		notifyObservers(null);

	}

}
