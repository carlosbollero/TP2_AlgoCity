package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JList;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import algo3.algocity.model.Juego;
import algo3.algocity.view.Ventana;
import algo3.algocity.view.VentanaInicial;

public class AccionMouseComenzarConJugadorExistente implements ActionListener {

	VentanaInicial ventanaPortadora;
	JList<String> listaUsuarios;
	
	public AccionMouseComenzarConJugadorExistente(VentanaInicial ventana,JList<String> listaUsuarios){
		this.ventanaPortadora = ventana;
		this.listaUsuarios = listaUsuarios;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Juego juegoARecuperar = new Juego();
		try {
			juegoARecuperar = juegoARecuperar.recuperar(listaUsuarios.getSelectedValue().toString());
			juegoARecuperar.actualizar();
			this.ventanaPortadora.cerrar();
			Ventana ventanaJuego = new Ventana(juegoARecuperar);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
