package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoblacionTest {

	@Test
	public void testSeCreaConEstadoValido() {
		Poblacion p = new Poblacion();

		assertEquals(0, p.getCantidad());
	}

	@Test
	public void testLaPoblacionPuedeCrecer() {
		Poblacion p = new Poblacion();

		assertTrue(p.getCantidad() == 0);

		p.aumentar();

		assertTrue(p.getCantidad() > 0);
	}

	@Test
	public void testLaPoblacionPuedeDecrecer() {
		Poblacion p = new Poblacion();

		assertTrue(p.getCantidad() == 0);

		p.aumentar();
		int referencia = p.getCantidad();

		assertTrue(referencia > 0);

		p.disminuir();

		assertTrue(p.getCantidad() < referencia);
	}

	@Test
	public void testLaPoblacionCrecePorTurnos() {
		Poblacion p = new Poblacion();
		Turno t = new Turno();

		t.addObserver(p);
		int referencia = p.getCantidad();

		assertTrue(referencia == 0);

		t.avanzarTurno();

		assertTrue(p.getCantidad() > referencia);

	}

}
