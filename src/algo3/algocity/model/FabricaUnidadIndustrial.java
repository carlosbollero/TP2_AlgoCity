package algo3.algocity.model;

public class FabricaUnidadIndustrial implements FabricaUnidades {

	public Unidad construir() {

		return new UnidadIndustrial();
	}

}
