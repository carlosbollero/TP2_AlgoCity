package algo3.algocity.model;

import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

import org.junit.Test;

import algo3.algocity.model.TurnoTest.TestObserver;

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
	public void testLosTurnosCorrenPorUnHiloDeEjecucionDiferente(){
		Turno t = new Turno();
		t.iniciarHilo();
		
		assertTrue(t.estaVivo());
		
		t.finalizar();
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertFalse(t.estaVivo());
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
	
	
	@Test
	public void testTurnosSeEjecutaEnUnHiloDiferente() {
		Turno t = new Turno();
		t.iniciarHilo();
		TestObserver obs = new TestObserver();
		t.addObserver(obs);
		
		assertTrue(t.estaVivo());
		
		t.finalizar();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertFalse(t.estaVivo());
	} 
	
	public class TestObserver implements Observer {
		int turn = 0;
		
		@Override
		public void update(Observable o, Object arg) {
			turn++;
		}
		
	}

}
