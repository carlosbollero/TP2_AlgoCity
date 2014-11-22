package algo3.algocity.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map.Entry;


public class MapaEdilicio extends Mapa {

	HashMap<Point, Ubicable> posiciones;

	public MapaEdilicio(int alto, int ancho) {
		super(alto, ancho);
		this.posiciones = new HashMap<Point, Ubicable>();
	}

	public boolean agregar(Ubicable elemento, int x, int y) {
		if (!this.validarCoordenadas(x, y) || this.contiene(elemento)) {
			return false;
		}
		Point clave = new Point(x, y);
		if (!this.posiciones.containsKey(clave)) {
			this.posiciones.put(clave, elemento);
			return true;
		}
		return false;
	}

	public void remover(int x, int y) {
		this.posiciones.remove(new Point(x, y));
	}

	private boolean validarCoordenadas(int x, int y) {
		return (this.estaDentroDeLimites(x, y));
	}

	public boolean contiene(Ubicable unaUnidad) {
		return (this.posiciones.containsValue(unaUnidad));
	}

	@Override
	public boolean tieneCoordenadaOcupada(int x, int y) {
		return (this.posiciones.containsKey(new Point(x, y)));
	}

	@Override
	protected boolean estaVacio() {
		return (this.posiciones.isEmpty());
	}
	
	public Point getCoordenadas(Ubicable elemento){
		for (Entry<Point, Ubicable> entry : posiciones.entrySet()){
			if (entry.getValue().equals(elemento)){
				return entry.getKey();
			}
		}
		return null;
	}

}
