package algo3.algocity.model;

public class UnidadComercial extends Unidad {
	
	int consumo;
	
	public UnidadComercial(int costo, int consumo){
		this.costo = costo;
		this.consumo = consumo;
	}
	
	public int getConsumo(){
		return this.consumo;
	}

}
