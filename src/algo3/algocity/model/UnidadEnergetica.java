package algo3.algocity.model;

public abstract class UnidadEnergetica extends Unidad {
	
	int danios;
	int radioDeInfluencia;
	int capacidad;
	
	public abstract int getCosto();
	
	public UnidadEnergetica(){
		danios = 0;		
	}
	
	public int getRadioDeInfluencia(){
		return radioDeInfluencia;
	}
	
	public int getCapacidad(){
		return capacidad;
	}

}
