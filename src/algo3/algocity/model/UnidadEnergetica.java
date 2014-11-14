package algo3.algocity.model;

public abstract class UnidadEnergetica extends Unidad implements Reparable{
	
	final int ESTADOINICIAL = 100;
	int capacidad;
	int radioDeInfluencia;
	int porcentajeDanios;

		
	public UnidadEnergetica(int capacidad, int radioDeInfluencia){
		this.capacidad = capacidad;
		this.radioDeInfluencia = radioDeInfluencia;
		this.porcentajeDanios = 0;		
	}

	public int getCosto() {
		return this.costo;
	}
	
	public int getRadioDeInfluencia(){
		return radioDeInfluencia;
	}
	
	public int getCapacidad(){
		return capacidad;
	}

	private int getDanios() {
		return this.porcentajeDanios;
	}

	protected int porcentajeReparacion() {
		return (this.ESTADOINICIAL * 3) /100;
	}
	
	@Override
	public void repararse() {
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0){
			this.porcentajeDanios = 0;
		}
	}
}
