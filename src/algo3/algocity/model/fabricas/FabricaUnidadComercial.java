package algo3.algocity.model.fabricas;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class FabricaUnidadComercial implements FabricaUnidades {

	@Override
	public UnidadComercial construir(Mapa mapa, Dinero dinero, int x, int y)
			throws NoSeCumplenLosRequisitosException, FondosInsuficientesException {

		return new UnidadComercial(mapa, dinero,new Coordenada(x, y));
	}

}