package algo3.algocity.view.panelDer;

import java.util.Observable;

import javax.swing.ImageIcon;

import algo3.algocity.controller.ControladorMouseMapaSub;
import algo3.algocity.model.Juego;
import algo3.algocity.model.mapas.Coordenada;

public class VistaTerrenoSub extends VistaPosicion {
	
	private static final long serialVersionUID = 8179004051089239685L;
	
	public VistaTerrenoSub(Juego juego, Coordenada coord) {
		super(juego, coord);
		juego.mapa().tuberias().addObserver(this);
		controlador = new ControladorMouseMapaSub(juego, coord);
		addMouseListener(controlador);
		setImagen();
	}

	public void setImagen() {
		imagen = (juego.mapa().tuberias().tieneCoordenadaOcupada(coordenada)) ? new ImageIcon(
				"img/tuberia.png").getImage() : new ImageIcon(
				"img/underground.png").getImage();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setImagen();
		revalidate();
		repaint();
	}
}