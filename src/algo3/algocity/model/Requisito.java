package algo3.algocity.model;

public class Requisito {

	private String nombre;
	private boolean estaConectadaARequisito;

	public Requisito(String nombreRequisito) {
		this.nombre = nombreRequisito;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombreRequisito) {
		this.nombre = nombreRequisito;
	}
	// TODO
	
	public boolean estaConectado() {
		return this.estaConectadaARequisito;
	}
	
	public void conectar() {
		this.estaConectadaARequisito = true;
	}

}
