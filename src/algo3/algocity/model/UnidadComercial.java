package algo3.algocity.model;

public class UnidadComercial extends Unidad implements Reparable {

	int consumo;
	final int ESTADOINICIAL = 100;
	int porcentajeDanios;

	public UnidadComercial(int costo, int consumo) {
		this.costo = costo;
		this.consumo = consumo;
	}

	public int getConsumo() {
		return this.consumo;
	}

	@Override
	public void repararse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void aplicarDanio(int cantidad) {
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		} else {
			this.porcentajeDanios += cantidad;
		}
	}

	@Override
	public int getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}

}