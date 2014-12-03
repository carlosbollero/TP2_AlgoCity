package algo3.algocity.model.mapas;

import java.awt.Point;
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
		if (test) {
			inicializarConTierraParaTest();
		} else {
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

	public boolean agregar(Superficie superficie, int x, int y) {
		Point coord = new Point(x, y);
		mapa.put(coord, superficie);
		return (mapa.containsKey(coord) && mapa.containsValue(superficie));
	}

	public boolean posicionConAgua(Point punto) {
		return (superficie(punto).esAgua());
	}

	public boolean posicionConTierra(Point punto) {
		return (superficie(punto).esTierra());
	}

	public Superficie superficie(Point punto) {
		return (this.mapa.get(punto));
	}

	public boolean sePuedeConstruir(Unidad unidad) {
		return unidad.esConstruibleEn(superficie(unidad.getCoordenadas())
				.getSuperficie());
	}

	public boolean sePuedeConstruir(Conector conector) {
		return conector
				.esConstruibleEn(superficie(conector.getCoordenadas())
						.getSuperficie());
	}
	
	// METODOS SOLO IMPLEMENTADOS PARA NO TESTEAR SOBRE RANDOM
	/***********************************************************/
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

	public Point getPosicionDeUnaSuperficieDeTierra() {

		for (Entry<Point, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esTierra()) {
				return entry.getKey();
			}
		}
		return null;
	}

	public Point getPosicionDeUnaSuperficieDeAgua() {
		for (Entry<Point, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esAgua()) {
				return entry.getKey();
			}
		}
		return null;
	}
	/***********************************************************/
}
