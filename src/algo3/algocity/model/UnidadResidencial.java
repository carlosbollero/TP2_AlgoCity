package algo3.algocity.model;

public class UnidadResidencial extends UnidadOcupable implements Visitable {

	public UnidadResidencial() {
		this.costo = 5;
		this.consumo = 1;
		this.capacidad = 100;
	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 100;
		
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this); 
		
	}

}
