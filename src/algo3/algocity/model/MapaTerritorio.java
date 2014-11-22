package algo3.algocity.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.Random;

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
				Point coord = new Point(x, y);
				Superficie posicion = new Superficie(aleatorio.nextBoolean());
				this.mapa.put(coord, posicion);
			}
		}

	}

	public boolean consultarCoordenada(int x, int y) {
		return this.mapa.get(new Point(x, y)).tipo();
	}

	public Superficie getContenido(int x, int y) {
		return (this.mapa.get(new Point(x, y)));
	}
}
