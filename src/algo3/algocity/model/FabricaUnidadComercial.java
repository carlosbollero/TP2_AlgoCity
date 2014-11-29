package algo3.algocity.model;

public class FabricaUnidadComercial implements FabricaUnidades {

	public Unidad construir() {

		return new UnidadComercial();
	}

}