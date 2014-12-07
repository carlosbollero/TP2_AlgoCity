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
		
		assertTrue(c1.distacia(c2) != 0);
		
		
	}
	
	@Test
	public void testSePuedenCompararCoordenadas(){
		Coordenada c1 = new Coordenada(2,3);
		Coordenada c2 = new Coordenada(4,5);
		Coordenada c3 = new Coordenada(4,5);
		
		assertFalse(c1.equals(c2));
		assertFalse(c1.equals(c3));
		assertTrue(c2.equals(c3));
	}

}
