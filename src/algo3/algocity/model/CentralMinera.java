package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.mapas.Mapa;

public class CentralMinera extends UnidadEnergetica {

	public CentralMinera() {
		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
	}

	public CentralMinera(int x, int y) {
		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
		this.coordX = x;
		this.coordY = y;
	}

	public CentralMinera(ArrayList<Mapa> mapas, int x, int y) {
		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
		this.coordX = x;
		this.coordY = y;
	}

}
