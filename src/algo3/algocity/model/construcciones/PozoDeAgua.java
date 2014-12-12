package algo3.algocity.model.construcciones;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class PozoDeAgua extends Unidad implements Daniable {

	public PozoDeAgua() {
		costo = 250;
		consumo = 0;
	}

	public PozoDeAgua(int x, int y) {
		costo = 250;
		consumo = 0;
		this.coordenadas = new Coordenada(x, y);
	}

	public PozoDeAgua(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		coordenadas = new Coordenada(x, y);
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

	// @Override
	// public void aplicarDanio(double i) {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	public double getSalud() {
		// TODO revisar de hacerlo de otra forma
		// por ahora pasan los tests, pero que PozoDeAgua y EstacionDeBomberos
		// entiendan este mensaje nose si es lo mejor
		return 100;
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarACiudad(this);
		mapa.agregarPuntoRelevanteEnTuberias(coordenadas);
	}

	@Override
	public void repararse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aplicarDanio(double unDanio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptar(Visitante v) {
		// TODO Auto-generated method stub
		
	}

}
