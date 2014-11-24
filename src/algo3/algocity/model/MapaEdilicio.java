package algo3.algocity.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map.Entry;

public class MapaEdilicio extends Mapa {

	HashMap<Point, Ubicable> mapa;
	//boolean existeEstacionDeBomberos;
	//para saber si los ubicables del mapa se pueden reparar
	

	public MapaEdilicio(int alto, int ancho) {
		super(alto, ancho);
		this.mapa = new HashMap<Point, Ubicable>();
	}

	public boolean agregar(Ubicable elemento, int x, int y) {
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

	public boolean contiene(Ubicable unaUnidad) {
		return (this.mapa.containsValue(unaUnidad));
	}

	@Override
	public boolean tieneCoordenadaOcupada(int x, int y) {
		return (this.mapa.containsKey(new Point(x, y)));
	}

	@Override
	protected boolean estaVacio() {
		return (this.mapa.isEmpty());
	}

	public Point getCoordenadas(Ubicable elemento) {
		for (Entry<Point, Ubicable> entry : mapa.entrySet()) {
			if (entry.getValue().equals(elemento)) {
				return entry.getKey();
			}
		}
		return null;
	}

}
