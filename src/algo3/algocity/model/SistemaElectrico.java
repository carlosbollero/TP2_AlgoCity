package algo3.algocity.model;

import java.util.Observable;
import java.util.Observer;

import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;

public class SistemaElectrico implements Observer {
	
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

	@Override
	public void update(Observable o, Object arg) {
		capacidad -= (int)arg;
		
	}

}
