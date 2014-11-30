package algo3.algocity.model;

import java.util.ArrayList;

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
