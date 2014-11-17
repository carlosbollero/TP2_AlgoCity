package algo3.algocity.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Mapa {
	
	ArrayList<Parcela> lista;
	Iterator<Parcela> e;
	
	public Mapa(){
		this.lista = new ArrayList<>();
	}

	public boolean agregarUnidadEn(Unidad unaUnidad, int i, int j) {
		if (this.validarCoordenadas(i, j)){
			Parcela nuevaParcela = new Parcela(unaUnidad, i, j);
			this.lista.add(nuevaParcela);
			return true;
		}
		return false;
	}

	private boolean validarCoordenadas(int i, int j) {
		boolean resultado = true;
		for (Parcela p : this.lista){
			if (p.tieneCoordenadas(i, j)){
				resultado = false;
			}
		}
		return resultado;
	}

	public boolean tieneUnidadEn(int i, int j) {
		this.e = this.lista.iterator();
		boolean resultado = false;
		while (!resultado && e.hasNext()){
			Parcela parcelaActual = e.next();
			resultado = ((parcelaActual.tieneCoordenadas(i, j)) && (parcelaActual.tieneUnidad()));
		}
		
		return resultado;
	}

}
