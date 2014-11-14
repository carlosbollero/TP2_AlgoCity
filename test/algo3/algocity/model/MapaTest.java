package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaTest {
	
	@Test
	public void testSePuedeConsultarUnaCoordenadaDelMapa(){
		Mapa m = new Mapa();
		
		assertFalse(m.tieneUnidadEn(1, 1));
		
		m.agregarUnidadEn((new Edificador()).construirPozoDeAgua(), 1, 1);
		
		assertTrue(m.tieneUnidadEn(1, 1));
	}

	@Test
	public void testSePuedeConstruirUnaUnidadEnCoordenadaDelMapa() {
		Edificador e = new Edificador();
		Mapa m = new Mapa();
		
		m.agregarUnidadEn(e.construirUnidadResidencial(), 1, 1);
		
		assertTrue(m.tieneUnidadEn(1, 1));
	}
	
	@Test
	public void testNoSePuedeAgregarEnUnaParcelaOcupada(){
		Mapa m = new Mapa();
		
		assertFalse(m.tieneUnidadEn(1, 1));
		
		m.agregarUnidadEn((new Edificador()).construirUnidadResidencial(), 1, 1);
		
		assertTrue(m.tieneUnidadEn(1, 1));
		
		assertFalse(m.agregarUnidadEn((new Edificador()).construirUnidadIndustrial(), 1, 1));		
	}

}
