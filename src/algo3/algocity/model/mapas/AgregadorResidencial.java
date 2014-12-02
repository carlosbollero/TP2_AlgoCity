package algo3.algocity.model.mapas;

import algo3.algocity.model.construcciones.UnidadResidencial;

public class AgregadorResidencial implements Agregador {

	@Override
	public void agregar(Mapa mapa, UnidadResidencial unidad) {
		mapa.ciudad.agregar(unidad, unidad.getCoordenadas().x, unidad.getCoordenadas().y);
	}

}
