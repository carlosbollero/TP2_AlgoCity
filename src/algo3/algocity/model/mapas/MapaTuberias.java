package algo3.algocity.model.mapas;

import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.construcciones.PozoDeAgua;

public class MapaTuberias extends MapaConexiones {

	public MapaTuberias(Mapa mapa) {
		super(mapa);
	}

	public boolean agregar(Tuberia tuberia) {
		if (!contiene(tuberia) && !tieneCoordenadaOcupada(tuberia.coordenada())) {
//			mapaConectores.put(tuberia.coordenada(), tuberia);
			grafo.addVertex(tuberia);
			actualizarGrafo(tuberia);
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
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
