package algo3.algocity.model;

public class EstadoPoblacionCreciendo implements EstadoPoblacion {

	@Override
	public void operar(Poblacion unaPoblacion) {
		unaPoblacion.aumentar();

	}

}
