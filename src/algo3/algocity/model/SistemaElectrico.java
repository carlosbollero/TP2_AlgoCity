package algo3.algocity.model;

import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;

public class SistemaElectrico {
	
	int capacidad;
	int consumiendo;
	
	public SistemaElectrico() {
		capacidad = 0;	
	}
	
	public void aumentarCapacidad(int cantidad){
		capacidad += cantidad;
	}
	
	public void disminuirCapacidad(int cantidad){
		capacidad -= cantidad;
	}
	
	public void consumir(int cantidad) throws CapacidadElectricaInsuficienteException{
		if (consumiendo + cantidad > capacidad){
			throw new CapacidadElectricaInsuficienteException();
		}
		consumiendo += cantidad;
	}

}
