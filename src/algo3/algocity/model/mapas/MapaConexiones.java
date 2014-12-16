/**********************************************************  
 /********************************************************** 
 * 
 * Para que funcione esta clase se debe agregar al proyecto
 * la librería JGraphT descargable de http://jgrapht.org/ 
 * Archivos fuentes en https://github.com/jgrapht/jgrapht 
 * 
 **********************************************************/

package algo3.algocity.model.mapas;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadEnergetica;

public class MapaConexiones {

	int alto;
	int ancho;
	LinkedHashMap<Coordenada, Conector> mapa;
	ArrayList<Unidad> posicionesRelevantes;

	SimpleGraph<Conector, DefaultEdge> grafo;
	ConnectivityInspector<Conector, DefaultEdge> camino;

	public MapaConexiones(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.mapa = new LinkedHashMap<Coordenada, Conector>();
		this.grafo = new SimpleGraph<Conector, DefaultEdge>(DefaultEdge.class);
		posicionesRelevantes = new ArrayList<Unidad>();
	}

	/* Para tests */
	public MapaConexiones() {
		this.mapa = new LinkedHashMap<Coordenada, Conector>();
		this.grafo = new SimpleGraph<Conector, DefaultEdge>(DefaultEdge.class);
		posicionesRelevantes = new ArrayList<Unidad>();
	}

	public boolean agregar(Conector elemento) {
		int x = elemento.coordenadas().getX();
		int y = elemento.coordenadas().getY();
		if (this.validarCoordenadas(x, y) && !this.contiene(elemento)
				&& !this.tieneCoordenadaOcupada(x, y)) {
			this.mapa.put(new Coordenada(x, y), elemento);
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
		for (Entry<Coordenada, Conector> entry : mapa.entrySet()) {
			if (hayDistanciaMinima(new Coordenada(x, y), entry.getKey())) {
				grafo.addEdge(elemento, entry.getValue());
			}
		}
	}

	private boolean hayDistanciaMinima(Coordenada point, Coordenada key) {
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
		// if ((Math.abs(x1 - x2) == 1) && (Math.abs(y1 - y2) == 1)) {
		// return true;
		// }
		return resultado;
	}

	public boolean contiene(Conector elemento) {
		return (this.mapa.containsValue(elemento) && this.grafo
				.containsVertex(elemento));
	}

	public Conector getConectorEn(int x, int y) {
		if (tieneCoordenadaOcupada(x, y)) {
			Coordenada p = new Coordenada(x, y);
			return (this.mapa.get(p));
		} else {
			return null;
		}
	}

	private boolean validarCoordenadas(int x, int y) {
		return (this.estaDentroDeLimites(x, y));
	}

	private boolean estaDentroDeLimites(int x, int y) {
		return ((x >= 0) && (x <= this.alto) && (y >= 0) && (y <= this.ancho));
	}

	public boolean tieneCoordenadaOcupada(int x, int y) {
		return (this.mapa.containsKey(new Coordenada(x, y)));
	}

	public boolean hayConexion(Coordenada unPunto, Coordenada otroPunto) {
		this.camino = new ConnectivityInspector<Conector, DefaultEdge>(grafo);
		return (camino.pathExists(mapa.get(unPunto), mapa.get(otroPunto)));
	}

	public boolean hayConexion(Coordenada unPunto) {
		for (Unidad ur : posicionesRelevantes) {
			if (estaDentroDeRangoUnidadEnergetica(unPunto, ur)
					|| hayConexion(unPunto, ur.coordenadas())) {
				return true;
			}
		}
		return false;
	}

	public Coordenada coordenadas(Conector elemento) {
		for (Entry<Coordenada, Conector> entry : mapa.entrySet()) {
			if (entry.getValue().equals(elemento)) {
				return entry.getKey();
			}
		}
		return null;
	}

	public boolean hayConectorAdyacente(Coordenada coord) {
		for (Entry<Coordenada, Conector> entry : mapa.entrySet()) {
			if (hayDistanciaMinima(coord, entry.getKey())) {
				return true;
			}
		}
		return false;
	}

	public boolean agregarPosicionRelevante(Unidad u) {
		if (posicionesRelevantes == null) {
			posicionesRelevantes = new ArrayList<Unidad>();
		}
		return posicionesRelevantes.add(u);
	}

	public ArrayList<Unidad> posicionesRelevantes() {
		return this.posicionesRelevantes;
	}

	public boolean sePuedeConstruir(Unidad unidad) {
		for (Unidad ur : posicionesRelevantes) {
			if (estaDentroDeRangoUnidadEnergetica(unidad.coordenadas(), ur)
					|| hayConexion(unidad.coordenadas(), ur.coordenadas())) {

				return true;
			}
		}
		return false;
	}

	private boolean estaDentroDeRangoUnidadEnergetica(
			Coordenada coordACorroborar, Unidad unidadRelevante) {
		// TODO CORREGIRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
		if (unidadRelevante instanceof UnidadEnergetica) {
			int rango = ((UnidadEnergetica) unidadRelevante)
					.getRadioDeInfluencia();
			return estaDentroDeRango(coordACorroborar,
					unidadRelevante.coordenadas(), rango);
		}
		return false;
	}

	private boolean estaDentroDeRango(Coordenada coordACorroborar,
			Coordenada coordURelevante, int rango) {
		if (coordACorroborar.distancia(coordURelevante) <= rango) {
			return true;
		}
		return false;
	}

	public boolean sePuedeConstruir(Conector conector) {
		return tieneCoordenadaOcupada(conector.coordenadas().x,
				conector.coordenadas().y);
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
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
			Coordenada clave = (Coordenada) e.getKey();
			Conector valor = (Conector) e.getValue();

			Element nodo = doc.createElement("Nodo");
			mapa.appendChild(nodo);

			Element point = doc.createElement("Coordenada");
			nodo.appendChild(point);
			point.setTextContent(String.valueOf((int) clave.getX()) + ","
					+ String.valueOf((int) clave.getY()));

			Element conector = valor.getElement(doc);
			nodo.appendChild(conector);
		}

		/* Serializacion de posiciones relevantes */
		Element posicionesRelevantes = doc
				.createElement("posicionesRelevantes");
		red.appendChild(posicionesRelevantes);
		Iterator<Unidad> it = this.posicionesRelevantes.iterator();
		/*
		 * falta probar esta parte.. solo se estan agregando las coordenadas
		 * como posiciones relevantes
		 */
		while (it.hasNext()) {
			Unidad p = it.next();
			Element punto = doc.createElement("Unidad");
			posicionesRelevantes.appendChild(punto);
			punto.appendChild(p.getElement(doc));
		}
		// TODO
		// El grafo no es necesario serializarlo?
		return red;
	}

	public static MapaConexiones fromElement(Node tuberias) {
		MapaConexiones mapaConexiones = new MapaConexiones();
		NodeList hijosDeRed = tuberias.getChildNodes();

		for (int i = 0; i < hijosDeRed.getLength(); i++) {
			Node hijoDeRed = hijosDeRed.item(i);
			if (hijoDeRed.getNodeName().equals("alto")) {
				mapaConexiones.alto = Integer.valueOf(hijoDeRed
						.getTextContent());
			} else if (hijoDeRed.getNodeName().equals("ancho")) {
				mapaConexiones.ancho = Integer.valueOf(hijoDeRed
						.getTextContent());
			} else if (hijoDeRed.getNodeName().equals("mapa")) {
				NodeList hijosDeMapa = hijoDeRed.getChildNodes();
				for (int j = 0; j < hijosDeMapa.getLength(); j++) {
					Node hijoDeMapa = hijosDeMapa.item(j);
					if (hijoDeMapa.getNodeName().equals("Nodo")) {
						NodeList hijosDeNodo = hijoDeMapa.getChildNodes();
						String stringPunto = "";
						Coordenada puntoAAgregar = new Coordenada();
						for (int k = 0; k < hijosDeNodo.getLength(); k++) {
							Node hijoDeNodo = hijosDeNodo.item(k);
							if (hijoDeNodo.getNodeName().equals("Coordenada")) {
								stringPunto = hijoDeNodo.getTextContent();
								String[] arrayPunto = stringPunto.split(",");
								puntoAAgregar = new Coordenada(
										Integer.valueOf(arrayPunto[0]),
										Integer.valueOf(arrayPunto[1]));
							} else if (hijoDeNodo.getNodeName().equals(
									"Tuberia")) {
								Tuberia tb = Tuberia.fromElement(hijoDeNodo);
								tb.setCoordenadas(puntoAAgregar);
								mapaConexiones.agregar(tb);

							} else if (hijoDeNodo.getNodeName().equals("Ruta")) {
								Ruta rt = Ruta.fromElement(hijoDeNodo);
								rt.setCoordenadas(puntoAAgregar);
								mapaConexiones.agregar(rt);
							} else if (hijoDeNodo.getNodeName().equals(
									"LineaTension")) {
								LineaTension lt = LineaTension
										.fromElement(hijoDeNodo);
								lt.setCoordenadas(puntoAAgregar);
								mapaConexiones.agregar(lt);
							}
						}
					}
				}
			} else if (hijoDeRed.getNodeName().equals("posicionesRelevantes")) {
				NodeList hijosDePosicionesRelevantes = hijoDeRed
						.getChildNodes();
				// String stringPunto = "";
				// Coordenada puntoAAgregar = new Coordenada();
				for (int k = 0; k < hijosDePosicionesRelevantes.getLength(); k++) {
					Node hijoDePosicionRelevante = hijosDePosicionesRelevantes
							.item(k);
					if (hijoDePosicionRelevante.getNodeName().equals("Unidad")) {
						NodeList hijosDeUnidad = hijoDePosicionRelevante
								.getChildNodes();
						for (int l = 0; l < hijosDeUnidad.getLength(); l++) {
							Node hijoDeUnidad = hijosDeUnidad.item(l);
							if (hijoDeUnidad.getNodeName().equals(
									"CentralMinera")) {
								CentralMinera cm = CentralMinera
										.fromElement(hijoDeUnidad);
								mapaConexiones.posicionesRelevantes.add(cm);
							} else if (hijoDeUnidad.getNodeName().equals(
									"CentralNuclear")) {
								CentralNuclear cn = CentralNuclear
										.fromElement(hijoDeUnidad);
								mapaConexiones.posicionesRelevantes.add(cn);
							} else if (hijoDeUnidad.getNodeName().equals(
									"CentralEolica")) {
								CentralEolica ce = CentralEolica
										.fromElement(hijoDeUnidad);
								mapaConexiones.posicionesRelevantes.add(ce);
							} else if (hijoDeUnidad.getNodeName().equals(
									"PozoDeAgua")) {
								PozoDeAgua pa = PozoDeAgua
										.fromElement(hijoDeUnidad);
								mapaConexiones.posicionesRelevantes.add(pa);
							}
						}
					}
				}
			}
		}
		//imprimirMapaConexiones(mapaConexiones);
		return mapaConexiones;
	}

	/* Para probar */
	private static void imprimirMapaConexiones(MapaConexiones mapaConexiones) {
		System.out.println("imprimiendo mapa conexiones");
		for (Map.Entry e : mapaConexiones.mapa.entrySet()) {
			Coordenada clave = (Coordenada) e.getKey();
			Conector valor = (Conector) e.getValue();

			System.out.println(String.valueOf(clave.getX()));
			System.out.println(String.valueOf(clave.getY()));
			System.out.println(valor.getClass());
		}
	}

}