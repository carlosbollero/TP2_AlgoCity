package algo3.algocity.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algo3.algocity.model.Juego;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.view.VistaMapa;
import algo3.algocity.view.VistaTerreno;

public class ControladorMouse extends MouseAdapter {
	Mapa mapa;
	VistaMapa vistaMapa;
	VistaTerreno vistaTerreno;
	Juego juego;

	public ControladorMouse(VistaMapa vista) {
		mapa = null;
		vistaMapa = vista;
		vistaTerreno = null;
	}

	public ControladorMouse(Mapa mapa, VistaMapa vistaMapa) {
		this.mapa = mapa;
		this.vistaMapa = vistaMapa;

	}

	public ControladorMouse(Mapa mapa, VistaTerreno vistaTerreno,
			VistaMapa vMapa, Juego juego) {
		vistaMapa = vMapa;
		this.mapa = mapa;
		this.vistaTerreno = vistaTerreno;
		this.juego = juego;
	}

	public void mousePressed(MouseEvent mouseEvent) {

		if (vistaMapa.hayConector() == true) {
			try {
				mapa.agregar(vistaMapa.devolverConector().construir(mapa,
						juego.dinero(), vistaTerreno.coordenada()));

			} catch (NoSeCumplenLosRequisitosException e) {
				System.out.println("Bleh");
			} catch (FondosInsuficientesException e) {
				System.out.println("Bleh");
			} catch (SuperficieInvalidaParaConstruir e) {
				System.out.println("Bleh");
			} catch (CoordenadaInvalidaException e) {
				System.out.println("Bleh");
			}

		}

		if (vistaMapa.hayEnergetica() == true) {
			try {
				mapa.agregar(vistaMapa.devolverEnergetica().construir(mapa,
						juego.dinero(), vistaTerreno.coordenada()));

			} catch (NoSeCumplenLosRequisitosException e) {
				System.out.println("Bleh");
			} catch (FondosInsuficientesException e) {
				System.out.println("Bleh");
			} catch (SuperficieInvalidaParaConstruir e) {
				System.out.println("Bleh");
			} catch (NoHayConexionConTuberias e) {
				System.out.println("Bleh");
			} catch (CoordenadaInvalidaException e) {
				System.out.println("Bleh");
			}

		}

		if (vistaMapa.hayUnidades() == true) {
			try {

				mapa.agregar(vistaMapa.devolverUnidades().construir(mapa,
						juego.dinero(), vistaTerreno.coordenada()));

			} catch (NoSeCumplenLosRequisitosException e) {
				System.out.println("Bleh");
			} catch (FondosInsuficientesException e) {
				System.out.println("Bleh");
			} catch (NoHayConexionConTuberias e) {
				System.out.println("Bleh");
			} catch (CoordenadaInvalidaException e) {
				System.out.println("Bleh");
			} catch (NoHayConexionConRedElectrica e) {
				System.out.println("Bleh");
			} catch (NoHayConexionConRutas e) {
				System.out.println("Bleh");
			} catch (CapacidadElectricaInsuficienteException e) {
				System.out.println("Bleh");
			}catch (SuperficieInvalidaParaConstruir e){
				System.out.println("Bleh");
			}

		}

	}

	public void mouseReleased(MouseEvent mouseEvent) {
		vistaMapa.resetearFabricas();
	}

}
