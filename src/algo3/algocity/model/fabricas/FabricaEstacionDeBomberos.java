package algo3.algocity.model.fabricas;

import java.util.ArrayList;

import algo3.algocity.model.EstacionDeBomberos;
import algo3.algocity.model.Unidad;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class FabricaEstacionDeBomberos implements FabricaUnidades {

	@Override
	public Unidad construir(ArrayList<Mapa> mapas, int x, int y) throws NoSeCumplenLosRequisitosException {

		return new EstacionDeBomberos(mapas, x, y);

	}

}