package algo3.algocity.model.fabricas;

import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class FabricaCentralEolica implements FabricaEnergetica {

	public UnidadEnergetica construir(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		return new CentralEolica(mapa, x, y);
	}

}
