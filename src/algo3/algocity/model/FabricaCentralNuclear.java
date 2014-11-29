package algo3.algocity.model;

public class FabricaCentralNuclear implements FabricaUnidades {

	public Unidad construir() {

		return new CentralNuclear();
	}

}
