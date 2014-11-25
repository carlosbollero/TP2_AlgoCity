package algo3.algocity.model;

public class EstacionDeBomberos extends Unidad {

	private Conector conexion;

	public EstacionDeBomberos() {
		this.costo = 1500;
		this.conexion = null;
	}
	
	public EstacionDeBomberos(int costo) {
		this.costo = costo;
		this.conexion = null;
	}
	
	//TODO Revisar si sirve el metodo
	public void conectarTuberia(Conector unaTuberia) {
		this.conexion = unaTuberia;
	}

	public Conector getConexion() {
		return this.conexion;
	}

}
