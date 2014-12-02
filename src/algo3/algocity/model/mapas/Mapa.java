package algo3.algocity.model.mapas;

import java.awt.Point;

import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadEnergetica;
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

	// Método implementado solo para tests
	public void setTerritorioTierraParaTest() {
		boolean tierra = true;
		territorio = new MapaTerritorio(alto, ancho, tierra);
	}
	
	public void setTerritorioAguaParaTest() {
		boolean agua = false;
		territorio = new MapaTerritorio(alto, ancho, agua);
	}

	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void agregar(Unidad unidad, int x, int y) {
		ciudad.agregar(unidad, x, y);
	}
	
	public void agregar(PozoDeAgua pozo, int x, int y){
		ciudad.agregar(pozo, x, y);
		tuberias.agregarPosicionRelevante(x, y);
	}

	// Supongo que para que una residencia este conectada tmb tiene
	// que tener una ruta a una central
	public void agregar(UnidadEnergetica unidad, int x, int y) {
		ciudad.agregar(unidad, x, y);
		redElectrica.agregarPosicionRelevante(x, y);
	}

	public void agregarLineaTension(LineaTension linea, int x, int y) {
		redElectrica.agregar(linea, x, y);
	}

	public void agregarRuta(Ruta ruta, int x, int y) {
		rutas.agregar(ruta, x, y);
	}

	public void agregarTuberia(Tuberia tuberia, int x, int y) {
		tuberias.agregar(tuberia, x, y);
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
	public Superficie getSuperficie(Point punto) {
		return territorio.getSuperficie(punto);
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

	// Agregar requisitos solo agua

}
