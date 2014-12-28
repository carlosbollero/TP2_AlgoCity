package algo3.algocity.model.fabricas;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class FabricaRuta implements FabricaConectores {

	public Conector construir(Mapa mapa, Dinero dinero, Coordenada coordenada)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, CoordenadaInvalidaException {
		return new Ruta(mapa, dinero, coordenada);
	}

}