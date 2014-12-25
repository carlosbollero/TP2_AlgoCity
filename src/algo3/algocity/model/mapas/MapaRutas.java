package algo3.algocity.model.mapas;

import java.util.ArrayList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.Ruta;

public class MapaRutas extends MapaConexiones {
	
	ArrayList<Ruta> listado;

	public MapaRutas(Mapa mapa) {
		super(mapa);
		listado = new ArrayList<Ruta>();
	}

	public boolean agregar(Ruta ruta) {
		if (contiene(ruta) || tieneCoordenadaOcupada(ruta.coordenada())) {
			return false;
		}
		listado.add(ruta);
//		mapaConectores.put(ruta.coordenada(), ruta);
		grafo.addVertex(ruta);
		actualizarGrafo(ruta);
		setChanged();
		notifyObservers();
		return true;
	}

	@Override
	public boolean hayConexion(Coordenada coord) {
		return hayConectorAdyacente(coord);
	}

	public boolean hayConectorAdyacente(Coordenada coord) {
		for (Conector c : grafo.vertexSet()) {
			if (hayDistanciaMinima(coord, c.coordenada())) {
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
