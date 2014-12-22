package algo3.algocity.model;

import java.util.Observable;
import java.util.Observer;

import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;

public class SistemaElectrico implements Observer {
	
	private int capacidad;
	private int consumo;
	
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
		if (consumo + cantidad > capacidad){
			throw new CapacidadElectricaInsuficienteException();
		}
		consumo += cantidad;
	}

	@Override
	public void update(Observable o, Object arg) {
		disminuirCapacidad((int)arg);
		
	}
	
	public int capacidad(){
		return capacidad;
	}
	
	public int consumo(){
		return consumo;
	}

}
