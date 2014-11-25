package algo3.algocity.model;

public class FabricaEstacionDeBomberos implements FabricaEdificables{

	private int costo = 1500;
	
	public EstacionDeBomberos construir (){
		
		return new EstacionDeBomberos(this.costo); 
	}
	
}