package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.mapas.Mapa;

public class UnidadResidencial extends UnidadOcupable implements Visitable {

	public UnidadResidencial() {
		this.costo = 5;
		this.consumo = 1;
		this.capacidad = 100;
	}

	public UnidadResidencial(int x, int y) {
		this.costo = 5;
		this.consumo = 1;
		this.capacidad = 100;
		this.coordX = x;
		this.coordY = y;		
	}
	
	public UnidadResidencial(ArrayList<Mapa> mapas, int x, int y) {
		this.costo = 5;
		this.consumo = 1;
		this.capacidad = 100;
		this.coordX = x;
		this.coordY = y;
	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 100;
		
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this); 
		
	}

}
