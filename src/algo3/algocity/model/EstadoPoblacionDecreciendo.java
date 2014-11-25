package algo3.algocity.model;

public class EstadoPoblacionDecreciendo implements EstadoPoblacion {

	@Override
	public void operar(Poblacion unaPoblacion) {
		unaPoblacion.disminuir();

	}

}