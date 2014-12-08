package algo3.algocity.model.caracteristicas;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface Ocupable {
	
	public int capacidad();
	
	/*Persistencia*/
	public Element getElement(Document doc);

}
