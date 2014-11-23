package algo3.algocity.model;

public class FabricaUnidadIndustrial implements FabricaEdificables {

	public UnidadIndustrial construir() {

		return new UnidadIndustrial(10, 5, 25);
	}

}
