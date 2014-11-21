package algo3.algocity.model;

import java.util.ArrayList;

public class Juego {
	
	final int anchoMapaJuego = 100;
	final int altoMapaJuego = 100;
	
	private MapaTerritorio mapaTerritorio;
	private MapaEdilicio mapaEdilicio;
	private MapaConexiones mapaTuberias;
	private MapaConexiones mapaRutas;
	private MapaConexiones mapaLineasDeTension;	
	
	private Edificador edificador;
	//Usuario usuario;
	
	
	
	public Juego(){
		this.generarMapas();
		this.edificador = this.generarEdificador();
	}
	
	
	public MapaTerritorio getMapaTerritorio(){
		return this.mapaTerritorio;
	}
	
	
	public MapaEdilicio getMapaEdilicio(){
		return this.mapaEdilicio;
	}
	
	
	public MapaConexiones getMapaTuberias(){
		return this.mapaTuberias;
	}
	
	
	public MapaConexiones getMapaRutas(){
		return this.mapaRutas;
	}
	
	
	public MapaConexiones getMapaLineasDeTension(){
		return this.mapaLineasDeTension;
	}
		
	
	private void generarMapas(){
		this.mapaTerritorio = new MapaTerritorio(this.altoMapaJuego,this.anchoMapaJuego);
		this.mapaEdilicio = new MapaEdilicio(this.altoMapaJuego,this.anchoMapaJuego);
		//Comentado hasta que se implemente bien el grafo
		//this.mapaTuberias = new MapaConexiones(this.altoMapaJuego,this.anchoMapaJuego);
		//this.mapaRutas = new MapaConexiones(this.altoMapaJuego,this.anchoMapaJuego);
		//this.mapaLineasDeTension = new MapaConexiones(this.altoMapaJuego,this.anchoMapaJuego);
	}
	

	private Edificador generarEdificador(){
		return new Edificador();
	}
	
	
	public void agregarPozoDeAguaEn(int coordX, int coordY) {
		Superficie superficieAEdificar = this.mapaTerritorio.getContenido(coordX,coordY);
		if(superficieAEdificar.esAgua()){ //Decidir bien quien va a guardar la informacion del requisito del terreno
			PozoDeAgua pozo = this.edificador.construirPozoDeAgua();
			this.mapaEdilicio.agregar(pozo, coordX, coordY);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
	
	
	

	

	

	
	
	
	
	
	

