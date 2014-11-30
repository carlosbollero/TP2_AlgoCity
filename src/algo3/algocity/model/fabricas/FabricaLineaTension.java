package algo3.algocity.model.fabricas;

import java.util.ArrayList;

import algo3.algocity.model.Conector;
import algo3.algocity.model.LineaTension;
import algo3.algocity.model.mapas.Mapa;


public class FabricaLineaTension implements FabricaConectores {

	public Conector construir(ArrayList<Mapa> mapas, int x, int y) {
		return new LineaTension(mapas, x, y);
	}

}