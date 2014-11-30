package algo3.algocity.model.estadosPoblacion;

import algo3.algocity.model.Poblacion;


public class EstadoPoblacionDecreciendo implements EstadoPoblacion {

	@Override
	public void operar(Poblacion unaPoblacion) {
		unaPoblacion.disminuir();

	}

}