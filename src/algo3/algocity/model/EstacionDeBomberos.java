package algo3.algocity.model;

import java.util.ArrayList;

public class EstacionDeBomberos extends UnidadDeServicio {
	
	static final int COSTO = 1500;
	Tuberia conexion;
	
	public EstacionDeBomberos(){
		conexion = null;
	}
	
	public int getCosto() {
		
		return COSTO;
	}
	
	public void conectarTuberia(Tuberia unaTuberia){
		conexion = unaTuberia;
	}

	@Override
	public ArrayList<boolean[]> getRequisitosConexion() {
		// TODO Auto-generated method stub
		return null;
	}

}
