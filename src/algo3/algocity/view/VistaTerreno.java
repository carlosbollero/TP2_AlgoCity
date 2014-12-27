package algo3.algocity.view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import algo3.algocity.controller.ControladorMouse;
import algo3.algocity.model.Juego;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.mapas.MapaEdilicio;

public class VistaTerreno extends JPanel implements Observer {

	private static final long serialVersionUID = -8808512415555786403L;

	Coordenada coordenada;
	Mapa mapa;
	Image terreno;
	Image unidad;
	MapaEdilicio ciudad;

		public VistaTerreno(Mapa mapa, Coordenada coord, VistaMapa vMapa, Juego juego) {
		this.mapa = mapa;
		ciudad = mapa.ciudad();
		coordenada = coord;
//		mapa.addObserver(this);
//		ciudad.addObserver(this);
		addMouseListener(new ControladorMouse(mapa, coord, vMapa, juego));
		unidad = null;
		setImagen();
	}

	public void setImagen(){
		terreno = (mapa.superficie(coordenada).esAgua()) ? new ImageIcon(
				"img/water.png").getImage() : new ImageIcon("img/dirt.png")
				.getImage();
	}

	public Coordenada coordenada(){
		return coordenada;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(terreno, 0, 0, getWidth(), getHeight(), null);
		super.paintComponents(g);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
//		setImagen();
		repaint();

	}

}
