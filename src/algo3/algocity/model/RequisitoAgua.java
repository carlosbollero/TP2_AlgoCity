package algo3.algocity.model;

import java.util.ArrayList;

public class RequisitoAgua implements Requisito {
	
	final boolean agua = false;
	
	public boolean evaluar(ArrayList<Mapa> mapas, int x, int y) {
		
		return mapas.get(0).sePuedeConstruir(agua, x, y);
		
	}

}
