package algo3.algocity.model;

import java.util.ArrayList;
import java.util.Iterator;


/**
	Clase controladora del login y registro de usuarios
**/

public class ControladorUsuarios {
	
	private ArrayList<Usuario> usuarios;

	
	public ControladorUsuarios() {
		
		usuarios = new ArrayList<Usuario>();
	}
	
	
	public void addUsuario(Usuario unUsuario) {
		
		if(usuarios.isEmpty()){
			
			usuarios.add(unUsuario);
			
		}else if(!existeNombreUsuario(unUsuario.getNombre())){
			
			usuarios.add(unUsuario);
			
		}/**else{
			
			throw new ExcepcionAgregarUsuarioYaExistente("El usuario ya existe");
			
		}**/
		//Ver de tratar esto con una excepcion
	}


	public boolean existeNombreUsuario(String nombreUsuarioAChequear) {
		boolean encontrado = false;
		Iterator<Usuario> iteradorUsuarios = usuarios.iterator();
	    while(iteradorUsuarios.hasNext() && (!encontrado)){
	         Usuario unUsuario = iteradorUsuarios.next();
	         
	         if(unUsuario.getNombre() == nombreUsuarioAChequear){
	        	 
	        	 encontrado = true;
	         }       
	      }
	    return encontrado;
	}
	
	
	public boolean existeUsuario(Usuario usuarioAChequear){
		
		boolean encontrado = false;
		Iterator<Usuario> iteradorUsuarios = usuarios.iterator();
	    while(iteradorUsuarios.hasNext() && (!encontrado)){
	         Usuario unUsuario = iteradorUsuarios.next();
	         
	         if(unUsuario == usuarioAChequear){
	        	 
	        	 encontrado = true;
	         }       
	      }
	    return encontrado;
	}

	
	
	
}
