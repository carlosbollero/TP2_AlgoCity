package algo3.algocity.model.fabricas;

import java.util.ArrayList;

import algo3.algocity.model.CentralEolica;
import algo3.algocity.model.Unidad;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class FabricaCentralEolica implements FabricaUnidades {

	public Unidad construir(ArrayList<Mapa> mapas, int x, int y) throws NoSeCumplenLosRequisitosException {

		return new CentralEolica(mapas, x, y);
	}

}
