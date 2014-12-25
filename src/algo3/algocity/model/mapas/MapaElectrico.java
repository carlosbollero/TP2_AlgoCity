package algo3.algocity.model.mapas;

import java.util.ArrayList;
import java.util.Iterator;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.construcciones.UnidadEnergetica;

public class MapaElectrico extends MapaConexiones {
	
	ArrayList<LineaTension> listado;

	public MapaElectrico(Mapa mapa) {
		super(mapa);
		listado = new ArrayList<LineaTension>();
	}

	public boolean agregar(LineaTension linea) {
		// if (validarCoordenadas(linea.coordenada()) && !contiene(linea)
		// && !tieneCoordenadaOcupada(linea.coordenada())) {
		if (!contiene(linea) && !tieneCoordenadaOcupada(linea.coordenada())) {
			listado.add(linea);
//			mapaConectores.put(linea.coordenada(), linea);
			grafo.addVertex(linea);
			actualizarGrafo(linea);
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
	}

	@Override
	public boolean hayConexion(Coordenada coord) {
		for (UnidadEnergetica u : mapa.ciudad().getUnidadesEnergeticas()) {
			if (u.estaDentroDeRadio(coord)) {
				return true;
			}
			if (hayConexion(coord, u.coordenada())) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Daniable> unidadesDaniables() {
		ArrayList<Daniable> lista = new ArrayList<Daniable>();
		for (LineaTension lt : listado) {
			lista.add(lt);
		}
		return lista;
	}

}
