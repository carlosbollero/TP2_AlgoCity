package algo3.algocity.model;

public class Superficie implements Ubicable {
	
	//TODO revisar esto
	//true == tierra;
	//false == agua;
	boolean estado;
	
	public Superficie(boolean estado){
		this.estado = estado;
	}
	
	public boolean tipo(){
		return this.estado;
	}
	
	public boolean esTierra(){
		return (this.estado == true);
	}
	
	public boolean esAgua(){
		return (this.estado == false);
	}

}
