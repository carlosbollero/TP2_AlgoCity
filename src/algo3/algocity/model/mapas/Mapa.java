package algo3.algocity.model.mapas;

import java.util.ArrayList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Ocupable;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.terreno.Superficie;

public class Mapa {

	int alto;
	int ancho;

	MapaTerritorio territorio;
	MapaEdilicio ciudad;
	MapaConexiones tuberias;
	MapaConexiones rutas;
	MapaConexiones redElectrica;

	public Mapa() {
		alto = 14;
		ancho = 14;
		territorio = new MapaTerritorio(alto, ancho);
		ciudad = new MapaEdilicio(alto, ancho);
		tuberias = new MapaConexiones(alto, ancho);
		rutas = new MapaConexiones(alto, ancho);
		redElectrica = new MapaConexiones(alto, ancho);
	}

	public int alto() {
		return alto;
	}

	public int ancho() {
		return ancho;
	}

	public void agregar(Unidad unidad) {
		unidad.agregarseA(this);
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

	public boolean agregarPuntoRelevanteEnTuberias(Coordenada punto) {
		return tuberias.agregarPosicionRelevante(punto);
	}

	public boolean agregarPuntoRelevanteEnRedElectrica(Coordenada punto) {
		return redElectrica.agregarPosicionRelevante(punto);
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

	public ArrayList<Daniable> getDaniablesAlrededorDe(Coordenada epicentro,
			int radio) {
		return ciudad.getUnidadesAlrededorDe(epicentro, radio);
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

	// Método implementado solo para tests
	/*********************************************************/
	public void setTerritorioTierraParaTest() {
		boolean tierra = true;
		territorio = new MapaTerritorio(alto, ancho, tierra);
	}

	public void setTerritorioAguaParaTest() {
		boolean agua = false;
		territorio = new MapaTerritorio(alto, ancho, agua);
	}
	/*********************************************************/

	// CONSULTA PARA ACTUALIZACION DE POBLACION
	public int capacidadDePoblacion() {
		return this.ciudad.capacidadDePoblacion();
	}

	public int capacidadDeEmpleo() {
		return this.ciudad.capacidadDeEmpleo();
	}
}
