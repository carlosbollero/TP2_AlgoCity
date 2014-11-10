package algo3.algocity.model;

public class EstacionDeBomberos extends UnidadDeServicio {
	
	static final int COSTO = 1500;
	Tuberia conexion;
	
	public EstacionDeBomberos(){
		
	}
	
	public void conectarTuberia(Tuberia unaTuberia){
		conexion = unaTuberia;
	}

}
