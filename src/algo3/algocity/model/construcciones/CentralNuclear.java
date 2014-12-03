package algo3.algocity.model.construcciones;

import java.awt.Point;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class CentralNuclear extends UnidadEnergetica {

	public CentralNuclear() {
		this.costo = 10000;
		this.capacidad = 1000;
		this.radioDeInfluencia = 25;
	}

	public CentralNuclear(int x, int y) {
		coordenadas = new Point(x, y);
		this.costo = 10000;
		this.capacidad = 1000;
		this.radioDeInfluencia = 25;
	}

	public CentralNuclear(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		this.costo = 10000;
		this.capacidad = 1000;
		this.radioDeInfluencia = 25;
		this.coordenadas = new Point(x, y);
		if (!(esConstruibleEn(mapa.superficie(coordenadas)) && hayConexionesEn(mapa))) {
			throw new NoSeCumplenLosRequisitosException();
		}
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarACiudad(this);
		mapa.agregarPuntoRelevanteEnRedElectrica(coordenadas);
	}

}
