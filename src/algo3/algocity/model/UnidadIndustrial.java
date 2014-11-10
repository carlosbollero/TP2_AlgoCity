package algo3.algocity.model;

public class UnidadIndustrial extends UnidadZonal {
	
	static final int COSTO = 10;
	static final int EMPLEO = 25;
	int ocupacion;
	
	public UnidadIndustrial(){
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
