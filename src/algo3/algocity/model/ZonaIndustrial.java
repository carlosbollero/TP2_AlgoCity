package algo3.algocity.model;

public class ZonaIndustrial extends UnidadZonal {
	
	static final int EMPLEO = 25;
	int ocupacion;
	
	public ZonaIndustrial(){
		costo = 10;
		consumo = 5;
		ocupacion = 0;
	}
	
	public boolean estaOcupada(){
		return (this.consultarDisponibilidad() == 0);
	}
	
	public int consultarDisponibilidad(){
		return (EMPLEO - ocupacion);
	}

}
