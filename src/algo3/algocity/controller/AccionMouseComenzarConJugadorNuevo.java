package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.Juego;
import algo3.algocity.model.Poblacion;
import algo3.algocity.model.RegistroUsuarios;
import algo3.algocity.model.Turno;
import algo3.algocity.model.Usuario;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.NoSeEncontroElFicheroException;
import algo3.algocity.model.excepciones.NombreDeUsuarioYaExisteException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
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
		RegistroUsuarios ru = null;
		try {
			ru = new RegistroUsuarios();
		} catch (SAXException | IOException | ParserConfigurationException
				| NoSeCumplenLosRequisitosException
				| FondosInsuficientesException
				| SuperficieInvalidaParaConstruir | CoordenadaInvalidaException
				| CapacidadElectricaInsuficienteException
				| NoHayConexionConTuberias | NoHayConexionConRutas
				| NoHayConexionConRedElectrica e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
