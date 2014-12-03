package algo3.algocity.model.construcciones;

import java.awt.Point;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class PozoDeAgua extends Unidad {

	public PozoDeAgua() {
		costo = 250;
		consumo = 0;
	}

	public PozoDeAgua(int x, int y) {
		costo = 250;
		consumo = 0;
		this.coordenadas = new Point(x, y);
	}

	public PozoDeAgua(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		coordenadas = new Point(x, y);
		costo = 250;
		consumo = 0;

		if (!esConstruibleEn(mapa.superficie(coordenadas))) {
			throw new NoSeCumplenLosRequisitosException();
		}
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return (superficie.esAgua());
	}

	@Override
	public void aplicarDanio(double i) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getSalud() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarACiudad(this);
		mapa.agregarPuntoRelevanteEnTuberias(coordenadas);
	}

}
