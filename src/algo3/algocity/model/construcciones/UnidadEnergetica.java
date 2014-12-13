package algo3.algocity.model.construcciones;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
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

	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);

	}

	public boolean hayConexionesEn(Mapa mapa) {
		return (mapa.hayConexionConTuberias(coordenadas));
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return superficie.esTierra();
	}
}
