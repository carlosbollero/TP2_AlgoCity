package algo3.algocity.model.fabricas;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.SistemaElectrico;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class FabricaUnidadComercial implements FabricaUnidades {

	@Override
	public UnidadComercial construir(Mapa mapa, Dinero dinero,
			SistemaElectrico sisElectrico, Coordenada coordenada)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica {

		return new UnidadComercial(mapa, dinero, sisElectrico, coordenada);
	}

}