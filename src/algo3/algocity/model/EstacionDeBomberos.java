package algo3.algocity.model;

public class EstacionDeBomberos extends Unidad {

	private Conector conexion;

	public EstacionDeBomberos(int costo) {
		this.costo = costo;
		this.conexion = null;
	}

	public void conectarTuberia(Conector unaTuberia) {
		this.conexion = unaTuberia;
	}

	public Conector getConexion() {
		return this.conexion;
	}

}
