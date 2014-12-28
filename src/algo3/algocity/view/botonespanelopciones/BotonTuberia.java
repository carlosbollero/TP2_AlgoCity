package algo3.algocity.view.botonespanelopciones;

import algo3.algocity.controller.accionboton.AccionBotonTuberia;

public class BotonTuberia extends Boton {

	private static final long serialVersionUID = 1L;
	
	public BotonTuberia() {
		super("img/b_tuberia.png");
		setToolTipText("Tubería");
		accion = new AccionBotonTuberia();
		addActionListener(accion);
	}

}
