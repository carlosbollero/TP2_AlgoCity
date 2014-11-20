package algo3.algocity.model;

import java.util.ArrayList;

//import org.jgrapht.graph.DefaultEdge;
//import org.jgrapht.graph.ListenableUndirectedGraph;

public abstract class Mapa {

	int alto;
	int ancho;

	public Mapa(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;

	}

	public abstract boolean agregar(Ubicable elemento, int i, int j);

	private boolean validarCoordenadas(int i, int j) {
		if (this.estaVacio() || !this.estaDentroDeLimites(i, j)
				|| this.tieneCoordenadaOcupada(i, j)) {
			return false;
		}

		// for (Parcela p : this.lista){
		// if (p.tieneCoordenadas(i, j)){
		// return false;
		// }
		// }
		return true;
	}

	private boolean estaDentroDeLimites(int i, int j) {
		return ((i >= 0) && (i <= this.alto) && (j >= 0) && (j <= this.ancho));
	}

	public boolean tieneCoordenadaOcupada(int i, int j) {
		if (this.estaVacio()) {
			return false;
		}
		boolean resultado = false;
		// if (!this.validarCoordenadas(i, j)){
		// return false;
		// }
		this.i = this.lista.iterator();
		while (!resultado && this.i.hasNext()) {
			Parcela parcelaActual = this.i.next();
			resultado = ((parcelaActual.tieneCoordenadas(i, j)) && (parcelaActual
					.tieneContenido()));
		}

		return resultado;
	}

	public boolean contiene(Ubicable unaUnidad) {
		this.i = this.lista.iterator();
		boolean resultado = false;
		while (!resultado && i.hasNext()) {
			resultado = unaUnidad.equals(i.next().getContenido());
		}
		return resultado;
	}

	private boolean estaVacio() {
		return (this.lista == null);
	}

}
