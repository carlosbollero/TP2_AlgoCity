package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnidadEnergeticaTest {

	@Test
	public void testCentralEolicaTieneRadioInfluenciaValido() {
		
		CentralEolica unaCentralEolica = new CentralEolica();
		assertEquals(4,unaCentralEolica.getRadioDeInfluencia());
	}
	
	@Test
	public void testCentralMineraTieneRadioInfluenciaValido() {
		
		CentralMinera unaCentralMinera = new CentralMinera();
		assertEquals(10,unaCentralMinera.getRadioDeInfluencia());
	}

	@Test
	public void testCentralNuclearTieneRadioInfluenciaValido() {
		
		CentralNuclear unaCentralNuclear = new CentralNuclear();
		assertEquals(25,unaCentralNuclear.getRadioDeInfluencia());
	}
	
	@Test
	public void testCentralEolicaTieneCapacidadValida() {
		
		CentralEolica unaCentralEolica = new CentralEolica();
		assertEquals(100,unaCentralEolica.getCapacidad());
	}

	@Test
	public void testCentralMineraTieneCapacidadValida() {
		
		CentralMinera unaCentralMinera = new CentralMinera();
		assertEquals(400,unaCentralMinera.getCapacidad());
	}
	
	@Test
	public void testCentralNuclearTieneCapacidadValida() {

		CentralNuclear unaCentralNuclear = new CentralNuclear();
		assertEquals(1000,unaCentralNuclear.getCapacidad());
	}
	
	
}
