package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaConexionesTest {
	
	int alto = 10;
	int ancho = 10;

	@Test
	public void testSePuedeAgregarUnConectorAlMapa() {
		MapaConexiones mc = new MapaConexiones(alto, ancho);
		Conector c = new Conector(0);
		
		assertTrue(mc.agregar(c, 3, 3));		
	}
	
	@Test
	public void testSePuedeAgregarMasDeUnConectorAlMapa(){
		MapaConexiones mc = new MapaConexiones(alto, ancho);
		Conector c1 = new Conector(0);
		Conector c2 = new Conector(0);
		Conector c3 = new Conector(0);
		
		assertTrue(mc.agregar(c1, 1, 1));
		assertTrue(mc.agregar(c2, 1, 1));
		assertTrue(mc.agregar(c3, 1, 1));		
	}
	
	@Test
	public void testNoSePuedeAgregarDosConectoresDeIgualCoordenada(){
		MapaConexiones mc = new MapaConexiones(alto, ancho);
		Conector c1 = new Conector(0);
		Conector c2 = new Conector(0);
		
		assertTrue(mc.agregar(c1, 1, 1));
		assertTrue(mc.contiene(c1));
		assertFalse(mc.agregar(c2, 1, 1));
	}

}
