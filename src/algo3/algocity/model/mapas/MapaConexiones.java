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
import java.util.Observable;

import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.PozoDeAgua;

public abstract class MapaConexiones extends Observable {

//	int tamanio;
	LinkedHashMap<Coordenada, Conector> mapaConectores;
	SimpleGraph<Conector, DefaultEdge> grafo;
	ConnectivityInspector<Conector, DefaultEdge> camino;
	Mapa mapa;

	public MapaConexiones(Mapa mapa) {
		this.mapa = mapa;
//		tamanio = mapa.tamanio();
		mapaConectores = new LinkedHashMap<Coordenada, Conector>();
		grafo = new SimpleGraph<Conector, DefaultEdge>(DefaultEdge.class);
	}

	/* Para tests */
	public MapaConexiones() {
		this.mapaConectores = new LinkedHashMap<Coordenada, Conector>();
		this.grafo = new SimpleGraph<Conector, DefaultEdge>(DefaultEdge.class);
	}

	// public boolean agregar(Conector elemento) {
	// int x = elemento.coordenada().getX();
	// int y = elemento.coordenada().getY();
	// if (validarCoordenadas(x, y) && !contiene(elemento)
	// && !tieneCoordenadaOcupada(x, y)) {
	// this.mapaConectores.put(new Coordenada(x, y), elemento);
	// this.grafo.addVertex(elemento);
	// this.actualizarGrafo(elemento, x, y);
	//
	// setChanged();
	// notifyObservers();
	// return true;
	// }
	// return false;
	// }

	public int cantidadElementos() {
		return (grafo.vertexSet().size());
	}

	protected void actualizarGrafo(Conector elemento) {
		for(Conector c : grafo.vertexSet()){
			if (hayDistanciaMinima(elemento.coordenada(), c.coordenada())) {
				grafo.addEdge(elemento, c);
			}
		}
//		for (Entry<Coordenada, Conector> entry : mapaConectores.entrySet()) {
//			if (hayDistanciaMinima(elemento.coordenada(), entry.getKey())) {
//				grafo.addEdge(elemento, entry.getValue());
//			}
//		}
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
		return (mapaConectores.containsValue(elemento) && grafo
				.containsVertex(elemento));
	}

	public boolean contiene(Coordenada coord) {
		return (mapaConectores.containsKey(coord));
	}

	public Conector getConectorEn(Coordenada coord) {
		if (tieneCoordenadaOcupada(coord)) {
			return (this.mapaConectores.get(coord));
		} else {
			return null;
		}
	}

//	protected boolean validarCoordenadas(Coordenada coord) {
//		return (this.estaDentroDeLimites(coord));
//	}
//
//	private boolean estaDentroDeLimites(Coordenada coord) {
//		return ((coord.getX() >= 0) && (coord.getX() <= tamanio)
//				&& (coord.getY() >= 0) && (coord.getY() <= tamanio));
//	}

	public boolean tieneCoordenadaOcupada(Coordenada coord) {
		return (this.mapaConectores.containsKey(coord));
	}

	public abstract boolean hayConexion(Coordenada unPunto);

	public boolean hayConexion(Coordenada unPunto, Coordenada otroPunto) {
		this.camino = new ConnectivityInspector<Conector, DefaultEdge>(grafo);
		return (camino.pathExists(mapaConectores.get(unPunto),
				mapaConectores.get(otroPunto)));
	}

	public Coordenada getCoordenadaDe(Conector elemento) {
		for (Entry<Coordenada, Conector> entry : mapaConectores.entrySet()) {
			if (entry.getValue().equals(elemento)) {
				return entry.getKey();
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
		Element alto = doc.createElement("alto");
		red.appendChild(alto);
		alto.setTextContent(String.valueOf(this.tamanio));

		Element ancho = doc.createElement("ancho");
		red.appendChild(ancho);
		ancho.setTextContent(String.valueOf(this.tamanio));

		Element mapa = doc.createElement("mapa");
		red.appendChild(mapa);

		/* Serializacion de conectores del mapa */
		for (Map.Entry e : this.mapaConectores.entrySet()) {
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
		Iterator<Coordenada> it = this.posicionesRelevantes.iterator();
		/*
		 * falta probar esta parte.. solo se estan agregando las coordenadas
		 * como posiciones relevantes
		 */
		while (it.hasNext()) {
			Coordenada p = it.next();
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

								Tuberia tb = new Tuberia();
								tb.fromElement(hijoDeNodo);
								tb.setCoordenadas(puntoAAgregar);
								// Tuberia tb = Tuberia.fromElement(hijoDeNodo);
								// tb.setCoordenadas(puntoAAgregar);
								mapaConexiones.agregar(tb);

							} else if (hijoDeNodo.getNodeName().equals("Ruta")) {

								Ruta rt = new Ruta();
								rt.fromElement(hijoDeNodo);
								rt.setCoordenadas(puntoAAgregar);
								// Ruta rt = Ruta.fromElement(hijoDeNodo);
								// rt.setCoordenadas(puntoAAgregar);
								mapaConexiones.agregar(rt);
							} else if (hijoDeNodo.getNodeName().equals(
									"LineaTension")) {
								LineaTension lt = new LineaTension();
								lt.fromElement(hijoDeNodo);
								lt.setCoordenadas(puntoAAgregar);

								// LineaTension lt = LineaTension
								// .fromElement(hijoDeNodo);
								// lt.setCoordenadas(puntoAAgregar);
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
								CentralMinera cm = new CentralMinera();
								cm.fromElement(hijoDeUnidad);

								// CentralMinera cm = CentralMinera
								// .fromElement(hijoDeUnidad);
								mapaConexiones.posicionesRelevantes.add(cm);
							} else if (hijoDeUnidad.getNodeName().equals(
									"CentralNuclear")) {
								CentralNuclear cn = new CentralNuclear();
								cn.fromElement(hijoDeUnidad);

								// CentralNuclear cn = CentralNuclear
								// .fromElement(hijoDeUnidad);
								mapaConexiones.posicionesRelevantes.add(cn);
							} else if (hijoDeUnidad.getNodeName().equals(
									"CentralEolica")) {
								CentralEolica ce = new CentralEolica();
								ce.fromElement(hijoDeUnidad);

								// CentralEolica ce = CentralEolica
								// .fromElement(hijoDeUnidad);
								mapaConexiones.posicionesRelevantes.add(ce);
							} else if (hijoDeUnidad.getNodeName().equals(
									"PozoDeAgua")) {
								PozoDeAgua pa = new PozoDeAgua();
								pa.fromElement(hijoDeUnidad);

								// PozoDeAgua pa = PozoDeAgua
								// .fromElement(hijoDeUnidad);
								mapaConexiones.posicionesRelevantes.add(pa);
							}
						}
					}
				}
			}
		}
		// imprimirMapaConexiones(mapaConexiones);
		return mapaConexiones;
	}

	/* Para probar */
	private static void imprimirMapaConexiones(MapaConexiones mapaConexiones) {
		System.out.println("imprimiendo mapa conexiones");
		for (Map.Entry e : mapaConexiones.mapaConectores.entrySet()) {
			Coordenada clave = (Coordenada) e.getKey();
			Conector valor = (Conector) e.getValue();

			System.out.println(String.valueOf(clave.getX()));
			System.out.println(String.valueOf(clave.getY()));
			System.out.println(valor.getClass());
		}
	}

	public ArrayList<Daniable> unidadesDaniables() {
		for (Daniable d : grafo.vertexSet()) {

		}
		return null;
	}

}