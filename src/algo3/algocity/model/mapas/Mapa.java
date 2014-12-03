package algo3.algocity.model.mapas;

import java.awt.Point;

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

	public Mapa(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		territorio = new MapaTerritorio(alto, ancho);
		ciudad = new MapaEdilicio(alto, ancho);
		tuberias = new MapaConexiones(alto, ancho);
		rutas = new MapaConexiones(alto, ancho);
		redElectrica = new MapaConexiones(alto, ancho);
	}

	public int getAlto() {
		return alto;
	}

	public int getAncho() {
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

	public boolean agregarPuntoRelevanteEnTuberias(Point punto) {
		return tuberias.agregarPosicionRelevante(punto);
	}

	public boolean agregarPuntoRelevanteEnRedElectrica(Point punto) {
		return redElectrica.agregarPosicionRelevante(punto);
	}

	public Point getPosicionConAgua() {
		return territorio.getPosicionDeUnaSuperficieDeAgua();
	}

	public Point getPosicionConTierra() {
		return territorio.getPosicionDeUnaSuperficieDeTierra();
	}

	public boolean contiene(Unidad u) {
		return ciudad.contiene(u);
	}

	// METODOS PARA VALIDAR REQUISITOS
	public Superficie superficie(Point punto) {
		return territorio.superficie(punto);
	}

	public boolean hayConexionCompleta(Point coordenadas) {
		return (hayConexionConRutas(coordenadas) && hayConexionConTuberias(coordenadas))
				&& hayConexionConRedElectrica(coordenadas);
	}

	public boolean hayConexionConTuberias(Point coordenadas) {
		return tuberias.hayConexion(coordenadas);
	}

	public boolean hayConexionConRedElectrica(Point coordenadas) {
		return redElectrica.hayConexion(coordenadas);
	}

	public boolean hayConexionConRutas(Point coordenadas) {
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
	public int capacidadHabitacional() {
		return this.ciudad.getCapacidadHabitacional();
	}

	public int capacidadEmpleo() {
		return this.ciudad.getCapacidadEmpleo();
	}

}
