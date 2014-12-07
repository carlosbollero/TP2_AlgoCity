package algo3.algocity.model.mapas;

import java.util.HashMap;
import java.util.Map;
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
	Map<Coordenada, Superficie> mapa;
	GeneradorTerritorio generador;
	Random aleatorio;

	public MapaTerritorio(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		aleatorio = new Random();
		generador = new GeneradorTerritorio(alto, ancho);
		mapa = new HashMap<Coordenada, Superficie>();
		
		inicializar();
	}

	// CONSTRUCTOR PARA TESTS
	/*************************************************************/
	public MapaTerritorio(int alto, int ancho, boolean test) {
		this.alto = alto;
		this.ancho = ancho;
		this.mapa = new HashMap<Coordenada, Superficie>();
		if (test) {
			inicializarConTierraParaTest();
		} else {
			inicializarConAguaParaTest();
		}
	}

	/*************************************************************/

	private void inicializar() {
		mapa = generador.generarTerritorio();
	}

	public boolean agregar(Superficie superficie, int x, int y) {
		Coordenada coord = new Coordenada(x, y);
		mapa.put(coord, superficie);
		return (mapa.containsKey(coord) && mapa.containsValue(superficie));
	}

	public boolean esAgua(Coordenada punto) {
		return (superficie(punto).esAgua());
	}

	public boolean esTierra(Coordenada punto) {
		return (superficie(punto).esTierra());
	}

	public Superficie superficie(Coordenada punto) {
		return (this.mapa.get(punto));
	}

	public boolean sePuedeConstruir(Unidad unidad) {
		return unidad.esConstruibleEn(superficie(unidad.coordenadas())
				.getSuperficie());
	}

	public boolean sePuedeConstruir(Conector conector) {
		return conector.esConstruibleEn(superficie(conector.coordenadas())
				.getSuperficie());
	}

	// METODOS UTILIZADOS POR TESTS PARA NO TRABAJAR SOBRE RANDOM
	/****************************************************************/
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

	public Coordenada posicionConAgua() {
		for (Entry<Coordenada, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esAgua()) {
				return entry.getKey();
			}
		}
		return null;
	}

	public Coordenada posicionConTierra() {

		for (Entry<Coordenada, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esTierra()) {
				return entry.getKey();
			}
		}
		return null;
	}
	/****************************************************************/

}
