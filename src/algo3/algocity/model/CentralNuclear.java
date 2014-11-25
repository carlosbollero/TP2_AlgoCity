package algo3.algocity.model;

public class CentralNuclear extends UnidadEnergetica {

	public CentralNuclear() {
		this.costo = 10000;
		this.capacidad = 1000;
		this.radioDeInfluencia = 25;
	}

	public CentralNuclear(int costo, int capacidadElectrica, int radioInfluencia) {
		this.costo = costo;
		this.capacidad = capacidadElectrica;
		this.radioDeInfluencia = radioInfluencia;
	}

}
