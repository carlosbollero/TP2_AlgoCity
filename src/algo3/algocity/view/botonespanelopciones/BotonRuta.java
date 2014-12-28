package algo3.algocity.view.botonespanelopciones;

import algo3.algocity.controller.accionboton.AccionBotonRuta;

public class BotonRuta extends Boton {

	private static final long serialVersionUID = -8203627685307550080L;
	
	public BotonRuta() {
		super("img/b_ruta");
		setToolTipText("Ruta");
		accion = new AccionBotonRuta();
		addActionListener(accion);
	}

}
