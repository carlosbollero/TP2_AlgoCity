/**********************************************************  
 /********************************************************** 
 * 
 * Para que funcione esta clase se debe agregar al proyecto
 * la librería JGraphT descargable de http://jgrapht.org/ 
 * Archivos fuentes en https://github.com/jgrapht/jgrapht 
 * 
 **********************************************************/

package algo3.algocity.model.mapas;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.construcciones.Unidad;

public class MapaConexiones {

	int alto;
	int ancho;
	LinkedHashMap<Point, Conector> mapa;
	ArrayList<Point> posicionesRelevantes;
	SimpleGraph<Conector, DefaultEdge> grafo;
	ConnectivityInspector<Conector, DefaultEdge> camino;

	public MapaConexiones(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.mapa = new LinkedHashMap<Point, Conector>();
		this.grafo = new SimpleGraph<Conector, DefaultEdge>(DefaultEdge.class);
		posicionesRelevantes = new ArrayList<Point>();
	}

	public boolean agregar(Conector elemento) {
		int x = elemento.coordenadas().x;
		int y = elemento.coordenadas().y;
		if (this.validarCoordenadas(x, y) && !this.contiene(elemento)
				&& !this.tieneCoordenadaOcupada(x, y)) {
			this.mapa.put(new Point(x, y), elemento);
			this.grafo.addVertex(elemento);
			this.actualizarGrafo(elemento, x, y);
			return true;
		}
		return false;
	}

	public int cantidadElementos() {
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
		boolean resultado = false;
		int x1 = point.x;
		int y1 = point.y;
		int x2 = key.x;
		int y2 = key.y;
		if ((Math.abs(x1 - x2) == 1) && (y1 == y2)) {
			resultado = true;
		}
		if ((x1 == x2) && (Math.abs(y1 - y2) == 1)) {
			resultado = true;
		}
		// if ((Math.abs(x1 - x2) == 1) && (Math.abs(y1 - y2) == 1)) {
		// return true;
		// }
		return resultado;
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

	public boolean hayConexion(Point unPunto) {
		for (Point coord : posicionesRelevantes) {
			if (hayConexion(unPunto, coord)) {
				return true;
			}
		}
		return false;
	}

	public Point coordenadas(Conector elemento) {
		for (Entry<Point, Conector> entry : mapa.entrySet()) {
			if (entry.getValue().equals(elemento)) {
				return entry.getKey();
			}
		}
		return null;
	}

	public boolean hayConectorAdyacente(Point coord) {
		for (Entry<Point, Conector> entry : mapa.entrySet()) {
			if (hayDistanciaMinima(coord, entry.getKey())) {
				return true;
			}
		}
		return false;
	}

	public boolean agregarPosicionRelevante(Point punto) {
		if (posicionesRelevantes == null) {
			posicionesRelevantes = new ArrayList<Point>();
		}
		return posicionesRelevantes.add(punto);

	}

	public boolean sePuedeConstruir(Unidad unidad) {
		for (Point coord : posicionesRelevantes) {
			if (hayConexion(unidad.coordenadas(), coord)) {
				return true;
			}
		}
		return false;
	}

	public boolean sePuedeConstruir(Conector conector) {
		return tieneCoordenadaOcupada(conector.coordenadas().x,
				conector.coordenadas().y);
	}

	
	/*Persistencia*/
	@SuppressWarnings("rawtypes")
	public Element getElement(Document doc, Element red) {	
		
		Element alto = doc.createElement("alto");
		red.appendChild(alto);
		alto.setTextContent(String.valueOf(this.alto));

		Element ancho = doc.createElement("ancho");
		red.appendChild(ancho);
		ancho.setTextContent(String.valueOf(this.ancho));

		Element mapa = doc.createElement("mapa");
		red.appendChild(mapa);		
		

		/* Serializacion de conectores del mapa */
		for (Map.Entry e : this.mapa.entrySet()) {
			Point clave = (Point) e.getKey();
			Conector valor = (Conector) e.getValue();

			Element point = doc.createElement("Point");
			mapa.appendChild(point);
			point.setTextContent(String.valueOf((int) clave.getX()) + ","
					+ String.valueOf((int) clave.getY()));

			Element conector = valor.getElement(doc);
			mapa.appendChild(conector);
		}
		
		
		/* Serializacion de posiciones relevantes */
		Element posicionesRelevantes = doc
				.createElement("posicionesRelevantes");
		red.appendChild(posicionesRelevantes);
		Iterator<Point> it = this.posicionesRelevantes.iterator();
		while (it.hasNext()) {
			Point p = it.next();
			Element punto = doc.createElement("Point");
			posicionesRelevantes.appendChild(punto);
			punto.setTextContent(String.valueOf((int) p.getX()) + ","
					+ String.valueOf((int) p.getY()));
		}		
		
		//TODO
		//El grafo no es necesario serializarlo?		
		return red;
	}

}