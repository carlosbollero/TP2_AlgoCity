/********************************************************** 
 * 
 * Para que funcione esta clase se debe agregar al proyecto
 * la librería JGraphT descargable de http://jgrapht.org/ 
 * Archivos fuentes en https://github.com/jgrapht/jgrapht 
 * 
 **********************************************************/

package algo3.algocity.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableUndirectedGraph;

public class MapaConexiones {

	int alto;
	int ancho;
	HashMap<Point, Conector> lista;
	ListenableUndirectedGraph<Conector, DefaultEdge> grafo;

	public MapaConexiones(int alto, int ancho) {

		this.alto = alto;
		this.ancho = ancho;
		this.lista = new HashMap<Point, Conector>();
		this.grafo = new ListenableUndirectedGraph<Conector, DefaultEdge>(
				DefaultEdge.class);
	}

	// TODO REVISAR
	public boolean agregar(Conector elemento, int x, int y) {
		if (this.validarCoordenadas(x, y) && !this.contiene(elemento) && !this.tieneCoordenadaOcupada(x, y)) {
			this.lista.put(new Point(x, y), elemento);
			this.grafo.addVertex(elemento);
			this.actualizarGrafo(elemento, x,y);
			return true;
		}
		return false;
	}

	private void actualizarGrafo(Conector elemento, int x, int y) {
		Map<Point, Conector> mapa = this.lista;
		for (Map.Entry<Point, Conector> entry : mapa.entrySet()){
			if (entry.getX() == (x + 1) || entry.getX() == (x - 1)){
				if (entry.getY() == (y + 1) || entry.getY() == (y - 1)){
					this.grafo.addEdge(elemento, this.lista.get(entry));
				}
			}
		}
		
	}

	public boolean contiene(Conector elemento) {
		return (this.lista.containsValue(elemento) && this.grafo.containsVertex(elemento));
	}

	private boolean validarCoordenadas(int x, int y) {
		return (this.estaDentroDeLimites(x, y));
	}

	private boolean estaDentroDeLimites(int x, int y) {
		return ((x >= 0) && (x <= this.alto) && (y >= 0) && (y <= this.ancho));
	}
	
	public boolean tieneCoordenadaOcupada(int x, int y) {
		return (this.lista.containsKey(new Point(x, y)));
	}

}