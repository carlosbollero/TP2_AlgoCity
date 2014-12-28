package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonRuta;
import algo3.algocity.model.Constantes;

public class BotonRuta extends Boton {

	private static final long serialVersionUID = -8203627685307550080L;
	
	public BotonRuta() {
		super("img/b_ruta");
		etiqueta = "Ruta $ " + Constantes.COSTO_RUTA;
		setToolTipText(etiqueta);
		accion = new AccionBotonRuta();
		addActionListener(accion);
	}

}
