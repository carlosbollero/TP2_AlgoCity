package algo3.algocity.model;

public class FabricaUnidadResidencial implements FabricaEdificables {

	public UnidadResidencial construir() {

		return new UnidadResidencial(5, 1, 100); // parametros
	}

}
