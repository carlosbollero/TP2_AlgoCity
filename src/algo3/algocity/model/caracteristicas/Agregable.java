package algo3.algocity.model.caracteristicas;

import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public interface Agregable {
	
	public Coordenada coordenada();
	
	public boolean agregarseA(Mapa mapa);

	public boolean estaContenidoEn(Mapa mapa);

}
