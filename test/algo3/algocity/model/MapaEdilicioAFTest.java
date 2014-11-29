package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaEdilicioAFTest {

	int alto = 10;
	int ancho = 10;

	@Test
	public void testSePuedeAgregarUnidadesAlMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		FabricaEdificables f = new FabricaUnidadResidencial();

		Ubicable u = f.construir();

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
	public void testSePuedeRemoverUnaUnidad() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		FabricaEdificables f = new FabricaEstacionDeBomberos();

		Ubicable eb = f.construir();

		m.agregar(eb, 1, 1);

		assertTrue(m.contiene(eb));

		m.remover(1, 1);

		assertFalse(m.contiene(eb));
	}

	@Test
	public void testSePuedeConsultarUnaCoordenadaDelMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		FabricaEdificables f = new FabricaPozoAgua();

		assertFalse(m.tieneCoordenadaOcupada(1, 1));
		assertTrue(m.agregar(f.construir(), 1, 1));
		assertTrue(m.tieneCoordenadaOcupada(1, 1));
	}

	@Test
	public void testSePuedeConsultarSiUnUbicableEstaEnElMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		FabricaEdificables f = new FabricaUnidadResidencial();

		Ubicable u = f.construir();

		assertTrue(m.agregar(u, 4, 4));
		assertTrue(m.contiene(u));
	}

	@Test
	public void testNoSePuedeConstruirFueraDeLimiteDelMapa() {
		FabricaEdificables f = new FabricaEstacionDeBomberos();
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		Ubicable eb = f.construir();

		assertFalse(m.agregar(eb, alto + 1, ancho + 1));
		assertFalse(m.contiene(eb));
	}

	@Test
	public void testNoSePuedeAgregarDosVecesUnaMismaInstancia() {
		FabricaEdificables f = new FabricaCentralEolica();
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		Ubicable ce = f.construir();

		assertTrue(m.agregar(ce, 3, 4));
		assertTrue(m.contiene(ce));
		assertFalse(m.agregar(ce, 5, 5));
	}

	@Test
	public void testNoSePuedeAgregarUnaUnidadHastaQueNoCumplaRequisitosDeConexion() {
		VerificadorConexiones verificador = new VerificadorConexiones();
		FabricaUnidadIndustrial fabricaIndustrial = new FabricaUnidadIndustrial();
		FabricaRuta fabricaRuta = new FabricaRuta();
		FabricaLineaTension fabricaElectricidad = new FabricaLineaTension();
		
		
		MapaEdilicio mapaEdilicio = new MapaEdilicio(15,15);
		MapaConexiones mapaConexiones = new MapaConexiones(15,15);
		
		Conector unaRuta = fabricaRuta.construir(); //nose porque me obliga a castear
		Conector unaLineaTension = fabricaElectricidad.construir();
		UnidadIndustrial unaUnidadIndustrial = fabricaIndustrial.construir(); 
		
		
		assertFalse(mapaEdilicio.agregar(unaUnidadIndustrial, 5, 5));
		//pues no se puede agregar la unidad hasta que no se cumplan los requisitos de conexion
				
		mapaConexiones.agregar(unaRuta,5,5);
		mapaConexiones.agregar(unaLineaTension,5,5);
		
		assertTrue(mapaEdilicio.agregar(unaUnidadIndustrial, 5, 5));
		
		
		
		
		
	}

}
