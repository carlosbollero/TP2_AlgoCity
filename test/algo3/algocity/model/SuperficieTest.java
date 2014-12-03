package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.terreno.Superficie;
import algo3.algocity.model.terreno.SuperficieAgua;
import algo3.algocity.model.terreno.SuperficieTierra;

public class SuperficieTest {

	@Test
	public void testSePuedeCosultarQueTipoDeSuperficieEs() {
		Superficie st = new SuperficieTierra();
		Superficie sa = new SuperficieAgua();
		
		assertTrue(st.esTierra());
		assertTrue(sa.esAgua());
	}
	
	@Test
	public void testSePuedeCrearSuperficieTierraYOtraAgua() {
		Superficie st = new SuperficieTierra();
		Superficie sa = new SuperficieAgua();

		assertFalse(st.equals(sa));
		assertTrue(st.esTierra());
		assertFalse(st.esAgua());
		assertTrue(sa.esAgua());
		assertFalse(sa.esTierra());
	}
}
