package algo3.algocity.view.botonespanelopciones;

import algo3.algocity.controller.accionboton.AccionBotonResidencia;

public class BotonUnidadResidencial extends Boton{

	private static final long serialVersionUID = 6553651246003455535L;

	public BotonUnidadResidencial() {
		super("img/b_residencial.png");
		setToolTipText("Unidad Residencial");
		accion = new AccionBotonResidencia();
		addActionListener(accion);
	}
}
