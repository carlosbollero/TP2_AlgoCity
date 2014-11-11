package algo3.algocity.model;

public class UnidadIndustrial extends UnidadZonal implements Ocupable {
	
	static final int COSTO = 10;
	static final int CAPACIDAD = 25;
	int ocupacion;
	
	public UnidadIndustrial(){
		consumo = 5;
		ocupacion = 0;
	}
	
	public boolean estaOcupada(){
		return (this.consultarDisponibilidad() == 0);
	}
	
	public int consultarDisponibilidad(){
		return (CAPACIDAD - ocupacion);
	}
	
	private void recibirEmpleados(int cantidad){
		// TODO corresponderia una excepcion?
		if (ocupacion + cantidad > CAPACIDAD){
			ocupacion = CAPACIDAD;
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

}
