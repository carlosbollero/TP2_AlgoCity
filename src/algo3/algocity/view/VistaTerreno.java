package algo3.algocity.view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import algo3.algocity.controller.ControladorMouseVistaMapa;
import algo3.algocity.model.Juego;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.view.botonespanelopciones.Boton;

public class VistaTerreno extends JPanel implements Observer {

	private static final long serialVersionUID = -8808512415555786403L;

	Coordenada coordenada;
	Mapa mapa;
	Image terreno;
	ControladorMouseVistaMapa controlador;

	public VistaTerreno(Mapa mapa, Coordenada coord, VistaMapa vMapa,
			Juego juego) {
		this.mapa = mapa;
		coordenada = coord;
		controlador = new ControladorMouseVistaMapa(juego, coord);
		addMouseListener(controlador);
		setImagen();
	}

	public ControladorMouseVistaMapa getControlador() {
		return controlador;
	}

	public void setImagen() {
		terreno = (mapa.superficie(coordenada).esAgua()) ? new ImageIcon(
				"img/water.png").getImage() : new ImageIcon("img/dirt.png")
				.getImage();
	}

	public Coordenada coordenada() {
		return coordenada;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(terreno, 0, 0, getWidth(), getHeight(), null);
		super.paintComponents(g);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();

	}

}
