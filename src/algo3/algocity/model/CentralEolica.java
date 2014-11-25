package algo3.algocity.model;

public class CentralEolica extends UnidadEnergetica {

	public CentralEolica() {
		this.costo = 1000;
		this.capacidad = 100;
		this.radioDeInfluencia = 4;
	}

	public CentralEolica(int costo, int capacidadElectrica, int radioInfluencia) {
		this.costo = costo;
		this.capacidad = capacidadElectrica;
		this.radioDeInfluencia = radioInfluencia;
	}

}
