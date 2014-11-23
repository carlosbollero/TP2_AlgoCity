package algo3.algocity.model;

import java.util.Observable;
import java.util.Observer;

public class Poblacion implements Observer {

	int cantidad;

	public int getCantidad() {
		return cantidad;
	}

	public void aumentar() {
		cantidad++;
	}

	public void aumentar(int cantidad) {
		this.cantidad += cantidad;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		aumentar();
	}

	public void disminuir() {
		cantidad--;
	}

	public void disminuir(int cantidad) {
		this.cantidad -= cantidad;
	}

}
