package algo3.algocity.model;

public class Usuario {


	private String nombre;
	private String rutaJuegoAsociado;
	
	public Usuario(String unNombre) {

		this.nombre = unNombre;
		this.rutaJuegoAsociado = "JuegoDe"+this.nombre;
	}

	public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;		
	}

	
	public String getNombre() {
		return this.nombre;
	}
	
	
	public String getRutaJuegoAsociado(){
		return rutaJuegoAsociado;
	}
	
}
