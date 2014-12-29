package algo3.algocity.view.panelDer;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import algo3.algocity.controller.ControladorMouseMapa;
import algo3.algocity.model.Juego;
import algo3.algocity.model.mapas.Coordenada;

public abstract class VistaPosicion extends JPanel implements Observer  {

	private static final long serialVersionUID = -8589358511674016615L;
	
	protected Juego juego;
	protected Coordenada coordenada;
	protected ControladorMouseMapa controlador;
	protected Image imagen;

	public VistaPosicion(Juego j, Coordenada c) {
		juego = j;
		coordenada = c;
	}
	
	public ControladorMouseMapa getControlador() {
		return controlador;
	}

	public Coordenada coordenada() {
		return coordenada;
	}

	public abstract void setImagen();

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		super.paintComponents(g);
	}
	
	public abstract void update(Observable arg0, Object arg1);
	
	

}
