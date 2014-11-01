package algo3.algocity.controlUsuarios;

import java.util.ArrayList;

import algo3.algocity.ciudad.Personaje;

public class Usuario {
	
	private String nombre;
	ArrayList<Personaje> personajes;


	public void setNombre(String nuevoNombre) {
		
		nombre = nuevoNombre;		
	}

	public String getNombre() {
		
		return nombre;
	}

}
