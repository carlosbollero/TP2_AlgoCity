package algo3.algocity.model;

public class FabricaCentralEolica implements FabricaEdificables {

	public CentralEolica construir() {

		return new CentralEolica(1000, 100, 4);// Setear los parametros

	}

}
