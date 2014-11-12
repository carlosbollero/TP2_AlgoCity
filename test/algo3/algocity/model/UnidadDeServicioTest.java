package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnidadDeServicioTest {

	@Test
	public void testPozoDeAguaTieneCostoValido() {
		
		assertEquals(250,PozoDeAgua.COSTO);
	}
	
	@Test
	public void testEstacionDeBomberosTieneCostoValido() {
		
		assertEquals(1500,EstacionDeBomberos.COSTO);
	}
}
