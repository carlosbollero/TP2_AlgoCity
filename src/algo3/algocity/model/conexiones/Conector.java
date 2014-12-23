package algo3.algocity.model.conexiones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import algo3.algocity.model.caracteristicas.Agregable;
import algo3.algocity.model.excepciones.NoSePuedeConstruirEnSuperficie;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.terreno.Superficie;

public interface Conector extends Agregable {

	public abstract Coordenada coordenada();
	
	public abstract boolean esConstruibleEn(Superficie superficie) throws NoSePuedeConstruirEnSuperficie ;
	
	public abstract double getSalud();
	
	/*Persistencia*/
	public abstract Element getElement(Document doc);
	
}
