package algo3.algocity.model;

import javax.swing.JFrame;

import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.view.Ventana;

public class Juego {

	final int anchoMapaJuego = 100;
	final int altoMapaJuego = 100;

	private Mapa mapa;

	private Turno turnos;

	Usuario usuario;

	public Juego() {
		
	}
	
	public void iniciar(){
		//generarMapas();
		crearVentana();
		//iniciarTurnos();
	}

	private void crearVentana() {
		JFrame ventana = new Ventana(20);
		ventana.setSize(500, 400);
		ventana.setLocation(8, 0);
		ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void iniciarTurnos() {
		turnos = new Turno();
	}

	private void generarMapas() {
		mapa = new Mapa(altoMapaJuego, anchoMapaJuego);

	}

}