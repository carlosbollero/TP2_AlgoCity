package algo3.algocity.model;

import java.awt.Point;

public abstract class Unidad {

	int costo;
	int consumo;
	int coordX;
	int coordY;

	public int costo() {
		return this.costo;
	}

	public int consumo() {
		return consumo;
	}


	public Point getCoordenadas() {
		return (new Point(this.coordX, this.coordY));
	}

	public void aplicarDanio(double i) {
		// TODO Auto-generated method stub

	}

}
