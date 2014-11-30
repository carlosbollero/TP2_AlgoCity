package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.mapas.Mapa;

public class CentralNuclear extends UnidadEnergetica {

	public CentralNuclear() {
		this.costo = 10000;
		this.capacidad = 1000;
		this.radioDeInfluencia = 25;
	}

	public CentralNuclear(int x, int y) {
		this.costo = 10000;
		this.capacidad = 1000;
		this.radioDeInfluencia = 25;
		this.coordX = x;
		this.coordY = y;
	}

	public CentralNuclear(ArrayList<Mapa> mapas, int x, int y) {
		this.costo = 10000;
		this.capacidad = 1000;
		this.radioDeInfluencia = 25;
		this.coordX = x;
		this.coordY = y;
	}

}
