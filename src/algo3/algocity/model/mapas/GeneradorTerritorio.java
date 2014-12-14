package algo3.algocity.model.mapas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import algo3.algocity.model.terreno.Superficie;
import algo3.algocity.model.terreno.SuperficieAgua;
import algo3.algocity.model.terreno.SuperficieTierra;

public class GeneradorTerritorio {

	Random aleatorio;
	SortedSet<Coordenada> puntosCentrales;
	LinkedList<Coordenada> coordNoOcupadas;
	Map<Coordenada, Superficie> mapa;
	int alto;
	int ancho;
	int tamanio;

	public GeneradorTerritorio(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		tamanio = alto * ancho;
		coordNoOcupadas = new LinkedList<Coordenada>();
		rellenarCoordenadasNoOcupadas();
		puntosCentrales = new TreeSet<Coordenada>();
		mapa = new HashMap<Coordenada, Superficie>();
		aleatorio = new Random();
	}

	public Map<Coordenada, Superficie> generarTerritorio() {
		definirPuntosCentrales();
		definirRestoDelMapa();
		return mapa;
	}

	/*
	 * Define los puntos centrales que van a establecer donde hay agua y donde
	 * hay tierra. La cantidad de puntos es igual al 10% del tamaño del mapa.
	 */
	public void definirPuntosCentrales() {
		int cantidad = ((tamanio * 8) / 100);
		for (int i = 0; i < cantidad; i++) {
			Coordenada c = coordenadaAleatoria();
//			while (puntosCentrales.contains(c)) {
//				c = coordenadaAleatoria();
//			}
			Superficie s = superficieAleatoria();
			mapa.put(c, s);
			puntosCentrales.add(c);
			coordNoOcupadas.remove(c);
		}

	}

	/*
	 * Genera una lista con las coordenadas no ocupadas en el mapa
	 */
	private void rellenarCoordenadasNoOcupadas() {
		for (int x = 0; x < alto; x++) {
			for (int y = 0; y < ancho; y++) {
				coordNoOcupadas.add(new Coordenada(x, y));
			}
		}
	}

	/*
	 * Completa el mapa con la superficie que le corresponde segun la lista de
	 * puntos centrales.
	 */
	private void definirRestoDelMapa() {
		for (Coordenada coord : coordNoOcupadas) {
			Superficie ref = superficieMasCercana(coord);
			Superficie sup;
			sup = (ref.esAgua()) ? new SuperficieAgua()	: new SuperficieTierra();
			mapa.put(coord, sup);
		}

	}

	/*
	 * Devuelve la superficie de la coordenada más cercana dentro de la lista de
	 * puntos centrales.
	 */
	private Superficie superficieMasCercana(Coordenada c) {
		Coordenada ref = puntosCentrales.first();
		int dist = c.distancia(ref);
		for (Coordenada coord : puntosCentrales) {
			if (c.distancia(coord) < dist) {
				dist = c.distancia(coord);
				ref = coord;
			}
		}
		return mapa.get(ref);
	}

	/*
	 * Genera una Coordenada aleatoria dentro de los limites del mapa y
	 * asegurandose que no repita una generada anteriormente como punto central.
	 */
	private Coordenada coordenadaAleatoria() {
		return coordNoOcupadas.remove(aleatorio.nextInt(coordNoOcupadas.size()));
//		return new Coordenada(aleatorio.nextInt(alto), aleatorio.nextInt(ancho));
	}

	/*
	 * Genera una supeficie aleatoria, con mayor probabilidad de que sea Tierra.
	 */
	private Superficie superficieAleatoria() {
		Superficie s;
		int numero = aleatorio.nextInt(10);
		s = (numero > 7) ? new SuperficieAgua() : new SuperficieTierra();
		return s;
	}

	public ArrayList<Coordenada> getPuntonsCentrales() {
		ArrayList<Coordenada> lista = new ArrayList<Coordenada>();
		for (Coordenada coord : puntosCentrales) {
			lista.add(coord);
		}
		return lista;
	}
}
