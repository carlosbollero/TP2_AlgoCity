package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import algo3.algocity.model.Juego;

public class AccionMouseGuardarJuego implements ActionListener {

	Juego juego;

	public AccionMouseGuardarJuego(Juego juego) {
		 this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			juego.persistir();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
