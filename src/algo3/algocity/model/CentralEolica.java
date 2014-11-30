package algo3.algocity.model;

import java.util.ArrayList;

public class CentralEolica extends UnidadEnergetica {

	public CentralEolica() {
		this.costo = 1000;
		this.capacidad = 100;
		this.radioDeInfluencia = 4;
	}
	
	public CentralEolica(ArrayList<Mapa> mapas,int x, int y) {
		this.costo = 1000;
		this.capacidad = 100;
		this.radioDeInfluencia = 4;
		this.coordX = x;
		this.coordY = y;
	}

}
