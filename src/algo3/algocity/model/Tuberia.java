package algo3.algocity.model;

public class Tuberia extends Conector {
	
	static final int COSTO = 5;
	Tuberia conexion;
	
	public Tuberia(){
		conexion = null;
	}
	
	public void conectarA(Tuberia unaTuberia){
		conexion = unaTuberia;
	}
}
