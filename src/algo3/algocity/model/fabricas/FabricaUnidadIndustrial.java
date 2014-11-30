package algo3.algocity.model.fabricas;

import java.util.ArrayList;

import algo3.algocity.model.Unidad;
import algo3.algocity.model.UnidadIndustrial;
import algo3.algocity.model.mapas.Mapa;

public class FabricaUnidadIndustrial implements FabricaUnidades {

	public Unidad construir(ArrayList<Mapa> mapas, int x, int y) {

		return new UnidadIndustrial(mapas,x,y);
	}

}
