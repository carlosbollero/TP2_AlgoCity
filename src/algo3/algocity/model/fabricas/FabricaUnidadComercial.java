package algo3.algocity.model.fabricas;

import java.util.ArrayList;

import algo3.algocity.model.Unidad;
import algo3.algocity.model.UnidadComercial;
import algo3.algocity.model.mapas.Mapa;

public class FabricaUnidadComercial implements FabricaUnidades {

	public Unidad construir(ArrayList<Mapa> mapas, int x, int y) {

		return new UnidadComercial(mapas,x,y);
	}

}