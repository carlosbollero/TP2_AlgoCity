package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonBomberos;
import algo3.algocity.model.Constantes;

public class BotonBomberos extends Boton {

	private static final long serialVersionUID = -991774239798536781L;

	public BotonBomberos() {
		super("img/b_bomberos.png");
		etiqueta = "Estacion de Bomberos $ " + Constantes.COSTO_E_BOMBEROS;
		setToolTipText(etiqueta);
		accion = new AccionBotonBomberos();
		addActionListener(accion);
	}

}
