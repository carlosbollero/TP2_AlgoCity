package algo3.algocity.model;

import java.util.ArrayList;

public class FabricaUnidadIndustrial implements FabricaUnidades {

	public Unidad construir(ArrayList<Mapa> mapas, int x, int y) {

		return new UnidadIndustrial(mapas,x,y);
	}

}
