package algo3.algocity.view.panelDer;

import java.util.Observable;

import javax.swing.ImageIcon;

import algo3.algocity.controller.ControladorMouseMapaSup;
import algo3.algocity.model.Juego;
import algo3.algocity.model.mapas.Coordenada;

public class VistaTerreno extends VistaPosicion {
	
	private static final long serialVersionUID = -8808512415555786403L;

	public VistaTerreno(Juego juego, Coordenada coord) {
		super(juego, coord);
		controlador = new ControladorMouseMapaSup(juego, coord, this);
		addMouseListener(controlador);
		setImagen();
		System.out.println("VistaPosicion " + coordenada.getX() + coordenada.getY());
	}
	
	public void setImagen() {
		imagen = (juego.mapa().superficie(coordenada).esAgua()) ? new ImageIcon(
				"img/water.png").getImage() : new ImageIcon("img/dirt.png")
				.getImage();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
}
