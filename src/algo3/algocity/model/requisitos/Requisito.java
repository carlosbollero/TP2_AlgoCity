package algo3.algocity.model.requisitos;

import java.util.ArrayList;

import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.mapas.MapaGral;

public interface Requisito {
	
	public boolean evaluar(ArrayList<MapaGral> mapas, Unidad unidad);

}
