package algo3.algocity.model.catastrofes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;

public class CatastrofeGodzilla implements Visitante {

	private int ancho; 
	private int alto; 
	private Random aleatorio;
    private LinkedList<Point> caminoGodzilla; 
    
    
	//TODO mover algunas cosas a una clase abstracta.
    
    
	public CatastrofeGodzilla() {
		this.caminoGodzilla = new LinkedList<Point>();			
	}
	
	//deberia haber un constructor de Godzilla que reciba un mapa
	public CatastrofeGodzilla (int x , int y){		
		ancho = x; 
		alto = y; 
		caminoGodzilla = new LinkedList<Point>(); 		
	}


	//Comienzo aleatorio de Godzilla , que puede ser tanto el linea recta como en zigzag
	public void comenzar() {		
		Point puntoInicio; 
		Point puntoFinal; 
		if (this.girarMoneda() == 0) {
			puntoInicio  = new Point (this.aleatorio.nextInt(this.ancho+1),0); 
			puntoFinal = new Point (this.aleatorio.nextInt(ancho+1), this.alto);
		}else{
			puntoInicio = new Point (0,this.aleatorio.nextInt(alto+1));
			puntoFinal = new Point (this.ancho,this.aleatorio.nextInt(alto+1));
		}				
		if (this.girarMoneda()== 0){
			 this.caminoGodzilla = this.caminarEnLineaRecta(puntoInicio, puntoFinal);
		}else{
			this.caminoGodzilla = this.caminarEnZigZag(puntoInicio, puntoFinal); 
		}		
	}	
	
	//50/50 chances, esta para dejar el codigo mas limpio en comenzar.
	public int girarMoneda (){
		int resultado = this.aleatorio.nextInt(2); 
		return resultado; 
	}	
	
	//Funcion obtenida de internet, utiliza el algoritmo de Berensham para el dibujo de lineas rectas,
	//lo cambie para que en cambio de dibujar, guarde estos valores.
	public LinkedList<Point> caminarEnLineaRecta(Point puntoInicio,Point puntoFinal) {		
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

	//TODO No se muy bien como hacer que Godzilla de pasos en zig zag, verificar un poco mas adelante. 
	//La idea en general es hacer que Godzilla camine en linea recta, luego recorrer la lista de caminoGodzilla y tomar un punto 
	//proximo, a ese punto sumarle un salto en las coordenadas y reemplazar ese punto en la lista, luego para que no queden espacios 
	//entre puntos volver a correr caminar en linea recta entre cada punto de la lista y con eso armar la lista final. 
	public LinkedList<Point> caminarEnZigZag (Point puntoInicio, Point puntoFinal){		
		int puntoXInicio= (int)puntoInicio.getX()+1; 
		int puntoXFinal= (int)puntoFinal.getX()+1;
		int puntoYInicio = (int) puntoInicio.getY()+1;
		int puntoYFinal = (int) puntoFinal.getY()+1;
		 
		if (puntoXInicio> this.ancho){ 	 puntoXInicio -= 2; }
		if (puntoXFinal>this.ancho){		puntoXFinal -= 2;  }
		if (puntoYInicio> this.alto){     puntoYInicio -= 2; }
		if (puntoYFinal> this.alto){       puntoYFinal -= 2; }
		
		LinkedList<Point> caminoRetorno = new LinkedList<Point>() ; 
		LinkedList<Point> caminoCentrico = new LinkedList<Point> (); 
		LinkedList<Point> caminoAlternativo = new LinkedList <Point>(); 
		Point puntoInicioAlternativo = new Point (puntoXInicio, puntoYInicio); 
		Point puntoFinalAlternativo = new Point (puntoXFinal, puntoYFinal); 
		
		
		caminoCentrico = this.caminarEnLineaRecta(puntoInicio, puntoFinal);
		caminoAlternativo = this.caminarEnLineaRecta(puntoInicioAlternativo, puntoFinalAlternativo);
		
		Iterator<Point> iteradorCaminoCentrico = caminoCentrico.iterator (); 
	    Iterator <Point>  iteradorCaminoAlternativo = caminoAlternativo.iterator (); 
		
		while (iteradorCaminoCentrico.hasNext() && iteradorCaminoAlternativo.hasNext()){
			
			 boolean alternar = false; 
			
			if (alternar = false){
			caminoRetorno.add(iteradorCaminoCentrico.next());
			iteradorCaminoAlternativo.next();
			alternar = true; 
			}else{
				iteradorCaminoCentrico.next(); 
			    caminoRetorno.add(iteradorCaminoAlternativo.next()); 		
			    alternar = false; 
			}
		}		
		return caminoRetorno;
	}

	public void actuar(ArrayList<Visitable> objetivos) {
		for (Visitable u : objetivos) {
			u.aceptar(this);
		}
	}

	@Override
	public void visitar(UnidadResidencial unaUnidadResidencial) {
		unaUnidadResidencial.aplicarDanioGodzilla();
	}

	@Override
	public void visitar(UnidadComercial unaUnidadComercial) {
		unaUnidadComercial.aplicarDanioGodzilla();
	}

	@Override
	public void visitar(UnidadIndustrial unaUnidadIndustrial) {
		unaUnidadIndustrial.aplicarDanioGodzilla();
	}

	@Override
	public void visitar(UnidadEnergetica unaUnidadEnergetica) {
		unaUnidadEnergetica.aplicarDanioGodzilla();
	}

	@Override
	public void visitar(LineaTension unaLineaTension) {
		unaLineaTension.aplicarDanioGodzilla();
	}

	@Override
	public void visitar(Ruta unaRuta) {
		unaRuta.aplicarDanioGodzilla();

	}

	@Override
	public void visitar(Unidad unaUnidad) {
	}

	public LinkedList<Point> genCaminoRecto() {
		comenzar();
		return caminoGodzilla;
	}

}
