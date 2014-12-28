package algo3.algocity.model.catastrofes;
 
import java.util.LinkedList;

import algo3.algocity.model.mapas.Coordenada;

public class CaminarEnLineaRecta implements Movimiento {

	
	public CaminarEnLineaRecta (){
		
	}
	
	
	@Override
	public LinkedList<Coordenada> devolverCamino (Coordenada puntoInicio, Coordenada puntoFinal){
		
		LinkedList<Coordenada> caminoRecorrido = new LinkedList<Coordenada>(); 
		int x = puntoInicio.getX(); 
		int y = puntoInicio.getY(); 
	    int w = puntoFinal.getX() - puntoInicio.getX() ;
	    int h = puntoFinal.getY() - puntoInicio.getY() ;
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
	    	Coordenada punto = new Coordenada (x,y); 
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
	
	
	

