package algo3.algocity.model;

public class EstacionDeBomberos extends Unidad {
	
	Conector conexion;
	
	public EstacionDeBomberos(int costo){
		this.costo = costo;
		conexion = null;
	}
	
	public int getCosto() {
		
		return this.costo;
	}
	
	public void conectarTuberia(Conector unaTuberia){
		this.conexion = unaTuberia;
	}
	
	
}
