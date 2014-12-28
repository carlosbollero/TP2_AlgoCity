package algo3.algocity.view.botonespanelopciones;

import algo3.algocity.controller.accionboton.AccionBotonCentralMinera;

public class BotonCentralMinera extends Boton {

	private static final long serialVersionUID = 1180151124978012272L;
	
	public BotonCentralMinera() {
		super("img/b_central_minera.png");
		setToolTipText("Central Minera");
		accion = new AccionBotonCentralMinera();
		addActionListener(accion);
	}

}
