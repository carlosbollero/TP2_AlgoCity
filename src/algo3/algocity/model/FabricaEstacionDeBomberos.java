package algo3.algocity.model;

public class FabricaEstacionDeBomberos implements FabricaUnidades {

	public Unidad construir() {

		return new EstacionDeBomberos();
	}

}