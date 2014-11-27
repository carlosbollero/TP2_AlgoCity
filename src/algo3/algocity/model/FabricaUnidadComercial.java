package algo3.algocity.model;

public class FabricaUnidadComercial implements FabricaUnidades {

<<<<<<< HEAD
	private int costo = 5;
	private int consumo = 2;

	public UnidadComercial construir() {
=======
	public Unidad construir() {
>>>>>>> dev-tomas

		return new UnidadComercial(this.costo, this.consumo);
	}

}