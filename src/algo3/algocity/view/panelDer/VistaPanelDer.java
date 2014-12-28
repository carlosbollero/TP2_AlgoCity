package algo3.algocity.view.panelDer;

import java.awt.CardLayout;

import javax.swing.JPanel;

import algo3.algocity.controller.ControladorMensajes;
import algo3.algocity.model.Juego;
import algo3.algocity.view.VentanaJuego;

public class VistaPanelDer extends JPanel {

	private static final long serialVersionUID = -6808380609722271169L;

	Juego juego;

	VentanaJuego contenedor;
	VistaMapa mapa;
	VistaMapaSubterraneo subterraneo;

	public VistaPanelDer(Juego juego, VentanaJuego ventana) {
		contenedor = ventana;
		setLayout(new CardLayout());
		subterraneo = new VistaMapaSubterraneo(juego.mapa());
		add(subterraneo, "subterraneo");
		mapa = new VistaMapa(juego.mapa(), juego, this);
		add(mapa, "superficie");
		((CardLayout) getLayout()).show(this, "superficie");
		ventana.getControladorMensajes().addObserver(
				ventana.getPanelIzq().getPanelInfo().getTextoMensajes());
	}

	public VistaMapa getVistaMapa() {
		return mapa;
	}

	public VistaMapaSubterraneo getVistaMapaSub() {
		return subterraneo;
	}

	public ControladorMensajes getControladorMensajes() {
		return contenedor.getControladorMensajes();
	}

	public VentanaJuego getVentana() {
		return contenedor;
	}

}
