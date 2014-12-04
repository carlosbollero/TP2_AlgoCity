package algo3.algocity.model.catastrofes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
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
		
		this.ancho = x; 
		this.alto = y; 
		this.caminoGodzilla = new LinkedList<Point>(); 
		
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
			  this.caminarEnLineaRecta(puntoInicio, puntoFinal);
		}else{
			  this.caminarEnZigZag(puntoInicio, puntoFinal); 
		}
		
	}
	
	
	//50/50 chances, esta para dejar el codigo mas limpio en comenzar.
	public int girarMoneda (){
		int resultado = this.aleatorio.nextInt(2); 
		return resultado; 
	}
	
	
	//Funcion obtenida de internet, utiliza el algoritmo de Berensham para el dibujo de lineas rectas,
	//lo cambie para que en cambio de dibujar, guarde estos valores.
	public void caminarEnLineaRecta(Point puntoInicio,Point puntoFinal) {
		CaminarEnLineaRecta caminarEnLineaRecta = new CaminarEnLineaRecta (); 
	    this.caminoGodzilla = caminarEnLineaRecta.devolverCamino (puntoInicio, puntoFinal); 
	     
	}
	

	public void caminarEnZigZag (Point puntoInicio, Point puntoFinal){
		CaminarEnZigZag caminarEnZigZag = new CaminarEnZigZag (this.ancho, this.alto); 
        this.caminoGodzilla = caminarEnZigZag.devolverCamino(puntoInicio, puntoFinal); 
        
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
	public void visitar(Daniable unaUnidad) {
		// TODO Auto-generated method stub
		
	}

	public LinkedList<Point> genCaminoRecto() {
		comenzar();
		return caminoGodzilla;
	}

}
