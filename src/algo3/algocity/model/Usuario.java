package algo3.algocity.model;

public class Usuario {
<<<<<<< HEAD

	private String nombre;
	private String rutaJuegoAsociado;
	
	public Usuario(String unNombre) {
=======
	
	private String nombre;
	private String rutaJuegoAsociado;

	
	public Usuario(String unNombre){
>>>>>>> dev-tomas
		this.nombre = unNombre;
		this.rutaJuegoAsociado = "JuegoDe"+this.nombre;
	}

	public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;		
		}

	
	public String getNombre() {
		return nombre;
	}
	
<<<<<<< HEAD
	/*
	public void crearPersonaje(String nombrePersonaje){
		personajes.add(new Personaje(nombrePersonaje));
=======
	
	public String getRutaJuegoAsociado(){
		return rutaJuegoAsociado;
>>>>>>> dev-tomas
	}
	
	
	
	
	public void jugar(String nombrePersonaje){
		Iterator<Personaje> it = personajes.iterator();
		boolean encontrado = false;
		Personaje personajeEnJuego = null;
		
		while(it.hasNext() && !encontrado){
			Personaje unPersonaje = it.next();
			if(unPersonaje.getNombrePersonaje() == nombrePersonaje){
				encontrado = true;
				personajeEnJuego = unPersonaje;
			}			
		}
		personajeEnJuego.jugar();
	}
	*/

}
