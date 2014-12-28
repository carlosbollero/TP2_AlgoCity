package algo3.algocity.model.conexiones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.Dinero;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class Ruta implements Conector, Daniable, Visitable {

	final boolean intacto = true;
	final boolean destruido = false;
	final double ESTADOINICIAL = 100;

	boolean estado;
	int costo;
	double porcentajeDanios;
	Coordenada coordenadas;

	public Ruta() {
		this.costo = 10;
	}

	public Ruta(Coordenada coordenada) {
		// porcentajeDanios = 0;
		costo = 10;
		this.coordenadas = coordenada;

	}

	public Ruta(Mapa mapa, Dinero dinero, Coordenada coordenada)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, CoordenadaInvalidaException {
		porcentajeDanios = 0;
		costo = Constantes.COSTO_RUTA;
		this.coordenadas = coordenada;
		
		mapa.validarCoordenadas(coordenada);
		esConstruibleEn(mapa.superficie(coordenada));
		dinero.cobrar(costo);
		/*
		 * else { mapa.agregar(this); }
		 */
	}
	
	public int costo() {
		return this.costo;
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

	}

	public Coordenada coordenada() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada c) {
		this.coordenadas = c;
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

	@Override
	public void aplicarDanio(double cantidad) {
		this.porcentajeDanios += cantidad;
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		}
	}

	@Override
	public double getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return superficie.esTierra();
	}

	@Override
	public boolean agregarseA(Mapa mapa) {
		return mapa.rutas().agregar(this);
	}

	@Override
	public boolean estaContenidoEn(Mapa mapa) {
		return mapa.rutas().contiene(this);
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	@Override
	public Element getElement(Document doc) {
		Element conector = doc.createElement("Ruta");

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

	public void fromElement(Node hijoDeUnidadDaniable) {

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

	// public Ruta fromElement(Node hijoDeUnidadDaniable) {
	// Ruta rt = new Ruta();
	// NodeList hijosDeUnidad = hijoDeUnidadDaniable.getChildNodes();
	//
	// for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
	// Node hijoDeUnidad = hijosDeUnidad.item(i);
	// if (hijoDeUnidad.getNodeName().equals("costo")) {
	// rt.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
	// } else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
	// String stringPunto = hijoDeUnidad.getTextContent();
	// String[] arrayPunto = stringPunto.split(",");
	// Coordenada punto = new Coordenada(
	// Integer.valueOf(arrayPunto[0]),
	// Integer.valueOf(arrayPunto[1]));
	// rt.coordenadas = punto;
	// } else if (hijoDeUnidad.getNodeName().equals("porcentajeDanios")) {
	// rt.porcentajeDanios = Double.valueOf(hijoDeUnidad
	// .getTextContent());
	// }
	// }
	// return rt;
	// }

	/* No evalua los invariantes de la clase */
	public boolean equals(Daniable rt) {
		if (rt == this) {
			return true;
		} else if (rt.coordenada().getX() == this.coordenada().getX()
				&& rt.coordenada().getY() == this.coordenada().getY()
				&& ((Ruta) rt).porcentajeDanios == this.porcentajeDanios) {
			return true;
		}
		return false;
	}
}
