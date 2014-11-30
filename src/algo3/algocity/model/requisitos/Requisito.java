package algo3.algocity.model.requisitos;

import java.util.ArrayList;

import algo3.algocity.model.mapas.Mapa;

public interface Requisito {
	
	public boolean evaluar(ArrayList<Mapa> mapas, int x, int y);

}
