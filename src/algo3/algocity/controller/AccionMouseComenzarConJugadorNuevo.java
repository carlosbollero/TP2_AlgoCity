package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.Juego;
import algo3.algocity.model.Poblacion;
import algo3.algocity.model.RegistroUsuarios;
import algo3.algocity.model.Turno;
import algo3.algocity.model.Usuario;
import algo3.algocity.model.excepciones.NombreDeUsuarioYaExisteException;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.view.Ventana;
import algo3.algocity.view.VentanaInicial;

public class AccionMouseComenzarConJugadorNuevo implements ActionListener {

	VentanaInicial ventanaPortadora;
	JTextField panelIngreso;
	JTextField panelInforme;

	public AccionMouseComenzarConJugadorNuevo(VentanaInicial ventanaPortadora,
			JTextField panelIngreso, JTextField panelInforme) {
		this.ventanaPortadora = ventanaPortadora;
		this.panelIngreso = panelIngreso;
		this.panelInforme = panelInforme;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		RegistroUsuarios ru = new RegistroUsuarios();
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
				ru.crearUsuario(panelIngreso.getText());
				Usuario usuario = new Usuario(panelIngreso.getText());
				ru.addUsuario(usuario);
				Mapa mapa = new Mapa();
				Turno turno = new Turno();
				Poblacion poblacion = new Poblacion();
				Dinero dinero = new Dinero();

				this.ventanaPortadora.cerrar();
				Ventana ventanaJuego = new Ventana(new Juego(usuario, mapa,
						turno, poblacion, dinero));
			}

		} catch (NombreDeUsuarioYaExisteException e) {
			e.printStackTrace();
		}
	}

}
