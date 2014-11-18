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
		
		m.agregarUnidadEn((new Edificador()).construirPozoDeAgua(), 1, 1);
		
		assertTrue(m.tieneCoordenadaOcupada(1, 1));
	}
	
	@Test
	public void testSePuedeConsultarSiUnUbicableEstaEnElMapa(){
		Mapa m = new Mapa(alto, ancho);
		Edificador e = new Edificador();
		Unidad u = e.construirPozoDeAgua();
		
		assertTrue(m.agregarUnidadEn(u, 4, 4));
		
		
	}
	
	@Test
	public void testNoSePuedeConstruirFueraDeLimiteDelMapa(){
		Edificador e = new Edificador();
		Mapa m = new Mapa(alto, ancho);
		
		Unidad eb = e.construirEstacionDeBomberos();
		
		assertFalse(m.agregarUnidadEn(eb, alto + 1, ancho + 1));
		assertFalse(m.contiene(eb));		
	}
	
	@Test
	public void testNoSePuedeAgregarDosVecesUnaMismaInstancia(){
		Edificador e = new Edificador();
		Mapa m = new Mapa(alto, ancho);
		Unidad u = e.construirPozoDeAgua();
		
		assertTrue(m.agregarUnidadEn(u, 4, 4));
		assertTrue(m.contiene(u));
		assertFalse(m.agregarUnidadEn(u, 5, 5));
	}

	@Test
	public void testSePuedeConstruirUnaUnidadEnCoordenadaDelMapa() {
		Edificador e = new Edificador();
		Mapa m = new Mapa(10, 10);
		
		m.agregarUnidadEn(e.construirUnidadResidencial(), 1, 1);
		
		assertTrue(m.tieneCoordenadaOcupada(1, 1));
	}
	
	@Test
	public void testNoSePuedeAgregarEnUnaParcelaOcupada(){
		Mapa m = new Mapa(10, 10);
		
		assertFalse(m.tieneCoordenadaOcupada(1, 1));
		
		m.agregarUnidadEn((new Edificador()).construirUnidadResidencial(), 1, 1);
		
		assertTrue(m.tieneCoordenadaOcupada(1, 1));
		
		assertFalse(m.agregarUnidadEn((new Edificador()).construirUnidadIndustrial(), 1, 1));		
	}
	
	

}
