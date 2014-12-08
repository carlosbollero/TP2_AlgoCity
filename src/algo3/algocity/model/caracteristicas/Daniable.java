package algo3.algocity.model.caracteristicas;

import java.awt.Point;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface Daniable {

	public void repararse();

	public void aplicarDanio(double unDanio);

	public double getSalud();

	public Point coordenadas();
	
	public void aceptar(Visitante v);

	/*Persistencia*/
	public Element getElement(Document doc);

}
