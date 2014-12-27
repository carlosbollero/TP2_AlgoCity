package algo3.algocity.view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.mapas.MapaEdilicio;

public class VistaUnidad extends JPanel implements Observer {

	private static final long serialVersionUID = -1933418471723107152L;
	
	Coordenada coordenada;
	Mapa mapa;
	Image imagen;
	MapaEdilicio ciudad;

	public VistaUnidad(Mapa mapa, Coordenada coord) {
		this.mapa = mapa;
		ciudad = mapa.ciudad();
		coordenada = coord;
//		mapa.addObserver(this);
//		ciudad.addObserver(this);
//		addMouseListener(new ControladorMouse(mapa, this));
		setImagen();
	}
	
	public VistaUnidad(String nombre) {
		setImagen(nombre);
	}
	
	public void setImagen(String nombre){
		imagen = new ImageIcon("img/" + nombre + ".png").getImage();
	}

	public void setImagen(){
		imagen = new ImageIcon("img/bomberos.png").getImage();
	}
	
	public Coordenada coordenada(){
		return coordenada;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		super.paintComponents(g);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		setImagen();
		repaint();
	}

}
