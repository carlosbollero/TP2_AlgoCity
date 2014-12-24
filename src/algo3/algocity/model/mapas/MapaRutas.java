package algo3.algocity.model.mapas;

import java.util.ArrayList;
import java.util.Map.Entry;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.Ruta;

public class MapaRutas extends MapaConexiones {

	public MapaRutas(Mapa mapa) {
		super(mapa);
	}

	public boolean agregar(Ruta ruta) {
		if (!contiene(ruta) && !tieneCoordenadaOcupada(ruta.coordenada())) {
			mapaConectores.put(ruta.coordenada(), ruta);
			grafo.addVertex(ruta);
			actualizarGrafo(ruta);
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
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

	// @Override
	// protected void actualizarGrafo(Conector elemento) {
	// for (Entry<Coordenada, Conector> entry : mapaConectores.entrySet()) {
	// if (hayDistanciaMinima(elemento.coordenada(), entry.getKey())) {
	// grafo.addEdge(elemento, entry.getValue());
	// }
	// }
	// }

	public ArrayList<Daniable> unidadesDaniables() {
		ArrayList<Daniable> lista = new ArrayList<Daniable>();
		for (Conector c : grafo.vertexSet()) {
			lista.add((Daniable) c);
		}
		return lista;
	}
}
