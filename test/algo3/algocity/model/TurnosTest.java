package algo3.algocity.model;

import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

import org.junit.Test;

public class TurnosTest {

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
	
	private class TestObserver implements Observer {

		int turn = 0;
		
		@Override
		public void update(Observable o, Object arg) {
			turn++;
		}
		
	}

}
