package algo3.algocity.model;

import java.util.ArrayList;

public class FabricaPozoAgua implements FabricaUnidades {

	public Unidad construir(ArrayList<Mapa> mapas, int x, int y) {
		
		return new PozoDeAgua(mapas, x, y);		
	}

}