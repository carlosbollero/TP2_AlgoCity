package algo3.algocity.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import algo3.algocity.model.Juego;

public class VistaPanelDer extends JPanel {

	private static final long serialVersionUID = -6808380609722271169L;

	Juego juego;

	Ventana contenedor;
	VistaMapa mapa;
	VistaMapaSubterraneo subterraneo;

	public VistaPanelDer(Juego juego, Ventana ventana) {
		contenedor = ventana;
		setLayout(new CardLayout());
		subterraneo = new VistaMapaSubterraneo(juego.mapa());
		add(subterraneo, "subterraneo");
		mapa = new VistaMapa(juego.mapa(), juego);
		add(mapa, "superficie");
		((CardLayout) getLayout()).show(this, "superficie");
	}

	public VistaMapa getVistaMapa() {
		return mapa;
	}

	public VistaMapaSubterraneo getVistaMapaSub() {
		return subterraneo;
	}

}
