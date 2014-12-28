package algo3.algocity.model.catastrofes;

import java.util.LinkedList;

import algo3.algocity.model.mapas.Coordenada;

public interface Movimiento {
	
	
	public LinkedList<Coordenada> devolverCamino (Coordenada puntoInicio, Coordenada puntoFinal); 
	
}
