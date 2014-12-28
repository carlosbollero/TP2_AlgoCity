package algo3.algocity.controller.estadocontroladormouse;

import algo3.algocity.model.Juego;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.fabricas.FabricaEstacionDeBomberos;
import algo3.algocity.model.mapas.Coordenada;

public class StateConstruirBomberos implements StateConstruir {
	
	FabricaEstacionDeBomberos fabrica;
	
	public StateConstruirBomberos(FabricaEstacionDeBomberos f) {
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
