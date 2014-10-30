package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResidenciaTest {

	@Test
	public void testLaResidenciaCreadaEsValida() {
		
		Residencia r = new Residencia();
		
		assertEquals(5, r.getCosto());
		assertEquals(1, r.getArea());
		assertEquals(100, r.getCapacidad());
		assertEquals(0, r.getOcupacion());		
		assertEquals(1, r.getConsumo());
		assertEquals(0, r.getDanios());
	}

	@Test
	public void testLaResidenciaPuedeRecibirDanios(){
		Residencia r = new Residencia();
		
		r.aplicarDanio(50);
		
		assertEquals(50, r.getDanios());
	}
	
	@Test
	public void testLaResidenciaPuedeRecibirMasDeUnDanio(){
		Residencia r = new Residencia();
		
		r.aplicarDanio(25);
		r.aplicarDanio(50);
		
		assertEquals(75, r.getDanios());
	}

}
