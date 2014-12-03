package algo3.algocity.model.catastrofes;

import java.awt.Point;
import java.util.LinkedList;

public interface Movimiento {
	
	
	public LinkedList<Point> devolverCamino (Point puntoInicio, Point puntoFinal); 
	
}
