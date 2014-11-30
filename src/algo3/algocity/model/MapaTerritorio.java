package algo3.algocity.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;

public class MapaTerritorio implements Mapa {

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

	//Este método se implementó para poder realizar test sobre Random
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
	
	public ArrayList<Point> posicionesConTierra(){
		ArrayList<Point> lista = new ArrayList<Point>();
		for (Entry<Point, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esTierra()) {
				lista.add(entry.getKey());
			}
		}
		return lista;
	}

	@Override
	public boolean sePuedeConstruir(boolean resultadoEsperado,int x, int y) {
		if (resultadoEsperado == tierra){
			return (consultarCoordenada(x, y) == resultadoEsperado);
		}else if (resultadoEsperado == agua) {
			return (consultarCoordenada(x, y) == resultadoEsperado);
		}
		return false;
	}
}
