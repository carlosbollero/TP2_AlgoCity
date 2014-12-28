package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonTuberia;
import algo3.algocity.model.Constantes;

public class BotonTuberia extends Boton {

	private static final long serialVersionUID = 1L;
	
	public BotonTuberia() {
		super("img/b_tuberia.png");
		etiqueta = "Tubería $ " + Constantes.COSTO_TUBERIA;
		setToolTipText(etiqueta);
		accion = new AccionBotonTuberia();
		addActionListener(accion);
	}

}
