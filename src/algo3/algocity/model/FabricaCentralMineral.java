package algo3.algocity.model;

public class FabricaCentralMineral implements FabricaEdificables {

	private int costo = 3000;
	private int capacidadElectrica = 400;
	private int radioInfluencia = 10;

	public CentralMinera construir() {

		return new CentralMinera(this.costo, this.capacidadElectrica,
				this.radioInfluencia);
	}



}
