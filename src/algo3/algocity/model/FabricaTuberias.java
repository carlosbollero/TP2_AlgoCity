package algo3.algocity.model;

import java.util.ArrayList;

public class FabricaTuberias implements FabricaConectores{

	public Conector construir(ArrayList<Mapa> mapas, int x, int y) {
		return new Tuberia(mapas,x,y);
	}

}