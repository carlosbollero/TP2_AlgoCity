package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.requisitos.RequisitoTierra;

public class CentralEolica extends UnidadEnergetica {
	
	public CentralEolica(){
		this.costo = 1000;
		this.capacidad = 100;
		this.radioDeInfluencia = 4;
	}

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
