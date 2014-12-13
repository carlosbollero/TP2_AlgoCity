package algo3.algocity.model.mapas;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Ocupable;
import algo3.algocity.model.construcciones.Unidad;

public class MapaEdilicio {

	private int alto;
	private int ancho;

	HashMap<Coordenada, Unidad> mapa;
	ArrayList<Ocupable> unidadesConPoblacion;
	ArrayList<Ocupable> unidadesConEmpleo;
	ArrayList<Daniable> unidadesDaniables;

	public MapaEdilicio(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		mapa = new HashMap<Coordenada, Unidad>();
		unidadesConPoblacion = new ArrayList<Ocupable>();
		unidadesConEmpleo = new ArrayList<Ocupable>();
		unidadesDaniables = new ArrayList<Daniable>();
	}

	public boolean agregar(Unidad elemento) {
		int x = elemento.coordenadas().getX();
		int y = elemento.coordenadas().getY();
		if (!this.validarCoordenadas(x, y) || this.contiene(elemento)) {
			return false;
		}
		if (!this.mapa.containsKey(elemento.coordenadas())) {
			this.mapa.put(elemento.coordenadas(), elemento);
			return true;
		}
		return false;
	}

	public boolean agregarUnidadConPoblacion(Ocupable unidad) {
		if (unidadesConPoblacion == null) {
			unidadesConPoblacion = new ArrayList<Ocupable>();
		}
		return unidadesConPoblacion.add(unidad);
	}

	public boolean agregarUnidadConEmpleo(Ocupable unidad) {
		if (unidadesConEmpleo == null) {
			unidadesConEmpleo = new ArrayList<Ocupable>();
		}
		return unidadesConEmpleo.add(unidad);
	}

	public boolean agregarUnidadDaniable(Daniable unidad) {
		if (unidadesDaniables == null) {
			unidadesDaniables = new ArrayList<Daniable>();
		}
		return unidadesDaniables.add(unidad);
	}

	public ArrayList<Ocupable> unidadesConPoblacion() {
		return unidadesConPoblacion;
	}

	public ArrayList<Ocupable> unidadesConEmpleo() {
		return unidadesConEmpleo;
	}

	public ArrayList<Daniable> unidadesDaniables() {
		return unidadesDaniables;
	}

	public void remover(int x, int y) {
		this.mapa.remove(new Coordenada(x, y));
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
		return (this.mapa.containsKey(new Coordenada(x, y)));
	}

	public boolean vacia() {
		return (this.mapa.isEmpty());
	}

	public Coordenada getCoordenadas(Unidad elemento) {
		for (Entry<Coordenada, Unidad> entry : mapa.entrySet()) {
			if (entry.getValue().equals(elemento)) {
				return entry.getKey();
			}
		}
		return null;
	}

	public Unidad getUnidadEn(int x, int y) {
		if (tieneCoordenadaOcupada(x, y)) {
			Coordenada p = new Coordenada(x, y);
			return (this.mapa.get(p));
		} else {
			return null;
		}

	}

	public ArrayList<Daniable> getUnidadesAlrededorDe(Coordenada epicentro,
			int radio) {
		ArrayList<Daniable> unidadesADevolver = new ArrayList<Daniable>();
		Coordenada inic = calcularCoordenadaDeInicio(epicentro, radio);
		Coordenada fin = calcularCoordenadaDeFin(epicentro, radio);

		for (int x = (int) inic.getX(); x < (int) fin.getX(); x++) {
			for (int y = (int) inic.getY(); y < (int) fin.getY(); y++) {
				if (validarCoordenadas(x, y) && existeDaniable(x, y)) {
					unidadesADevolver.add((Daniable) this.getDaniableEn(x, y));
				}
			}
		}
		return unidadesADevolver;
	}

	public ArrayList<Daniable> getDaniablesEnElCaminoDe(
			LinkedList<Point> listaCamino) {

		ArrayList<Daniable> listaDaniablesEnElCamino = new ArrayList<Daniable>();
		Iterator<Point> iterador = listaCamino.iterator();
		while (iterador.hasNext()) {
			Point punto = iterador.next();
			if (existeDaniable((int) punto.getX(), (int) punto.getY())) {

				listaDaniablesEnElCamino.add(getDaniableEn((int) punto.getX(),
						(int) punto.getY()));

			}
		}

		return listaDaniablesEnElCamino;
	}

	private boolean existeDaniable(int x, int y) {
		Iterator<Daniable> it = unidadesDaniables.iterator();
		while (it.hasNext()) {
			Daniable d = it.next();
			if (d.coordenadas().getX() == x && d.coordenadas().getY() == y) {
				return true;
			}
		}
		return false;
	}

	private Daniable getDaniableEn(int x, int y) {
		Iterator<Daniable> it = unidadesDaniables.iterator();
		while (it.hasNext()) {
			Daniable d = it.next();
			if (d.coordenadas().getX() == x && d.coordenadas().getY() == y) {
				return d;
			}
		}
		return null;

	}

	private Coordenada calcularCoordenadaDeInicio(Coordenada epicentro,
			int radio) {
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
		return new Coordenada(xi, yi);
	}

	private Coordenada calcularCoordenadaDeFin(Coordenada epicentro, int radio) {
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
		return new Coordenada(xf, yf);
	}

	public int capacidadDePoblacion() {
		int capacidad = 0;
		for (Ocupable unidad : unidadesConPoblacion) {
			capacidad += unidad.capacidad();
		}
		return capacidad;
	}

	public int capacidadDeEmpleo() {
		int capacidad = 0;
		for (Ocupable unidad : unidadesConEmpleo) {
			capacidad += unidad.capacidad();
		}
		return capacidad;
	}
}