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
	
	@Test
	public void testElTurnoAvanzaAutomaticamenteCadaCiertoTiempo(){
		Turno turno = new Turno();
		
		assertEquals(turno.getTurno(), 1);
		
		try {
			Thread.sleep(turno.getDelay()+5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(2, turno.getTurno());
	}

}
