package algo3.algocity.view.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonBulldozer;

public class BotonBulldozer extends Boton {
	
	private static final long serialVersionUID = 4376475520175027625L;
	
	public BotonBulldozer() {
		super("img/b_bulldozer.png");
		setToolTipText("Bulldozer");
		accion = new AccionBotonBulldozer();
		addActionListener(accion);
	}

}
