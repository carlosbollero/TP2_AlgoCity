package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import algo3.algocity.controller.accionBoton.AccionBotonPozoAgua;
import algo3.algocity.model.Constantes;

public class BotonPozoDeAgua extends Boton {

	private static final long serialVersionUID = 5913635258186561480L;

	public BotonPozoDeAgua() {
		super("img/b_pozo_de_agua.png");
		etiqueta = "Pozo de Agua $ " +  Constantes.COSTO_POZOAGUA;
		setToolTipText(etiqueta);
		accion = new AccionBotonPozoAgua();
		addActionListener(accion);
	}
}
