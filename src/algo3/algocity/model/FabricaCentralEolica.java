package algo3.algocity.model;

public class FabricaCentralEolica implements FabricaEdificables {

	private int costo = 1000;
	private int capacidadElectrica = 100;
	private int radioInfluencia = 4;

	public CentralEolica construir() {

		return new CentralEolica(this.costo, this.capacidadElectrica,
				this.radioInfluencia);
	}

}
