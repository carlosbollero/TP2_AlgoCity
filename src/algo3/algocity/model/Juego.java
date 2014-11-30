package algo3.algocity.model;

import algo3.algocity.model.mapas.MapaConexiones;
import algo3.algocity.model.mapas.MapaEdilicio;
import algo3.algocity.model.mapas.MapaTerritorio;


public class Juego {
	

	final int anchoMapaJuego = 100;
	final int altoMapaJuego = 100;

	private MapaTerritorio mapaTerritorio;
	private MapaEdilicio mapaEdilicio;
	private MapaConexiones mapaTuberias;
	private MapaConexiones mapaRutas;
	private MapaConexiones mapaLineasDeTension;
	
	private Turno turnos;

	Usuario usuario;

	public Juego() {
		this.generarMapas();
		this.turnos = new Turno();
		this.turnos.iniciar();
	}

	public MapaTerritorio getMapaTerritorio() {
		return this.mapaTerritorio;
	}

	public MapaEdilicio getMapaEdilicio() {
		return this.mapaEdilicio;
	}

	public MapaConexiones getMapaTuberias() {
		return this.mapaTuberias;
	}

	public MapaConexiones getMapaRutas() {
		return this.mapaRutas;
	}

	public MapaConexiones getMapaLineasDeTension() {
		return this.mapaLineasDeTension;
	}

	private void generarMapas() {
		this.mapaTerritorio = new MapaTerritorio(this.altoMapaJuego,
				this.anchoMapaJuego);
		this.mapaEdilicio = new MapaEdilicio(this.altoMapaJuego,
				this.anchoMapaJuego);
		this.mapaTuberias = new MapaConexiones(this.altoMapaJuego,
				this.anchoMapaJuego);
		this.mapaRutas = new MapaConexiones(this.altoMapaJuego,
				this.anchoMapaJuego);
		this.mapaLineasDeTension = new MapaConexiones(this.altoMapaJuego,
				this.anchoMapaJuego);

	}

}