package algo3.algocity.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;

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

	private void inicializar() {
		for (int x = 0; x < alto; x++) {
			for (int y = 0; y < ancho; y++) {
				Superficie posicion = new Superficie(aleatorio.nextBoolean());
				agregar(posicion, x, y);
			}
		}
	}
	
	public boolean agregar(Superficie superficie, int x, int y){
		Point coord = new Point(x, y);
		mapa.put(coord, superficie);
		return (mapa.containsKey(coord) && mapa.containsValue(superficie));
	}

	public boolean consultarCoordenada(int x, int y) {
		return this.mapa.get(new Point(x, y)).tipo();
	}

	public Superficie getContenido(int x, int y) {
		return (this.mapa.get(new Point(x, y)));
	}

	// TODO
	// FEOFEO
	public Point getPosicionDeUnaSuperficieDeAgua() {
		for (Entry<Point, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esAgua()) {
				return entry.getKey();
			}
		}
		return null;

		/*
		 * boolean encontrado = false; int xADevolver = 0; int yADevolver = 0;
		 * for (int x = 0; (x < alto) && !encontrado; x++) { for (int y = 0; (y
		 * < ancho) && !encontrado; y++) { Point coord = new Point(x, y);
		 * Superficie unaSuperficie = this.mapa.get(coord); encontrado =
		 * unaSuperficie.esAgua(); yADevolver = y; } xADevolver = x; } int[]
		 * coordenadasADevolver = new int[]{xADevolver,yADevolver}; return
		 * coordenadasADevolver;
		 */
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

		/*
		 * boolean encontrado = false; int xADevolver = 0; int yADevolver = 0;
		 * for (int x = 0; (x < alto) && !encontrado; x++) { for (int y = 0; (y
		 * < ancho) && !encontrado; y++) { Point coord = new Point(x, y);
		 * Superficie unaSuperficie = this.mapa.get(coord); encontrado =
		 * unaSuperficie.esTierra(); yADevolver = y; } xADevolver = x; } int[]
		 * coordenadasADevolver = new int[]{xADevolver,yADevolver}; return
		 * coordenadasADevolver;
		 */
	}
}
