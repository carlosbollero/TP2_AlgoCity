/********************************************************** 
 * 
 * Para que funcione esta clase se debe agregar al proyecto
 * la librería JGraphT descargable de http://jgrapht.org/ 
 * Archivos fuentes en https://github.com/jgrapht/jgrapht 
 * 
 **********************************************************/

package algo3.algocity.model;

import java.awt.Point;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class MapaConexiones {

	int alto;
	int ancho;
	LinkedHashMap<Point, Conector> mapa;
	SimpleGraph<Conector, DefaultEdge> grafo;
	ConnectivityInspector<Conector, DefaultEdge> camino;

	public MapaConexiones(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.mapa = new LinkedHashMap<Point, Conector>();
		this.grafo = new SimpleGraph<Conector, DefaultEdge>(DefaultEdge.class);
	}

	public boolean agregar(Conector elemento, int x, int y) {
		if (this.validarCoordenadas(x, y) && !this.contiene(elemento)
				&& !this.tieneCoordenadaOcupada(x, y)) {
			this.mapa.put(new Point(x, y), elemento);
			this.grafo.addVertex(elemento);
			this.actualizarGrafo(elemento, x, y);
			return true;
		}
		return false;
	}

	public int getCantidadElementos() {
		return (grafo.vertexSet().size());
	}

	private void actualizarGrafo(Conector elemento, int x, int y) {
		for (Entry<Point, Conector> entry : mapa.entrySet()) {
			if (hayDistanciaMinima(new Point(x, y), entry.getKey())) {
				grafo.addEdge(elemento, entry.getValue());
			}
		}
	}

	private boolean hayDistanciaMinima(Point point, Point key) {
		int x1 = (int) point.getX();
		int y1 = (int) point.getY();
		int x2 = (int) key.getX();
		int y2 = (int) key.getY();
		if ((Math.abs(x1 - x2) == 1) && (y1 == y2)) {
			return true;
		}
		if ((x1 == x2) && (Math.abs(y1 - y2) == 1)) {
			return true;
		}
		if ((Math.abs(x1 - x2) == 1) && (Math.abs(y1 - y2) == 1)) {
			return true;
		}
		return false;
	}

	public boolean contiene(Conector elemento) {
		return (this.mapa.containsValue(elemento) && this.grafo
				.containsVertex(elemento));
	}

	private boolean validarCoordenadas(int x, int y) {
		return (this.estaDentroDeLimites(x, y));
	}

	private boolean estaDentroDeLimites(int x, int y) {
		return ((x >= 0) && (x <= this.alto) && (y >= 0) && (y <= this.ancho));
	}

	public boolean tieneCoordenadaOcupada(int x, int y) {
		return (this.mapa.containsKey(new Point(x, y)));
	}

	public boolean hayConexion(Point unPunto, Point otroPunto) {
		this.camino = new ConnectivityInspector<Conector, DefaultEdge>(grafo);
		return (camino.pathExists(mapa.get(unPunto), mapa.get(otroPunto)));
	}

	public Point getCoordenadas(Conector elemento) {
		for (Entry<Point, Conector> entry : mapa.entrySet()) {
			if (entry.getValue().equals(elemento)) {
				return entry.getKey();
			}
		}
		return null;
	}

}