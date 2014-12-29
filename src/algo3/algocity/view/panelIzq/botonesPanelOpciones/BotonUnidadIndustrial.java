package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonIndustrial;
import algo3.algocity.model.Constantes;

public class BotonUnidadIndustrial extends Boton {

	private static final long serialVersionUID = 3358801902952698690L;

	public BotonUnidadIndustrial() {
		super("img/b_industrial.png");
		etiqueta = "Unidad Industrial $ " + Constantes.CONSUMO_U_INDUSTRIAL;
		setToolTipText(etiqueta);
		accion = new AccionBotonIndustrial();
		addActionListener(accion);		
	}

}
