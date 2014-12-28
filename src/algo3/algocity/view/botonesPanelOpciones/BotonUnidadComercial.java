package algo3.algocity.view.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonComercial;

public class BotonUnidadComercial extends Boton {

	private static final long serialVersionUID = -8033923457267073440L;
	
	public BotonUnidadComercial() {
		super("img//b_comercial.png");
		setToolTipText("Unidad Comercial");
		accion = new AccionBotonComercial();
		addActionListener(accion);
	}

}
