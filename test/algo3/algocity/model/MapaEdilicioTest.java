package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaEdilicioTest {

	int alto = 10;
	int ancho = 10;

	@Test
	public void testSePuedeAgregarUnidadesAlMapa(){
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		
		Unidad u = new UnidadResidencial();
		
		assertTrue(m.agregar(u, 1, 1));
		assertTrue(m.contiene(u));
		
		u = new UnidadComercial();
		
		assertTrue(m.agregar(u, 1, 2));
		assertTrue(m.contiene(u));
		
		u = new UnidadIndustrial();
		
		assertTrue(m.agregar(u, 2, 2));
		assertTrue(m.contiene(u));		
	}
	
	@Test
	public void testSePuedeRemoverUnaUnidad(){
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		
		Unidad eb = new EstacionDeBomberos();
				
		m.agregar(eb, 1, 1);

		assertTrue(m.contiene(eb));

		m.remover(1, 1);

		assertFalse(m.contiene(eb));
	}
	
	@Test
	public void testSePuedeConsultarUnaCoordenadaDelMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		assertFalse(m.tieneCoordenadaOcupada(1, 1));
		assertTrue(m.agregar(new PozoDeAgua(), 1, 1));
		assertTrue(m.tieneCoordenadaOcupada(1, 1));
	}
	
	@Test
	public void testSePuedeConsultarSiUnUbicableEstaEnElMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		Unidad u = new UnidadResidencial();

		assertTrue(m.agregar(u, 4, 4));
		assertTrue(m.contiene(u));
	}
	
	@Test
	public void testNoSePuedeConstruirFueraDeLimiteDelMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		Unidad eb = new EstacionDeBomberos();

		assertFalse(m.agregar(eb, alto + 1, ancho + 1));
		assertFalse(m.contiene(eb));
	}
	
	@Test
	public void testNoSePuedeAgregarDosVecesUnaMismaInstancia() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		Unidad ce = new CentralEolica();

		assertTrue(m.agregar(ce, 3, 4));
		assertTrue(m.contiene(ce));
		assertFalse(m.agregar(ce, 5, 5));
	}
	
}
