package algo3.algocity.model.catastrofes;
 
import java.awt.Point; 
import java.util.LinkedList; 




public class CaminarEnLineaRecta implements Movimiento {

	
	public CaminarEnLineaRecta (){
		
	}
	
	
	@Override
	public LinkedList<Point> devolverCamino (Point puntoInicio, Point puntoFinal){
		
		LinkedList<Point> caminoRecorrido = new LinkedList<Point>(); 
		int x = (int)puntoInicio.getX(); 
		int y = (int)puntoInicio.getY(); 
	    int w = (int)puntoFinal.getX() - (int)puntoInicio.getX() ;
	    int h = (int)puntoFinal.getY() - (int)puntoInicio.getY() ;
	    int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
	    if (w<0) dx1 = -1 ; else if (w>0) dx1 = 1 ;
	    if (h<0) dy1 = -1 ; else if (h>0) dy1 = 1 ;
	    if (w<0) dx2 = -1 ; else if (w>0) dx2 = 1 ;
	    int longest = Math.abs(w) ;
	    int shortest = Math.abs(h) ;
	    if (!(longest>shortest)) {
	        longest = Math.abs(h) ;
	        shortest = Math.abs(w) ;
	        if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1 ;
	        dx2 = 0 ;            
	    }
	    int numerator = longest >> 1 ;
	    for (int i=0;i<=longest;i++) {
	    	Point punto = new Point (x,y); 
	        caminoRecorrido.add (punto); 
	        numerator += shortest ;
	        if (!(numerator<longest)) {
	            numerator -= longest ;
	            x += dx1 ;
	            y += dy1 ;
	        } else {
	            x += dx2 ;
	            y += dy2 ;
	        }
	    }
	return caminoRecorrido; 
	}
		
		
	}
	
	
	

