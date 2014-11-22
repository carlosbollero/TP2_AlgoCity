package algo3.algocity.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {

	private String nombre;
	//ArrayList<Personaje> personajes;
	private String rutaJuegoAsociado;

	public Usuario(String unNombre) {
		this.nombre = unNombre;
	}

	public void setNombre(String nuevoNombre) {
<<<<<<< HEAD
		nombre = nuevoNombre;		
=======

		nombre = nuevoNombre;
>>>>>>> c7ba9ea2755935aefb2f15ed70c6ab7201030da7
	}

	
	public String getNombre() {
<<<<<<< HEAD
=======

>>>>>>> c7ba9ea2755935aefb2f15ed70c6ab7201030da7
		return nombre;
	}
	
	
	public void crearPersonaje(String nombrePersonaje){
		personajes.add(new Personaje(nombrePersonaje));
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
	
	

}
