package algo3.algocity.model.fabricas;

import java.util.ArrayList;

import algo3.algocity.model.Conector;
import algo3.algocity.model.Tuberia;
import algo3.algocity.model.mapas.Mapa;



public class FabricaTuberias implements FabricaConectores{

	public Conector construir(ArrayList<Mapa> mapas, int x, int y) {
		return new Tuberia(mapas,x,y);
	}

}