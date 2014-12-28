package algo3.algocity.controller.estadocontroladormouse;

import algo3.algocity.model.Juego;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.fabricas.FabricaUnidadResidencial;
import algo3.algocity.model.mapas.Coordenada;

public class StateConstruirUnidadResidencial implements StateConstruir {

	FabricaUnidadResidencial fabrica;

	public StateConstruirUnidadResidencial(FabricaUnidadResidencial f) {
		fabrica = f;
	}

	@Override
	public void construir(Juego j, Coordenada c)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, SuperficieInvalidaParaConstruir,
			NoHayConexionConTuberias, CoordenadaInvalidaException,
			CapacidadElectricaInsuficienteException, NoHayConexionConRutas,
			NoHayConexionConRedElectrica {
		j.mapa().agregar(fabrica.construir(j.mapa(), j.dinero(), c));
	}

}
