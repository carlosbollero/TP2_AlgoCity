package algo3.algocity.view.panelDer;

import java.util.Observable;

import javax.swing.ImageIcon;

import algo3.algocity.controller.ControladorMouseMapaSup;
import algo3.algocity.model.Juego;
import algo3.algocity.model.mapas.Coordenada;

public class VistaUnidad extends VistaPosicion{

	private static final long serialVersionUID = -1933418471723107152L;

	public VistaUnidad(Juego juego, Coordenada coord) {
		super(juego, coord);
		controlador = new ControladorMouseMapaSup(juego, coord, this);
		addMouseListener(controlador);
		setImagen();
	}
	
	public VistaUnidad(Juego juego, Coordenada coord, String nombre) {
		super(juego, coord);
		setImagen(nombre);
	}
	
	public void setImagen(String nombre){
		imagen = new ImageIcon("img/" + nombre + ".png").getImage();
	}

	public void setImagen(){
		imagen = new ImageIcon("img/bomberos.png").getImage();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setImagen();
		repaint();
	}

}
