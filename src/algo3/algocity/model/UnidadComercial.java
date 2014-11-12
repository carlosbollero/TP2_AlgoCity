package algo3.algocity.model;

public class UnidadComercial extends UnidadZonal {
	
	static final int COSTO = 5;
	
	public UnidadComercial(){
		consumo = 2;
	}
	
	public int getCosto() {
		return COSTO;
	}
	
	public int getConsumo() {
		return consumo;
	}

	@Override
	protected int porcentajeReparacion() {
		return (UnidadComercial.ESTADOINICIAL * 7) / 100;
	}

}
