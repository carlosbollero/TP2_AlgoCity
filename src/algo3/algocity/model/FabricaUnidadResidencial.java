package algo3.algocity.model;

<<<<<<< HEAD
public class FabricaUnidadResidencial implements FabricaEdificables {
	
	private int costo = 5;
	private int consumo = 1;
	private int capacidad = 100;
	
	
	public UnidadResidencial construir(){
		
		return new UnidadResidencial(this.costo, this.consumo, this.capacidad); //parametros
=======
public class FabricaUnidadResidencial implements FabricaUnidades {

	public UnidadResidencial construir() {

		return new UnidadResidencial();
>>>>>>> 917b3213c37505003cd54fea865827e02bc80497
	}

}
