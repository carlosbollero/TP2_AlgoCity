package algo3.algocity.model;

public class FabricaPozoAgua implements FabricaUnidades {

	public Unidad construir() {

		return new PozoDeAgua();
	}

}