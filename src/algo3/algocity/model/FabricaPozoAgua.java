package algo3.algocity.model;

public class FabricaPozoAgua implements FabricaEdificables {

	private int costo = 250;

	public PozoDeAgua construir() {

		return new PozoDeAgua(this.costo);
	}

}