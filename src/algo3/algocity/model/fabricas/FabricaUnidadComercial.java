package algo3.algocity.model.fabricas;

import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class FabricaUnidadComercial implements FabricaUnidades {

	@Override
	public UnidadComercial construir(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		return new UnidadComercial(mapa, x, y);
	}

}