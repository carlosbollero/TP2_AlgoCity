package algo3.algocity.model;

public class FabricaUnidadResidencial implements FabricaUnidades {

	public Unidad construir() {

		return new UnidadResidencial();
	}

}
