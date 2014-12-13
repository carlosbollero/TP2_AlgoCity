package algo3.algocity.model.mapas;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Ocupable;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.EstacionDeBomberos;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;

public class MapaEdilicio {

	private int alto;
	private int ancho;

	HashMap<Coordenada, Unidad> mapa;
	ArrayList<Ocupable> unidadesConPoblacion;
	ArrayList<Ocupable> unidadesConEmpleo;
	ArrayList<Daniable> unidadesDaniables;

	public MapaEdilicio(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		mapa = new HashMap<Coordenada, Unidad>();
		unidadesConPoblacion = new ArrayList<Ocupable>();
		unidadesConEmpleo = new ArrayList<Ocupable>();
		unidadesDaniables = new ArrayList<Daniable>();
	}

	/* Para tests */
	public MapaEdilicio() {
		mapa = new HashMap<Coordenada, Unidad>();

		unidadesConPoblacion = new ArrayList<Ocupable>();
		unidadesConEmpleo = new ArrayList<Ocupable>();
		unidadesDaniables = new ArrayList<Daniable>();
	}

	public boolean agregar(Unidad elemento) {
		int x = elemento.coordenadas().getX();
		int y = elemento.coordenadas().getY();
		if (!this.validarCoordenadas(x, y) || this.contiene(elemento)) {
			return false;
		}
		if (!this.mapa.containsKey(elemento.coordenadas())) {
			this.mapa.put(elemento.coordenadas(), elemento);
			return true;
		}
		return false;
	}

	public boolean agregarUnidadConPoblacion(Ocupable unidad) {
		if (unidadesConPoblacion == null) {
			unidadesConPoblacion = new ArrayList<Ocupable>();
		}
		return unidadesConPoblacion.add(unidad);
	}

	public boolean agregarUnidadConEmpleo(Ocupable unidad) {
		if (unidadesConEmpleo == null) {
			unidadesConEmpleo = new ArrayList<Ocupable>();
		}
		return unidadesConEmpleo.add(unidad);
	}

	public boolean agregarUnidadDaniable(Daniable unidad) {
		if (unidadesDaniables == null) {
			unidadesDaniables = new ArrayList<Daniable>();
		}
		return unidadesDaniables.add(unidad);
	}

	public ArrayList<Ocupable> unidadesConPoblacion() {
		return unidadesConPoblacion;
	}

	public ArrayList<Ocupable> unidadesConEmpleo() {
		return unidadesConEmpleo;
	}

	public ArrayList<Daniable> unidadesDaniables() {
		return unidadesDaniables;
	}

	public void remover(int x, int y) {
		this.mapa.remove(new Coordenada(x, y));
	}

	private boolean validarCoordenadas(int x, int y) {
		return (this.estaDentroDeLimites(x, y));
	}

	private boolean estaDentroDeLimites(int i, int j) {
		return ((i >= 0) && (i <= this.alto) && (j >= 0) && (j <= this.ancho));
	}

	public boolean contiene(Unidad unaUnidad) {
		return (this.mapa.containsValue(unaUnidad));
	}

	public boolean tieneCoordenadaOcupada(int x, int y) {
		return (this.mapa.containsKey(new Coordenada(x, y)));
	}

	public boolean vacia() {
		return (this.mapa.isEmpty());
	}

	public Coordenada getCoordenadas(Unidad elemento) {
		for (Entry<Coordenada, Unidad> entry : mapa.entrySet()) {
			if (entry.getValue().equals(elemento)) {
				return entry.getKey();
			}
		}
		return null;
	}

	public Unidad getUnidadEn(int x, int y) {
		if (tieneCoordenadaOcupada(x, y)) {
			Coordenada p = new Coordenada(x, y);
			return (this.mapa.get(p));
		} else {
			return null;
		}

	}

	public ArrayList<Daniable> getUnidadesAlrededorDe(Coordenada epicentro,
			int radio) {
		ArrayList<Daniable> unidadesADevolver = new ArrayList<Daniable>();
		Coordenada inic = calcularCoordenadaDeInicio(epicentro, radio);
		Coordenada fin = calcularCoordenadaDeFin(epicentro, radio);

		for (int x = (int) inic.getX(); x < (int) fin.getX(); x++) {
			for (int y = (int) inic.getY(); y < (int) fin.getY(); y++) {
				if (validarCoordenadas(x, y) && existeDaniable(x, y)) {
					unidadesADevolver.add((Daniable) this.getDaniableEn(x, y));
				}
			}
		}
		return unidadesADevolver;
	}

	public ArrayList<Daniable> getDaniablesEnElCaminoDe(
			LinkedList<Point> listaCamino) {

		ArrayList<Daniable> listaDaniablesEnElCamino = new ArrayList<Daniable>();
		Iterator<Point> iterador = listaCamino.iterator();
		while (iterador.hasNext()) {
			Point punto = iterador.next();
			if (existeDaniable((int) punto.getX(), (int) punto.getY())) {

				listaDaniablesEnElCamino.add(getDaniableEn((int) punto.getX(),
						(int) punto.getY()));

			}
		}

		return listaDaniablesEnElCamino;
	}

	private boolean existeDaniable(int x, int y) {
		Iterator<Daniable> it = unidadesDaniables.iterator();
		while (it.hasNext()) {
			Daniable d = it.next();
			if (d.coordenadas().getX() == x && d.coordenadas().getY() == y) {
				return true;
			}
		}
		return false;
	}

	private Daniable getDaniableEn(int x, int y) {
		Iterator<Daniable> it = unidadesDaniables.iterator();
		while (it.hasNext()) {
			Daniable d = it.next();
			if (d.coordenadas().getX() == x && d.coordenadas().getY() == y) {
				return d;
			}
		}
		return null;

	}

	private Coordenada calcularCoordenadaDeInicio(Coordenada epicentro,
			int radio) {
		int xi;
		int yi;
		if (epicentro.getX() - radio < 0) {
			xi = 0;
		} else {
			xi = (int) epicentro.getX() - radio;
		}
		if (epicentro.getY() - radio < 0) {
			yi = 0;
		} else {
			yi = (int) epicentro.getY() - radio;
		}
		return new Coordenada(xi, yi);
	}

	private Coordenada calcularCoordenadaDeFin(Coordenada epicentro, int radio) {
		int xf;
		int yf;
		if (epicentro.getX() - radio < 0) {
			xf = radio;
		} else {
			xf = (int) epicentro.getX() + radio;
		}
		if (epicentro.getY() - radio < 0) {
			yf = radio;
		} else {
			yf = (int) epicentro.getY() + radio;
		}
		return new Coordenada(xf, yf);
	}

	public int capacidadDePoblacion() {
		int capacidad = 0;
		for (Ocupable unidad : unidadesConPoblacion) {
			capacidad += unidad.capacidad();
		}
		return capacidad;
	}

	public int capacidadDeEmpleo() {
		int capacidad = 0;
		for (Ocupable unidad : unidadesConEmpleo) {
			capacidad += unidad.capacidad();
		}
		return capacidad;
	}

	/* Persistencia */
	@SuppressWarnings("rawtypes")
	public Element getElement(Document doc, Element ciudad) {
		Element alto = doc.createElement("alto");
		ciudad.appendChild(alto);
		alto.setTextContent(String.valueOf(this.alto));

		Element ancho = doc.createElement("ancho");
		ciudad.appendChild(ancho);
		ancho.setTextContent(String.valueOf(this.ancho));

		Element mapa = doc.createElement("mapa");
		ciudad.appendChild(mapa);

		/* Serializacion de unidades del mapa */
		for (Map.Entry e : this.mapa.entrySet()) {
			Coordenada clave = (Coordenada) e.getKey();
			Unidad valor = (Unidad) e.getValue();

			Element nodo = doc.createElement("Nodo");
			mapa.appendChild(nodo);

			Element point = doc.createElement("Coordenada");
			nodo.appendChild(point);
			point.setTextContent(String.valueOf((int) clave.getX()) + ","
					+ String.valueOf((int) clave.getY()));

			Element unidad = valor.getElement(doc);
			nodo.appendChild(unidad);
		}

		/* Serializacion de unidades con poblacion */
		Element unidadesConPoblacion = doc
				.createElement("unidadesConPoblacion");
		ciudad.appendChild(unidadesConPoblacion);
		Iterator<Ocupable> it = this.unidadesConPoblacion.iterator();
		while (it.hasNext()) {
			Ocupable o = it.next();
			Element unidad = o.getElement(doc);
			unidadesConPoblacion.appendChild(unidad);
		}

		/* Serializacion de unidades con empleo */
		Element unidadesConEmpleo = doc.createElement("unidadesConEmpleo");
		ciudad.appendChild(unidadesConEmpleo);
		Iterator<Ocupable> it2 = this.unidadesConEmpleo.iterator();
		while (it2.hasNext()) {
			Ocupable o = it2.next();
			Element unidad = o.getElement(doc);
			unidadesConEmpleo.appendChild(unidad);
		}

		/* Serializacion de unidades daniables */
		Element unidadesDaniables = doc.createElement("unidadesDaniables");
		ciudad.appendChild(unidadesDaniables);
		Iterator<Daniable> it3 = this.unidadesDaniables.iterator();
		while (it3.hasNext()) {
			Daniable o = it3.next();
			Element unidad = o.getElement(doc);
			unidadesDaniables.appendChild(unidad);
		}

		return ciudad;
	}

	public static MapaEdilicio fromElement(Node ciudad) {
		MapaEdilicio mapaEdilicio = new MapaEdilicio();
		NodeList hijosDeCiudad = ciudad.getChildNodes();

		for (int i = 0; i < hijosDeCiudad.getLength(); i++) {
			Node hijoDeCiudad = hijosDeCiudad.item(i);
			if (hijoDeCiudad.getNodeName().equals("alto")) {
				mapaEdilicio.alto = Integer.valueOf(hijoDeCiudad
						.getTextContent());
			} else if (hijoDeCiudad.getNodeName().equals("ancho")) {
				mapaEdilicio.ancho = Integer.valueOf(hijoDeCiudad
						.getTextContent());
			} else if (hijoDeCiudad.getNodeName().equals("mapa")) {
				NodeList hijosDeMapa = hijoDeCiudad.getChildNodes();
				for (int j = 0; j < hijosDeMapa.getLength(); j++) {
					Node hijoDeMapa = hijosDeMapa.item(j);
					if (hijoDeMapa.getNodeName().equals("Nodo")) {
						NodeList hijosDeNodo = hijoDeMapa.getChildNodes();
						String stringPunto = "";
						Coordenada puntoAAgregar = new Coordenada();
						for (int k = 0; k < hijosDeNodo.getLength(); k++) {
							Node hijoDeNodo = hijosDeNodo.item(k);
							if (hijoDeNodo.getNodeName().equals("Point")) {
								stringPunto = hijoDeNodo.getTextContent();
								String[] arrayPunto = stringPunto.split(",");
								puntoAAgregar = new Coordenada(
										Integer.valueOf(arrayPunto[0]),
										Integer.valueOf(arrayPunto[1]));
							} else if (hijoDeNodo.getNodeName().equals(
									"UnidadComercial")) {
								UnidadComercial uc = UnidadComercial
										.fromElement(hijoDeNodo);
								mapaEdilicio.agregar(uc);
							} else if (hijoDeNodo.getNodeName().equals(
									"UnidadIndustrial")) {
								UnidadIndustrial ui = UnidadIndustrial
										.fromElement(hijoDeNodo);
								mapaEdilicio.agregar(ui);
							} else if (hijoDeNodo.getNodeName().equals(
									"EstacionDeBomberos")) {
								EstacionDeBomberos eb = EstacionDeBomberos
										.fromElement(hijoDeNodo);
								mapaEdilicio.agregar(eb);
							} else if (hijoDeNodo.getNodeName().equals(
									"CentralNuclear")) {
								CentralNuclear cn = CentralNuclear
										.fromElement(hijoDeNodo);
								mapaEdilicio.agregar(cn);
							} else if (hijoDeNodo.getNodeName().equals(
									"UnidadResidencial")) {
								UnidadResidencial ur = UnidadResidencial
										.fromElement(hijoDeNodo);
								mapaEdilicio.agregar(ur);
							} else if (hijoDeNodo.getNodeName().equals(
									"PozoDeAgua")) {
								PozoDeAgua pa = PozoDeAgua
										.fromElement(hijoDeNodo);
								mapaEdilicio.agregar(pa);
							} else if (hijoDeNodo.getNodeName().equals(
									"CentralMinera")) {
								CentralMinera cm = CentralMinera
										.fromElement(hijoDeNodo);
								mapaEdilicio.agregar(cm);
							} else if (hijoDeNodo.getNodeName().equals(
									"CentralEolica")) {
								CentralEolica ce = CentralEolica
										.fromElement(hijoDeNodo);
								mapaEdilicio.agregar(ce);
							}
						}
					}
				}
			} else if (hijoDeCiudad.getNodeName()
					.equals("unidadesConPoblacion")) {
				NodeList hijosDeUnidadesConPoblacion = hijoDeCiudad
						.getChildNodes();
				for (int j = 0; j < hijosDeUnidadesConPoblacion.getLength(); j++) {
					Node hijoDeUnidadConPoblacion = hijosDeUnidadesConPoblacion
							.item(j);
					if (hijoDeUnidadConPoblacion.getNodeName().equals(
							"UnidadResidencial")) {
						UnidadResidencial ur = UnidadResidencial
								.fromElement(hijoDeUnidadConPoblacion);
						mapaEdilicio.unidadesConPoblacion.add(ur);
					}
				}
			} else if (hijoDeCiudad.getNodeName().equals("unidadesConEmpleo")) {
				NodeList hijosDeUnidadesConEmpleo = hijoDeCiudad
						.getChildNodes();
				for (int j = 0; j < hijosDeUnidadesConEmpleo.getLength(); j++) {
					Node hijoDeUnidadConEmpleo = hijosDeUnidadesConEmpleo
							.item(j);
					if (hijoDeUnidadConEmpleo.getNodeName().equals(
							"UnidadIndustrial")) {
						UnidadIndustrial ui = UnidadIndustrial
								.fromElement(hijoDeUnidadConEmpleo);
						mapaEdilicio.unidadesConEmpleo.add(ui);
					}
				}
			} else if (hijoDeCiudad.getNodeName().equals("unidadesDaniables")) {
				NodeList hijosDeUnidadesDaniables = hijoDeCiudad
						.getChildNodes();
				for (int j = 0; j < hijosDeUnidadesDaniables.getLength(); j++) {
					Node hijoDeUnidadDaniable = hijosDeUnidadesDaniables
							.item(j);
					if (hijoDeUnidadDaniable.getNodeName().equals(
							"UnidadIndustrial")) {
						UnidadIndustrial ui = UnidadIndustrial
								.fromElement(hijoDeUnidadDaniable);
						mapaEdilicio.unidadesDaniables.add(ui);
					} else if (hijoDeUnidadDaniable.getNodeName().equals(
							"UnidadResidencial")) {
						UnidadResidencial ur = UnidadResidencial
								.fromElement(hijoDeUnidadDaniable);
						mapaEdilicio.unidadesDaniables.add(ur);
					} else if (hijoDeUnidadDaniable.getNodeName().equals(
							"UnidadComercial")) {
						UnidadComercial uc = UnidadComercial
								.fromElement(hijoDeUnidadDaniable);
						mapaEdilicio.unidadesDaniables.add(uc);
					} else if (hijoDeUnidadDaniable.getNodeName().equals(
							"CentralEolica")) {
						CentralEolica ce = CentralEolica
								.fromElement(hijoDeUnidadDaniable);
						mapaEdilicio.unidadesDaniables.add(ce);
					} else if (hijoDeUnidadDaniable.getNodeName().equals(
							"CentralMinera")) {
						CentralMinera cm = CentralMinera
								.fromElement(hijoDeUnidadDaniable);
						mapaEdilicio.unidadesDaniables.add(cm);
					} else if (hijoDeUnidadDaniable.getNodeName().equals(
							"CentralNuclear")) {
						CentralNuclear cn = CentralNuclear
								.fromElement(hijoDeUnidadDaniable);
						mapaEdilicio.unidadesDaniables.add(cn);
					} else if (hijoDeUnidadDaniable.getNodeName().equals(
							"EstacionDeBomberos")) {
						EstacionDeBomberos eb = EstacionDeBomberos
								.fromElement(hijoDeUnidadDaniable);
						mapaEdilicio.unidadesDaniables.add(eb);
					} else if (hijoDeUnidadDaniable.getNodeName().equals(
							"PozoDeAgua")) {
						PozoDeAgua pa = PozoDeAgua
								.fromElement(hijoDeUnidadDaniable);
						mapaEdilicio.unidadesDaniables.add(pa);
					} else if (hijoDeUnidadDaniable.getNodeName()
							.equals("Ruta")) {
						Ruta rt = Ruta.fromElement(hijoDeUnidadDaniable);
						mapaEdilicio.unidadesDaniables.add(rt);
					} else if (hijoDeUnidadDaniable.getNodeName().equals(
							"LineaTension")) {
						LineaTension lt = LineaTension
								.fromElement(hijoDeUnidadDaniable);
						mapaEdilicio.unidadesDaniables.add(lt);
					}
				}
			}

		}
		imprimirMapaEdilicio(mapaEdilicio);
		return mapaEdilicio;
	}

	/* Para probar */
	private static void imprimirMapaEdilicio(MapaEdilicio mapaEdilicio) {

		for (Map.Entry e : mapaEdilicio.mapa.entrySet()) {
			Coordenada clave = (Coordenada) e.getKey();
			Unidad valor = (Unidad) e.getValue();

			System.out.println(String.valueOf(clave.getX()));
			System.out.println(String.valueOf(clave.getY()));
			System.out.println(valor.getClass());

		}
	}

}