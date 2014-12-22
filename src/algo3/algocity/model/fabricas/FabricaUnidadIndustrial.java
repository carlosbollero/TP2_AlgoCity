package algo3.algocity.model.fabricas;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.SistemaElectrico;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class FabricaUnidadIndustrial implements FabricaUnidades {

	public Unidad construir(Mapa mapa, Dinero dinero,
			SistemaElectrico sisElectrico, Coordenada coordenada)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException,
			CapacidadElectricaInsuficienteException,
			NoHayConexionConRedElectrica, NoHayConexionConRutas {

		return new UnidadIndustrial(mapa, dinero, sisElectrico, coordenada);
	}

}
