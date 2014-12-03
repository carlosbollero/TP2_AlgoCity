package algo3.algocity.model.conexiones;

import java.awt.Point;

import algo3.algocity.model.caracteristicas.Reparable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class Ruta implements Conector, Reparable, Visitable {

	final boolean intacto = true;
	final boolean destruido = false;

	boolean estado;
	int costo;
	int danios;
	Point coordenadas;

	public Ruta() {
		this.costo = 10;
	}

	public Ruta(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		costo = 10;
		coordenadas = new Point(x, y);
		if (!esConstruibleEn(mapa.superficie(coordenadas))) {
			throw new NoSeCumplenLosRequisitosException();
		}
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

	public void repararse() {
		estado = intacto;

	}

	public Point getCoordenadas() {
		return coordenadas;
	}

	@Override
	public void aplicarDanio(double unDanio) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getSalud() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return superficie.esTierra();
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarARutas(this);

	}

}
