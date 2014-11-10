package algo3.algocity.model;

public class UnidadResidencial extends UnidadZonal {
	
	static final int COSTO = 5;
	static final int CAPACIDAD = 100;	
	int ocupacion;
	
	
	public UnidadResidencial(){
		consumo = 1;
		ocupacion = 0;
	}
	
	public int getCosto(){
		return COSTO;
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

	public void recibirHabitantes(int cantidad) {
		if (ocupacion + cantidad > 100){
			ocupacion = 100;
		}else{
			ocupacion += cantidad;
		}		
	}

}
