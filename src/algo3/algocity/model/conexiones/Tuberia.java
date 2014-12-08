package algo3.algocity.model.conexiones;

import java.awt.Point;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class Tuberia implements Conector {

	int costo;
	//int danios;
	Point coordenadas;

	public Tuberia() {
		costo = 5;
	}
	
	public Tuberia(int x, int y) {
		costo = 5;
		coordenadas = new Point(x, y);
	}

	public Tuberia(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		costo = 5;
		coordenadas = new Point(x, y);
		if (!esConstruibleEn(mapa.superficie(coordenadas))) {
			throw new NoSeCumplenLosRequisitosException();
		} else {
			mapa.agregar(this);
		}
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return superficie.esTierra();
	}

	@Override
	public Point coordenadas() {
		return coordenadas;
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarATuberias(this);
	}

	@Override
	public double getSalud() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public Element getElement(Document doc) {
				
		Element conector = doc.createElement("Tuberia");
		
		Element costo = doc.createElement("costo");
		conector.appendChild(costo);
		costo.setTextContent(String.valueOf(this.costo));
		
		Element coordenadas = doc.createElement("coordenadas");
		conector.appendChild(coordenadas);
		coordenadas
				.setTextContent((String.valueOf((int) this.coordenadas.getX())
						+ "," + String.valueOf((int) this.coordenadas.getY())));


		return conector;
	}

}
