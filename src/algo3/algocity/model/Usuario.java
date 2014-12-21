package algo3.algocity.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Usuario {

	private String nombre;
	private String ruta;
	private int puntaje;

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

	public void puntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int puntaje() {
		return this.puntaje;
	}

	// public void ruta(String ruta) {
	// this.ruta = ruta;
	// }

	public String ruta() {
		return ruta;
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	public Element getElement(Document doc) {
		Element usuario = doc.createElement("Usuario");
		usuario.setTextContent(this.nombre);
		//falta agregar la persistencia del puntaje
		return usuario;
	}

	public static Usuario fromElement(Node hijoDeJuego) {
		Usuario usuario = new Usuario();
		usuario.nombre = hijoDeJuego.getTextContent();
		usuario.ruta = "./saved/" + hijoDeJuego.getTextContent() + ".xml";
		return usuario;
	}
}
