package algo3.algocity.model;

<<<<<<< HEAD
public class FabricaCentralMineral implements FabricaEdificables {

	private int costo = 3000;
	private int capacidadElectrica = 400;
	private int radioInfluencia = 10;

	public CentralMinera construir() {
=======
public class FabricaCentralMineral implements FabricaUnidades {

	public Unidad construir() {
		return new CentralMinera();
>>>>>>> dev-tomas

		return new CentralMinera(this.costo, this.capacidadElectrica,
				this.radioInfluencia);
	}



}
