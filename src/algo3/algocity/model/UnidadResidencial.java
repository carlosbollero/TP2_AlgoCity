package algo3.algocity.model;

public class UnidadResidencial extends UnidadZonal implements Ocupable {
	
	static final int COSTO = 5;
	static final int CAPACIDAD = 100;
	final int familia = 4;
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
		return this.ocupacion;
	}
	
	public boolean estaOcupada(){
		return (this.consultarDisponibilidad() == 0);
	}

	//revisar uso
	public int consultarDisponibilidad() {
		return (UnidadResidencial.CAPACIDAD - this.ocupacion);
	}
	
	@Override
	public boolean hayDisponibilidad() {
		return (this.consultarDisponibilidad() >= 4);
	}

	//hace falta? o con agregar alcanza?
	private void recibirHabitantes(int cantidad) {
		this.ocupacion += cantidad;	
	}
	
	//TODO revisar
	private void despedirHabitantes(int cantidad){
		this.ocupacion -= cantidad;
	}

	//suponemos que la población crece por familias de cuatro personas
	@Override
	public void agregar() {
		if (this.hayDisponibilidad()){
			//revisar
			recibirHabitantes(this.familia);
		}
		
	}

	@Override
	public void despedir() {
		despedirHabitantes(this.familia);
		
	}
	
	protected int porcentajeReparacion(){
		return (UnidadResidencial.ESTADOINICIAL * 10) / 100;
	}

}
