package algo3.algocity.model;

public class CentralEolica extends UnidadEnergetica {

	static final int COSTO = 1000;
	
	public CentralEolica(){
		capacidad = 100;
		radioDeInfluencia = 4;
		
	}
	
	public int getCosto(){
		return COSTO;
	}

	@Override
	protected int porcentajeReparacion() {
		return (CentralEolica.ESTADOINICIAL * 15) / 100;
	}
	
	

}
