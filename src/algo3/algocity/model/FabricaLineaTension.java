package algo3.algocity.model;

import java.util.ArrayList;

public class FabricaLineaTension implements FabricaConectores {

	public Conector construir(ArrayList<Mapa> mapas, int x, int y) {
		return new LineaTension(mapas, x, y);
	}

}