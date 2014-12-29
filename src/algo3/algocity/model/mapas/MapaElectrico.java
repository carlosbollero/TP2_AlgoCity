package algo3.algocity.model.mapas;

import java.util.ArrayList;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import algo3.algocity.model.Dinero;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;

public class MapaElectrico extends MapaConexiones {

	ArrayList<LineaTension> listado;

	public MapaElectrico(Mapa mapa) {
		super(mapa);
		listado = new ArrayList<LineaTension>();
	}

	public boolean agregar(LineaTension linea) {
		if (contiene(linea) || tieneCoordenadaOcupada(linea.coordenada())) {
			return false;
		}
		listado.add(linea);
		grafo.addVertex(linea);
		actualizarGrafo(linea);
		setChanged();
		notifyObservers(linea);
		return true;
	}

	@Override
	public boolean hayConexion(Coordenada coord) {
		for (UnidadEnergetica u : mapa.ciudad().getUnidadesEnergeticas()) {
			if (u.estaDentroDeRadio(coord)) {
				return true;
			}
			if (hayConexion(coord, u.coordenada())) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Daniable> unidadesDaniables() {
		ArrayList<Daniable> lista = new ArrayList<Daniable>();
		for (LineaTension lt : listado) {
			lista.add(lt);
		}
		return lista;
	}

	public Conector getConectorEn(int x, int y) {
		Coordenada coordEvaluar = new Coordenada(x, y);
		for (Conector c : grafo.vertexSet()) {
			if (c.coordenada().equals(coordEvaluar)) {
				return c;
			}
		}
		return null;
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**
	 * @param d
	 * @throws CoordenadaInvalidaException
	 * @throws FondosInsuficientesException
	 * @throws NoSeCumplenLosRequisitosException
	 ********************************************************************/

	public static MapaElectrico fromElement(Node tuberias, Mapa mapa, Dinero d)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, CoordenadaInvalidaException {
		MapaElectrico mapaElectrico = new MapaElectrico(mapa);
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
									"LineaTension")) {
								LineaTension lt = new LineaTension(mapa, d,
										puntoAAgregar);
								lt.fromElement(hijoDeNodo);
								mapaElectrico.agregar(lt);
								d.add(lt.costo());
							}
						}
					}
				}
			}
		}
		return mapaElectrico;
	}
}
