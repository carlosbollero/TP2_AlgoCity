/********************************************************** 
 * 
 * Para que funcione esta clase se debe agregar al proyecto
 * la librería JGraphT descargable de http://jgrapht.org/ 
 * Archivos fuentes en https://github.com/jgrapht/jgrapht 
 * 
 **********************************************************/

package algo3.algocity.model;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableUndirectedGraph;

public class MapaConexiones{

	 int alto;
	 int ancho;
	ListenableUndirectedGraph<Parcela, DefaultEdge> grafo;

	public MapaConexiones(int alto, int ancho) {
		
		this.alto = alto;
		this.ancho = ancho;
		this.grafo = new ListenableUndirectedGraph<Parcela, DefaultEdge>(
				DefaultEdge.class);
	}

	//TODO REVISAR
	public boolean agregar(Conector elemento, int x, int y) {
		Parcela parcela = new Parcela(elemento, x, y);
		if (this.validarCoordenadas(x, y) && !this.contiene(elemento)) {
			return this.grafo.addVertex(parcela);
		}
		return false;
	}

	public boolean contiene(Conector elemento) {
		return (this.grafo.containsVertex(elemento.contenedor()));
	}

	private boolean validarCoordenadas(int x, int y) {
		return (this.estaDentroDeLimites(x, y));
	}
	
	private boolean estaDentroDeLimites(int x, int y) {
		return ((x >= 0) && (x <= this.alto) && (y >= 0) && (y <= this.ancho));
	}

}