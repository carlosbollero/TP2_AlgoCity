package algo3.algocity.model;

public class FabricaUnidadIndustrial implements FabricaUnidades {

<<<<<<< HEAD
	private int costo = 10;
	private int consumo = 5;
	private int capacidad = 25;

	public UnidadIndustrial construir() {
=======
	public Unidad construir() {
>>>>>>> 275e25272bfc21a3f80890c7ce3add1a02b67ca1

		return new UnidadIndustrial(this.costo, this.consumo, this.capacidad);
	}

}
