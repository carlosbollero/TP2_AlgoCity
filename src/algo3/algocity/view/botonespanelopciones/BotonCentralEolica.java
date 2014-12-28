package algo3.algocity.view.botonespanelopciones;

import algo3.algocity.controller.accionboton.AccionBotonCentralEolica;

public class BotonCentralEolica extends Boton {

	private static final long serialVersionUID = -7894323728361100376L;

	public BotonCentralEolica() {
		super("img/b_central_eolica.png");
		setToolTipText("Central Eolica");
		accion = new AccionBotonCentralEolica();
		addActionListener(accion);
	}

}
