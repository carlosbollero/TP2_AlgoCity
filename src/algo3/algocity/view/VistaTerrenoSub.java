package algo3.algocity.view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.MapaConexiones;

public class VistaTerrenoSub extends JPanel implements Observer {

	private static final long serialVersionUID = 8179004051089239685L;

	MapaConexiones mapa;
	Coordenada coordenada;
	Image imagen;

	public VistaTerrenoSub(MapaConexiones m, Coordenada coord) {
		mapa = m;
		mapa.addObserver(this);
		coordenada = coord;
		setImagen();
	}

	private void setImagen() {
		imagen = (mapa.contiene(coordenada)) ? new ImageIcon(
				"img/tuberia.png").getImage() : new ImageIcon(
				"img/underground.png").getImage();
//		imagen = new ImageIcon("img/underground.png").getImage();
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
