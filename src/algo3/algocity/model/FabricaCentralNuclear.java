package algo3.algocity.model;

public class FabricaCentralNuclear implements FabricaEdificables {

<<<<<<< HEAD
	private int costo = 10000;
	private int capacidadElectrica = 1000;
	private int radioInfluencia = 25;

	public CentralNuclear construir() {

		return new CentralNuclear(this.costo, this.capacidadElectrica,
				this.radioInfluencia);
=======
	public CentralNuclear construir() {

		return new CentralNuclear();
>>>>>>> dev-tomas
	}

}
