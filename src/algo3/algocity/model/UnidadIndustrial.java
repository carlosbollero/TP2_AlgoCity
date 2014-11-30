package algo3.algocity.model;

import java.util.ArrayList;

public class UnidadIndustrial extends UnidadOcupable implements Visitable{


	public UnidadIndustrial() {
		this.costo = 10;
		this.consumo = 5;
		this.capacidad = 25;
	}
	
	public UnidadIndustrial(ArrayList<Mapa> mapas, int x, int y) {
		this.costo = 10;
		this.consumo = 5;
		this.capacidad = 25;
		this.coordX = x;
		this.coordY = y;
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this); 
		
	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 40;
		
	}

}
