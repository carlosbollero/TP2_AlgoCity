package algo3.algocity.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Usuario {

	private String nombre;
	private String ruta;

	public Usuario(String unNombre) {
		this.nombre = unNombre;
		this.ruta = "./saved/" + unNombre + ".xml";
	}

	/* Para persistencia */
	public Usuario() {
		this.ruta = "";
		this.nombre = "";
	}

	public void nombre(String nuevoNombre) {
		nombre = nuevoNombre;
	}

	public String nombre() {
		return nombre;
	}

	// public void ruta(String ruta) {
	// this.ruta = ruta;
	// }

	public String ruta() {
		return ruta;
	}

	/*
	 * 
	 * public String getRutaJuegoAsociado(){ return rutaJuegoAsociado; }
	 * 
	 * 
	 * 
	 * 
	 * public void jugar(String nombrePersonaje){ Iterator<Personaje> it =
	 * personajes.iterator(); boolean encontrado = false; Personaje
	 * personajeEnJuego = null;
	 * 
	 * while(it.hasNext() && !encontrado){ Personaje unPersonaje = it.next();
	 * if(unPersonaje.getNombrePersonaje() == nombrePersonaje){ encontrado =
	 * true; personajeEnJuego = unPersonaje; } } personajeEnJuego.jugar(); }
	 */

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	public Element getElement(Document doc) {
		Element usuario = doc.createElement("Usuario");
		usuario.setTextContent(this.nombre);

		return usuario;
	}

	public static Usuario fromElement(Node hijoDeJuego) {
		Usuario usuario = new Usuario();
		usuario.nombre = hijoDeJuego.getTextContent();
		usuario.ruta = "./saved/" + hijoDeJuego.getTextContent() + ".xml";
		return usuario;
	}
}
