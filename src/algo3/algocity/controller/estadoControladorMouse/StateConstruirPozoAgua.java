package algo3.algocity.controller.estadoControladorMouse;

import algo3.algocity.model.Juego;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.fabricas.FabricaPozoAgua;
import algo3.algocity.model.mapas.Coordenada;

public class StateConstruirPozoAgua implements StateConstruir {
	
	FabricaPozoAgua fabrica;
	
	public StateConstruirPozoAgua(FabricaPozoAgua f) {
		fabrica = f;
	}

	@Override
	public void construir(Juego j, Coordenada c)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, SuperficieInvalidaParaConstruir,
			NoHayConexionConTuberias, CoordenadaInvalidaException {
		j.mapa().agregar(fabrica.construir(j.mapa(), j.dinero(), c));

	}

}
