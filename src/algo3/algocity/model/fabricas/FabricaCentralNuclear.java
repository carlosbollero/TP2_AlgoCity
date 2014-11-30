package algo3.algocity.model.fabricas;

import java.util.ArrayList;

import algo3.algocity.model.CentralNuclear;
import algo3.algocity.model.Unidad;
import algo3.algocity.model.mapas.Mapa;

public class FabricaCentralNuclear implements FabricaUnidades {

	public Unidad construir(ArrayList<Mapa> mapas, int x, int y) {

		return new CentralNuclear(mapas, x, y);
	}

}
