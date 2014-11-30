package algo3.algocity.model;

import java.util.ArrayList;

public class FabricaRuta implements FabricaConectores {

	public Conector construir(ArrayList<Mapa> mapas, int x, int y) {
		return new Ruta(mapas,x,y);
	}

}