package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.view.VentanaInicial;

public class AccionMouseIniciarPartida implements ActionListener {

	VentanaInicial ventanaPortadora;
	
	public AccionMouseIniciarPartida(VentanaInicial ventana){
		this.ventanaPortadora = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.ventanaPortadora.mostrarVistaJugadorNuevo();
	}

}
