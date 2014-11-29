package algo3.algocity.model;

public class FabricaCentralNuclear implements FabricaUnidades {

<<<<<<< HEAD
	private int costo = 10000;
	private int capacidadElectrica = 1000;
	private int radioInfluencia = 25;

	public CentralNuclear construir() {
=======
	public Unidad construir() {
>>>>>>> 275e25272bfc21a3f80890c7ce3add1a02b67ca1

		return new CentralNuclear(this.costo, this.capacidadElectrica,
				this.radioInfluencia);
	}

}
