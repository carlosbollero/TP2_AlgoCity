package algo3.algocity.model.requisitos;

import java.util.ArrayList;

import algo3.algocity.model.mapas.Mapa;

public class RequisitoTierra implements Requisito {
	
	final boolean tierra = true;

	@Override
	public boolean evaluar(ArrayList<Mapa> mapas, int x, int y) {
		// TODO Auto-generated method stub
		return mapas.get(0).sePuedeConstruir(tierra, x, y);
	}

}
