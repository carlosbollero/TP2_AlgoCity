package algo3.algocity.model.mapas;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.Reparador;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Ocupable;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.excepciones.NoTieneSuficientesFondosException;
import algo3.algocity.model.terreno.Superficie;

public class Mapa extends Observable {

	int alto;
	int ancho;
	int tamanio;

	MapaTerritorio territorio;
	MapaEdilicio ciudad;
	MapaConexiones tuberias;
	MapaConexiones rutas;
	MapaConexiones redElectrica;
	
	Dinero dinero;

	Reparador reparador;

	public Mapa() {
		alto = 20;
		ancho = 20;
		tamanio = 20;
		territorio = new MapaTerritorio(alto, ancho);
		ciudad = new MapaEdilicio(alto, ancho);
		tuberias = new MapaConexiones(alto, ancho);
		rutas = new MapaConexiones(alto, ancho);
		redElectrica = new MapaConexiones(alto, ancho);
		this.reparador = null;
	}
	
	public Mapa(Dinero dinero) {
		alto = 20;
		ancho = 20;
		tamanio = 20;
		territorio = new MapaTerritorio(alto, ancho);
		ciudad = new MapaEdilicio(alto, ancho);
		tuberias = new MapaConexiones(alto, ancho);
		rutas = new MapaConexiones(alto, ancho);
		redElectrica = new MapaConexiones(alto, ancho);
		this.reparador = null;
	}

	public int alto() {
		return alto;
	}

	public int ancho() {
		return ancho;
	}
	
//	public void agregar(Unidad unidad) {
//		unidad.agregarseA(this);
//	}

//	Verificar si es correcto
//	y ver que crashea la persistencia
	public void agregar(Unidad unidad) {
		try {
			if (dinero.cobrar(unidad.costo())){
				unidad.agregarseA(this);			
			}
		} catch (NoTieneSuficientesFondosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void agregar(Conector conector) {
		conector.agregarseA(this);
	}

	public boolean agregarACiudad(Unidad unidad) {
		return ciudad.agregar(unidad);
	}

	public boolean agregarARedElectrica(LineaTension linea) {
		return redElectrica.agregar(linea);
	}

	public boolean agregarARutas(Ruta ruta) {
		return rutas.agregar(ruta);
	}

	public boolean agregarATuberias(Tuberia tuberia) {
		return tuberias.agregar(tuberia);
	}

	/*
	 * public boolean agregarPuntoRelevanteEnTuberias(Coordenada punto) { return
	 * tuberias.agregarPosicionRelevante(punto); }
	 * 
	 * public boolean agregarPuntoRelevanteEnRedElectrica(Coordenada punto) {
	 * return redElectrica.agregarPosicionRelevante(punto); }
	 */
	public boolean agregarPuntoRelevanteEnTuberias(PozoDeAgua pa) {
		return tuberias.agregarPosicionRelevante(pa);
	}

	public boolean agregarPuntoRelevanteEnRedElectrica(UnidadEnergetica ue) {
		return redElectrica.agregarPosicionRelevante(ue);

	}

	public boolean agregarUnidadConPoblacion(Ocupable unidad) {
		return ciudad.agregarUnidadConPoblacion(unidad);
	}

	public boolean agregarUnidadConEmpleo(Ocupable unidad) {
		return ciudad.agregarUnidadConEmpleo(unidad);
	}

	public boolean agregarUnidadDaniable(Daniable unidad) {
		return ciudad.agregarUnidadDaniable(unidad);
	}

	public ArrayList<Ocupable> unidadesConPoblacion() {
		return ciudad.unidadesConPoblacion();
	}

	public ArrayList<Ocupable> unidadesConEmpleo() {
		return ciudad.unidadesConEmpleo();
	}

	public ArrayList<Daniable> unidadesDaniables() {
		return ciudad.unidadesDaniables();
	}

	public Coordenada posicionConAgua() {
		return territorio.posicionConAgua();
	}

	public Coordenada posicionConTierra() {
		return territorio.posicionConTierra();
	}

	public boolean contiene(Unidad u) {
		return ciudad.contiene(u);
	}
	
	public boolean contiene(LineaTension lt){
		return redElectrica.contiene(lt);
	}
	
	public boolean contiene(Ruta rt){
		return rutas.contiene(rt);
	}
	
	public boolean contiene(Tuberia tb){
		return tuberias.contiene(tb);
	}
	
	public ArrayList<Daniable> getDaniablesAlrededorDe(Coordenada epicentro,
			int radio) {
		return ciudad.getUnidadesAlrededorDe(epicentro, radio);
	}

	public ArrayList<Daniable> getDaniablesEnElCaminoDe(
			LinkedList<Point> listaCamino) {
		return ciudad.getDaniablesEnElCaminoDe(listaCamino);
	}

	// METODOS PARA VALIDAR REQUISITOS
	public Superficie superficie(Coordenada punto) {
		return territorio.superficie(punto);
	}

	public boolean hayConexionCompleta(Coordenada coordenadas) {
		return (hayConexionConRutas(coordenadas) && hayConexionConTuberias(coordenadas))
				&& hayConexionConRedElectrica(coordenadas);
	}

	public boolean hayConexionConTuberias(Coordenada coordenadas) {
		return tuberias.hayConexion(coordenadas);
	}

	public boolean hayConexionConRedElectrica(Coordenada coordenadas) {
		return redElectrica.hayConexion(coordenadas);
	}

	public boolean hayConexionConRutas(Coordenada coordenadas) {
		return rutas.hayConectorAdyacente(coordenadas);
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
	
	/*Usados para corroborar tests de persistencia*/
	public MapaEdilicio ciudad(){
		return this.ciudad;
	}
	
	public MapaConexiones tuberias(){
		return this.tuberias;
	}
	
	public MapaConexiones redElectrica(){
		return this.redElectrica;
	}
	
	public MapaConexiones rutas(){
		return this.rutas;
	}
	
	public MapaTerritorio territorio(){
		return this.territorio;
	}

	// Metodo implementado solo para tests
	/*********************************************************/
	public void setTerritorioTierraParaTest() {
		boolean tierra = true;
		territorio = new MapaTerritorio(alto, ancho, tierra);
		setChanged();
		notifyObservers();
	}

	public void setTerritorioAguaParaTest() {
		boolean agua = false;
		territorio = new MapaTerritorio(alto, ancho, agua);
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

	public int getTamanio() {
		return tamanio;

	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	public Element getElement(Document doc) {
		Element mapa = doc.createElement("Mapa");

		Element alto = doc.createElement("alto");
		mapa.appendChild(alto);
		alto.setTextContent(String.valueOf(this.alto));

		Element ancho = doc.createElement("ancho");
		mapa.appendChild(ancho);
		ancho.setTextContent(String.valueOf(this.ancho));

		Element territorio = doc.createElement("territorio");
		mapa.appendChild(territorio);
		territorio = this.territorio.getElement(doc, territorio);

		Element ciudad = doc.createElement("ciudad");
		mapa.appendChild(ciudad);
		ciudad = this.ciudad.getElement(doc, ciudad);

		Element tuberias = doc.createElement("tuberias");
		mapa.appendChild(tuberias);
		tuberias = this.tuberias.getElement(doc, tuberias);

		Element rutas = doc.createElement("rutas");
		mapa.appendChild(rutas);
		rutas = this.rutas.getElement(doc, rutas);

		Element redElectrica = doc.createElement("redElectrica");
		mapa.appendChild(redElectrica);
		redElectrica = this.redElectrica.getElement(doc, redElectrica);

		return mapa;
	}
	
	public static Mapa fromElement(Node element) {

		Mapa mapa = new Mapa();

		NodeList childs = element.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);

			if (child.getNodeName().equals("alto")) {
				mapa.alto = Integer.valueOf(child.getTextContent());
			} else if (child.getNodeName().equals("ancho")) {
				mapa.ancho = Integer.valueOf(child.getTextContent());
			} else if (child.getNodeName().equals("territorio")) {
				MapaTerritorio territorio = MapaTerritorio.fromElement(child);
				mapa.territorio = territorio;
			} else if (child.getNodeName().equals("ciudad")) {
				MapaEdilicio ciudad = MapaEdilicio.fromElement(child);
				mapa.ciudad = ciudad;
			} else if (child.getNodeName().equals("tuberias")) {
				MapaConexiones tuberias = MapaConexiones.fromElement(child);
				mapa.tuberias = tuberias;
			} else if (child.getNodeName().equals("rutas")) {
				MapaConexiones rutas = MapaConexiones.fromElement(child);
				mapa.rutas = rutas;
			} else if (child.getNodeName().equals("redElectrica")) {
				MapaConexiones redElectrica = MapaConexiones.fromElement(child);
				mapa.redElectrica = redElectrica;
			}
		}
		//mapa.territorio.imprimirTerritorio();
		return mapa;
	}
}
