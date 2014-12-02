package algo3.algocity.model.mapas;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.terreno.Superficie;
import algo3.algocity.model.terreno.SuperficieAgua;
import algo3.algocity.model.terreno.SuperficieTierra;

public class MapaTerritorio {

	int alto;
	int ancho;
	final boolean tierra = true;
	final boolean agua = false;
	HashMap<Point, Superficie> mapa;
	Random aleatorio;

	public MapaTerritorio(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.aleatorio = new Random();
		this.mapa = new HashMap<Point, Superficie>();
		this.inicializar();
	}
	
	public MapaTerritorio(int alto, int ancho, boolean test) {
		this.alto = alto;
		this.ancho = ancho;
		this.mapa = new HashMap<Point, Superficie>();
		if (test){
			inicializarConTierraParaTest();
		}else{
			inicializarConAguaParaTest();
		}
	}
	
	

	private void inicializar() {
		for (int x = 0; x < alto; x++) {
			for (int y = 0; y < ancho; y++) {
				Superficie posicion;
				if (aleatorio.nextBoolean()) {
					posicion = new SuperficieAgua();
				} else {
					posicion = new SuperficieTierra();
				}
				agregar(posicion, x, y);
			}
		}
	}
	
	private void inicializarConTierraParaTest(){
		for (int x = 0; x < alto; x++) {
			for (int y = 0; y < ancho; y++) {
				Superficie posicion = new SuperficieTierra();
				agregar(posicion, x, y);
			}
		}
	}
	
	private void inicializarConAguaParaTest(){
		for (int x = 0; x < alto; x++) {
			for (int y = 0; y < ancho; y++) {
				Superficie posicion = new SuperficieAgua();
				agregar(posicion, x, y);
			}
		}
	}

	public boolean agregar(Superficie superficie, int x, int y) {
		Point coord = new Point(x, y);
		mapa.put(coord, superficie);
		return (mapa.containsKey(coord) && mapa.containsValue(superficie));
	}

	public boolean posicionConAgua(Point punto) {
		return (getSuperficie(punto).esAgua());
	}

	public boolean posicionConTierra(Point punto) {
		return (getSuperficie(punto).esTierra());
	}

	public Superficie getSuperficie(Point punto) {
		return (this.mapa.get(punto));
	}

	// Este método se implementó para poder realizar test sobre Random
	public Point getPosicionDeUnaSuperficieDeAgua() {
		for (Entry<Point, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esAgua()) {
				return entry.getKey();
			}
		}
		return null;
	}

	// TODO
	// FEOFEO
	public Point getPosicionDeUnaSuperficieDeTierra() {

		for (Entry<Point, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esTierra()) {
				return entry.getKey();
			}
		}
		return null;
	}

	public ArrayList<Point> posicionesConTierra() {
		ArrayList<Point> lista = new ArrayList<Point>();
		for (Entry<Point, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esTierra()) {
				lista.add(entry.getKey());
			}
		}
		return lista;
	}

	public boolean sePuedeConstruir(Unidad unidad) {
		return unidad.esConstruibleEn(getSuperficie(unidad.getCoordenadas())
				.getSuperficie());
	}

	// public boolean sePuedeConstruir(Servicio servicio) {
	// return servicio.esConstruibleEn(getSuperficie(
	// servicio.getCoordenadas().x, servicio.getCoordenadas().y)
	// .getSuperficie());
	// }

	public boolean sePuedeConstruir(Conector conector) {
		return conector
				.esConstruibleEn(getSuperficie(conector.getCoordenadas())
						.getSuperficie());
	}

}
