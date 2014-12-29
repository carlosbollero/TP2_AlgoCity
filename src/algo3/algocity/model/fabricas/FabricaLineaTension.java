package algo3.algocity.model.fabricas;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class FabricaLineaTension implements FabricaConectores {

	public Conector construir(Mapa mapa, Dinero dinero, Coordenada coordenada)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, CoordenadaInvalidaException,
			SuperficieInvalidaParaConstruir {
		return new LineaTension(mapa, dinero, coordenada);
	}

}