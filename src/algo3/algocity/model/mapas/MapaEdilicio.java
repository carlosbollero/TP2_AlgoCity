package algo3.algocity.model.mapas;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.construcciones.Unidad;

public class MapaEdilicio {

	private int alto;
	private int ancho;

	HashMap<Point, Unidad> mapa;

	public MapaEdilicio(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.mapa = new HashMap<Point, Unidad>();
	}

	public boolean agregar(Unidad elemento) {
		int x = elemento.getCoordenadas().x;
		int y = elemento.getCoordenadas().y;
		if (!this.validarCoordenadas(x, y) || this.contiene(elemento)) {
			return false;
		}
		if (!this.mapa.containsKey(elemento.getCoordenadas())) {
			this.mapa.put(elemento.getCoordenadas(), elemento);
			return true;
		}
		return false;
	}

	public void remover(int x, int y) {
		this.mapa.remove(new Point(x, y));
	}

	private boolean validarCoordenadas(int x, int y) {
		return (this.estaDentroDeLimites(x, y));
	}

	private boolean estaDentroDeLimites(int i, int j) {
		return ((i >= 0) && (i <= this.alto) && (j >= 0) && (j <= this.ancho));
	}

	public boolean contiene(Unidad unaUnidad) {
		return (this.mapa.containsValue(unaUnidad));
	}

	public boolean tieneCoordenadaOcupada(int x, int y) {
		return (this.mapa.containsKey(new Point(x, y)));
	}

	public boolean vacia() {
		return (this.mapa.isEmpty());
	}

	public Point getCoordenadas(Unidad elemento) {
		for (Entry<Point, Unidad> entry : mapa.entrySet()) {
			if (entry.getValue().equals(elemento)) {
				return entry.getKey();
			}
		}
		return null;
	}

	public Unidad getUnidadEn(int x, int y) {
		if (tieneCoordenadaOcupada(x, y)) {
			Point p = new Point(x, y);
			return (this.mapa.get(p));
		} else {
			return null;
		}

	}

	public ArrayList<Visitable> getUnidadesAlrededorDe(Point epicentro,
			int radio) {
		ArrayList<Visitable> unidadesADevolver = new ArrayList<Visitable>();
		// unidadesADevolver.add((Visitable) this.getUnidadEn(
		// (int) epicentro.getX(), (int) epicentro.getY()));

		Point inic = calcularCoordenadaDeInicio(epicentro, radio);
		Point fin = calcularCoordenadaDeFin(epicentro, radio);

		for (int x = (int) inic.getX(); x < (int) fin.getX(); x++) {
			for (int y = (int) inic.getY(); y < (int) fin.getY(); y++) {
				if (validarCoordenadas(x, y)) {
					if (this.getUnidadEn(x, y) != null) {
						unidadesADevolver.add((Visitable) this
								.getUnidadEn(x, y));
					}
				}
			}
		}

		/*
		 * for (int i = -radio; i < radio; i++) { for (int j = -radio; j < radio
		 * && i != j; j++) { if (validarCoordenadas((int) epicentro.getX() + j,
		 * (int) epicentro.getY() + i)) { unidadesADevolver.add((Visitable)
		 * this.getUnidadEn( (int) (epicentro.getX() + j), (int)
		 * (epicentro.getY() + i))); } } }
		 */

		return unidadesADevolver;
	}

	private Point calcularCoordenadaDeInicio(Point epicentro, int radio) {
		int xi;
		int yi;
		if (epicentro.getX() - radio < 0) {
			xi = 0;
		} else {
			xi = (int) epicentro.getX() - radio;
		}
		if (epicentro.getY() - radio < 0) {
			yi = 0;
		} else {
			yi = (int) epicentro.getY() - radio;
		}
		return new Point(xi, yi);
	}

	private Point calcularCoordenadaDeFin(Point epicentro, int radio) {
		int xf;
		int yf;
		if (epicentro.getX() - radio < 0) {
			xf = radio;
		} else {
			xf = (int) epicentro.getX() + radio;
		}
		if (epicentro.getY() - radio < 0) {
			yf = radio;
		} else {
			yf = (int) epicentro.getY() + radio;
		}
		return new Point(xf, yf);
	}

	/*********************************************************************/
	/*********************************************************************/
	// 					REVISAR PORQUE ES REALMENTE FEO
	/*********************************************************************/
	public int getCapacidadHabitacional() {
		int capacidad = 0;
		for (Entry<Point, Unidad> entry : mapa.entrySet()) {
			capacidad += entry.getValue().getCapacidadHabitacional();
		}
		return capacidad;
	}

	public int getCapacidadEmpleo() {
		int capacidad = 0;
		for (Entry<Point, Unidad> entry : mapa.entrySet()) {
			capacidad += entry.getValue().getCapacidadEmpleo();
		}
		return capacidad;
	}
	/*********************************************************************/
	/*********************************************************************/
}