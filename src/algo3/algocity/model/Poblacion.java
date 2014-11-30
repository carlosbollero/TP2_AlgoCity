package algo3.algocity.model;

import java.util.Observable;
import java.util.Observer;

import algo3.algocity.model.estadosPoblacion.EstadoPoblacion;
import algo3.algocity.model.estadosPoblacion.EstadoPoblacionCreciendo;
import algo3.algocity.model.estadosPoblacion.EstadoPoblacionDecreciendo;
import algo3.algocity.model.estadosPoblacion.EstadoPoblacionEstable;

public class Poblacion implements Observer {

	int cantidad;
	int ocupacionEmpleo;
	int indiceCrecimiento;
	EstadoPoblacion estadoActual;
	
	public Poblacion(){
		cantidad = 0;
		ocupacionEmpleo = 0;
		indiceCrecimiento = 0;
		estadoActual = null;
	}

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
		estadoActual.operar(this);
	}

	public void disminuir() {
		cantidad--;
	}

	public void disminuir(int cantidad) {
		this.cantidad -= cantidad;
	}
	
	public void setIndice(int indice){
		indiceCrecimiento = indice;
		actualizarIndice();
	}

	private void actualizarIndice() {
		if (indiceCrecimiento > 0){
			estadoActual = new EstadoPoblacionCreciendo();
		}else if (indiceCrecimiento < 0){
			estadoActual = new EstadoPoblacionDecreciendo();
		} else{
			estadoActual = new EstadoPoblacionEstable();
		}
		
	}

}
