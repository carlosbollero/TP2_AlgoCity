package algo3.algocity.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import algo3.algocity.model.excepciones.ElUsuarioYaExisteException;
import algo3.algocity.model.excepciones.NoSeEncontroElFicheroException;
import algo3.algocity.model.excepciones.NombreDeUsuarioYaExisteException;
import algo3.algocity.model.mapas.Coordenada;

/**
 * Clase controladora del login y registro de usuarios
 **/

// TODO
// VER SI ESTA CLASE NO DEBERIA IR EN CONTROLADOR
public class RegistroUsuarios {

	private ArrayList<Usuario> usuarios;
	private ArrayList<String> nombresUsuarios;

	
	public RegistroUsuarios() throws NoSeEncontroElFicheroException {

		usuarios = new ArrayList<Usuario>();
		nombresUsuarios = new ArrayList<String>();

		leerUsuarios();
	}

	
	public void leerUsuarios() throws NoSeEncontroElFicheroException {
		String sDirectorio = "saved";
		File fDirectorio = new File(sDirectorio);

		if(!fDirectorio.exists()){
			throw new NoSeEncontroElFicheroException(); 
		}

		File[] ficheros = fDirectorio.listFiles();
		for (int i = 0; i < ficheros.length; i++) {

			String nombreUser = ficheros[i].getName();
			String[] arrayUser = nombreUser.split("\\.");

			nombresUsuarios.add(arrayUser[0]);
		}
	}

	public ArrayList<Usuario> usuarios() {
		return this.usuarios;
	}

	public ArrayList<String> nombresUsuarios() {
		return this.nombresUsuarios;
	}

	public void addUsuario(Usuario unUsuario)
			throws NombreDeUsuarioYaExisteException {

		if (usuarios.isEmpty()) {

			usuarios.add(unUsuario);
		} else if (!existeNombreUsuario(unUsuario.nombre())) {
			usuarios.add(unUsuario);
		}
	}

	public boolean existeNombreUsuario(String nombreUsuarioAChequear)
			throws NombreDeUsuarioYaExisteException {
		
		System.out.println(nombreUsuarioAChequear);
		for(String a : nombresUsuarios){
			System.out.println(a);
		}
		return (nombresUsuarios.contains(nombreUsuarioAChequear));

		/*
		boolean encontrado = false;
		Iterator<String> iteradorUsuarios = nombresUsuarios.iterator();
		while (iteradorUsuarios.hasNext() && (!encontrado)) {
			String unNombre = iteradorUsuarios.next();

			if (unNombre == nombreUsuarioAChequear) {

				encontrado = true;
			}
		}
		return encontrado;
		*/
	}
/*
	public boolean existeUsuario(Usuario usuarioAChequear)
			throws ElUsuarioYaExisteException {
		boolean encontrado = false;
		Iterator<Usuario> iteradorUsuarios = usuarios.iterator();
		while (iteradorUsuarios.hasNext() && (!encontrado)) {
			Usuario unUsuario = iteradorUsuarios.next();

			if (unUsuario == usuarioAChequear) {

				encontrado = true;
			}
		}
		if (encontrado) {
			throw new ElUsuarioYaExisteException();
		}
		return encontrado;
	}
*/


	public boolean crearUsuario(String nombreIngresado) {
		
		if (nombreIngresado.length() > 3 && !nombreIngresado.contains(" ") && !nombreIngresado.contains(",")) {
			return( nombresUsuarios.add(nombreIngresado) );
		}
		return false;	
	}


}
