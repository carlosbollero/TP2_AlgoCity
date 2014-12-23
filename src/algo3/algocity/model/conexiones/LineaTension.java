package algo3.algocity.model.conexiones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class LineaTension implements Conector, Daniable, Visitable {

	final boolean intacto = true;
	final boolean destruido = false;
	final double ESTADOINICIAL = 100;

	boolean estado; // true para intacto
					// false para destruido
	int costo;
	double porcentajeDanios;
	int danios; //no usado?
	Coordenada coordenadas;

	public LineaTension() {
		this.costo = 5;
	}

	public LineaTension(Coordenada coordenada) {
		porcentajeDanios = 0;
		this.coordenadas = coordenada;
	}

	public LineaTension(Mapa mapa, Dinero dinero, Coordenada coordenada)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException {
		porcentajeDanios = 0;
		this.coordenadas = coordenada;

		if (!esConstruibleEn(mapa.superficie(coordenadas))) {
			throw new NoSeCumplenLosRequisitosException();
		} 
		dinero.cobrar(costo);
		/*else {
			mapa.agregar(this);
		}*/
	}

	public boolean estado() {
		return estado;
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);

	}

	public void aplicarDanioGodzilla() {
		estado = destruido;
		this.porcentajeDanios = 100; 

	}

	@Override
	public void repararse() {
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0) {
			this.porcentajeDanios = 0;
		}
	}

	public double getDanios() {
		return porcentajeDanios;
	}

	protected double porcentajeReparacion() {
		return 100;
	}

	public void aplicarDanio(double cantidad) {
		this.porcentajeDanios += cantidad;
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		}
	}

	public double getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}

	public Coordenada coordenadas() {
		return coordenadas;
	}
	
	public void setCoordenadas(Coordenada c){
		this.coordenadas = c;
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return superficie.esTierra();
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarARedElectrica(this);
		mapa.agregarUnidadDaniable(this);
	}
	
	
	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	@Override
	public Element getElement(Document doc) {
		Element conector = doc.createElement("LineaTension");

		Element costo = doc.createElement("costo");
		conector.appendChild(costo);
		costo.setTextContent(String.valueOf(this.costo));

		Element coordenadas = doc.createElement("coordenadas");
		conector.appendChild(coordenadas);
		coordenadas
				.setTextContent((String.valueOf((int) this.coordenadas.getX())
						+ "," + String.valueOf((int) this.coordenadas.getY())));

		Element porcentajeDanios = doc.createElement("porcentajeDanios");
		conector.appendChild(porcentajeDanios);
		porcentajeDanios.setTextContent(String.valueOf(this.porcentajeDanios));

		return conector;
	}
	
	
	public void fromElement(Node hijoDeUnidadDaniable){
		
		NodeList hijosDeUnidad = hijoDeUnidadDaniable.getChildNodes();

		for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
			Node hijoDeUnidad = hijosDeUnidad.item(i);
			if (hijoDeUnidad.getNodeName().equals("costo")) {
				this.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeUnidad.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				this.coordenadas = punto;
			} else if (hijoDeUnidad.getNodeName().equals("porcentajeDanios")) {
				this.porcentajeDanios = Double.valueOf(hijoDeUnidad
						.getTextContent());
			}
		}		
	}

//	public LineaTension fromElement(Node hijoDeUnidadDaniable) {
//		LineaTension lt = new LineaTension();
//		NodeList hijosDeUnidad = hijoDeUnidadDaniable.getChildNodes();
//
//		for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
//			Node hijoDeUnidad = hijosDeUnidad.item(i);
//			if (hijoDeUnidad.getNodeName().equals("costo")) {
//				lt.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
//			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
//				String stringPunto = hijoDeUnidad.getTextContent();
//				String[] arrayPunto = stringPunto.split(",");
//				Coordenada punto = new Coordenada(
//						Integer.valueOf(arrayPunto[0]),
//						Integer.valueOf(arrayPunto[1]));
//				lt.coordenadas = punto;
//			} else if (hijoDeUnidad.getNodeName().equals("porcentajeDanios")) {
//				lt.porcentajeDanios = Double.valueOf(hijoDeUnidad
//						.getTextContent());
//			}
//		}
//		return lt;
//	}
	
	
	
	
	/*No evalua los invariantes de la clase*/
	public boolean equals(Daniable lt) {
		if (lt == this) {
			return true;
		} else if (lt.coordenadas().getX() == this.coordenadas().getX()
				&& lt.coordenadas().getY() == this.coordenadas().getY()
				&& ((LineaTension)lt).porcentajeDanios == this.porcentajeDanios) {
			return true;
		}
		return false;
	}
	
}
