package algo3.algocity.model;

public class CentralEolica extends UnidadEnergetica {

	public CentralEolica() {

	}

	public CentralEolica(int costoCentral, int capacidadElectrica,
			int radioInfluencia) {
		this.costo = costoCentral;
		this.capacidad = capacidadElectrica;
		this.radioDeInfluencia = radioInfluencia;
	}

}
