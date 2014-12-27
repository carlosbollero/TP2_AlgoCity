package algo3.algocity.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;
import java.util.Observer;

import algo3.algocity.model.Juego;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.fabricas.FabricaEstacionDeBomberos;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.view.VistaMapa;


public class ControladorMouse extends MouseAdapter  implements Observer{
	Mapa mapa;
	VistaMapa vistaMapa;
	Coordenada coordenada;
	Juego juego;
	//agregado
	StateConstruir estadoActual;

	public ControladorMouse(VistaMapa vista) {
		mapa = null;
		vistaMapa = vista;
	}

	public ControladorMouse(Mapa mapa, VistaMapa vistaMapa) {
		this.mapa = mapa;
		this.vistaMapa = vistaMapa;

	}

	public ControladorMouse(Mapa mapa, Coordenada coord,
			VistaMapa vMapa, Juego juego) {
		vistaMapa = vMapa;
		this.mapa = mapa;
		coordenada = coord;
		this.juego = juego;
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		
		try {
			Method update = getClass().getMethod("update",arg1.getClass(), Object.class);
			update.invoke(this, arg0, arg1);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	    
		
	}
	
	public void update(Observable arg0, FabricaEstacionDeBomberos arg1){
		estadoActual = new StateConstruirBomberos();
	}

	public void mousePressed(MouseEvent mouseEvent) {
		
		try {
			estadoActual.construir(juego, coordenada);
		} catch (NoSeCumplenLosRequisitosException
				| FondosInsuficientesException
				| SuperficieInvalidaParaConstruir | NoHayConexionConTuberias
				| CoordenadaInvalidaException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		/*
		

		if (vistaMapa.hayConector() == true) {
			try {
				mapa.agregar(vistaMapa.devolverConector().construir(mapa,
						juego.dinero(), coordenada));

			} catch (NoSeCumplenLosRequisitosException e) {
				System.out.println(e);
			} catch (FondosInsuficientesException e) {
				System.out.println(e);
			} catch (SuperficieInvalidaParaConstruir e) {
				System.out.println(e);
			} catch (CoordenadaInvalidaException e) {
				System.out.println(e);
			}

		}

		if (vistaMapa.hayEnergetica() == true) {
			try {
				mapa.agregar(vistaMapa.devolverEnergetica().construir(mapa,
						juego.dinero(), coordenada));

			} catch (NoSeCumplenLosRequisitosException e) {
				System.out.println(e);
			} catch (FondosInsuficientesException e) {
				System.out.println(e);
			} catch (SuperficieInvalidaParaConstruir e) {
				System.out.println(e);
			} catch (NoHayConexionConTuberias e) {
				System.out.println(e);
			} catch (CoordenadaInvalidaException e) {
				System.out.println(e);
			}

		}

		if (vistaMapa.hayUnidades() == true) {
			try {

				mapa.agregar(vistaMapa.devolverUnidades().construir(mapa,
						juego.dinero(), coordenada));

			} catch (NoSeCumplenLosRequisitosException e) {
				System.out.println(e);
			} catch (FondosInsuficientesException e) {
				System.out.println(e);
			} catch (NoHayConexionConTuberias e) {
				System.out.println(e);
			} catch (CoordenadaInvalidaException e) {
				System.out.println(e);
			} catch (NoHayConexionConRedElectrica e) {
				System.out.println(e);
			} catch (NoHayConexionConRutas e) {
				System.out.println(e);
			} catch (CapacidadElectricaInsuficienteException e) {
				System.out.println(e);
			}catch (SuperficieInvalidaParaConstruir e){
				System.out.println(e);
			}

		}
*/
	}

	public void mouseReleased(MouseEvent mouseEvent) {
//		vistaMapa.resetearFabricas();
	}


}
