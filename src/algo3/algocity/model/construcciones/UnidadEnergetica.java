package algo3.algocity.model.construcciones;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSePuedeConstruirEnSuperficie;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public abstract class UnidadEnergetica extends Unidad implements Daniable,
		Visitable {

	protected final double ESTADOINICIAL = 100;
	int capacidad;
	int radioDeInfluencia;
	double porcentajeDanios;

	public int costo() {
		return this.costo;
	}

	public int getRadioDeInfluencia() {
		return radioDeInfluencia;
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
		int reduccionCapacidad = (100 * (int) porcentajeDanios) / capacidad;
		setChanged();
		notifyObservers(reduccionCapacidad);

	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);

	}

	public boolean hayConexionesEn(Mapa mapa) throws NoHayConexionConTuberias {
		return (mapa.hayConexionConTuberias(coordenadas));
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) throws NoSePuedeConstruirEnSuperficie {
		if (!superficie.esTierra()){
			throw new NoSePuedeConstruirEnSuperficie();
		}
		return superficie.esTierra();
	}
	
	
	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	
	//PRUEBA SUBIR ESTE METODO
	//TODO, ver si borrando los metodos en los hijos funciona bien
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
				this.coordenadas = punto;
			}
		}
	}
	
	
	
}
