package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EdificadorTest {

	@Test
	public void testConstruirZonaResidencial() {
		Edificador e = new Edificador();
		
		
		assertTrue(e.construirUnidadResidencial() instanceof UnidadResidencial);
	}
	
	@Test
	public void testConstruirZonaComercial() {
		Edificador e = new Edificador();
		
		assertTrue(e.construirUnidadComercial() instanceof UnidadComercial);
	}

	@Test
	public void testConstruirZonaIndustrial() {
		Edificador e = new Edificador();
		
		assertTrue(e.construirUnidadIndustrial() instanceof UnidadIndustrial);
	}
	
	@Test
	public void testConstruirCentralEolica() {
		Edificador e = new Edificador();
		
		assertTrue(e.construirCentralEolica() instanceof CentralEolica);
	}
	
	@Test
	public void testConstruirCentralMinera() {
		Edificador e = new Edificador();
		
		assertTrue(e.construirCentralMinera() instanceof CentralMinera);
	}
	
	@Test
	public void testConstruirCentralNuclear() {
		Edificador e = new Edificador();
		
		assertTrue(e.construirCentralNuclear() instanceof CentralNuclear);
	}
	
	@Test
	public void testConstruirTuberia() {
		Edificador e = new Edificador();
		
		assertTrue(e.construirTuberia() instanceof Tuberia);
	}
	
	@Test
	public void testConstruirRuta() {
		Edificador e = new Edificador();
		
		assertTrue(e.construirRuta() instanceof Ruta);
	}
	
	@Test
	public void testConstruirLineaDeTension() {
		Edificador e = new Edificador();
		
		assertTrue(e.construirLineaDeTension() instanceof LineaDeTension);
	}
	
	@Test
	public void testConstruirPozoDeAgua() {
		Edificador e = new Edificador();
		
		assertTrue(e.construirPozoDeAgua() instanceof PozoDeAgua);
	}
	
	@Test
	public void testConstruirEstacionDeBomberos() {
		Edificador e = new Edificador();
		
		assertTrue(e.construirEstacionDeBomberos() instanceof EstacionDeBomberos);
	}
}
