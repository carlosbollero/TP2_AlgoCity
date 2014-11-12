package algo3.algocity.model;

public abstract class UnidadEnergetica extends Unidad implements Reparable{
	
	static final int ESTADOINICIAL = 100;
	int porcentajeDanios;
	int radioDeInfluencia;
	int capacidad;
	
	public abstract int getCosto();
	
	public UnidadEnergetica(){
		porcentajeDanios = 0;		
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

	protected abstract int porcentajeReparacion();
	
	@Override
	public void repararse() {
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0){
			this.porcentajeDanios = 0;
		}
	}



}
