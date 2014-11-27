package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TurnoTest {

	@Test
	public void testTurnoSeIniciaDeFormaValida() {
		Turno t = new Turno();

		assertEquals(t.getTurno(), 1);
	}

	@Test
	public void testSePuedeAvanzarDeTurno() {
		Turno t = new Turno();

		assertEquals(t.getTurno(), 1);

		t.avanzar();

		assertEquals(t.getTurno(), 2);

	}

//	@Test
//	public void testElTurnoAvanzaAutomaticamente() throws InterruptedException {
//		Turno t = new Turno();
//
//		assertEquals(t.getTurno(), 1);
//
//		Thread.sleep(1000);
//
//		assertEquals(t.getTurno(), 2);
//
//	}

}
