package algo3.algocity.model.requisitos;

import java.util.ArrayList;
import java.util.Iterator;

import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.mapas.MapaGral;

public class RequisitoTierra implements Requisito {
	
	public boolean evaluar(ArrayList<MapaGral> mapas, Unidad unidad) {
		Iterator<MapaGral> it = mapas.iterator();
		boolean resultado = true;
		
		while (resultado && it.hasNext()){
			resultado = it.next().sePuedeConstruir(unidad);
		}		
		return resultado;
	}

}
