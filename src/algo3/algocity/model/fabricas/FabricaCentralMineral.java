package algo3.algocity.model.fabricas;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class FabricaCentralMineral implements FabricaEnergetica {

	public UnidadEnergetica construir(Mapa mapa ,Dinero dinero, int x, int y)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException {

		return new CentralMinera(mapa, dinero, new Coordenada(x,y));
	}
}
