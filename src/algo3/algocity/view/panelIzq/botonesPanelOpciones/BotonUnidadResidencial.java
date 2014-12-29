package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonResidencia;
import algo3.algocity.model.Constantes;

public class BotonUnidadResidencial extends Boton{

	private static final long serialVersionUID = 6553651246003455535L;

	public BotonUnidadResidencial() {
		super("img/b_residencial.png");
		etiqueta = "Unidad Residencial $ " + Constantes.COSTO_U_RESIDENCIAL;
		setToolTipText(etiqueta);
		accion = new AccionBotonResidencia();
		addActionListener(accion);
	}
}
