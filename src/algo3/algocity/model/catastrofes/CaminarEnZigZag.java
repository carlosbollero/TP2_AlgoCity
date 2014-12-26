package algo3.algocity.model.catastrofes;

import java.util.Iterator;
import java.util.LinkedList;

import algo3.algocity.model.mapas.Coordenada;

public class CaminarEnZigZag implements Movimiento {

	private LinkedList<Coordenada> caminoRetorno;
	private LinkedList<Coordenada> caminoCentrico;
	private LinkedList<Coordenada> caminoAlternativo;
	private int alto;
	private int ancho;

	public CaminarEnZigZag(int ancho, int alto) {

		this.caminoRetorno = new LinkedList<Coordenada>();
		this.caminoCentrico = new LinkedList<Coordenada>();
		this.caminoAlternativo = new LinkedList<Coordenada>();
		this.ancho = ancho;
		this.alto = alto;
	}

	@Override
	public LinkedList<Coordenada> devolverCamino(Coordenada puntoInicio, Coordenada puntoFinal) {
		CaminarEnLineaRecta caminoEnLineaRecta = new CaminarEnLineaRecta();
		this.caminoCentrico = caminoEnLineaRecta.devolverCamino(puntoInicio,
				puntoFinal);
		this.caminoAlternativo = caminoEnLineaRecta.devolverCamino(
				this.validarPunto(puntoInicio), this.validarPunto(puntoFinal));

		Iterator<Coordenada> iteradorCaminoCentrico = caminoCentrico.iterator();
		Iterator<Coordenada> iteradorCaminoAlternativo = caminoAlternativo
				.iterator();
		boolean alternar = false;
		while (iteradorCaminoCentrico.hasNext()
				&& iteradorCaminoAlternativo.hasNext()) {
			//
			// REVISAR 
			//
			if (alternar == false) {
				this.caminoRetorno.add(iteradorCaminoCentrico.next());
				iteradorCaminoAlternativo.next();
				alternar = true;
			} else {
				iteradorCaminoCentrico.next();
				this.caminoRetorno.add(iteradorCaminoAlternativo.next());
				alternar = false;
			}
		}

		return this.caminoRetorno;
	}

	public Coordenada validarPunto(Coordenada punto) {
		int puntoX = (int) punto.getX() + 1;
		int puntoY = (int) punto.getY() + 1;
		if (puntoX > this.ancho) {
			puntoX -= 2;
		}
		if (puntoY > this.alto) {
			puntoY -= 2;
		}
		Coordenada puntoRetorno = new Coordenada(puntoX, puntoY);
		return puntoRetorno;
	}

}
