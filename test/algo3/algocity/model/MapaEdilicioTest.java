package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaEdilicioTest {
	int alto = 10;
	int ancho = 10;

	@Test
<<<<<<< HEAD
	public void testSePuedeAgregarUnaUnidadAlMapa(){
=======
	public void testSePuedeAgregarUnaUnidadAlMapa() {
>>>>>>> c7ba9ea2755935aefb2f15ed70c6ab7201030da7
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		Edificador e = new Edificador();

		Ubicable ur = e.construirUnidadResidencial();
		m.agregar(ur, 1, 1);

		assertTrue(m.contiene(ur));
	}

	@Test
<<<<<<< HEAD
	public void testSePuedeRemoverDeUnaCoordenada(){
=======
	public void testSePuedeRemoverDeUnaCoordenada() {
>>>>>>> c7ba9ea2755935aefb2f15ed70c6ab7201030da7
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		Edificador e = new Edificador();

		Ubicable ur = e.construirUnidadResidencial();
		m.agregar(ur, 1, 1);

		assertTrue(m.contiene(ur));

		m.remover(1, 1);

		assertFalse(m.contiene(ur));
	}

	@Test
<<<<<<< HEAD
	public void testSePuedeAgregarVariasUnidadesAlMapa(){
=======
	public void testSePuedeAgregarVariasUnidadesAlMapa() {
>>>>>>> c7ba9ea2755935aefb2f15ed70c6ab7201030da7
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		Edificador e = new Edificador();

		Ubicable ur = e.construirUnidadResidencial();
		Ubicable uc = e.construirUnidadComercial();

		m.agregar(ur, 1, 1);
		m.agregar(uc, 2, 2);

		assertTrue(m.contiene(ur));
		assertTrue(m.contiene(uc));
	}

	@Test
	public void testSePuedeConsultarUnaCoordenadaDelMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		assertFalse(m.tieneCoordenadaOcupada(1, 1));
		assertTrue(m.agregar((new Edificador()).construirPozoDeAgua(), 1, 1));
		assertTrue(m.tieneCoordenadaOcupada(1, 1));
	}

	@Test
	public void testSePuedeConsultarSiUnUbicableEstaEnElMapa() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
		Edificador e = new Edificador();

		Unidad u = e.construirPozoDeAgua();

		assertTrue(m.agregar(u, 4, 4));
		assertTrue(m.contiene(u));
	}

	@Test
	public void testNoSePuedeConstruirFueraDeLimiteDelMapa() {
		Edificador e = new Edificador();
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		Unidad eb = e.construirEstacionDeBomberos();

		assertFalse(m.agregar(eb, alto + 1, ancho + 1));
		assertFalse(m.contiene(eb));
	}

	@Test
	public void testNoSePuedeAgregarDosVecesUnaMismaInstancia() {
		Edificador e = new Edificador();
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		Unidad u = e.construirPozoDeAgua();

		assertTrue(m.agregar(u, 3, 4));
		assertTrue(m.contiene(u));
		assertFalse(m.agregar(u, 5, 5));
	}

	@Test
	public void testSePuedeAgregarVariasUnidades() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);
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
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		assertTrue(m.agregar(e.construirUnidadResidencial(), 1, 1));
		assertTrue(m.tieneCoordenadaOcupada(1, 1));
	}

	@Test
	public void testNoSePuedeAgregarEnUnaParcelaOcupada() {
		MapaEdilicio m = new MapaEdilicio(alto, ancho);

		assertFalse(m.tieneCoordenadaOcupada(1, 1));
		assertTrue(m.agregar((new Edificador()).construirUnidadResidencial(),
				1, 1));
		assertTrue(m.tieneCoordenadaOcupada(1, 1));
		assertFalse(m.agregar((new Edificador()).construirUnidadIndustrial(),
				1, 1));
	}

	// @Test
	// public void testSePuedeGenerarUnaRedDeRuta(){
	// Mapa m = new Mapa(alto, ancho);
	// }

}
