package algo3.algocity.model.conexiones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.NoSePuedeConstruirEnSuperficie;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class Tuberia implements Conector {

	int costo;
	int danios;
	Coordenada coordenadas;

	public Tuberia() {
		costo = 5;
	}

	public Tuberia(Coordenada coordenada) {
		costo = 5;
		this.coordenadas = coordenada;
	}

	public Tuberia(Mapa mapa, Dinero dinero, Coordenada coordenada)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, NoSePuedeConstruirEnSuperficie {
		costo = 5;
		this.coordenadas = coordenada;
		esConstruibleEn(mapa.superficie(coordenadas));
		// if (!esConstruibleEn(mapa.superficie(coordenadas))) {
		// throw new NoSeCumplenLosRequisitosException();
		// }
		dinero.cobrar(costo);
		/*
		 * else { mapa.agregar(this); }
		 */
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie)
			throws NoSePuedeConstruirEnSuperficie {
		if (!(superficie.esTierra() || superficie.esAgua())){
			throw new NoSePuedeConstruirEnSuperficie();
		}
		return (superficie.esTierra() || superficie.esAgua());
	}

	@Override
	public Coordenada coordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada c) {
		this.coordenadas = c;
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

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
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

	
	public void fromElement(Node hijoDeNodo){
		
		NodeList hijosDeTuberia = hijoDeNodo.getChildNodes();

		for (int i = 0; i < hijosDeTuberia.getLength(); i++) {
			Node hijoDeTuberia = hijosDeTuberia.item(i);
			if (hijoDeTuberia.getNodeName().equals("costo")) {
				this.costo = Integer.valueOf(hijoDeTuberia.getTextContent());
			} else if (hijoDeTuberia.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeTuberia.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				this.coordenadas = punto;
			}
		}
		
		
	}

	/* No evalua los invariantes de la clase */
	public boolean equals(Tuberia tb) {
		if (tb == this) {
			return true;
		} else if (tb.coordenadas().getX() == this.coordenadas().getX()
				&& tb.coordenadas().getY() == this.coordenadas().getY()) {
			return true;
		}
		return false;
	}
}
