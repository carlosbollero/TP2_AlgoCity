package algo3.algocity.model;

public class FabricaCentralNuclear implements FabricaEdificables {
	
	public CentralNuclear construir (){
		
		return new CentralNuclear(10000,1000,25); //parametros
	}

}
