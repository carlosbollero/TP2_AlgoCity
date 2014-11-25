package algo3.algocity.model;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Unidad implements Ubicable {

	int costo;
	ArrayList<RequisitoConexion> requisitos; // una instancia de Requisito

	// para cada requisito

	public int getCosto() {
		return this.costo;
	}

	public ArrayList<RequisitoConexion> getRequisitos() {
		return this.requisitos;
	}

	// Verifica si la unidad esta conectada a todos sus requisitos
	public boolean estaConectada() {

		return (this.verificarConexiones());
	}

	// Verifica si la unidad esta conectada al requisito
	public boolean estaConectadaA(RequisitoConexion unRequisito) {

		for (RequisitoConexion requisito : requisitos) {
			if (unRequisito.getNombre() == requisito.getNombre()) {
				return requisito.estaConectado();
			}
		}
		return false;
	}

	private boolean verificarConexiones() {
		Iterator<RequisitoConexion> it = requisitos.iterator();
		boolean conectada = true;

		while (it.hasNext() && conectada) {
			RequisitoConexion unRequisito = it.next();
			conectada = unRequisito.estaConectado();
		}
		return conectada;
	}

	// Indica a la unidad que esta conectada al requisito pasado como parametro
	public void conectar(RequisitoConexion unRequisito) {

		for (RequisitoConexion requisito : requisitos) {
			if (unRequisito.getNombre() == requisito.getNombre()) {
				requisito.conectar();
			}
		}
	}

	public ArrayList<RequisitoConexion> getConexionesFaltantes() {
		ArrayList<RequisitoConexion> requisitosFaltantes = new ArrayList<RequisitoConexion>();
		for (RequisitoConexion requisito : requisitos) {
			if (!requisito.estaConectado()) {
				requisitosFaltantes.add(requisito);
			}
		}
		return requisitosFaltantes;
	}

	// la idea es desde mapa ir consultando a todas las unidades del mapa
	// y preguntandoles si estan conectadas, y que cada unidad almacene sus
	// requisitos de conexion
	// y devuelva si esta conectada o no

}
