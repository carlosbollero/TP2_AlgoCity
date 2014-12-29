package algo3.algocity.model.construcciones;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public abstract class UnidadEnergetica extends Unidad implements Daniable,
		Visitable {

	protected final double ESTADOINICIAL = 100;
	int capacidad;
	int radioDeInfluencia;
	double porcentajeDanios;

	public UnidadEnergetica(int costo, int capacidad, int radio) {
		super(costo, 0);
		this.capacidad = capacidad;
		this.radioDeInfluencia = radio;
	}

	public int costo() {
		return this.costo;
	}

	public int getRadio() {
		return radioDeInfluencia;
	}

	public boolean estaDentroDeRadio(Coordenada coord) {
		return (coordenada.distancia(coord) <= radioDeInfluencia);
	}

	public int getCapacidad() {
		return capacidad;
	}

	protected double getDanios() {
		return this.porcentajeDanios;
	}

	public double getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}

	public void aplicarDanio(double cantidad) {
		this.porcentajeDanios += cantidad;
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		}
	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 35;
		int reduccionCapacidad = (capacidad * (int) porcentajeDanios) / 100;
		setChanged();
		notifyObservers(reduccionCapacidad);

	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);

	}

	public boolean hayConexionesEn(Mapa mapa) throws NoHayConexionConTuberias {
		return (mapa.hayConexionConTuberias(coordenada));
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie)
			throws SuperficieInvalidaParaConstruir {
		if (superficie.esAgua()) {
			throw new SuperficieInvalidaParaConstruir();
		}
		return superficie.esTierra();
	}

	@Override
	public boolean agregarseA(Mapa mapa) {
		System.out.println("en UnidadEnergetica agregandose en :");
		System.out.println(coordenada().getX() + "," + coordenada().getY());
		if (mapa.ciudad().agregar(this)) {
			addObserver(mapa.sistemaElectrico());
			return true;
		}
		return false;
	}

	@Override
	public boolean estaContenidoEn(Mapa mapa) {
		return mapa.ciudad().contiene(this);
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/

	// PRUEBA SUBIR ESTE METODO
	// TODO, ver si borrando los metodos en los hijos funciona bien
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
			} else if (hijoDeUnidad.getNodeName().equals("porcentajeDanios")) {
				this.porcentajeDanios = Double.valueOf(hijoDeUnidad
						.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("radioDeInfluencia")) {
				this.radioDeInfluencia = Integer.valueOf(hijoDeUnidad
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

	public Coordenada coordenada() {
		return null;
	}

}
