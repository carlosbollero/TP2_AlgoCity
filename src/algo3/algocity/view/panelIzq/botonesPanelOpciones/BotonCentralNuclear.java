package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonCentralNuclear;
import algo3.algocity.model.Constantes;

public class BotonCentralNuclear extends Boton {

	private static final long serialVersionUID = -8374245446334969423L;
	
	public BotonCentralNuclear() {
		super("img/b_central_nuclear.png");
		etiqueta = "Central Nuclear $ " + Constantes.COSTO_C_NUCLEAR;
		setToolTipText(etiqueta);
		accion = new AccionBotonCentralNuclear();
		addActionListener(accion);
	}

}
