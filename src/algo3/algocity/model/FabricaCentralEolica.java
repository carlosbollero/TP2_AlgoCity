package algo3.algocity.model;

public class FabricaCentralEolica implements FabricaUnidades {

<<<<<<< HEAD
	private int costo = 1000;
	private int capacidadElectrica = 100;
	private int radioInfluencia = 4;
=======
	public Unidad construir() {
>>>>>>> 275e25272bfc21a3f80890c7ce3add1a02b67ca1

	public CentralEolica construir() {

		return new CentralEolica(this.costo, this.capacidadElectrica,
				this.radioInfluencia);
	}

}
