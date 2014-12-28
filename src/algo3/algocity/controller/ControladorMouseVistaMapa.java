package algo3.algocity.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;
import java.util.Observer;

import algo3.algocity.controller.estadoControladorMouse.StateConstruir;
import algo3.algocity.controller.estadoControladorMouse.StateConstruirBomberos;
import algo3.algocity.controller.estadoControladorMouse.StateConstruirCentralEolica;
import algo3.algocity.controller.estadoControladorMouse.StateConstruirCentralMinera;
import algo3.algocity.controller.estadoControladorMouse.StateConstruirCentralNuclear;
import algo3.algocity.controller.estadoControladorMouse.StateConstruirLineasDeTension;
import algo3.algocity.controller.estadoControladorMouse.StateConstruirPozoAgua;
import algo3.algocity.controller.estadoControladorMouse.StateConstruirRutas;
import algo3.algocity.controller.estadoControladorMouse.StateConstruirTuberias;
import algo3.algocity.controller.estadoControladorMouse.StateConstruirUnidadComercial;
import algo3.algocity.controller.estadoControladorMouse.StateConstruirUnidadIndustrial;
import algo3.algocity.controller.estadoControladorMouse.StateConstruirUnidadResidencial;
import algo3.algocity.model.Juego;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.fabricas.FabricaCentralEolica;
import algo3.algocity.model.fabricas.FabricaCentralMinera;
import algo3.algocity.model.fabricas.FabricaCentralNuclear;
import algo3.algocity.model.fabricas.FabricaEstacionDeBomberos;
import algo3.algocity.model.fabricas.FabricaLineaTension;
import algo3.algocity.model.fabricas.FabricaPozoAgua;
import algo3.algocity.model.fabricas.FabricaRuta;
import algo3.algocity.model.fabricas.FabricaTuberias;
import algo3.algocity.model.fabricas.FabricaUnidadComercial;
import algo3.algocity.model.fabricas.FabricaUnidadIndustrial;
import algo3.algocity.model.fabricas.FabricaUnidadResidencial;
import algo3.algocity.model.mapas.Coordenada;

public class ControladorMouseVistaMapa extends MouseAdapter implements Observer {
	
	Coordenada coordenada;
	Juego juego;
	StateConstruir estadoActual;
	ControladorMensajes controlador;

	public ControladorMouseVistaMapa(Juego j, Coordenada c) {
		juego = j;
		coordenada = c;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		try {
			Method update = getClass().getMethod("update", Observable.class,
					arg1.getClass());
			update.invoke(this, arg0, arg1);
		} catch (NoSuchMethodException e) {
			System.out.println(e);
		} catch (SecurityException e) {
			System.out.println(e);
		} catch (IllegalAccessException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		} catch (InvocationTargetException e) {
			System.out.println(e);
		}
	}

	public void update(Observable arg0, FabricaEstacionDeBomberos fabrica) {
		estadoActual = new StateConstruirBomberos(fabrica);
	}

	public void update(Observable arg0, FabricaPozoAgua fabrica) {
		estadoActual = new StateConstruirPozoAgua(fabrica);
	}

	public void update(Observable arg0, FabricaUnidadResidencial fabrica) {
		estadoActual = new StateConstruirUnidadResidencial(fabrica);
	}

	public void update(Observable arg0, FabricaUnidadComercial fabrica) {
		estadoActual = new StateConstruirUnidadComercial(fabrica);
	}

	public void update(Observable arg0, FabricaUnidadIndustrial fabrica) {
		estadoActual = new StateConstruirUnidadIndustrial(fabrica);
	}

	public void update(Observable arg0, FabricaCentralEolica fabrica) {
		estadoActual = new StateConstruirCentralEolica(fabrica);
	}

	public void update(Observable arg0, FabricaCentralMinera fabrica) {
		estadoActual = new StateConstruirCentralMinera(fabrica);
	}

	public void update(Observable arg0, FabricaCentralNuclear fabrica) {
		estadoActual = new StateConstruirCentralNuclear(fabrica);
	}
	
	public void update(Observable arg0, FabricaTuberias fabrica) {
		estadoActual = new StateConstruirTuberias(fabrica);
	}
	
	public void update(Observable arg0, FabricaLineaTension fabrica) {
		estadoActual = new StateConstruirLineasDeTension(fabrica);
	}
	
	public void update(Observable arg0, FabricaRuta fabrica) {
		estadoActual = new StateConstruirRutas(fabrica);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			estadoActual.construir(juego, coordenada);
		} catch (NoSeCumplenLosRequisitosException
				| FondosInsuficientesException
				| SuperficieInvalidaParaConstruir | NoHayConexionConTuberias
				| CoordenadaInvalidaException
				| CapacidadElectricaInsuficienteException
				| NoHayConexionConRedElectrica | NoHayConexionConRutas e1) {
			System.out.println(e1);
			controlador.recibirYNotificar(e1.getClass().getSimpleName());
		}
		super.mouseClicked(e);
	}
	
	public void setControladorMensajes(ControladorMensajes c){
		controlador = c;
	}

}
