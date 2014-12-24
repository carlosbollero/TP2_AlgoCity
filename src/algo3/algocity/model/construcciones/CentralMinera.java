package algo3.algocity.model.construcciones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.SistemaElectrico;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.NoSePuedeConstruirEnSuperficie;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class CentralMinera extends UnidadEnergetica {

	public CentralMinera(Coordenada coord) {
		super(3000, 400, 10);
		coordenada = coord;
	}

	public CentralMinera(Mapa mapa, Dinero dinero,
			SistemaElectrico sisElectrico, Coordenada coord)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, NoSePuedeConstruirEnSuperficie,
			NoHayConexionConTuberias {
		super(3000, 400, 10);
		this.coordenada = coord;
		if (!esConstruibleEn(mapa.superficie(coordenada))
				|| !hayConexionesEn(mapa)) {
			throw new NoSeCumplenLosRequisitosException();
		}
		sisElectrico.aumentarCapacidad(capacidad);
		dinero.cobrar(costo);
	}

	@Override
	public void repararse() {
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0) {
			this.porcentajeDanios = 0;
		}
	}

	protected double porcentajeReparacion() {
		return (this.ESTADOINICIAL * 10) / 100;
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
		Element unidad = doc.createElement("CentralMinera");

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

		Element radioDeInfluencia = doc.createElement("radioDeInfluencia");
		unidad.appendChild(radioDeInfluencia);
		radioDeInfluencia
				.setTextContent(String.valueOf(this.radioDeInfluencia));

		return unidad;
	}

	/* No evalua los invariantes de la clase */
	public boolean equals(Daniable cm) {
		if (cm == this) {
			return true;
		} else if (cm.coordenada().getX() == this.coordenada().getX()
				&& cm.coordenada().getY() == this.coordenada().getY()
				&& ((CentralMinera) cm).porcentajeDanios == this.porcentajeDanios) {
			return true;
		}
		return false;
	}


}
