package algo3.algocity.model.mapas;

import algo3.algocity.model.construcciones.UnidadEnergetica;

public class MapaElectrico extends MapaConexiones {
	
	public MapaElectrico(int tamanio) {
		super(tamanio);
	}

	@Override
	public boolean hayConexion(Coordenada coord) {		
		for (UnidadEnergetica u : mapa.ciudad().getUnidadesEnergeticas()){
			if (estaDentroDeRadio(coord, u)){
				return true;
			}
			if (super.hayConexion(coord, u.coordenada())){
				return true;
			}
		}
		return false;
	}
	
	public boolean estaDentroDeRadio(Coordenada coord, UnidadEnergetica unidad) {
		return ( unidad.coordenada().distancia(coord) <= unidad.getRadio());
	}

}
