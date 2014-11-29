package algo3.algocity.model;

public class UnidadResidencial extends UnidadOcupable implements Visitable {

	
	
	public UnidadResidencial() {
		this.costo = 5;
		this.consumo = 1;
		this.capacidad = 100;
	}

<<<<<<< HEAD
	public UnidadResidencial(int costo, int consumo, int capacidad) {
		this.costo = costo;
		this.consumo = consumo;
		this.capacidad = capacidad;

=======
	public void aplicarDanioGodzilla() {
		porcentajeDanios = 100;
		
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this); 
		
>>>>>>> 275e25272bfc21a3f80890c7ce3add1a02b67ca1
	}

}
