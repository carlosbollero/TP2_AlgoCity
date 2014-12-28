package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonCentralMinera;
import algo3.algocity.model.Constantes;

public class BotonCentralMinera extends Boton {

	private static final long serialVersionUID = 1180151124978012272L;
	
	public BotonCentralMinera() {
		super("img/b_central_minera.png");
		etiqueta = "Central Minera $ " + Constantes.COSTO_C_MINERA;
		setToolTipText(etiqueta);
		accion = new AccionBotonCentralMinera();
		addActionListener(accion);
	}

}
