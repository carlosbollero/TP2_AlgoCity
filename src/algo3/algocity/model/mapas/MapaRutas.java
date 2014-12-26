package algo3.algocity.model.mapas;

import java.util.ArrayList;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.Ruta;

public class MapaRutas extends MapaConexiones {
	
	ArrayList<Ruta> listado;

	public MapaRutas(Mapa mapa) {
		super(mapa);
		listado = new ArrayList<Ruta>();
	}

	public boolean agregar(Ruta ruta) {
		if (contiene(ruta) || tieneCoordenadaOcupada(ruta.coordenada())) {
			return false;
		}
		//AGREGAODO
		mapaConectores.put(ruta.coordenada(),ruta);
		listado.add(ruta);
		grafo.addVertex(ruta);
		actualizarGrafo(ruta);
		setChanged();
		notifyObservers();
		return true;
	}

	@Override
	public boolean hayConexion(Coordenada coord) {
		return hayConectorAdyacente(coord);
	}

	public boolean hayConectorAdyacente(Coordenada coord) {
		for (Conector c : grafo.vertexSet()) {
			if (hayDistanciaMinima(coord, c.coordenada())) {
				return true;
			}
		}
		return false;
	}

	// @Override
	// protected void actualizarGrafo(Conector elemento) {
	// for (Entry<Coordenada, Conector> entry : mapaConectores.entrySet()) {
	// if (hayDistanciaMinima(elemento.coordenada(), entry.getKey())) {
	// grafo.addEdge(elemento, entry.getValue());
	// }
	// }
	// }

	public ArrayList<Daniable> unidadesDaniables() {
		ArrayList<Daniable> lista = new ArrayList<Daniable>();
		for (Conector c : grafo.vertexSet()) {
			lista.add((Daniable) c);
		}
		return lista;
	}
		public Conector getConectorEn(int x, int y) {
		Coordenada coordEvaluar = new Coordenada(x,y);
		for (Conector c : grafo.vertexSet()) {
			if (c.coordenada().equals(coordEvaluar)) {
				return c;
			}
		}
		return null;
	}
	
	
	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	
	public static MapaRutas fromElement(Node tuberias, Mapa mapa) {
		MapaRutas mapaRutas = new MapaRutas(mapa);
		mapaRutas.mapa = mapa;
		NodeList hijosDeRed = tuberias.getChildNodes();

		for (int i = 0; i < hijosDeRed.getLength(); i++) {
			Node hijoDeRed = hijosDeRed.item(i);
			if (hijoDeRed.getNodeName().equals("mapa")) {
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
									"Ruta")) {
								Ruta rt = new Ruta();
								rt.fromElement(hijoDeNodo);
								rt.setCoordenadas(puntoAAgregar);
								mapaRutas.agregar(rt);
								//mapaTuberias.mapaConectores.put(puntoAAgregar,tb);
							} 
						}
					}
				}
			} 
		}
		// imprimirMapaConexiones(mapaConexiones);
		return mapaRutas;
	}
}
