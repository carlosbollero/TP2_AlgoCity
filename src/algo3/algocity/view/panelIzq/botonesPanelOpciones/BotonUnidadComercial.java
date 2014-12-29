package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonComercial;
import algo3.algocity.model.Constantes;

public class BotonUnidadComercial extends Boton {

	private static final long serialVersionUID = -8033923457267073440L;
	
	public BotonUnidadComercial() {
		super("img//b_comercial.png");
		etiqueta = "Unidad Comercial $ " + Constantes.CONSUMO_U_COMERCIAL;
		setToolTipText(etiqueta);
		accion = new AccionBotonComercial();
		addActionListener(accion);
	}

}
