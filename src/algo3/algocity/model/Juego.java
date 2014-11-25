package algo3.algocity.model;

public class Juego {

	final int anchoMapaJuego = 100;
	final int altoMapaJuego = 100;

	private MapaTerritorio mapaTerritorio;
	private MapaEdilicio mapaEdilicio;
	private MapaConexiones mapaTuberias;
	private MapaConexiones mapaRutas;
	private MapaConexiones mapaLineasDeTension;

	Usuario usuario;

	private Edificador edificador; // esto volaria
	private FabricaEdificables fabrica;

	public Juego() {
		this.generarMapas();
		this.edificador = this.generarEdificador();
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

	private Edificador generarEdificador() {
		return new Edificador();
	}

	// TODO
	/*
	 * TODOS LOS AGREGAR DE Unidad,EstacionDeBomberos,y PozoDeAgua SON IGUALES
	 * ver de solucionar esto generalizando el comportamiento comun en otro lado
	 */
	/*
	 * /* TODOS LOS AGREGAR DE Unidad,EstacionDeBomberos,y PozoDeAgua SON
	 * IGUALES ver de solucionar esto generalizando el comportamiento comun en
	 * otro lado
	 */
	/*
	 * public void agregarPozoDeAguaEn(int coordX, int coordY) {
	 * 
	 * Superficie superficieAEdificar = this.mapaTerritorio.getContenido(
	 * coordX, coordY); if (superficieAEdificar.esAgua()) { // Decidir bien
	 * quien va a guardar // la informacion del requisito del // terreno
	 * //PozoDeAgua pozo = this.edificador.construirPozoDeAgua(); this.fabrica =
	 * new FabricaPozoAgua(); PozoDeAgua pozo =
	 * (PozoDeAgua)this.fabrica.construir();
	 * 
	 * this.mapaEdilicio.agregar(pozo, coordX, coordY); } }
	 * 
	 * public void agregarEstacionDeBomberosEn(int coordX, int coordY) {
	 * 
	 * Superficie superficieAEdificar = this.mapaTerritorio.getContenido(
	 * coordX, coordY); if (superficieAEdificar.esTierra()) { // Decidir bien
	 * quien va a guardar // la informacion del requisito // del terreno
	 * EstacionDeBomberos estacion = this.edificador
	 * .construirEstacionDeBomberos(); this.mapaEdilicio.agregar(estacion,
	 * coordX, coordY); } }
	 * 
	 * public void agregarUnidadResidencialEn(int coordX, int coordY) {
	 * 
	 * Superficie superficieAEdificar = this.mapaTerritorio.getContenido(
	 * coordX, coordY); if (superficieAEdificar.esTierra()) { // Decidir bien
	 * quien va a guardar // la informacion del requisito // del terreno
	 * UnidadOcupable unidadResidencial = this.edificador
	 * .construirUnidadResidencial();
	 * this.mapaEdilicio.agregar(unidadResidencial, coordX, coordY); } }
	 * 
	 * public void agregarUnidadIndustrialEn(int coordX, int coordY) {
	 * 
	 * Superficie superficieAEdificar = this.mapaTerritorio.getContenido(
	 * coordX, coordY); if (superficieAEdificar.esTierra()) { // Decidir bien
	 * quien va a guardar // la informacion del requisito // del terreno
	 * UnidadOcupable unidadIndustrial = this.edificador
	 * .construirUnidadIndustrial(); this.mapaEdilicio.agregar(unidadIndustrial,
	 * coordX, coordY); } }
	 * 
	 * public void agregarUnidadComercialEn(int coordX, int coordY) {
	 * 
	 * Superficie superficieAEdificar = this.mapaTerritorio.getContenido(
	 * coordX, coordY); if (superficieAEdificar.esTierra()) { // Decidir bien
	 * quien va a guardar // la informacion del requisito // del terreno
	 * UnidadComercial unidadComercial = this.edificador
	 * .construirUnidadComercial(); this.mapaEdilicio.agregar(unidadComercial,
	 * coordX, coordY); } }
	 */

}