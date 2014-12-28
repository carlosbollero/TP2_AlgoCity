package algo3.algocity.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Usuario{

	private String nombre;
	private String ruta;
	private int puntaje;

	public Usuario(String unNombre) {
		this.nombre = unNombre;
		this.ruta = "./saved/" + unNombre + ".xml";
		this.puntaje = 0;
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

		Element nombre = doc.createElement("nombre");
		nombre.setTextContent(this.nombre);
		usuario.appendChild(nombre);

		Element ruta = doc.createElement("ruta");
		ruta.setTextContent(this.ruta);
		usuario.appendChild(ruta);

		Element puntaje = doc.createElement("puntaje");
		puntaje.setTextContent(String.valueOf(this.puntaje));
		usuario.appendChild(puntaje);

		return usuario;
	}

	public static Usuario fromElement(Node hijoDeJuego) {

		Usuario usuario = new Usuario();
		NodeList childs = hijoDeJuego.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);
			if (child.getNodeName().equals("nombre")) {
				usuario.nombre = child.getTextContent();
			} else if (child.getNodeName().equals("ruta")) {
				usuario.ruta = child.getTextContent();
			} else if (child.getNodeName().equals("puntaje")) {
				usuario.puntaje = Integer.valueOf(child.getTextContent());
			}
		}
		return usuario;
	}

}
