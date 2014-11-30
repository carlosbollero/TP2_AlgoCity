package algo3.algocity.model.fabricas;

import java.util.ArrayList;

import algo3.algocity.model.Conector;
import algo3.algocity.model.Ruta;
import algo3.algocity.model.mapas.Mapa;


public class FabricaRuta implements FabricaConectores {

	public Conector construir(ArrayList<Mapa> mapas, int x, int y) {
		return new Ruta(mapas,x,y);
	}

}