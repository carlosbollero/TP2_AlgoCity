package algo3.algocity.model.construcciones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.Dinero;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Ocupable;
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

public class UnidadResidencial extends Unidad implements Ocupable, Daniable,
		Visitable {

	final double ESTADOINICIAL = 100;

	int capacidad; // capacidad habitacional
	double porcentajeDanios;

	public UnidadResidencial() {
		super(5, 1);
		this.capacidad = 100;
	}

	public UnidadResidencial(Coordenada coord) {
		super(5, 1);
		coordenada = coord;
		this.capacidad = 100;
	}

	// public UnidadResidencial(Mapa mapa, int x, int y)
	// throws NoSeCumplenLosRequisitosException {
	// this.costo = 5;
	// this.consumo = 1;
	// this.capacidad = 100;
	// coordenadas = new Coordenada(x, y);
	//
	// if (!esConstruibleEn(mapa.superficie(coordenadas))
	// || !hayConexionesEn(mapa)) {
	// throw new NoSeCumplenLosRequisitosException();
	// }
	// }

	public UnidadResidencial(Mapa mapa, Dinero dinero, Coordenada coord)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			CoordenadaInvalidaException, SuperficieInvalidaParaConstruir {
		super(5, 1);
		capacidad = Constantes.CAPACIDAD_U_RESIDENCIAL;
		coordenada = coord;
		mapa.validarCoordenadas(coord);
		esConstruibleEn(mapa.superficie(coordenada));
		hayConexionesEn(mapa);
		mapa.sistemaElectrico().consumir(consumo);
		dinero.cobrar(costo);
	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 100;

	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);
	}

	public int capacidad() {
		return this.capacidad;
	}

	public double getDanios() {
		return porcentajeDanios;
	}

	public double getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}

	@Override
	public void repararse() {
		System.out.println(getSalud());
		this.porcentajeDanios -= this.porcentajeReparacion();
		System.out.println(getSalud());
		if (this.getDanios() < 0) {
			this.porcentajeDanios = 0;
		}
	}

	protected double porcentajeReparacion() {
		return (this.ESTADOINICIAL * 10) / 100;
	}

	public void aplicarDanio(double cantidad) {
		this.porcentajeDanios += cantidad;
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		}
	}

	private boolean hayConexionesEn(Mapa mapa) throws NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica {
		return (mapa.hayConexionCompleta(coordenada));
	}

	// @Override
	// public boolean esConstruibleEn(Superficie superficie)
	// throws SuperficieInvalidaParaConstruir {
	// if (!superficie.esTierra()) {
	// throw new SuperficieInvalidaParaConstruir();
	// }
	// return superficie.esTierra();
	// }

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
		Element unidad = doc.createElement("UnidadResidencial");

		Element costo = doc.createElement("costo");
		unidad.appendChild(costo);
		costo.setTextContent(String.valueOf(this.costo));

		Element consumo = doc.createElement("consumo");
		unidad.appendChild(consumo);
		consumo.setTextContent(String.valueOf(this.consumo));

		Element capacidad = doc.createElement("capacidad");
		unidad.appendChild(capacidad);
		capacidad.setTextContent(String.valueOf(this.capacidad));

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
		NodeList hijosDeUnidad = hijoDeNodo.getChildNodes();

		for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
			Node hijoDeUnidad = hijosDeUnidad.item(i);
			if (hijoDeUnidad.getNodeName().equals("costo")) {
				this.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("consumo")) {
				this.consumo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("capacidad")) {
				this.capacidad = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeUnidad.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				this.coordenada = punto;
			} else if (hijoDeUnidad.getNodeName().equals("porcentajeDanios")) {
				this.porcentajeDanios = Double.valueOf(hijoDeUnidad
						.getTextContent());
			}
		}
	}

	/* No evalua los invariantes de la clase */
	public boolean equals(Unidad ur) {
		if (ur == this) {
			return true;
		} else if (ur.coordenada().getX() == this.coordenada().getX()
				&& ur.coordenada().getY() == this.coordenada().getY()
				&& ((UnidadResidencial) ur).porcentajeDanios == this.porcentajeDanios) {
			return true;
		}
		return false;
	}

	public Coordenada coordenada() {
		return null;
	}

	public int costo() {
		return 0;
	}

}
