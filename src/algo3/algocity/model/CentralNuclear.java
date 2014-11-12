package algo3.algocity.model;

public class CentralNuclear extends UnidadEnergetica {
	
	static final int COSTO = 10000;
	
	public CentralNuclear(){
		capacidad = 1000;
		radioDeInfluencia = 25;		
	}
	
	public int getCosto(){
		return COSTO;
	}

	@Override
	protected int porcentajeReparacion() {
		return (CentralNuclear.ESTADOINICIAL * 3) /100;
	}
	
}
