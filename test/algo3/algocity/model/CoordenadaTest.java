package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.mapas.Coordenada;

public class CoordenadaTest {

	@Test
	public void testSePuedeCalcularDistaciaEntreCoordenadas(){
		Coordenada c1 = new Coordenada(2,3);
		Coordenada c2 = new Coordenada(4,5);
		
		System.out.println(c1.distacia(c2));
		
		assertTrue(c1.distacia(c2) > 0);
		assertTrue(c2.distacia(c1) > 0);
		
		Coordenada c3 = new Coordenada(1,1);
		Coordenada c4 = new Coordenada(1,1);
		
		assertEquals(c3.distacia(c4), 0);
		
		
	}
	
	@Test
	public void testSePuedenCompararIgualdadDeCoordenadas(){
		Coordenada c1 = new Coordenada(2,3);
		Coordenada c2 = new Coordenada(4,5);
		Coordenada c3 = new Coordenada(4,5);
		
		assertFalse(c1.equals(c2));
		assertFalse(c1.equals(c3));
		assertTrue(c2.equals(c3));
	}

}
