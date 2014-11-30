package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;

public class PozoDeAgua extends Unidad {
	
	public PozoDeAgua(){
		costo = 250;
		consumo = 0;
	}
	
	public PozoDeAgua(ArrayList<Mapa> mapas, int x, int y) throws NoSeCumplenLosRequisitosException {
		
		requisitos = new RequisitoAgua();
		
		if (requisitos.evaluar(mapas, x, y)){
			costo = 250;
			consumo = 0;
		}else{
			throw new NoSeCumplenLosRequisitosException();
		}
		
		
		
		
	}

}
