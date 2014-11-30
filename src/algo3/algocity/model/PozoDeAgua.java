package algo3.algocity.model;

import java.util.ArrayList;

public class PozoDeAgua extends Unidad {

	public PozoDeAgua() {
		costo = 250;
		consumo = 0;
		
	}

	public PozoDeAgua(ArrayList<Mapa> mapas, int x, int y) {
		costo = 250;
		consumo = 0;
		this.coordX = x;
		this.coordY = y;
	}

}
