package algo3.algocity.model;

public class UnidadIndustrial extends UnidadZonal implements Ocupable {
	
	static final int COSTO = 10;
	static final int EMPLEO = 25;
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
		return (EMPLEO - ocupacion);
	}
	
	@Override
	public boolean hayDisponibilidad() {
		return (UnidadIndustrial.EMPLEO - this.ocupacion > 0);
	}
	
	private void recibirEmpleados(int cantidad){
		// TODO corresponderia una excepcion?
		if (ocupacion + cantidad > EMPLEO){
			ocupacion = EMPLEO;
		}else{
			ocupacion += cantidad;
		}
	}
	
	private void despedirEmpleados(int cantidad){
		// TODO corresponderia una excepcion?
		if (ocupacion - cantidad < 0){
			ocupacion = 0;
		}else{
			ocupacion -=cantidad;
		}
	}

	@Override
	public void agregar(int cantidad) {
		recibirEmpleados(cantidad);
		
	}

	@Override
	public void despedir(int cantidad) {
		despedirEmpleados(cantidad);		
	}

	@Override
	protected int porcentajeReparacion() {
		return (UnidadIndustrial.ESTADOINICIAL * 3) / 100;
	}

}
