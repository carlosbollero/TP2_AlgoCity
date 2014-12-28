package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonLineaTension;
import algo3.algocity.model.Constantes;

public class BotonLineaTension extends Boton {

	private static final long serialVersionUID = 1L;
	
	public BotonLineaTension() {
		super("img/b_linea_tension.png");
		etiqueta = "Linea de Tensión \n $" + Constantes.COSTO_LINEATENSION;
		setToolTipText(etiqueta);
		accion = new AccionBotonLineaTension();
		addActionListener(accion);;
	}

}
