package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaTest {
	int alto = 10;
	int ancho = 10;
	
	@Test
	public void testSePuedeConsultarUnaCoordenadaDelMapa(){
		Mapa m = new Mapa(alto, ancho);
		
		assertFalse(m.tieneCoordenadaOcupada(1, 1));		
		assertTrue(m.agregar((new Edificador()).construirPozoDeAgua(), 1, 1));		
		assertTrue(m.tieneCoordenadaOcupada(1, 1));
	}
	
	@Test
	public void testSePuedeConsultarSiUnUbicableEstaEnElMapa(){
		Mapa m = new Mapa(alto, ancho);
		Edificador e = new Edificador();
		Unidad u = e.construirPozoDeAgua();
		
		assertTrue(m.agregar(u, 4, 4));
		assertTrue(m.contiene(u));
	}
	
	@Test
	public void testNoSePuedeConstruirFueraDeLimiteDelMapa(){
		Edificador e = new Edificador();
		Mapa m = new Mapa(alto, ancho);
		
		Unidad eb = e.construirEstacionDeBomberos();
		
		assertFalse(m.agregar(eb, alto + 1, ancho + 1));
		assertFalse(m.contiene(eb));		
	}
	
	@Test
	public void testNoSePuedeAgregarDosVecesUnaMismaInstancia(){
		Edificador e = new Edificador();
		Mapa m = new Mapa(alto, ancho);
		Unidad u = e.construirPozoDeAgua();
		
		assertTrue(m.agregar(u, 3, 4));
		assertTrue(m.contiene(u));
		assertFalse(m.agregar(u, 5, 5));
	}
	
	@Test
	public void testSePuedeAgregarVariasUnidades(){
		Mapa m = new Mapa(alto, ancho);
		Edificador e = new Edificador();
		
		UnidadEnergetica ce = e.construirCentralEolica();
		UnidadEnergetica cm = e.construirCentralMinera();
		UnidadEnergetica cn = e.construirCentralNuclear();
		UnidadOcupable r = e.construirUnidadResidencial();
		Unidad c = e.construirUnidadComercial();
		UnidadOcupable i = e.construirUnidadIndustrial();
		
		assertTrue(m.agregar(ce, 1, 1));
		assertTrue(m.agregar(cm, 1, 2));
		assertTrue(m.agregar(cn, 2, 1));
		assertTrue(m.agregar(r, 2, 2));
		assertTrue(m.agregar(c, 2, 3));
		assertTrue(m.agregar(i, 3, 2));
	}

	@Test
	public void testSePuedeConstruirUnaUnidadEnCoordenadaDelMapa() {
		Edificador e = new Edificador();
		Mapa m = new Mapa(alto, ancho);
		
		assertTrue(m.agregar(e.construirUnidadResidencial(), 1, 1));		
		assertTrue(m.tieneCoordenadaOcupada(1, 1));
	}
	
	@Test
	public void testNoSePuedeAgregarEnUnaParcelaOcupada(){
		Mapa m = new Mapa(alto, ancho);
		
		assertFalse(m.tieneCoordenadaOcupada(1, 1));		
		assertTrue(m.agregar((new Edificador()).construirUnidadResidencial(), 1, 1));		
		assertTrue(m.tieneCoordenadaOcupada(1, 1));		
		assertFalse(m.agregar((new Edificador()).construirUnidadIndustrial(), 1, 1));		
	}	

}
