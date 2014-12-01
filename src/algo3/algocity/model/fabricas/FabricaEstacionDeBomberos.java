package algo3.algocity.model.fabricas;

import algo3.algocity.model.construcciones.EstacionDeBomberos;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class FabricaEstacionDeBomberos implements FabricaUnidades {

	@Override
	public Unidad construir(Mapa mapa, int x, int y) throws NoSeCumplenLosRequisitosException {

		return new EstacionDeBomberos(mapa, x, y);

	}

}