package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuperficieTest {

	boolean tierra = true;
	boolean agua = false;

	@Test
	public void testSePuedeCrearSuperficieTierraYOtraAgua() {
		Superficie st = new Superficie(tierra);
		Superficie sa = new Superficie(agua);

		assertFalse(st.equals(sa));
		assertFalse((st.tipo()) == sa.tipo());
	}

	@Test
	public void testSePuedeCosultarQueTipoDeSuperficieEs() {
		Superficie st = new Superficie(tierra);
		Superficie sa = new Superficie(agua);

		assertTrue(st.esTierra());
		assertTrue(sa.esAgua());
	}

}
