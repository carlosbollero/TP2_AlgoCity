package algo3.algocity.model;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Unidad implements Ubicable {

	int costo;
	ArrayList<Requisito> requisitos; // una instancia de Requisito
										// para cada requisito

	public int getCosto() {
		return this.costo;
	}

	public ArrayList<Requisito> getRequisitos() {
		return this.requisitos;
	}

	// Verifica si la unidad esta conectada a todos sus requisitos
	public boolean estaConectada() {

		return (this.verificarConexiones());
	}

	// Verifica si la unidad esta conectada al requisito
	public boolean estaConectadaA(Requisito unRequisito) {

		for (Requisito requisito : requisitos) {
			if (unRequisito.getNombre() == requisito.getNombre()) {
				return requisito.estaConectado();
			}
		}
		return false;
	}

	private boolean verificarConexiones() {
		Iterator<Requisito> it = requisitos.iterator();
		boolean conectada = true;

		while (it.hasNext() && conectada) {
			Requisito unRequisito = it.next();
			conectada = unRequisito.estaConectado();
		}
		return conectada;
	}

	// Indica a la unidad que esta conectada al requisito pasado como parametro
	public void conectar(Requisito unRequisito) {

		for (Requisito requisito : requisitos) {
			if (unRequisito.getNombre() == requisito.getNombre()) {
				requisito.conectar();
			}
		}
	}

	// la idea es desde mapa ir consultando a todas las unidades del mapa
	// y preguntandoles si estan conectadas, y que cada unidad almacene sus
	// requisitos de conexion
	// y devuelva si esta conectada o no

}
