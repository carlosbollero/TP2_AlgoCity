package algo3.algocity.view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import algo3.algocity.controller.ControladorMouse;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class VistaTerreno extends JPanel implements Observer {

	private static final long serialVersionUID = -8808512415555786403L;

	Coordenada coordenada;
	Mapa mapa;
	Image imagen;

	public VistaTerreno(Superficie superficie, Coordenada coord) {
		coordenada = coord;
		imagen = (superficie.esAgua()) ? new ImageIcon("img/water.png")
				.getImage() : new ImageIcon("img/dirt.png").getImage();
	}

	public VistaTerreno(Mapa mapa, Coordenada coord) {
		this.mapa = mapa;
		coordenada = coord;
		mapa.addObserver(this);
		addMouseListener(new ControladorMouse(mapa, this));
		setImagen();
	}
	
	public void setImagen(){
		imagen = (mapa.superficie(coordenada).esAgua()) ? new ImageIcon(
				"img/water.png").getImage() : new ImageIcon("img/dirt.png")
				.getImage();
	}
	
	public Coordenada coordenada(){
		return coordenada;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		imagen = (mapa.superficie(coordenada).esAgua()) ? new ImageIcon(
				"img/water.png").getImage() : new ImageIcon("img/dirt.png")
				.getImage();
		repaint();

	}

}
