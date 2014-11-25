package algo3.algocity.model;

public class FabricaUnidadIndustrial implements FabricaEdificables {

<<<<<<< HEAD
	private int costo = 10;
	private int consumo = 5;
	private int capacidad = 25;

	public UnidadIndustrial construir() {

		return new UnidadIndustrial(this.costo, this.consumo, this.capacidad);
=======
	public UnidadIndustrial construir() {

		return new UnidadIndustrial();
>>>>>>> dev-tomas
	}

}
