package algo3.algocity.model.mapas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.Dinero;
import algo3.algocity.model.Poblacion;
import algo3.algocity.model.Reparador;
import algo3.algocity.model.SistemaElectrico;
import algo3.algocity.model.Turno;
import algo3.algocity.model.caracteristicas.Agregable;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.terreno.Superficie;

public class Mapa extends Observable {

	int tamanio;

	MapaTerritorio territorio;
	MapaEdilicio ciudad;
	MapaTuberias tuberias;
	MapaRutas rutas;
	MapaElectrico redElectrica;
	SistemaElectrico sistemaElectrico;
	Dinero dinero;
	Reparador reparador;

	public Mapa() {
		tamanio = Constantes.TAMANIO_MAPA;
		territorio = new MapaTerritorio(tamanio);
		ciudad = new MapaEdilicio(this);
		tuberias = new MapaTuberias(this);
		rutas = new MapaRutas(this);
		redElectrica = new MapaElectrico(this);
		dinero = new Dinero();
		sistemaElectrico = new SistemaElectrico();
		reparador = null;
	}

	public int tamanio() {
		return tamanio;
	}

	public boolean agregar(Agregable unidad) {
		if (contiene(unidad)) {
			return false;
		}
		return unidad.agregarseA(this);
	}

	public boolean contiene(Agregable u) {
		return u.estaContenidoEn(this);
	}

	public boolean validarCoordenadas(Coordenada coord)
			throws CoordenadaInvalidaException {
		if (!estaDentroDeLimites(coord)) {
			throw new CoordenadaInvalidaException();
		}
		return true;
	}

	private boolean estaDentroDeLimites(Coordenada coord) {
		return ((coord.getX() >= 0) && (coord.getX() < tamanio)
				&& (coord.getY() >= 0) && (coord.getY() < tamanio));
	}

	public ArrayList<Daniable> unidadesDaniables() {
		ArrayList<Daniable> lista = new ArrayList<Daniable>();
		lista.addAll(ciudad().unidadesDaniables());
		lista.addAll(redElectrica().unidadesDaniables());
		lista.addAll(rutas().unidadesDaniables());
		return lista;
	}

	public Coordenada posicionConAgua() {
		return territorio.posicionConAgua();
	}

	public Coordenada posicionConTierra() {
		return territorio.posicionConTierra();
	}

	// public boolean agregarACiudad(Unidad unidad) {
	// return ciudad.agregar(unidad);
	// }
	//
	// public boolean agregarARedElectrica(LineaTension linea) {
	// return redElectrica.agregar(linea);
	// }
	//
	// public boolean agregarARutas(Ruta ruta) {
	// return rutas.agregar(ruta);
	// }
	//
	// public boolean agregarATuberias(Tuberia tuberia) {
	// return tuberias.agregar(tuberia);
	// }

	// public boolean agregarUnidadDaniable(Daniable unidad) {
	// return ciudad.agregarUnidadDaniable(unidad);
	// }

	// public boolean contiene(LineaTension lt) {
	// return redElectrica.contiene(lt);
	// }
	//
	// public boolean contiene(Ruta rt) {
	// return rutas.contiene(rt);
	// }
	//
	// public boolean contiene(Tuberia tb) {
	// return tuberias.contiene(tb);
	// }

	// public ArrayList<Daniable> getDaniablesAlrededorDe(Coordenada epicentro,
	// int radio) {
	// return ciudad.getUnidadesAlrededorDe(epicentro, radio);
	// }

	public ArrayList<Daniable> getDaniablesEnElCaminoDe(
			LinkedList<Coordenada> listaCamino) {
		return ciudad.getDaniablesEnElCaminoDe(listaCamino);
	}

	// METODOS PARA VALIDAR REQUISITOS
	public Superficie superficie(Coordenada punto) {
		return territorio.superficie(punto);
	}

	public boolean hayConexionCompleta(Coordenada coordenadas)
			throws NoHayConexionConTuberias, NoHayConexionConRutas,
			NoHayConexionConRedElectrica {
		return (hayConexionConRutas(coordenadas) && hayConexionConTuberias(coordenadas))
				&& hayConexionConRedElectrica(coordenadas);
	}

	public boolean hayConexionConTuberias(Coordenada coordenadas)
			throws NoHayConexionConTuberias {
		if (!tuberias.hayConexion(coordenadas)) {
			throw new NoHayConexionConTuberias();
		}
		return tuberias.hayConexion(coordenadas);
	}

	public boolean hayConexionConRedElectrica(Coordenada coordenadas)
			throws NoHayConexionConRedElectrica {

		if (!redElectrica.hayConexion(coordenadas)) {
			throw new NoHayConexionConRedElectrica();
		}
		return redElectrica.hayConexion(coordenadas);
	}

	public boolean hayConexionConRutas(Coordenada coordenadas)
			throws NoHayConexionConRutas {
		if (!rutas.hayConexion(coordenadas)) {
			throw new NoHayConexionConRutas();
		}
		return rutas.hayConexion(coordenadas);
	}

	public void agregarReparador() {
		if (this.reparador == null) {
			this.reparador = new Reparador(this);
		}
	}

	public void reparar() {
		if (this.reparador != null) {
			this.reparador.actuar();
		}
	}

	/* Usados para corroborar tests de persistencia */
	public MapaEdilicio ciudad() {
		return ciudad;
	}

	public MapaTuberias tuberias() {
		return tuberias;
	}

	public MapaElectrico redElectrica() {
		return redElectrica;
	}

	public MapaRutas rutas() {
		return rutas;
	}

	public MapaTerritorio territorio() {
		return territorio;
	}

	public Reparador reparador() {
		return reparador;
	}

	public SistemaElectrico sistemaElectrico() {
		return sistemaElectrico;
	}

	// Metodo implementado solo para tests
	/*********************************************************/
	public void setTerritorioTierraParaTest() {
		boolean tierra = true;
		territorio = new MapaTerritorio(tamanio, tierra);
		setChanged();
		notifyObservers();
	}

	public void setTerritorioAguaParaTest() {
		boolean agua = false;
		territorio = new MapaTerritorio(tamanio, agua);
		setChanged();
		notifyObservers();
	}

	/*********************************************************/

	// CONSULTA PARA ACTUALIZACION DE POBLACION
	public int capacidadDePoblacion() {
		return this.ciudad.capacidadDePoblacion();
	}

	public int capacidadDeEmpleo() {
		return this.ciudad.capacidadDeEmpleo();
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	public Element getElement(Document doc) {
		Element mapa = doc.createElement("Mapa");

		Element tamanio = doc.createElement("tamanio");
		mapa.appendChild(tamanio);
		tamanio.setTextContent(String.valueOf(this.tamanio));

		Element territorio = doc.createElement("territorio");
		mapa.appendChild(territorio);
		territorio = this.territorio.getElement(doc, territorio);

		Element tuberias = doc.createElement("tuberias");
		mapa.appendChild(tuberias);
		tuberias = this.tuberias.getElement(doc, tuberias);

		Element rutas = doc.createElement("rutas");
		mapa.appendChild(rutas);
		rutas = this.rutas.getElement(doc, rutas);

		Element redElectrica = doc.createElement("redElectrica");
		mapa.appendChild(redElectrica);
		redElectrica = this.redElectrica.getElement(doc, redElectrica);

		Element sistemaElectrico = this.sistemaElectrico.getElement(doc);
		mapa.appendChild(sistemaElectrico);

		Element ciudad = doc.createElement("ciudad");
		mapa.appendChild(ciudad);
		ciudad = this.ciudad.getElement(doc, ciudad);

		Element dinero = this.dinero.getElement(doc);
		mapa.appendChild(dinero);

		if (this.reparador == null) {
			Element reparador = doc.createElement("reparador");
			mapa.appendChild(reparador);
		} else {
			//agregado, pruebaa
			this.reparador.actualizarObjetivos();
			Element reparador = this.reparador.getElement(doc);
			mapa.appendChild(reparador);
		}

		return mapa;
	}

	public static Mapa fromElement(Node element, Mapa mapa, Dinero d,
			Turno turnos, Poblacion poblacion)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, SuperficieInvalidaParaConstruir,
			CoordenadaInvalidaException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica {

		NodeList childs = element.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);

			if (child.getNodeName().equals("tamanio")) {
				mapa.tamanio = Integer.valueOf(child.getTextContent());
			} else if (child.getNodeName().equals("territorio")) {
				mapa.territorio = MapaTerritorio.fromElement(child);
			} else if (child.getNodeName().equals("tuberias")) {
				mapa.tuberias = MapaTuberias.fromElement(child, mapa, d);
			} else if (child.getNodeName().equals("rutas")) {
				mapa.rutas = MapaRutas.fromElement(child, mapa, d);
			} else if (child.getNodeName().equals("redElectrica")) {
				mapa.redElectrica = MapaElectrico.fromElement(child, mapa, d);
			} else if (child.getNodeName().equals("ciudad")) {
				mapa.ciudad = MapaEdilicio.fromElement(child, mapa, d);
			} else if (child.getNodeName().equals("sistemaElectrico")) {
				mapa.sistemaElectrico = SistemaElectrico.fromElement(child);
			} else if (child.getNodeName().equals("Dinero")) {
//				Dinero dinero = Dinero.fromElement(child, mapa, turnos,
//						poblacion);
//				mapa.dinero = dinero;
				mapa.dinero = d;
			} else if (child.getNodeName().equals("reparador")) {
				Reparador reparador = Reparador.fromElement(child, mapa);
				mapa.reparador = reparador;
			}
		}
		// mapa.territorio.imprimirTerritorio();
		return mapa;
	}

}
