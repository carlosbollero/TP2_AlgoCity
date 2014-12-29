package algo3.algocity.model.mapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Observable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.caracteristicas.Agregable;
import algo3.algocity.model.caracteristicas.Daniable;
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
		mapaSuperior = m;
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
		unidadesResidenciales = new ArrayList<UnidadResidencial>();
		unidadesIndustriales = new ArrayList<UnidadIndustrial>();
		unidadesComerciales = new ArrayList<UnidadComercial>();
		estacionesBomberos = new ArrayList<EstacionDeBomberos>();
		pozosDeAgua = new ArrayList<PozoDeAgua>();
		unidadesEnergeticas = new ArrayList<UnidadEnergetica>();
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

	public ArrayList<UnidadComercial> getUnidadesComerciales() {
		return this.unidadesComerciales;
	}

	public ArrayList<UnidadResidencial> getUnidadesResidenciales() {
		return this.unidadesResidenciales;
	}

	public ArrayList<UnidadIndustrial> getUnidadesIndustriales() {
		return this.unidadesIndustriales;
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
	
	public Unidad get(Coordenada coord){
		return getUnidadEn(coord);
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
	// @SuppressWarnings("rawtypes")
	public Element getElement(Document doc, Element ciudad) {
		Element mapa = doc.createElement("mapa");
		ciudad.appendChild(mapa);
		// TODO, falta inicializar estas listas en mapaEdilicio
		/* Escritura de pozos de agua */
		ArrayList<PozoDeAgua> pozosDeAgua = this.mapaSuperior.ciudad()
				.getPozosDeAgua();
		Iterator<PozoDeAgua> it0 = pozosDeAgua.iterator();
		while (it0.hasNext()) {
			PozoDeAgua pa = it0.next();
			Element nodo = doc.createElement("Nodo");
			mapa.appendChild(nodo);
			Element point = doc.createElement("Coordenada");
			nodo.appendChild(point);
			point.setTextContent(String.valueOf((int) pa.coordenada().getX())
					+ "," + String.valueOf((int) pa.coordenada().getY()));
			Element unidad = pa.getElement(doc);
			nodo.appendChild(unidad);
		}
		/* Escritura de estaciones de bomberos */
		ArrayList<EstacionDeBomberos> estacionesDeBomberos = this.mapaSuperior
				.ciudad().getestacionesDeBomberos();
		Iterator<EstacionDeBomberos> it1 = estacionesDeBomberos.iterator();
		while (it1.hasNext()) {
			EstacionDeBomberos eb = it1.next();
			Element nodo = doc.createElement("Nodo");
			mapa.appendChild(nodo);
			Element point = doc.createElement("Coordenada");
			nodo.appendChild(point);
			point.setTextContent(String.valueOf((int) eb.coordenada().getX())
					+ "," + String.valueOf((int) eb.coordenada().getY()));
			Element unidad = eb.getElement(doc);
			nodo.appendChild(unidad);
		}
		/* Escritura de unidades energeticas */
		ArrayList<UnidadEnergetica> unidadesEnergeticas = this.mapaSuperior
				.ciudad().getUnidadesEnergeticas();
		Iterator<UnidadEnergetica> it2 = unidadesEnergeticas.iterator();
		while (it2.hasNext()) {
			UnidadEnergetica eb = it2.next();
			Element nodo = doc.createElement("Nodo");
			mapa.appendChild(nodo);
			Element point = doc.createElement("Coordenada");
			nodo.appendChild(point);
			point.setTextContent(String.valueOf((int) eb.coordenada().getX())
					+ "," + String.valueOf((int) eb.coordenada().getY()));
			Element unidad = eb.getElement(doc);
			nodo.appendChild(unidad);
		}
		/* Escritura de unidades comerciales */
		ArrayList<UnidadComercial> unidadesComerciales = this.mapaSuperior
				.ciudad().getUnidadesComerciales();
		Iterator<UnidadComercial> it3 = unidadesComerciales.iterator();
		while (it3.hasNext()) {
			UnidadComercial eb = it3.next();
			Element nodo = doc.createElement("Nodo");
			mapa.appendChild(nodo);
			Element point = doc.createElement("Coordenada");
			nodo.appendChild(point);
			point.setTextContent(String.valueOf((int) eb.coordenada().getX())
					+ "," + String.valueOf((int) eb.coordenada().getY()));
			Element unidad = eb.getElement(doc);
			nodo.appendChild(unidad);
		}
		/* Escritura de unidades industriales */
		ArrayList<UnidadIndustrial> unidadesIndustriales = this.mapaSuperior
				.ciudad().getUnidadesIndustriales();
		Iterator<UnidadIndustrial> it4 = unidadesIndustriales.iterator();
		while (it4.hasNext()) {
			UnidadIndustrial eb = it4.next();
			Element nodo = doc.createElement("Nodo");
			mapa.appendChild(nodo);
			Element point = doc.createElement("Coordenada");
			nodo.appendChild(point);
			point.setTextContent(String.valueOf((int) eb.coordenada().getX())
					+ "," + String.valueOf((int) eb.coordenada().getY()));
			Element unidad = eb.getElement(doc);
			nodo.appendChild(unidad);
		}
		/* Escritura de unidades residenciales */
		ArrayList<UnidadResidencial> unidadesResidenciales = this.mapaSuperior
				.ciudad().getUnidadesResidenciales();
		Iterator<UnidadResidencial> it5 = unidadesResidenciales.iterator();
		while (it5.hasNext()) {
			UnidadResidencial eb = it5.next();
			Element nodo = doc.createElement("Nodo");
			mapa.appendChild(nodo);
			Element point = doc.createElement("Coordenada");
			nodo.appendChild(point);
			point.setTextContent(String.valueOf((int) eb.coordenada().getX())
					+ "," + String.valueOf((int) eb.coordenada().getY()));
			Element unidad = eb.getElement(doc);
			nodo.appendChild(unidad);
		}
		return ciudad;
		// LAS UNIDADES SE TIENEN QUE ESCRIBIR NECESARIAMENTE EN EL ORDEN
		// CORRECTO
		// CON ESTA IMPLEMENTACION SE ESCRIBEN EN CUALQUIER ORDEN
		// TODO
		// /* Serializacion de unidades del mapa */
		// for (Map.Entry e : this.mapa.entrySet()) {
		// Coordenada clave = (Coordenada) e.getKey();
		// Unidad valor = (Unidad) e.getValue();
		//
		// Element nodo = doc.createElement("Nodo");
		// mapa.appendChild(nodo);
		//
		// Element point = doc.createElement("Coordenada");
		// nodo.appendChild(point);
		// point.setTextContent(String.valueOf((int) clave.getX()) + ","
		// + String.valueOf((int) clave.getY()));
		//
		// Element unidad = valor.getElement(doc);
		// nodo.appendChild(unidad);
		// }
		//
		// return ciudad;
	}

	public static MapaEdilicio fromElement(Node ciudad, Mapa mapa, Dinero d)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			CoordenadaInvalidaException, SuperficieInvalidaParaConstruir {
		// MapaEdilicio mapaEdilicio = new MapaEdilicio(mapa);
		NodeList hijosDeCiudad = ciudad.getChildNodes();
		for (int i = 0; i < hijosDeCiudad.getLength(); i++) {
			Node hijoDeCiudad = hijosDeCiudad.item(i);
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