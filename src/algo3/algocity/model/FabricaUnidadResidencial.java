package algo3.algocity.model;

public class FabricaUnidadResidencial implements FabricaUnidades {

	private int costo = 5;
	private int consumo = 1;
	private int capacidad = 100;

	public UnidadResidencial construir() {

		return new UnidadResidencial(this.costo, this.consumo, this.capacidad); // parametros

	}

}
