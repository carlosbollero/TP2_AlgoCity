package algo3.algocity.view.panelDer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;

import javax.swing.ImageIcon;

import algo3.algocity.controller.ControladorMouseMapaSup;
import algo3.algocity.model.Juego;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.EstacionDeBomberos;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Coordenada;

public class VistaUnidad extends VistaPosicion {

	private static final long serialVersionUID = -1933418471723107152L;

	public VistaUnidad(Juego juego, Coordenada coord) {
		super(juego, coord);
		controlador = new ControladorMouseMapaSup(juego, coord, this);
		addMouseListener(controlador);
		setImagen();
		revalidate();
		repaint();
	}

	 public void setImagen(){
		 setImagen(juego.mapa().ciudad().getUnidadEn(coordenada));
	 }

	public void setImagen(Unidad unidad) {
		try {
			System.out.println("try");
			Method method = getClass()
					.getMethod("setImagen", unidad.getClass());
			method.invoke(this, unidad);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void setImagen(CentralEolica central) {
		imagen = new ImageIcon("img/central_eolica.png").getImage();
	}

	public void setImagen(CentralMinera central) {
		imagen = new ImageIcon("img/central_minera.png").getImage();
		System.out.println("cm");
	}

	public void setImagen(CentralNuclear central) {
		imagen = new ImageIcon("img/central_nuclear.png").getImage();
		System.out.println("cn");
	}

	public void setImagen(UnidadComercial unidad) {
		imagen = new ImageIcon("img/comercial.png").getImage();
		System.out.println("uc");
	}

	public void setImagen(UnidadIndustrial unidad) {
		imagen = new ImageIcon("img/industrial.png").getImage();
		System.out.println("ui");
	}

	public void setImagen(UnidadResidencial unidad) {
		imagen = new ImageIcon("img/residencial.png").getImage();
		System.out.println("ur");
	}

	public void setImagen(EstacionDeBomberos unidad) {
		imagen = new ImageIcon("img/bomberos.png").getImage();
		System.out.println("eb");
	}

	public void setImagen(PozoDeAgua unidad) {
		imagen = new ImageIcon("img/pozo_de_agua.png").getImage();
		System.out.println("pa");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setImagen();
		repaint();
	}
}
