package algo3.algocity.model;

public class Residencia extends Unidad {
	
	static int capacidad;
	int ocupacion;
	
	public Residencia(){
		costo = 5;
		capacidad = 100;
		consumo = 1;
		ocupacion = 0;
	}
	
	public int getCapacidad(){
		return capacidad;
	}

	public int getOcupacion() {
		return ocupacion;
	}


}
