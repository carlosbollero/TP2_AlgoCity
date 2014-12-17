package algo3.algocity.view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import algo3.algocity.model.mapas.Coordenada;

public class VistaTerrenoSub extends JPanel implements Observer {

	private static final long serialVersionUID = 8179004051089239685L;
	
	Coordenada coordenada;
	Image imagen;
	
	public VistaTerrenoSub(Coordenada coord) {
		 coordenada = coord;
		 setImagen();
	}

	private void setImagen() {
		imagen = new ImageIcon("img/underground.png").getImage();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		super.paintComponents(g);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();		
	}

}
