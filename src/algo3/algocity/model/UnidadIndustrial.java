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

}
