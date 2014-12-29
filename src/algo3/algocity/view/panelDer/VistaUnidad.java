package algo3.algocity.view.panelDer;

import java.lang.reflect.Method;
import java.util.Observable;

import javax.swing.ImageIcon;

import algo3.algocity.controller.ControladorMouseMapaSup;
import algo3.algocity.model.Juego;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Coordenada;

public class VistaUnidad extends VistaPosicion{

	private static final long serialVersionUID = -1933418471723107152L;
	
	Unidad unidad;

	public VistaUnidad(Juego juego, Coordenada coord) {
		super(juego, coord);
		controlador = new ControladorMouseMapaSup(juego, coord, this);
		addMouseListener(controlador);
		setTipoUnidad();
		setImagen(unidad);
	}
	
	private void setTipoUnidad() {
		unidad = juego.mapa().ciudad().getUnidadEn(coordenada);
		
	}

//	public VistaUnidad(Juego juego, Coordenada coord, String nombre) {
//		super(juego, coord);
//		setImagen(nombre);
//	}
	
	public void setImagen(Unidad unidad){
		try {
			Method method = getClass().getMethod("setImage", unidad.getClass());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	public void setImagen(CentralEolica central){
		imagen = new ImageIcon("img/central_eolica.png").getImage();
	}
	
	public void setImagen(CentralMinera central){
		imagen = new ImageIcon("img/central_minera.png").getImage();
	}
	
	public void setImagen(CentralNuclear central){
		imagen = new ImageIcon("img/central_nuclear.png").getImage();
	}
	
	public void setImagen(UnidadComercial unidad){
		imagen = new ImageIcon("img/comercial.png").getImage();
	}
	
	public void setImagen(UnidadIndustrial unidad){
		imagen = new ImageIcon("img/industrial.png").getImage();
	}
	
	public void setImagen(UnidadResidencial unidad){
		imagen = new ImageIcon("img/residencial.png").getImage();
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
