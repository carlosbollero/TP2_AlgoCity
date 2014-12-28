package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonBomberos;
import algo3.algocity.model.Constantes;

public class BotonBomberos extends Boton {

	private static final long serialVersionUID = -991774239798536781L;

	String costo = "\n$ " + Constantes.COSTO_E_BOMBEROS;

	public BotonBomberos() {
		super("img/b_bomberos.png");
		setToolTipText("Estacion de Bomberos" + costo);
		accion = new AccionBotonBomberos();
		addActionListener(accion);
	}

}
