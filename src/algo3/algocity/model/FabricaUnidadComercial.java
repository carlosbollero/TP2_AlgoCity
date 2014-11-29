package algo3.algocity.model;

public class FabricaUnidadComercial implements FabricaUnidades {

<<<<<<< HEAD
	private int costo = 5;
	private int consumo = 2;

	public UnidadComercial construir() {
=======
	public Unidad construir() {
>>>>>>> 275e25272bfc21a3f80890c7ce3add1a02b67ca1

		return new UnidadComercial(this.costo, this.consumo);
	}

}