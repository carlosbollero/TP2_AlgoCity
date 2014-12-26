package algo3.algocity.model.mapas;

import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.construcciones.PozoDeAgua;

public class MapaTuberias extends MapaConexiones {

	public MapaTuberias(Mapa mapa) {
		super(mapa);
	}

	public boolean agregar(Tuberia tuberia) {
		if (contiene(tuberia) || tieneCoordenadaOcupada(tuberia.coordenada())) {
			return false;
		}
		//AGREGADo
		mapaConectores.put(tuberia.coordenada(),tuberia);
		grafo.addVertex(tuberia);
		actualizarGrafo(tuberia);
		setChanged();
		notifyObservers();
		return true;
	}

	@Override
	public boolean hayConexion(Coordenada coord) {
		for (PozoDeAgua p : mapa.ciudad().getPozosDeAgua()) {
			if (hayConexion(coord, p.coordenada())) {
				return true;
			}
		}
		return false;
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
	@SuppressWarnings("rawtypes")
	public Element getElement(Document doc, Element red) {

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
		// TODO
		// El grafo no es necesario serializarlo?
		return red;
	}
	
	public static MapaTuberias fromElement(Node tuberias, Mapa mapa) {
		MapaTuberias mapaTuberias = new MapaTuberias(mapa);
		mapaTuberias.mapa = mapa;
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
									"Tuberia")) {
								Tuberia tb = new Tuberia();
								tb.fromElement(hijoDeNodo);
								tb.setCoordenadas(puntoAAgregar);
								mapaTuberias.agregar(tb);
								//mapaTuberias.mapaConectores.put(puntoAAgregar,tb);
							} 
						}
					}
				}
			} 
		}
		// imprimirMapaConexiones(mapaConexiones);
		return mapaTuberias;
	}
}
