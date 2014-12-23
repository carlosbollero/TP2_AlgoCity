package algo3.algocity.model.mapas;

import java.util.Map.Entry;

import algo3.algocity.model.conexiones.Conector;

public class MapaRutas extends MapaConexiones{
	
	MapaRutas(int tamanio){
		super(tamanio);
	}

	@Override
	public boolean hayConexion(Coordenada coord) {
		return hayConectorAdyacente(coord);
	}

	public boolean hayConectorAdyacente(Coordenada coord) {
		for (Entry<Coordenada, Conector> entry : mapaConectores.entrySet()) {
			if (hayDistanciaMinima(coord, entry.getKey())) {
				return true;
			}
		}
		return false;
	}
}
