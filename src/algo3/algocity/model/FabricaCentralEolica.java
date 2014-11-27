package algo3.algocity.model;

public class FabricaCentralEolica implements FabricaUnidades {

	public Unidad construir() {

		return new CentralEolica();

	}

}
