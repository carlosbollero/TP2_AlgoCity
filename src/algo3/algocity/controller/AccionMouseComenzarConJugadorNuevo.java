package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import algo3.algocity.model.Juego;
import algo3.algocity.model.RegistroUsuarios;
import algo3.algocity.model.Usuario;
import algo3.algocity.model.excepciones.NombreDeUsuarioYaExisteException;
import algo3.algocity.view.VentanaInicial;
import algo3.algocity.view.VentanaJuego;

public class AccionMouseComenzarConJugadorNuevo implements ActionListener {

	VentanaInicial ventanaPortadora;
	JTextField panelIngreso;
	JTextField panelInforme;
	RegistroUsuarios ru;

	public AccionMouseComenzarConJugadorNuevo(VentanaInicial ventanaPortadora,
			JTextField panelIngreso, JTextField panelInforme, RegistroUsuarios ru) {
		this.ventanaPortadora = ventanaPortadora;
		this.panelIngreso = panelIngreso;
		this.panelInforme = panelInforme;
		this.ru = ru;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			if (ru.existeNombreUsuario(panelIngreso.getText())) {
				panelInforme.setText("Jugador ya existente. Ingrese otro");
				panelIngreso.setText("");
			} else if (!ru.crearUsuario(panelIngreso.getText())) {
				panelInforme
						.setText("El nombre de jugador debe contener al menos 4 caracteres");
				panelIngreso.setText("");
			} else {
				panelInforme.setText("");
				Usuario usuario = new Usuario(panelIngreso.getText());
				ru.addUsuario(usuario);
				this.ventanaPortadora.cerrar();
				VentanaJuego ventanaJuego = new VentanaJuego(new Juego(usuario));
			}
		} catch (NombreDeUsuarioYaExisteException e) {
			e.printStackTrace();
		}
	}

}
