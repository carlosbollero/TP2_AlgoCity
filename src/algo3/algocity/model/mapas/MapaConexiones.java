/**********************************************************  
 /********************************************************** 
 * 
 * Para que funcione esta clase se debe agregar al proyecto
 * la librería JGraphT descargable de http://jgrapht.org/ 
 * Archivos fuentes en https://github.com/jgrapht/jgrapht 
 * 
 **********************************************************/

package algo3.algocity.model.mapas;

import java.util.LinkedHashMap;
import java.util.Observable;

import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import algo3.algocity.model.conexiones.Conector;

public abstract class MapaConexiones extends Observable {

	LinkedHashMap<Coordenada, Conector> mapaConectores;
	SimpleGraph<Conector, DefaultEdge> grafo;
	ConnectivityInspector<Conector, DefaultEdge> camino;
	Mapa mapa;

	public MapaConexiones(Mapa mapa) {
		this.mapa = mapa;
		mapaConectores = new LinkedHashMap<Coordenada, Conector>();
		grafo = new SimpleGraph<Conector, DefaultEdge>(DefaultEdge.class);
	}

	/* Para tests */
	public MapaConexiones() {
		this.mapaConectores = new LinkedHashMap<Coordenada, Conector>();
		this.grafo = new SimpleGraph<Conector, DefaultEdge>(DefaultEdge.class);
	}

	public int cantidadElementos() {
		return (grafo.vertexSet().size());
	}

	protected void actualizarGrafo(Conector elemento) {
		for (Conector c : grafo.vertexSet()) {
			if (hayDistanciaMinima(elemento.coordenada(), c.coordenada())) {
				grafo.addEdge(elemento, c);
			}
		}
	}

	protected boolean hayDistanciaMinima(Coordenada point, Coordenada key) {
		boolean resultado = false;
		int x1 = point.getX();
		int y1 = point.getY();
		int x2 = key.getX();
		int y2 = key.getY();
		if ((Math.abs(x1 - x2) == 1) && (y1 == y2)) {
			resultado = true;
		}
		if ((x1 == x2) && (Math.abs(y1 - y2) == 1)) {
			resultado = true;
		}
		return resultado;
	}

	public boolean contiene(Conector elemento) {
		return (grafo.containsVertex(elemento));
	}

	public boolean tieneCoordenadaOcupada(Coordenada coord) {
		for (Conector c : grafo.vertexSet()) {
			if (c.coordenada().equals(coord)) {
				return true;
			}
		}
		return false;
	}

	public abstract boolean hayConexion(Coordenada unPunto);

	public boolean hayConexion(Coordenada unPunto, Coordenada otroPunto) {
		this.camino = new ConnectivityInspector<Conector, DefaultEdge>(grafo);
		return (camino.pathExists(getConector(unPunto), getConector(otroPunto)));
	}
	
	public Conector get(Coordenada coord){
		return getConector(coord);
	}

	private Conector getConector(Coordenada coord) {
		for (Conector c : grafo.vertexSet()) {
			if (c.coordenada().equals(coord)) {
				return c;
			}
		}
		return null;
	}

	public boolean sePuedeConstruir(Conector conector) {
		return tieneCoordenadaOcupada(conector.coordenada());
	}


	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	
	@SuppressWarnings("rawtypes")
	public Element getElement(Document doc, Element red) {

		Element mapa = doc.createElement("mapa");
		red.appendChild(mapa);
		
		/* Serializacion de conectores del mapa */
		for (Conector tuberia : grafo.vertexSet()) {
			Coordenada coord = tuberia.coordenada();
			Conector tub = tuberia;
			
			Element nodo = doc.createElement("Nodo");
			mapa.appendChild(nodo);
			
			Element point = doc.createElement("Coordenada");
			nodo.appendChild(point);
			point.setTextContent(String.valueOf((int) coord.getX()) + ","
					+ String.valueOf((int) coord.getY()));
			
			Element conector = tub.getElement(doc);
			nodo.appendChild(conector);
		}
		return red;
	}

}