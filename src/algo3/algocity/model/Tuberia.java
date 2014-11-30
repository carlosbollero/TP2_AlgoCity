package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.mapas.Mapa;

public class Tuberia extends Conector {

	public Tuberia() {
		costo = 5;
	}

	public Tuberia(ArrayList<Mapa> mapas, int x, int y) {
		costo = 5;
		this.coordX = x;
		this.coordY = y;
	}

}
