package algo3.algocity.model;

public class CentralMinera extends UnidadEnergetica {
	
	static final int COSTO = 3000;
	
	public CentralMinera(){
		capacidad = 400;
		radioDeInfluencia = 10;		
	}
	
	public int getCosto(){
		return COSTO;
	}


}
