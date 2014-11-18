package algo3.algocity.model;

import java.util.ArrayList;
import java.util.Iterator;

//import org.jgrapht.graph.DefaultEdge;
//import org.jgrapht.graph.ListenableUndirectedGraph;

public class Mapa {
	
	final int ALTO;
	final int ANCHO;
	
	ArrayList<Parcela> lista;
	Iterator<Parcela> i;
	//ListenableUndirectedGraph<Parcela, DefaultEdge> grafo;
	
	public Mapa(int alto, int ancho){
		this.ALTO = alto;
		this.ANCHO = ancho;
		this.lista = new ArrayList<>();
		//this.grafo = new ListenableUndirectedGraph<Parcela, DefaultEdge>(DefaultEdge.class);
	}

	public boolean agregarEn(Unidad unaUnidad, int i, int j) {
		if (!this.contiene(unaUnidad) && this.validarCoordenadas(i, j)){
			//return this.grafo.addVertex(new Parcela(unaUnidad, i, j));
			return this.lista.add(new Parcela(unaUnidad, i, j));
		}
		return false;
	}

	private boolean validarCoordenadas(int i, int j) {
		boolean resultado = true;
		if (!this.estaDentroDeLimites(i, j)){
			return false;
		}
		for (Parcela p : this.lista){
			if (p.tieneCoordenadas(i, j)){
				resultado = false;
			}
		}		
		return resultado;
	}

	private boolean estaDentroDeLimites(int i, int j) {
		return ((i >= 0) && (i <= this.ALTO) && (j >= 0) && (j <= this.ANCHO));
	}

	public boolean tieneCoordenadaOcupada(int i, int j) {
		this.i = this.lista.iterator();
		boolean resultado = false;
		while (!resultado && this.i.hasNext()){
			Parcela parcelaActual = this.i.next();
			resultado = ((parcelaActual.tieneCoordenadas(i, j)) && (parcelaActual.tieneContenido()));
		}
		
		return resultado;
	}
	
	public boolean contiene(Ubicable unaUnidad){
		
		this.i = this.lista.iterator();
		boolean resultado = false;
		while(!resultado && i.hasNext()){
			resultado = unaUnidad.equals(i.next().getContenido());
		}		
		return resultado;
	}

}
