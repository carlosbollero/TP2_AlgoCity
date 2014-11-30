package algo3.algocity.model;

import java.util.ArrayList;

public class RequisitoTierra implements Requisito {
	
	final boolean tierra = true;

	@Override
	public boolean evaluar(ArrayList<Mapa> mapas, int x, int y) {
		// TODO Auto-generated method stub
		return mapas.get(0).sePuedeConstruir(tierra, x, y);
	}

}
