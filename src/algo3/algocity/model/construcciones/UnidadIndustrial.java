package algo3.algocity.model.construcciones;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Ocupable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class UnidadIndustrial extends Unidad implements Ocupable, Daniable,
		Visitable {

	final double ESTADOINICIAL = 100;
	int capacidad; // capacidad habitacional
	int ocupacion;
	double porcentajeDanios;

	public UnidadIndustrial() {
		this.costo = 10;
		this.consumo = 5;
		this.capacidad = 25;
	}

	public UnidadIndustrial(int x, int y) {
		coordenadas = new Coordenada(x, y);
		this.costo = 10;
		this.consumo = 5;
		this.capacidad = 25;
	}

	public UnidadIndustrial(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		coordenadas = new Coordenada(x, y);
		this.costo = 10;
		this.consumo = 5;
		this.capacidad = 25;
		coordenadas = new Coordenada(x, y);
		if (!(esConstruibleEn(mapa.superficie(coordenadas)) && hayConexionesEn(mapa))) {
			// if (!mapa.sePuedeConstruir(this)){
			throw new NoSeCumplenLosRequisitosException();
		}
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);

	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 40;

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
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0) {
			this.porcentajeDanios = 0;
		}
	}

	public void aplicarDanio(double cantidad) {
		this.porcentajeDanios += cantidad;
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		}
	}

	protected double porcentajeReparacion() {
		return (this.ESTADOINICIAL * 10) / 100;
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean hayConexionesEn(Mapa mapa) {
		return (mapa.hayConexionConRedElectrica(coordenadas) && mapa
				.hayConexionConRedElectrica(coordenadas));
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregar(this);
		mapa.agregarUnidadConEmpleo(this);
		mapa.agregarUnidadDaniable(this);
	}

}
