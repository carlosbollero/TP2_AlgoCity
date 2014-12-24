package algo3.algocity.model.construcciones;


import java.util.Observable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import algo3.algocity.model.caracteristicas.Agregable;
import algo3.algocity.model.excepciones.NoSePuedeConstruirEnSuperficie;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.terreno.Superficie;

public abstract class Unidad extends Observable implements Agregable{

	int costo;
	int consumo;
	Coordenada coordenada;
	
	public Unidad(int costo, int consumo) {
		this.costo = costo;
		this.consumo = consumo;
	}

	public int costo() {
		return costo;
	}

	public int consumo() {
		return consumo;
	}

	public Coordenada coordenada() {
		return coordenada;
	}

	public abstract boolean esConstruibleEn(Superficie superficie) throws NoSePuedeConstruirEnSuperficie;

	public abstract double getSalud();
	
	/* Persistencia */
	public abstract Element getElement(Document doc);

}
