package algo3.algocity.view.panelDer;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import algo3.algocity.controller.ControladorMouseMapa;
import algo3.algocity.controller.ControladorMouseMapaSub;
import algo3.algocity.model.Juego;
import algo3.algocity.model.mapas.Coordenada;

public class VistaTerrenoSub extends JPanel implements Observer {

	private static final long serialVersionUID = 8179004051089239685L;

	Juego juego;
	Coordenada coordenada;
	Image imagen;
	ControladorMouseMapa controlador;

	public VistaTerrenoSub(Juego juego, Coordenada coord) {
		this.juego = juego;
		juego.mapa().tuberias().addObserver(this);
		coordenada = coord;
		controlador = new ControladorMouseMapaSub(juego, coord);
		addMouseListener(controlador);
		setImagen();
	}

	public void setImagen() {
		imagen = (juego.mapa().tuberias().tieneCoordenadaOcupada(coordenada)) ? new ImageIcon(
				"img/tuberia.png").getImage() : new ImageIcon(
				"img/underground.png").getImage();
		// imagen = new ImageIcon("img/underground.png").getImage();
	}
	
	public ControladorMouseMapa getControlador(){
		return controlador;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		super.paintComponents(g);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setImagen();
		revalidate();
		repaint();
	}

}
