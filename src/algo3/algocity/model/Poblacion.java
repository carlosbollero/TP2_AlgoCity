package algo3.algocity.model;

import java.util.Observable;
import java.util.Observer;

import algo3.algocity.model.estadosPoblacion.EstadoPoblacion;
import algo3.algocity.model.estadosPoblacion.EstadoPoblacionCreciendo;
import algo3.algocity.model.estadosPoblacion.EstadoPoblacionDecreciendo;
import algo3.algocity.model.estadosPoblacion.EstadoPoblacionEstable;
import algo3.algocity.model.mapas.Mapa;

public class Poblacion implements Observer {

	int cantidad;
	int capacidadHabitacional;
	int capacidadEmpleo;
	int indiceCrecimiento;
	EstadoPoblacion estadoActual;
	Mapa mapa;

	public Poblacion() {
		cantidad = 0;
		capacidadHabitacional = 0;
		capacidadEmpleo = 0;
		indiceCrecimiento = 0;
		estadoActual = null;
	}

	public Poblacion(Mapa mapa) {
		cantidad = 0;
		capacidadEmpleo = 0;
		capacidadEmpleo = 0;
		indiceCrecimiento = 0;
		estadoActual = null;
		this.mapa = mapa;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getCapacidadHabitacional() {
		return this.capacidadHabitacional;
	}

	public int getCapacidadEmpleo() {
		return this.capacidadEmpleo;
	}

	public void aumentar() {
		cantidad++;
	}

	public void aumentar(int cantidad) {
		this.cantidad += cantidad;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		estadoActual.operar(this);
	}

	public void disminuir() {
		cantidad--;
	}

	public void disminuir(int cantidad) {
		this.cantidad -= cantidad;
	}

	public void setIndice(int indice) {
		indiceCrecimiento = indice;
		actualizarIndice();
	}

	private void actualizarIndice() {
		if (indiceCrecimiento > 0) {
			estadoActual = new EstadoPoblacionCreciendo();
		} else if (indiceCrecimiento < 0) {
			estadoActual = new EstadoPoblacionDecreciendo();
		} else {
			estadoActual = new EstadoPoblacionEstable();
		}
	}

	private void actualizarCapacidadHabitacional() {
		this.capacidadHabitacional = mapa.capacidadHabitacional();
	}

	private void actualizarCapacidadEmpleo() {
		this.capacidadEmpleo = mapa.capacidadEmpleo();
	}

	public void actualizar() {
		this.actualizarCapacidadHabitacional();
		this.actualizarCapacidadEmpleo();
	}

}