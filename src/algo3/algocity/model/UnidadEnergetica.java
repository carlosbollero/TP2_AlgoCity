package algo3.algocity.model;

public class UnidadEnergetica extends Unidad implements Reparable, Visitable {

	final double ESTADOINICIAL = 100;
	int capacidad;
	int radioDeInfluencia;
	double porcentajeDanios;

	public UnidadEnergetica() {

	}

	// TODO
	/* Este constructor no vuela??--No es el que usa edificador */
	public UnidadEnergetica(int capacidad, int radioDeInfluencia) {
		this.capacidad = capacidad;
		this.radioDeInfluencia = radioDeInfluencia;
		this.porcentajeDanios = 0;
	}

	public UnidadEnergetica(int costoCentral, int capacidadElectrica,
			int radioInfluencia) {
		this.costo = costoCentral;
		this.capacidad = capacidadElectrica;
		this.radioDeInfluencia = radioInfluencia;
	}

	public int costo() {
		return this.costo;
	}

	public int getRadioDeInfluencia() {
		return radioDeInfluencia;
	}

	public int getCapacidad() {
		return capacidad;
	}

	private double getDanios() {
		return this.porcentajeDanios;
	}

	protected double porcentajeReparacion() {
		return (this.ESTADOINICIAL * 3) / 100;
	}

	@Override
	public void repararse() {
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0) {
			this.porcentajeDanios = 0;
		}
	}

	public double getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}

	public void aplicarDanio(double cantidad) {
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		} else {
			this.porcentajeDanios += cantidad;
		}
	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 35;
		
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);
		
	}
}
