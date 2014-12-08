package algo3.algocity.model.construcciones;

import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public abstract class Unidad {

	int costo;
	int consumo;
	Coordenada coordenadas;

	public int costo() {
		return this.costo;
	}

	public int consumo() {
		return consumo;
	}

	public Coordenada coordenadas() {
		return coordenadas;
	}

//	public abstract void aplicarDanio(double i);

	public abstract boolean esConstruibleEn(Superficie superficie);

	public abstract double getSalud();
	
	//public abstract Agregador agregador();

	public abstract void agregarseA(Mapa mapa);

}
