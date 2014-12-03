package algo3.algocity.model.construcciones;

import java.awt.Point;

import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public abstract class Unidad {

	int costo;
	int consumo;
	Point coordenadas;

	public int costo() {
		return this.costo;
	}

	public int consumo() {
		return consumo;
	}

	public Point getCoordenadas() {
		return coordenadas;
	}

	public abstract void aplicarDanio(double i);

	public abstract boolean esConstruibleEn(Superficie superficie);

	public abstract double getSalud();
	
	//public abstract Agregador agregador();

	public abstract void agregarseA(Mapa mapa);

}
