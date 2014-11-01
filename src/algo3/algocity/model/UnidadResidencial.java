package algo3.algocity.model;

public class UnidadResidencial extends UnidadZonal {
	
	static final int CAPACIDAD = 100;
	int ocupacion;
	
	public UnidadResidencial(){
		costo = 5;
		consumo = 1;
		ocupacion = 0;
	}
	
	public int getCapacidad(){
		return CAPACIDAD;
	}

	public int getOcupacion() {
		return ocupacion;
	}
	
	public boolean estaOcupada(){
		return (this.consultarDisponibilidad() == 0);
	}

	public int consultarDisponibilidad() {
		return (CAPACIDAD - ocupacion);
	}

}
