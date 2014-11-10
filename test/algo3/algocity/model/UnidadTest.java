package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnidadTest {

	@Test
	public void testDistintasUnidadesTienenDistintosCostos() {
				
		System.out.println("eolica " + CentralEolica.COSTO);
		System.out.println("residencial " + UnidadResidencial.COSTO);
		System.out.println("comercio " + UnidadComercial.COSTO);
		System.out.println("industria " + UnidadIndustrial.COSTO);
		
		assertNotEquals(CentralEolica.COSTO, UnidadResidencial.COSTO);
		assertNotEquals(UnidadComercial.COSTO, UnidadIndustrial.COSTO);
	}

}
