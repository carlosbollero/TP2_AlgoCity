package algo3.algocity.model;

import algo3.algocity.model.mapas.Mapa;

public class Juego {

	final int anchoMapaJuego = 100;
	final int altoMapaJuego = 100;

	private Mapa mapa;

	private Turno turnos;

	Usuario usuario;

	public Juego() {
		generarMapas();
		iniciarTurnos();
	}

	public void iniciarTurnos() {
		turnos = new Turno();
	}

	private void generarMapas() {
		mapa = new Mapa(altoMapaJuego, anchoMapaJuego);

	}

}