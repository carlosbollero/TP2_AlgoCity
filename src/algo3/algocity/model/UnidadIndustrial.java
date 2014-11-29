package algo3.algocity.model;

public class UnidadIndustrial extends UnidadOcupable implements Visitable{

	
	public UnidadIndustrial() {
		this.costo = 10;
		this.consumo = 5;
		this.capacidad = 25;
	}
	
	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this); 
		
	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 40;
		
	}

	public UnidadIndustrial(int costo, int consumo, int capacidad) {
		this.costo = costo;
		this.consumo = consumo;
		this.capacidad = capacidad;
	}

}
