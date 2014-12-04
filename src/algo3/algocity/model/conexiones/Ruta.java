package algo3.algocity.model.conexiones;

import java.awt.Point;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class Ruta implements Conector, Daniable, Visitable {

	final boolean intacto = true;
	final boolean destruido = false;

	final double ESTADOINICIAL = 100;

	boolean estado;
	int costo;
	double porcentajeDanios;
	Point coordenadas;

	public Ruta() {
		this.costo = 10;
	}

	public Ruta(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		porcentajeDanios = 0;
		costo = 10;
		coordenadas = new Point(x, y);
			
		if (!esConstruibleEn(mapa.superficie(coordenadas))) {
			throw new NoSeCumplenLosRequisitosException();
		} else {
			mapa.agregar(this);
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

	public Point coordenadas() {
		return coordenadas;
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
	public void agregarseA(Mapa mapa) {
		mapa.agregarARutas(this);
		mapa.agregarUnidadDaniable(this);

	}


}
