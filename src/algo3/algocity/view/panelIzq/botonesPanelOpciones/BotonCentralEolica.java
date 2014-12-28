package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonCentralEolica;
import algo3.algocity.model.Constantes;

public class BotonCentralEolica extends Boton {

	private static final long serialVersionUID = -7894323728361100376L;

	public BotonCentralEolica() {
		super("img/b_central_eolica.png");
		etiqueta = "Central Eolica $ " + Constantes.COSTO_C_EOLICA;
		setToolTipText(etiqueta);
		accion = new AccionBotonCentralEolica();
		addActionListener(accion);
	}

}
