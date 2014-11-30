package algo3.algocity.model.catastrofes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import algo3.algocity.model.LineaTension;
import algo3.algocity.model.Ruta;
import algo3.algocity.model.Unidad;
import algo3.algocity.model.UnidadComercial;
import algo3.algocity.model.UnidadEnergetica;
import algo3.algocity.model.UnidadIndustrial;
import algo3.algocity.model.UnidadResidencial;
import algo3.algocity.model.Visitable;
import algo3.algocity.model.Visitante;
import algo3.algocity.model.mapas.MapaEdilicio;

public class CatastrofeGodzilla implements Visitante {
	
	int alto;
	int ancho;
	private Random aleatorio;
    private ArrayList<Point> camino; 
	
	public CatastrofeGodzilla(MapaEdilicio mapa){
		alto = mapa.getAlto();
		ancho = mapa.getAncho();
		camino = new ArrayList<Point>();
		
		
	}
	
	public void comenzar(){
		Point puntoInicio; 
		Point puntoFinal; 
		if (this.girarMoneda() == 0) {
			puntoInicio  = new Point (this.aleatorio.nextInt(this.ancho+1),0); 
			puntoFinal = new Point (this.aleatorio.nextInt(ancho+1), this.alto);
		}else{
			puntoInicio = new Point (0,this.aleatorio.nextInt(alto+1));
			puntoFinal = new Point (this.ancho,this.aleatorio.nextInt(alto+1));
		}
		this.caminarEnLineaRecta(puntoInicio, puntoFinal);
//		if (this.girarMoneda()== 0){
//			this.caminarEnLineaRecta(puntoInicio, puntoFinal);
//		}
//		}else{
//			this.caminarEnZigZag(puntoInicio, puntoFinal); 
//		}
	}
	
	//50/50 chances, esta para dejar el codigo mas limpio en comenzar.
	public int girarMoneda (){
		aleatorio = new Random();
		int resultado = this.aleatorio.nextInt(2); 
		return resultado; 
	}
	
	public ArrayList<Point> camino(){
		return camino;
	}
	
	//Funcion obtenida de internet, utiliza el algoritmo de Berensham para el dibujo de lineas rectas,
	//lo cambie para que en cambio de dibujar, guarde estos valores.
	public void caminarEnLineaRecta(Point puntoInicio,Point puntoFinal) {
		
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
	        camino.add (punto); 
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
	}
	
	public void actuar(ArrayList<Visitable> objetivos){
		for (Visitable u : objetivos){
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
		

	public ArrayList<Point> genCaminoRecto() {
		comenzar();
		return camino;
	}





}
