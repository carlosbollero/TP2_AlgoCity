package algo3.algocity.model.mapas;

import algo3.algocity.model.construcciones.PozoDeAgua;


public class MapaTuberias extends MapaConexiones {

	public MapaTuberias(int tamanio) {
		super(tamanio);
	}

	@Override
	public boolean hayConexion(Coordenada coord) {
		for (PozoDeAgua p : mapa.ciudad().getPozosDeAgua()) {
			if (hayConexion(coord, p.coordenada())) {
				return true;
			}
		}
		return false;
	}
	
}
