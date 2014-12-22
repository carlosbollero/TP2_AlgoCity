package algo3.algocity.model.mapas;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.excepciones.NoSePuedeConstruirEnSuperficie;
import algo3.algocity.model.terreno.Superficie;
import algo3.algocity.model.terreno.SuperficieAgua;
import algo3.algocity.model.terreno.SuperficieTierra;

public class MapaTerritorio {

	int alto;
	int ancho;
	final boolean tierra = true;
	final boolean agua = false;
	Map<Coordenada, Superficie> mapa;
	GeneradorTerritorio generador;
	Random aleatorio;

	public MapaTerritorio(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		aleatorio = new Random();
		generador = new GeneradorTerritorio(alto, ancho);
		mapa = new HashMap<Coordenada, Superficie>();
		
		inicializar();
	}

	// CONSTRUCTOR PARA TESTS
	/*************************************************************/
	public MapaTerritorio(int alto, int ancho, boolean test) {
		this.alto = alto;
		this.ancho = ancho;
		this.mapa = new HashMap<Coordenada, Superficie>();
		if (test) {
			inicializarConTierraParaTest();
		} else {
			inicializarConAguaParaTest();
		}
	}
	
	public MapaTerritorio() {
		this.mapa = new HashMap<Coordenada, Superficie>();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************/

	private void inicializar() {
		mapa = generador.generarTerritorio();
		
	}

	private boolean agregar(Superficie superficie, int x, int y) {
		Coordenada coord = new Coordenada(x, y);
		mapa.put(coord, superficie);
		return (mapa.containsKey(coord) && mapa.containsValue(superficie));
	}

	public boolean esAgua(Coordenada punto) {
		return (superficie(punto).esAgua());
	}

	public boolean esTierra(Coordenada punto) {
		return (superficie(punto).esTierra());
	}

	public Superficie superficie(Coordenada punto) {
		return (this.mapa.get(punto));
	}

	public boolean sePuedeConstruir(Unidad unidad)
			throws NoSePuedeConstruirEnSuperficie {
		return unidad.esConstruibleEn(superficie(unidad.coordenadas())
				.getSuperficie());
	}

	public boolean sePuedeConstruir(Conector conector)
			throws NoSePuedeConstruirEnSuperficie {
		return conector.esConstruibleEn(superficie(conector.coordenadas())
				.getSuperficie());
	}

	// METODOS UTILIZADOS POR TESTS PARA NO TRABAJAR SOBRE RANDOM
	/****************************************************************/
	private void inicializarConTierraParaTest() {
		for (int x = 0; x < alto; x++) {
			for (int y = 0; y < ancho; y++) {
				Superficie posicion = new SuperficieTierra();
				agregar(posicion, x, y);
			}
		}
	}

	private void inicializarConAguaParaTest() {
		for (int x = 0; x < alto; x++) {
			for (int y = 0; y < ancho; y++) {
				Superficie posicion = new SuperficieAgua();
				agregar(posicion, x, y);
			}
		}
	}

	public Coordenada posicionConAgua() {
		for (Entry<Coordenada, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esAgua()) {
				return entry.getKey();
			}
		}
		return null;
	}

	public Coordenada posicionConTierra() {

		for (Entry<Coordenada, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esTierra()) {
				return entry.getKey();
			}
		}
		return null;
	}
	/****************************************************************/
	
	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	@SuppressWarnings("rawtypes")
	public Element getElement(Document doc, Element territorio) {
		Element alto = doc.createElement("alto");
		territorio.appendChild(alto);
		alto.setTextContent(String.valueOf(this.alto));

		Element ancho = doc.createElement("ancho");
		territorio.appendChild(ancho);
		ancho.setTextContent(String.valueOf(this.ancho));

		Element mapa = doc.createElement("mapa");
		territorio.appendChild(mapa);
		/* Recorrido del hashmap */
		for (Map.Entry e : this.mapa.entrySet()) {
			Coordenada clave = (Coordenada) e.getKey();
			Superficie valor = (Superficie) e.getValue();

			Element nodo = doc.createElement("Nodo");
			mapa.appendChild(nodo);

			Element point = doc.createElement("Coordenada");
			nodo.appendChild(point);
			point.setTextContent(String.valueOf((int) clave.getX()) + ","
					+ String.valueOf((int) clave.getY()));

			Element superficie = doc.createElement("Superficie");
			nodo.appendChild(superficie);
			String sup;
			if (valor.esTierra()) {
				sup = "T";
			} else {
				sup = "A";
			}
			superficie.setTextContent(sup);
		}
		return territorio;
	}

	public static MapaTerritorio fromElement(Node territorio) {

		MapaTerritorio mapaTerritorio = new MapaTerritorio();
		NodeList hijosDeTerritorio = territorio.getChildNodes();

		for (int i = 0; i < hijosDeTerritorio.getLength(); i++) {
			Node hijoDeTerritorio = hijosDeTerritorio.item(i);
			if (hijoDeTerritorio.getNodeName().equals("alto")) {
				mapaTerritorio.alto = Integer.valueOf(hijoDeTerritorio
						.getTextContent());
			} else if (hijoDeTerritorio.getNodeName().equals("ancho")) {
				mapaTerritorio.ancho = Integer.valueOf(hijoDeTerritorio
						.getTextContent());
			} else if (hijoDeTerritorio.getNodeName().equals("mapa")) {
				NodeList hijosDeMapa = hijoDeTerritorio.getChildNodes();
				for (int j = 0; j < hijosDeMapa.getLength(); j++) {
					Node hijoDeMapa = hijosDeMapa.item(j);
					if (hijoDeMapa.getNodeName().equals("Nodo")) {
						NodeList hijosDeNodo = hijoDeMapa.getChildNodes();
						String punto = "";
						String superficie = "";
						for (int k = 0; k < hijosDeNodo.getLength(); k++) {
							Node hijoDeNodo = hijosDeNodo.item(k);
							if (hijoDeNodo.getNodeName().equals("Coordenada")) {
								punto = hijoDeNodo.getTextContent();
							} else if (hijoDeNodo.getNodeName().equals(
									"Superficie")) {
								superficie = hijoDeNodo.getTextContent();
							}
						}

						Superficie superficieAAgregar = null;
						Coordenada puntoAAgregar;

						if (superficie.equals("T")) {
							superficieAAgregar = new SuperficieTierra();
						}
						if (superficie.equals("A")) {
							superficieAAgregar = new SuperficieAgua();
						}

						String[] arrayPunto = punto.split(",");
						puntoAAgregar = new Coordenada(
								Integer.valueOf(arrayPunto[0]),
								Integer.valueOf(arrayPunto[1]));

						mapaTerritorio.mapa.put(puntoAAgregar,
								superficieAAgregar);
					}
				}
			}
		}

		return mapaTerritorio;
	}

	/* Para probar */
	public void imprimirTerritorio() {
		for (Map.Entry e : this.mapa.entrySet()) {
			Coordenada clave = (Coordenada) e.getKey();
			Superficie valor = (Superficie) e.getValue();

			System.out.println(String.valueOf(clave.getX()));
			System.out.println(String.valueOf(clave.getY()));
			if (valor.esTierra()) {
				System.out.println("T");
			}
			if (valor.esAgua()) {
				System.out.println("A");
			}
		}
	}
	
}
