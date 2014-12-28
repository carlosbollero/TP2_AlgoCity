package algo3.algocity.model.construcciones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.Dinero;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class UnidadComercial extends Unidad implements Daniable, Visitable {

	final double ESTADOINICIAL = 100;
	double porcentajeDanios;

	public UnidadComercial() {
		super(5, 2);
	}

	public UnidadComercial(Coordenada coord) {
		super(5, 2);
		coordenada = coord;
	}

	public UnidadComercial(Mapa mapa, Dinero dinero, Coordenada coord)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			CoordenadaInvalidaException, SuperficieInvalidaParaConstruir {
		super(Constantes.COSTO_U_COMERCIAL, Constantes.CONSUMO_U_COMERCIAL);
		this.coordenada = coord;

		mapa.validarCoordenadas(coord);
		esConstruibleEn(mapa.superficie(coordenada));
		hayConexionesEn(mapa);
		mapa.sistemaElectrico().consumir(consumo);
		dinero.cobrar(costo);
	}

	public double getDanios() {
		return porcentajeDanios;
	}

	@Override
	public void repararse() {
		porcentajeDanios -= porcentajeReparacion();
		if (getDanios() < 0) {
			porcentajeDanios = 0;
		}
	}

	protected double porcentajeReparacion() {
		return (this.ESTADOINICIAL * 7) / 100;
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
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);
	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 75;

	}

	private boolean hayConexionesEn(Mapa mapa) throws NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica {
		return (mapa.hayConexionCompleta(coordenada));
	}

	@Override
	public boolean agregarseA(Mapa mapa) {
		return mapa.ciudad().agregar(this);
	}

	@Override
	public boolean estaContenidoEn(Mapa mapa) {
		return mapa.ciudad().contiene(this);
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	@Override
	public Element getElement(Document doc) {
		Element unidad = doc.createElement("UnidadComercial");

		Element costo = doc.createElement("costo");
		unidad.appendChild(costo);
		costo.setTextContent(String.valueOf(this.costo));

		Element consumo = doc.createElement("consumo");
		unidad.appendChild(consumo);
		consumo.setTextContent(String.valueOf(this.consumo));

		Element coordenadas = doc.createElement("coordenadas");
		unidad.appendChild(coordenadas);
		coordenadas
				.setTextContent((String.valueOf((int) this.coordenada.getX())
						+ "," + String.valueOf((int) this.coordenada.getY())));

		Element porcentajeDanios = doc.createElement("porcentajeDanios");
		unidad.appendChild(porcentajeDanios);
		porcentajeDanios.setTextContent(String.valueOf(this.porcentajeDanios));

		return unidad;
	}

	public void fromElement(Node hijoDeNodo) {
		NodeList hijosDeUnidadComercial = hijoDeNodo.getChildNodes();

		for (int i = 0; i < hijosDeUnidadComercial.getLength(); i++) {
			Node hijoDeUnidad = hijosDeUnidadComercial.item(i);
			if (hijoDeUnidad.getNodeName().equals("costo")) {
				this.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("consumo")) {
				this.consumo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("porcentajeDanios")) {
				this.porcentajeDanios = Double.valueOf(hijoDeUnidad
						.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeUnidad.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				this.coordenada = punto;
			}
		}
	}

	/* No evalua los invariantes de la clase */
	public boolean equals(Unidad uc) {
		if (uc == this) {
			return true;
		} else if (uc.coordenada().getX() == this.coordenada().getX()
				&& uc.coordenada().getY() == this.coordenada().getY()
				&& ((UnidadComercial) uc).porcentajeDanios == this.porcentajeDanios) {
			return true;
		}
		return false;
	}

}