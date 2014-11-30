package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;

public class FabricaEstacionDeBomberos implements FabricaUnidades {

	@Override
	public Unidad construir(ArrayList<Mapa> mapas, int x, int y) throws NoSeCumplenLosRequisitosException {

		return new EstacionDeBomberos(mapas, x, y);

	}

}