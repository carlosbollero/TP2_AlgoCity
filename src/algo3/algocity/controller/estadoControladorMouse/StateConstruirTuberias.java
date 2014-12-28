package algo3.algocity.controller.estadoControladorMouse;

import algo3.algocity.model.Juego;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.fabricas.FabricaTuberias;
import algo3.algocity.model.mapas.Coordenada;

public class StateConstruirTuberias implements StateConstruir {
	
	/*
	 * Esta vacia por que es invocado desde mapa superficial
	 * 
	 */
	
	
	public StateConstruirTuberias(FabricaTuberias f) {
	}

	@Override
	public void construir(Juego j, Coordenada c)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, SuperficieInvalidaParaConstruir,
			NoHayConexionConTuberias, CoordenadaInvalidaException,
			CapacidadElectricaInsuficienteException,
			NoHayConexionConRedElectrica, NoHayConexionConRutas {
	}

}
