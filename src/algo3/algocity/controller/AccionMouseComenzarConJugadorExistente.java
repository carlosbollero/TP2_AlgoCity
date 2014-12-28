package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JList;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import algo3.algocity.model.Juego;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.view.VentanaInicial;
import algo3.algocity.view.VentanaJuego;

public class AccionMouseComenzarConJugadorExistente implements ActionListener {

	VentanaInicial ventanaPortadora;
	JList<String> listaUsuarios;

	public AccionMouseComenzarConJugadorExistente(VentanaInicial ventana,
			JList<String> listaUsuarios) {
		this.ventanaPortadora = ventana;
		this.listaUsuarios = listaUsuarios;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Juego juegoARecuperar = new Juego();
		try {
			juegoARecuperar = juegoARecuperar.recuperar(listaUsuarios
					.getSelectedValue().toString());
			juegoARecuperar.actualizar();
			this.ventanaPortadora.cerrar();
			VentanaJuego ventanaJuego = new VentanaJuego(juegoARecuperar);
		} catch (SAXException | IOException | ParserConfigurationException
				| NoSeCumplenLosRequisitosException
				| FondosInsuficientesException
				| SuperficieInvalidaParaConstruir | CoordenadaInvalidaException
				| CapacidadElectricaInsuficienteException
				| NoHayConexionConTuberias | NoHayConexionConRutas
				| NoHayConexionConRedElectrica e) {
			e.printStackTrace();
		}

	}

}
