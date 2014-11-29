package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaEdilicioAFTest {

	int alto = 10;
	int ancho = 10;

	@Test
	public void testSePuedeAgregarUnidadesAlMapa(){
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		FabricaUnidades f = new FabricaUnidadResidencial();
		
		Unidad u = f.construir();
		
		assertTrue(m.agregar(u, 1, 1));
		assertTrue(m.contiene(u));
		
		f = new FabricaUnidadComercial();
		u = f.construir();
		
		assertTrue(m.agregar(u, 1, 2));
		assertTrue(m.contiene(u));
		
		f = new FabricaUnidadIndustrial();
		u = f.construir();
		
		assertTrue(m.agregar(u, 2, 2));
		assertTrue(m.contiene(u));		
	}
	
	@Test
	public void testSePuedeRemoverUnaUnidad(){
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		FabricaUnidades f = new FabricaEstacionDeBomberos();
		
		Unidad eb = f.construir();
				
		m.agregar(eb, 1, 1);

		assertTrue(m.contiene(eb));

		m.remover(1, 1);

		assertFalse(m.contiene(eb));
	}
	
	@Test
	public void testSePuedeConsultarUnaCoordenadaDelMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		FabricaUnidades f = new FabricaPozoAgua();

		assertFalse(m.tieneCoordenadaOcupada(1, 1));
		assertTrue(m.agregar(f.construir(), 1, 1));
		assertTrue(m.tieneCoordenadaOcupada(1, 1));
	}
	
	@Test
	public void testSePuedeConsultarSiUnUbicableEstaEnElMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		FabricaUnidades f = new FabricaUnidadResidencial();

		Unidad u = f.construir();

		assertTrue(m.agregar(u, 4, 4));
		assertTrue(m.contiene(u));
	}
	
	@Test
	public void testNoSePuedeConstruirFueraDeLimiteDelMapa() {
		FabricaUnidades f = new FabricaEstacionDeBomberos();
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		Unidad eb = f.construir();

		assertFalse(m.agregar(eb, alto + 1, ancho + 1));
		assertFalse(m.contiene(eb));
	}
	
	@Test
	public void testNoSePuedeAgregarDosVecesUnaMismaInstancia() {
		FabricaUnidades f = new FabricaCentralEolica();
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		Unidad ce = f.construir();

		assertTrue(m.agregar(ce, 3, 4));
		assertTrue(m.contiene(ce));
		assertFalse(m.agregar(ce, 5, 5));
	}
	
}
