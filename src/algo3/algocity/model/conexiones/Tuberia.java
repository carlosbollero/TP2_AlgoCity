package algo3.algocity.model.conexiones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.Dinero;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class Tuberia extends Conector  {

	int costo;
	int danios;
	Coordenada coordenada;

	public Tuberia() {
		costo = 5;
	}

	public Tuberia(Coordenada coordenada) {
		costo = 5;
		this.coordenada = coordenada;
	}

	public Tuberia(Mapa mapa, Dinero dinero, Coordenada coordenada)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, SuperficieInvalidaParaConstruir,
			CoordenadaInvalidaException {
		costo = Constantes.COSTO_TUBERIA;
		this.coordenada = coordenada;
		mapa.validarCoordenadas(coordenada);
		if(esConstruibleEn(mapa.superficie(coordenada))){
			dinero.cobrar(costo);			
		}
	}
	
	public int costo() {
		return this.costo;
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie)
			throws SuperficieInvalidaParaConstruir {
		if (!(superficie.esTierra() || superficie.esAgua())) {
			throw new SuperficieInvalidaParaConstruir();
		}
		return true;
	}

	@Override
	public Coordenada coordenada() {
		return coordenada;
	}

	public void setCoordenadas(Coordenada c) {
		coordenada = c;
	}

	@Override
	public double getSalud() {
		return 100;
	}

	@Override
	public boolean agregarseA(Mapa mapa) {
		return mapa.tuberias().agregar(this);
	}

	@Override
	public boolean estaContenidoEn(Mapa mapa) {
		return mapa.tuberias().contiene(this);
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
				.setTextContent((String.valueOf((int) this.coordenada.getX())
						+ "," + String.valueOf((int) this.coordenada.getY())));

		return conector;
	}

	public void fromElement(Node hijoDeNodo) {

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
				this.coordenada = punto;
			}
		}

	}

	/* No evalua los invariantes de la clase */
	public boolean equals(Tuberia tb) {
		if (tb == this) {
			return true;
		} else if (tb.coordenada().getX() == this.coordenada().getX()
				&& tb.coordenada().getY() == this.coordenada().getY()) {
			return true;
		}
		return false;
	}
}
