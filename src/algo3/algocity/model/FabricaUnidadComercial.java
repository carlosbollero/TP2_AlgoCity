package algo3.algocity.model;

public class FabricaUnidadComercial implements FabricaEdificables{

	
	public UnidadComercial construir (){
		
		return new UnidadComercial(5,2); 
	}
	
}