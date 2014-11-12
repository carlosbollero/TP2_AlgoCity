package algo3.algocity.model;

public class UnidadIndustrial extends UnidadZonal implements Ocupable {
	
	static final int COSTO = 10;
	static final int EMPLEO = 25;
	final int trabajador = 1;
	int ocupacion;
	
	public UnidadIndustrial(){
		consumo = 5;
		ocupacion = 0;
	}
	
	public int getCosto() {
		return COSTO;
	}
	
	public int getOcupacion() {
		return ocupacion;
	}
	
	public int getCapacidad(){
		return EMPLEO;
	}
	
	public int getConsumo() {
		return consumo;
	}
	
	public boolean estaOcupada(){
		return (this.consultarDisponibilidad() == 0);
	}
	
	public int consultarDisponibilidad(){
		return (UnidadIndustrial.EMPLEO - ocupacion);
	}
	
	@Override
	public boolean hayDisponibilidad() {
		return (consultarDisponibilidad() >= 1);
	}
	
	private void recibirEmpleados(int cantidad){
		this.ocupacion += cantidad;
	}
	
	// TODO Revisar
	private void despedirEmpleados(int cantidad){
		// TODO corresponderia una excepcion?
		if (ocupacion - cantidad < 0){
			ocupacion = 0;
		}else{
			ocupacion -=cantidad;
		}
	}

	@Override
	public void agregar() {
		if (this.hayDisponibilidad()){
			recibirEmpleados(this.trabajador);
		}		
	}

	@Override
	public void despedir() {
		despedirEmpleados(this.trabajador);		
	}

	@Override
	protected int porcentajeReparacion() {
		return (UnidadIndustrial.ESTADOINICIAL * 3) / 100;
	}

}
