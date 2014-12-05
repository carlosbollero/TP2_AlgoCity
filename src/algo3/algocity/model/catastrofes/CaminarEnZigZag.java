package algo3.algocity.model.catastrofes;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;

public class CaminarEnZigZag implements Movimiento {

	private LinkedList<Point> caminoRetorno;
	private LinkedList<Point> caminoCentrico;
	private LinkedList<Point> caminoAlternativo;
	private int alto;
	private int ancho;

	public CaminarEnZigZag(int ancho, int alto) {

		this.caminoRetorno = new LinkedList<Point>();
		this.caminoCentrico = new LinkedList<Point>();
		this.caminoAlternativo = new LinkedList<Point>();
		this.ancho = ancho;
		this.alto = alto;
	}

	@Override
	public LinkedList<Point> devolverCamino(Point puntoInicio, Point puntoFinal) {
		CaminarEnLineaRecta caminoEnLineaRecta = new CaminarEnLineaRecta();
		this.caminoCentrico = caminoEnLineaRecta.devolverCamino(puntoInicio,
				puntoFinal);
		this.caminoAlternativo = caminoEnLineaRecta.devolverCamino(
				this.validarPunto(puntoInicio), this.validarPunto(puntoFinal));

		Iterator<Point> iteradorCaminoCentrico = caminoCentrico.iterator();
		Iterator<Point> iteradorCaminoAlternativo = caminoAlternativo
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

	public Point validarPunto(Point punto) {

		int puntoX = (int) punto.getX() + 1;
		int puntoY = (int) punto.getY() + 1;

		if (puntoX > this.ancho) {
			puntoX -= 2;
		}
		if (puntoY > this.alto) {
			puntoY -= 2;
		}

		Point puntoRetorno = new Point(puntoX, puntoY);

		return puntoRetorno;
	}

}
