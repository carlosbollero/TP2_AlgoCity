package algo3.algocity.model;

public class CentralMinera extends UnidadEnergetica {

	public CentralMinera() {
		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
	}

	public CentralMinera(int costo, int capacidadElectrica, int radioInfluencia) {
		this.costo = costo;
		this.capacidad = capacidadElectrica;
		this.radioDeInfluencia = radioInfluencia;
	}

}
