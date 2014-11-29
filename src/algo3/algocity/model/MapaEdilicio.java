package algo3.algocity.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map.Entry;

public class MapaEdilicio  {
	
	int alto;
	int ancho;

	HashMap<Point, Unidad> mapa;

	// boolean existeEstacionDeBomberos;
	// para saber si los ubicables del mapa se pueden reparar

	public MapaEdilicio(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.mapa = new HashMap<Point, Unidad>();
	}

	public boolean agregar(Unidad elemento, int x, int y) {
		if (!this.validarCoordenadas(x, y) || this.contiene(elemento)) {
			return false;
		}
		Point clave = new Point(x, y);
		if (!this.mapa.containsKey(clave)) {
			this.mapa.put(clave, elemento);
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
	
	protected boolean estaDentroDeLimites(int i, int j) {
		return ((i >= 0) && (i <= this.alto) && (j >= 0) && (j <= this.ancho));
	}

	public boolean contiene(Unidad unaUnidad) {
		return (this.mapa.containsValue(unaUnidad));
	}

	public boolean tieneCoordenadaOcupada(int x, int y) {
		return (this.mapa.containsKey(new Point(x, y)));
	}

	protected boolean estaVacio() {
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

	// devuelve si esta conectada a todos los requisitos que correspondan a la
	// unidad
	public boolean estaConectada(Unidad unaUnidad) {
		return unaUnidad.estaConectada();
	}

}
