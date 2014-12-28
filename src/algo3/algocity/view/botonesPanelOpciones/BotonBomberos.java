package algo3.algocity.view.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonBomberos;

public class BotonBomberos extends Boton {
	
	private static final long serialVersionUID = -991774239798536781L;

	public BotonBomberos() {
		super("img/b_bomberos.png");
		setToolTipText("Estacion de Bomberos");
		accion = new AccionBotonBomberos();
		addActionListener(accion);
	}

}
