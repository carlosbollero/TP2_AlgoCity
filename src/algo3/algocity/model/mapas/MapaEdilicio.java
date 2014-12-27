package algo3.algocity.model.mapas;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.Map.Entry;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.caracteristicas.Agregable;
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
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;

public class MapaEdilicio extends Observable {

	Mapa mapaSuperior;
	HashMap<Coordenada, Unidad> mapa;

	ArrayList<Daniable> unidadesDaniables;

	// prueba
	ArrayList<UnidadEnergetica> unidadesEnergeticas;
	ArrayList<PozoDeAgua> pozosDeAgua;
	ArrayList<EstacionDeBomberos> estacionesBomberos;
	ArrayList<UnidadResidencial> unidadesResidenciales;
	ArrayList<UnidadIndustrial> unidadesIndustriales;
	ArrayList<UnidadComercial> unidadesComerciales;

	public MapaEdilicio(Mapa m) {
		mapa = new HashMap<Coordenada, Unidad>();
		unidadesDaniables = new ArrayList<Daniable>();
		unidadesResidenciales = new ArrayList<UnidadResidencial>();
		unidadesIndustriales = new ArrayList<UnidadIndustrial>();
		unidadesComerciales = new ArrayList<UnidadComercial>();
		estacionesBomberos = new ArrayList<EstacionDeBomberos>();
		pozosDeAgua = new ArrayList<PozoDeAgua>();
		unidadesEnergeticas = new ArrayList<UnidadEnergetica>();
	}

	/* Para tests */
	public MapaEdilicio() {
		mapa = new HashMap<Coordenada, Unidad>();

		unidadesDaniables = new ArrayList<Daniable>();
	}

	// public boolean agregar(Unidad elemento) {
	// int x = elemento.coordenada().getX();
	// int y = elemento.coordenada().getY();
	// if (!.validarCoordenadas(x, y) || this.contiene(elemento)) {
	// return false;
	// }
	// if (!this.mapa.containsKey(elemento.coordenada())) {
	// this.mapa.put(elemento.coordenada(), elemento);
	// return true;
	// }
	// return false;
	// }

	public boolean agregar(PozoDeAgua p) {
		mapa.put(p.coordenada(), p);
		setChanged();
		notifyObservers(p.coordenada());
		return pozosDeAgua.add(p);
	}

	public boolean agregar(EstacionDeBomberos e) {
		mapa.put(e.coordenada(), e);
		setChanged();
		notifyObservers(e.coordenada());
		return estacionesBomberos.add(e);
	}

	public boolean agregar(UnidadResidencial u) {
		mapa.put(u.coordenada(), u);
		setChanged();
		notifyObservers(u.coordenada());
		return unidadesResidenciales.add(u);
	}

	public boolean agregar(UnidadIndustrial u) {
		mapa.put(u.coordenada(), u);
		setChanged();
		notifyObservers(u.coordenada());
		return unidadesIndustriales.add(u);
	}

	public boolean agregar(UnidadComercial u) {
		mapa.put(u.coordenada(), u);
		setChanged();
		notifyObservers(u.coordenada());
		return unidadesComerciales.add(u);
	}

	public boolean agregar(UnidadEnergetica u) {
		mapa.put(u.coordenada(), u);
		setChanged();
		notifyObservers(u.coordenada());
		return unidadesEnergeticas.add(u);
	}

	// public boolean agregarUnidadDaniable(Daniable unidad) {
	// if (unidadesDaniables == null) {
	// unidadesDaniables = new ArrayList<Daniable>();
	// }
	// return unidadesDaniables.add(unidad);
	// }

	public ArrayList<UnidadEnergetica> getUnidadesEnergeticas() {
		return unidadesEnergeticas;
	}

	public ArrayList<PozoDeAgua> getPozosDeAgua() {
		return pozosDeAgua;
	}

	public ArrayList<EstacionDeBomberos> getestacionesDeBomberos() {
		return estacionesBomberos;
	}

	public ArrayList<Daniable> unidadesDaniables() {
		// return unidadesDaniables;
		ArrayList<Daniable> lista = new ArrayList<Daniable>(
				unidadesResidenciales);
		lista.addAll(unidadesIndustriales);
		lista.addAll(unidadesComerciales);
		lista.addAll(unidadesEnergeticas);
		return lista;
	}

	public void remover(int x, int y) {
		this.mapa.remove(new Coordenada(x, y));
		setChanged();
		notifyObservers();
	}

	public boolean contiene(Unidad unaUnidad) {
		return (this.mapa.containsValue(unaUnidad));
	}

	public boolean tieneCoordenadaOcupada(Coordenada coord) {
		return (this.mapa.containsKey(coord));
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

	public Unidad getUnidadEn(Coordenada coord) {
		if (tieneCoordenadaOcupada(coord)) {
			return (this.mapa.get(coord));
		} else {
			return null;
		}
	}

	// public ArrayList<Daniable> getUnidadesAlrededorDe(Coordenada epicentro,
	// int radio) {
	// ArrayList<Daniable> unidadesADevolver = new ArrayList<Daniable>();
	// Coordenada inic = calcularCoordenadaDeInicio(epicentro, radio);
	// Coordenada fin = calcularCoordenadaDeFin(epicentro, radio);
	//
	// for (int x = (int) inic.getX(); x < (int) fin.getX(); x++) {
	// for (int y = (int) inic.getY(); y < (int) fin.getY(); y++) {
	// if (validarCoordenadas(x, y) && existeDaniable(x, y)) {
	// unidadesADevolver.add((Daniable) this.getDaniableEn(x, y));
	// }
	// }
	// }
	// return unidadesADevolver;
	// }

	public ArrayList<Daniable> getDaniablesEnElCaminoDe(
			LinkedList<Coordenada> listaCamino) {
		ArrayList<Daniable> listaDaniablesEnElCamino = new ArrayList<Daniable>();
		Iterator<Coordenada> iterador = listaCamino.iterator();
		while (iterador.hasNext()) {
			Coordenada punto = iterador.next();
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
			if (d.coordenada().getX() == x && d.coordenada().getY() == y) {
				return true;
			}
		}
		return false;
	}

	private Daniable getDaniableEn(int x, int y) {
		Iterator<Daniable> it = unidadesDaniables.iterator();
		while (it.hasNext()) {
			Daniable d = it.next();
			if (d.coordenada().getX() == x && d.coordenada().getY() == y) {
				return d;
			}
		}
		return null;

	}

	// private Coordenada calcularCoordenadaDeInicio(Coordenada epicentro,
	// int radio) {
	// int xi;
	// int yi;
	// if (epicentro.getX() - radio < 0) {
	// xi = 0;
	// } else {
	// xi = (int) epicentro.getX() - radio;
	// }
	// if (epicentro.getY() - radio < 0) {
	// yi = 0;
	// } else {
	// yi = (int) epicentro.getY() - radio;
	// }
	// return new Coordenada(xi, yi);
	// }
	//
	// private Coordenada calcularCoordenadaDeFin(Coordenada epicentro, int
	// radio) {
	// int xf;
	// int yf;
	// if (epicentro.getX() - radio < 0) {
	// xf = radio;
	// } else {
	// xf = (int) epicentro.getX() + radio;
	// }
	// if (epicentro.getY() - radio < 0) {
	// yf = radio;
	// } else {
	// yf = (int) epicentro.getY() + radio;
	// }
	// return new Coordenada(xf, yf);
	// }

	public int capacidadDePoblacion() {
		int capacidad = 0;
		for (UnidadResidencial unidad : unidadesResidenciales) {
			capacidad += unidad.capacidad();
		}
		return capacidad;
	}

	public int capacidadDeEmpleo() {
		int capacidad = 0;
		for (UnidadIndustrial unidad : unidadesIndustriales) {
			capacidad += unidad.capacidad();
		}
		return capacidad;
	}

	public ArrayList<UnidadResidencial> unidadesResidenciales() {
		return this.unidadesResidenciales();
	}

	public ArrayList<UnidadIndustrial> unidadesIndustriales() {
		return this.unidadesIndustriales();
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	@SuppressWarnings("rawtypes")
	public Element getElement(Document doc, Element ciudad) {

		// /* Serializacion de unidades daniables */
		// Element unidadesDaniables = doc.createElement("unidadesDaniables");
		// ciudad.appendChild(unidadesDaniables);
		// Iterator<Daniable> it3 = this.unidadesDaniables.iterator();
		// while (it3.hasNext()) {
		// Daniable o = it3.next();
		// Element unidad = o.getElement(doc);
		// unidadesDaniables.appendChild(unidad);
		// }

//		/* Serializacion de pozosDeAgua */
//		Element pozosDeAgua = doc.createElement("pozosDeAgua");
//		ciudad.appendChild(pozosDeAgua);
//		Iterator<PozoDeAgua> it1 = this.pozosDeAgua.iterator();
//		while (it1.hasNext()) {
//			PozoDeAgua o = it1.next();
//
//			Element nodo = doc.createElement("Nodo");
//			pozosDeAgua.appendChild(nodo);
//
//			Element point = doc.createElement("Coordenada");
//			nodo.appendChild(point);
//			point.setTextContent(String.valueOf(o.coordenada().getX()) + ","
//					+ String.valueOf(o.coordenada().getY()));
//
//			Element unidad = o.getElement(doc);
//			nodo.appendChild(unidad);
//		}
//
//		/* Serializacion de estacionesDeBomberos */
//		Element estacionesBomberos = doc.createElement("estacionesBomberos");
//		ciudad.appendChild(estacionesBomberos);
//		Iterator<EstacionDeBomberos> it7 = this.estacionesBomberos.iterator();
//		while (it7.hasNext()) {
//			EstacionDeBomberos eb = it7.next();
//
//			Element nodo = doc.createElement("Nodo");
//			estacionesBomberos.appendChild(nodo);
//
//			Element point = doc.createElement("Coordenada");
//			nodo.appendChild(point);
//			point.setTextContent(String.valueOf(eb.coordenada().getX()) + ","
//					+ String.valueOf(eb.coordenada().getY()));
//
//			Element unidad = eb.getElement(doc);
//			nodo.appendChild(unidad);
//		}
//
//		/* Serializacion de unidades energeticas */
//		Element unidadesEnergeticas = doc.createElement("unidadesEnergeticas");
//		ciudad.appendChild(unidadesEnergeticas);
//		Iterator<UnidadEnergetica> it2 = this.unidadesEnergeticas.iterator();
//		while (it2.hasNext()) {
//			UnidadEnergetica o = it2.next();
//
//			Element nodo = doc.createElement("Nodo");
//			unidadesEnergeticas.appendChild(nodo);
//
//			Element point = doc.createElement("Coordenada");
//			nodo.appendChild(point);
//			point.setTextContent(String.valueOf(o.coordenada().getX()) + ","
//					+ String.valueOf(o.coordenada().getY()));
//
//			Element unidad = o.getElement(doc);
//			nodo.appendChild(unidad);
//		}
//
//		/* Serializacion de unidadesResidenciales */
//		Element unidadesResidenciales = doc
//				.createElement("unidadesResidenciales");
//		ciudad.appendChild(unidadesResidenciales);
//		Iterator<UnidadResidencial> it = this.unidadesResidenciales.iterator();
//		while (it.hasNext()) {
//			UnidadResidencial o = it.next();
//
//			Element nodo = doc.createElement("Nodo");
//			unidadesResidenciales.appendChild(nodo);
//
//			Element point = doc.createElement("Coordenada");
//			nodo.appendChild(point);
//			point.setTextContent(String.valueOf(o.coordenada().getX()) + ","
//					+ String.valueOf(o.coordenada().getY()));
//
//			Element unidad = o.getElement(doc);
//			nodo.appendChild(unidad);
//		}
//
//		/* Serializacion de unidadesIndustriales */
//		Element unidadesIndustriales = doc
//				.createElement("unidadesIndustriales");
//		ciudad.appendChild(unidadesIndustriales);
//		Iterator<UnidadIndustrial> it5 = this.unidadesIndustriales.iterator();
//		while (it5.hasNext()) {
//			UnidadIndustrial o = it5.next();
//
//			Element nodo = doc.createElement("Nodo");
//			unidadesIndustriales.appendChild(nodo);
//
//			Element point = doc.createElement("Coordenada");
//			nodo.appendChild(point);
//			point.setTextContent(String.valueOf(o.coordenada().getX()) + ","
//					+ String.valueOf(o.coordenada().getY()));
//
//			Element unidad = o.getElement(doc);
//			nodo.appendChild(unidad);
//		}
//
//		/* Serializacion de unidadesComerciales */
//		Element unidadesComerciales = doc.createElement("unidadesComerciales");
//		ciudad.appendChild(unidadesComerciales);
//		Iterator<UnidadComercial> it6 = this.unidadesComerciales.iterator();
//		while (it6.hasNext()) {
//			UnidadComercial o = it6.next();
//
//			Element nodo = doc.createElement("Nodo");
//			unidadesComerciales.appendChild(nodo);
//
//			Element point = doc.createElement("Coordenada");
//			nodo.appendChild(point);
//			point.setTextContent(String.valueOf(o.coordenada().getX()) + ","
//					+ String.valueOf(o.coordenada().getY()));
//
//			Element unidad = o.getElement(doc);
//			nodo.appendChild(unidad);
//		}

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

		return ciudad;
	}

	public static MapaEdilicio fromElement(Node ciudad, Mapa mapa, Dinero d)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			CoordenadaInvalidaException, SuperficieInvalidaParaConstruir {
		MapaEdilicio mapaEdilicio = new MapaEdilicio(mapa);
		NodeList hijosDeCiudad = ciudad.getChildNodes();

		for (int i = 0; i < hijosDeCiudad.getLength(); i++) {
			Node hijoDeCiudad = hijosDeCiudad.item(i);
			/*
			 * else if (hijoDeCiudad.getNodeName() .equals("unidadesDaniables"))
			 * { NodeList hijosDeUnidadesDaniables = hijoDeCiudad
			 * .getChildNodes(); for (int j = 0; j <
			 * hijosDeUnidadesDaniables.getLength(); j++) { Node
			 * hijoDeUnidadDaniable = hijosDeUnidadesDaniables .item(j); //TODO,
			 * ver si no tira nullpointerexcept, o si agarra //el fromElement de
			 * cada unidad Daniable d =
			 * Daniable.fromElement(hijoDeUnidadDaniable);
			 * mapaEdilicio.unidadesDaniables.add(d); } }
//			 */
//			if (hijoDeCiudad.getNodeName().equals("pozosDeAgua")) {
//				NodeList hijosDePozosDeAgua = hijoDeCiudad.getChildNodes();
//				for (int j = 0; j < hijosDePozosDeAgua.getLength(); j++) {
//					Node hijoDePozoDeAgua = hijosDePozosDeAgua.item(j);
//					if (hijoDePozoDeAgua.getNodeName().equals("Nodo")) {
//						NodeList hijosDeNodo = hijoDePozoDeAgua.getChildNodes();
//						String stringPunto = "";
//						Coordenada puntoAAgregar = new Coordenada();
//						for (int k = 0; k < hijosDeNodo.getLength(); k++) {
//							Node hijoDeNodo = hijosDeNodo.item(k);
//							if (hijoDeNodo.getNodeName().equals("Coordenada")) {
//								stringPunto = hijoDeNodo.getTextContent();
//								String[] arrayPunto = stringPunto.split(",");
//								puntoAAgregar = new Coordenada(
//										Integer.valueOf(arrayPunto[0]),
//										Integer.valueOf(arrayPunto[1]));
//							} else if (hijoDeNodo.getNodeName().equals(
//									"PozoDeAgua")) {
//								PozoDeAgua pa = new PozoDeAgua(mapa, d,
//										puntoAAgregar);
//								pa.fromElement(hijoDeNodo);
//								pa.agregarseA(mapa);
//								// mapaEdilicio.mapa.put(puntoAAgregar, pa);
//								d.add(pa.costo());
//							}
//						}
//					}
//				}
//			} else if (hijoDeCiudad.getNodeName()
//					.equals("estacionesBomberos")) {
//				NodeList hijosDeEstacionesDeBomberos = hijoDeCiudad
//						.getChildNodes();
//				for (int j = 0; j < hijosDeEstacionesDeBomberos.getLength(); j++) {
//					Node hijoDeEstacionDeBomberos = hijosDeEstacionesDeBomberos
//							.item(j);
//					if (hijoDeEstacionDeBomberos.getNodeName().equals("Nodo")) {
//						NodeList hijosDeNodo = hijoDeEstacionDeBomberos.getChildNodes();
//						String stringPunto = "";
//						Coordenada puntoAAgregar = new Coordenada();
//						for (int k = 0; k < hijosDeNodo.getLength(); k++) {
//							Node hijoDeNodo = hijosDeNodo.item(k);
//							if (hijoDeNodo.getNodeName().equals("Coordenada")) {
//								stringPunto = hijoDeNodo.getTextContent();
//								String[] arrayPunto = stringPunto.split(",");
//								puntoAAgregar = new Coordenada(
//										Integer.valueOf(arrayPunto[0]),
//										Integer.valueOf(arrayPunto[1]));
//							} else if (hijoDeNodo.getNodeName().equals(
//									"EstacionDeBomberos")) {
//								EstacionDeBomberos eb = new EstacionDeBomberos(mapa, d,
//										puntoAAgregar);
//								eb.fromElement(hijoDeNodo);
//								eb.agregarseA(mapa);
//								
//								d.add(eb.costo());//agregado para que no reste el dinero dos veces
//							}
//						}
//					}
//				}
//			} else if (hijoDeCiudad.getNodeName().equals("unidadesEnergeticas")) {
//				NodeList hijosDeUnidadesEnergeticas = hijoDeCiudad
//						.getChildNodes();
//				for (int j = 0; j < hijosDeUnidadesEnergeticas.getLength(); j++) {
//					Node hijoDeUnidadEnergetica = hijosDeUnidadesEnergeticas
//							.item(j);
//					if (hijoDeUnidadEnergetica.getNodeName().equals("Nodo")) {
//						NodeList hijosDeNodo = hijoDeUnidadEnergetica.getChildNodes();
//						String stringPunto = "";
//						Coordenada puntoAAgregar = new Coordenada();
//						for (int k = 0; k < hijosDeNodo.getLength(); k++) {
//							Node hijoDeNodo = hijosDeNodo.item(k);
//							if (hijoDeNodo.getNodeName().equals("Coordenada")) {
//								stringPunto = hijoDeNodo.getTextContent();
//								String[] arrayPunto = stringPunto.split(",");
//								puntoAAgregar = new Coordenada(
//										Integer.valueOf(arrayPunto[0]),
//										Integer.valueOf(arrayPunto[1]));
//							} else if (hijoDeNodo.getNodeName().equals(
//									"CentralEolica")) {
//								CentralEolica ce = new CentralEolica(mapa, d,
//										puntoAAgregar);
//								ce.fromElement(hijoDeNodo);
//								ce.agregarseA(mapa);
//								d.add(ce.costo());
//								// mapaEdilicio.mapa.put(puntoAAgregar, pa);
//							}else if (hijoDeNodo.getNodeName().equals(
//									"CentralMinera")) {
//								CentralMinera cm = new CentralMinera(mapa, d,
//										puntoAAgregar);
//								cm.fromElement(hijoDeNodo);
//								cm.agregarseA(mapa);
//								d.add(cm.costo());
//								// mapaEdilicio.mapa.put(puntoAAgregar, pa);
//							}else if (hijoDeNodo.getNodeName().equals(
//									"CentralNuclear")) {
//								CentralNuclear cn = new CentralNuclear(mapa, d,
//										puntoAAgregar);
//								cn.fromElement(hijoDeNodo);
//								cn.agregarseA(mapa);
//								d.add(cn.costo());
//								// mapaEdilicio.mapa.put(puntoAAgregar, pa);
//							}
//						}
//					}
//				}
//			} else if (hijoDeCiudad.getNodeName().equals(
//					"unidadesResidenciales")) {
//				NodeList hijosDeUnidadesResidenciales = hijoDeCiudad
//						.getChildNodes();
//				for (int j = 0; j < hijosDeUnidadesResidenciales.getLength(); j++) {
//					Node hijoDeUnidadResidencial = hijosDeUnidadesResidenciales
//							.item(j);
//					if (hijoDeUnidadResidencial.getNodeName().equals("Nodo")) {
//						NodeList hijosDeNodo = hijoDeUnidadResidencial.getChildNodes();
//						String stringPunto = "";
//						Coordenada puntoAAgregar = new Coordenada();
//						for (int k = 0; k < hijosDeNodo.getLength(); k++) {
//							Node hijoDeNodo = hijosDeNodo.item(k);
//							if (hijoDeNodo.getNodeName().equals("Coordenada")) {
//								stringPunto = hijoDeNodo.getTextContent();
//								String[] arrayPunto = stringPunto.split(",");
//								puntoAAgregar = new Coordenada(
//										Integer.valueOf(arrayPunto[0]),
//										Integer.valueOf(arrayPunto[1]));
//							} else if (hijoDeNodo.getNodeName().equals(
//									"UnidadResidencial")) {
//								UnidadResidencial ur = new UnidadResidencial(mapa, d,
//										puntoAAgregar);
//								ur.fromElement(hijoDeNodo);
//								ur.agregarseA(mapa);
//								d.add(ur.costo());
//								// mapaEdilicio.mapa.put(puntoAAgregar, pa);
//							}
//						}
//					}
//				}
//			} else if (hijoDeCiudad.getNodeName()
//					.equals("unidadesIndustriales")) {
//				NodeList hijosDeUnidadesIndustriales = hijoDeCiudad
//						.getChildNodes();
//				for (int j = 0; j < hijosDeUnidadesIndustriales.getLength(); j++) {
//					Node hijoDeUnidadIndustrial = hijosDeUnidadesIndustriales
//							.item(j);
//					if (hijoDeUnidadIndustrial.getNodeName().equals("Nodo")) {
//						NodeList hijosDeNodo = hijoDeUnidadIndustrial.getChildNodes();
//						String stringPunto = "";
//						Coordenada puntoAAgregar = new Coordenada();
//						for (int k = 0; k < hijosDeNodo.getLength(); k++) {
//							Node hijoDeNodo = hijosDeNodo.item(k);
//							if (hijoDeNodo.getNodeName().equals("Coordenada")) {
//								stringPunto = hijoDeNodo.getTextContent();
//								String[] arrayPunto = stringPunto.split(",");
//								puntoAAgregar = new Coordenada(
//										Integer.valueOf(arrayPunto[0]),
//										Integer.valueOf(arrayPunto[1]));
//							} else if (hijoDeNodo.getNodeName().equals(
//									"UnidadIndustrial")) {
//								UnidadIndustrial ui = new UnidadIndustrial(mapa, d,
//										puntoAAgregar);
//								ui.fromElement(hijoDeNodo);
//								ui.agregarseA(mapa);
//								d.add(ui.costo());
//								// mapaEdilicio.mapa.put(puntoAAgregar, pa);
//							}
//						}
//					}
//				}
//			} else if (hijoDeCiudad.getNodeName().equals("unidadesComerciales")) {
//				NodeList hijosDeUnidadesComerciales = hijoDeCiudad
//						.getChildNodes();
//				for (int j = 0; j < hijosDeUnidadesComerciales.getLength(); j++) {
//					Node hijoDeUnidadComercial = hijosDeUnidadesComerciales
//							.item(j);
//					if (hijoDeUnidadComercial.getNodeName().equals("Nodo")) {
//						NodeList hijosDeNodo = hijoDeUnidadComercial.getChildNodes();
//						String stringPunto = "";
//						Coordenada puntoAAgregar = new Coordenada();
//						for (int k = 0; k < hijosDeNodo.getLength(); k++) {
//							Node hijoDeNodo = hijosDeNodo.item(k);
//							if (hijoDeNodo.getNodeName().equals("Coordenada")) {
//								stringPunto = hijoDeNodo.getTextContent();
//								String[] arrayPunto = stringPunto.split(",");
//								puntoAAgregar = new Coordenada(
//										Integer.valueOf(arrayPunto[0]),
//										Integer.valueOf(arrayPunto[1]));
//							} else if (hijoDeNodo.getNodeName().equals(
//									"UnidadComercial")) {
//								UnidadComercial uc = new UnidadComercial(mapa, d,
//										puntoAAgregar);
//								uc.fromElement(hijoDeNodo);
//								uc.agregarseA(mapa);
//								d.add(uc.costo());
//								// mapaEdilicio.mapa.put(puntoAAgregar, pa);
//							}
//						}
//					}
//				}
			 if (hijoDeCiudad.getNodeName().equals("mapa")) {
				NodeList hijosDeMapa = hijoDeCiudad.getChildNodes();
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
									"PozoDeAgua")) {
								PozoDeAgua pa = new PozoDeAgua(mapa, d,
										puntoAAgregar);
								pa.fromElement(hijoDeNodo);
								pa.agregarseA(mapa);
								d.add(pa.costo());
							} else if (hijoDeNodo.getNodeName().equals(
									"EstacionDeBomberos")) {
								EstacionDeBomberos eb = new EstacionDeBomberos(
										mapa, d, puntoAAgregar);
								eb.fromElement(hijoDeNodo);
								eb.agregarseA(mapa);
								d.add(eb.costo());
							} else if (hijoDeNodo.getNodeName().equals(
									"CentralEolica")) {
								CentralEolica ce = new CentralEolica(mapa, d,
										puntoAAgregar);
								ce.fromElement(hijoDeNodo);
								ce.agregarseA(mapa);
								d.add(ce.costo());
							} else if (hijoDeNodo.getNodeName().equals(
									"CentralNuclear")) {
								CentralNuclear cn = new CentralNuclear(mapa, d,
										puntoAAgregar);
								cn.fromElement(hijoDeNodo);
								cn.agregarseA(mapa);
								d.add(cn.costo());
							} else if (hijoDeNodo.getNodeName().equals(
									"CentralMinera")) {
								CentralMinera cm = new CentralMinera(mapa, d,
										puntoAAgregar);
								cm.fromElement(hijoDeNodo);
								cm.agregarseA(mapa);
								d.add(cm.costo());
							} else if (hijoDeNodo.getNodeName().equals(
									"UnidadComercial")) {
								UnidadComercial uc = new UnidadComercial(mapa,
										d, puntoAAgregar);
								uc.fromElement(hijoDeNodo);
								uc.agregarseA(mapa);
								d.add(uc.costo());
							} else if (hijoDeNodo.getNodeName().equals(
									"UnidadIndustrial")) {
								UnidadIndustrial ui = new UnidadIndustrial(
										mapa, d, puntoAAgregar);
								ui.fromElement(hijoDeNodo);
								ui.agregarseA(mapa);
								d.add(ui.costo());
							} else if (hijoDeNodo.getNodeName().equals(
									"UnidadResidencial")) {
								UnidadResidencial ur = new UnidadResidencial(
										mapa, d, puntoAAgregar);
								ur.fromElement(hijoDeNodo);
								ur.agregarseA(mapa);
								d.add(ur.costo());
							}
						}
					}
				}
			}
		}
		return mapa.ciudad;
	}
}