package algo3.algocity.model;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {
=======
public class Usuario {

>>>>>>> 9432c356ba6835857d9b000e809fe2334fc692f3

	private String nombre;
	private String rutaJuegoAsociado;
	
<<<<<<< HEAD
	public Usuario(String unNombre){
=======
	public Usuario(String unNombre) {

>>>>>>> 9432c356ba6835857d9b000e809fe2334fc692f3
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
<<<<<<< HEAD
		return this.rutaJuegoAsociado;
	}

	
	//TODO
	//Metodo encargado de persistir a disco la partida del usuario
	public void persistir(){

	}
	
	
	
	
	

	
	
	/*
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

=======
		return rutaJuegoAsociado;
	}
	
>>>>>>> 9432c356ba6835857d9b000e809fe2334fc692f3
}
