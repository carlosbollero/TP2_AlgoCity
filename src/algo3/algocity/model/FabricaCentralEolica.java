package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;

public class FabricaCentralEolica implements FabricaUnidades {

	public Unidad construir(ArrayList<Mapa> mapas, int x, int y) throws NoSeCumplenLosRequisitosException {

		return new CentralEolica(mapas, x, y);

	}

}
