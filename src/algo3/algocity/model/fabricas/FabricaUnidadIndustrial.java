package algo3.algocity.model.fabricas;

import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class FabricaUnidadIndustrial implements FabricaUnidades {

	public Unidad construir(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		return new UnidadIndustrial(mapa, x, y);
	}

}
