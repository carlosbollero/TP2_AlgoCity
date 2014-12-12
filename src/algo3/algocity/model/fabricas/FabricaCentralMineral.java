package algo3.algocity.model.fabricas;

import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class FabricaCentralMineral implements FabricaEnergetica {

	public UnidadEnergetica construir(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		return new CentralMinera(mapa, x, y);
	}

}
