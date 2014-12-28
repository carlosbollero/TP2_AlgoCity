package algo3.algocity.view.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonLineaTension;

public class BotonLineaTension extends Boton {

	private static final long serialVersionUID = 1L;
	
	public BotonLineaTension() {
		super("img/b_linea_tension.png");
		setToolTipText("Linea de Tensión");
		accion = new AccionBotonLineaTension();
		addActionListener(accion);;
	}

}
