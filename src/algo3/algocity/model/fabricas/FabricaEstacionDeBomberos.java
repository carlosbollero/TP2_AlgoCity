package algo3.algocity.model.fabricas;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.construcciones.EstacionDeBomberos;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class FabricaEstacionDeBomberos implements FabricaUnidades {

	@Override
	public Unidad construir(Mapa mapa, Dinero dinero, int x, int y)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException {

		return new EstacionDeBomberos(mapa, dinero, new Coordenada(x, y));

	}

}