package algo3.algocity.view.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonIndustrial;

public class BotonUnidadIndustrial extends Boton {

	private static final long serialVersionUID = 3358801902952698690L;

	public BotonUnidadIndustrial() {
		super("img/b_industrial.png");
		setToolTipText("Unidad Industrial");
		accion = new AccionBotonIndustrial();
		addActionListener(accion);		
	}

}
