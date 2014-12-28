package algo3.algocity.view.botonespanelopciones;

import algo3.algocity.controller.accionboton.AccionBotonPozoAgua;

public class BotonPozoDeAgua extends Boton {

	private static final long serialVersionUID = 5913635258186561480L;

	public BotonPozoDeAgua() {
		super("img/b_pozo_de_agua.png");
		setToolTipText("Pozo de Agua");
		accion = new AccionBotonPozoAgua();
		addActionListener(accion);
	}
}
