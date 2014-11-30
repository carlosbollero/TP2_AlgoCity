package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;

public class CentralEolica extends UnidadEnergetica {

	public CentralEolica(ArrayList<Mapa> mapas, int x, int y) throws NoSeCumplenLosRequisitosException {
		
		requisitos = new RequisitoTierra();
		
		if (requisitos.evaluar(mapas, x, y)){
			this.costo = 1000;
			this.capacidad = 100;
			this.radioDeInfluencia = 4;
		}else{
			throw new NoSeCumplenLosRequisitosException();
		}
		
		
	}

}
