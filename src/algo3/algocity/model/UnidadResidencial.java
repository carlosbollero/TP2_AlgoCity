package algo3.algocity.model;

public class UnidadResidencial extends UnidadZonal implements Ocupable {
	
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
	
	public int getConsumo() {
		return consumo;
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

	private void recibirHabitantes(int cantidad) {
		ocupacion += cantidad;	
	}
	
	private void despedirHabitantes(int cantidad){
		ocupacion -=cantidad;
	}

	@Override
	public void agregar(int cantidad) {
		recibirHabitantes(cantidad);
		
	}

	@Override
	public void despedir(int cantidad) {
		despedirHabitantes(cantidad);
		
	}

}
