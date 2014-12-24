package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.EstacionDeBomberos;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class MapaEdilicioTest {

	int tamanio = 10;

	@Test
	public void testSePuedeAgregarUnidadesAlMapa()
			throws CoordenadaInvalidaException{
		Mapa m = new Mapa();

		Unidad u = new UnidadResidencial(new Coordenada(4, 4));

		assertTrue(m.agregar(u));
		assertTrue(m.contiene(u));

		u = new UnidadComercial(new Coordenada(3, 3));

		assertTrue(m.agregar(u));
		assertTrue(m.contiene(u));

		u = new UnidadIndustrial(new Coordenada(2, 2));

		assertTrue(m.agregar(u));
		assertTrue(m.contiene(u));

	}

	@Test
	public void testSePuedeRemoverUnaUnidad()
			throws CoordenadaInvalidaException {
		Mapa m = new Mapa();

		Unidad eb = new EstacionDeBomberos(new Coordenada(1, 1));

		m.agregar(eb);

		assertTrue(m.contiene(eb));

		m.ciudad().remover(1, 1);

		assertFalse(m.contiene(eb));
	}

	@Test
	public void testSePuedeConsultarUnaCoordenadaDelMapa()
			throws CoordenadaInvalidaException{
		Mapa m = new Mapa();

		assertFalse(m.ciudad().tieneCoordenadaOcupada(new Coordenada(1, 1)));
		assertTrue(m.agregar(new PozoDeAgua(new Coordenada(1, 1))));
		assertTrue(m.ciudad().tieneCoordenadaOcupada(new Coordenada(1, 1)));
	}

	@Test
	public void testSePuedeConsultarSiUnUbicableEstaEnElMapa()
			throws CoordenadaInvalidaException {
		Mapa m = new Mapa();

		Unidad u = new UnidadResidencial(new Coordenada(1, 1));

		assertTrue(m.agregar(u));
		assertTrue(m.contiene(u));
	}

	@Test
	public void testNoSePuedeConstruirFueraDeLimiteDelMapa() {
		Mapa m = new Mapa();

		Unidad eb = new EstacionDeBomberos(new Coordenada(40, 4));
		

		try{
			m.agregar(eb);
		}catch (CoordenadaInvalidaException e){
			assertFalse(m.contiene(eb));
		}
		
		LineaTension lt = new LineaTension(new Coordenada(50,40));
		
		try{
			m.agregar(lt);
		}catch (CoordenadaInvalidaException e){
			assertFalse(m.contiene(lt));
		}
		
	}

	@Test
	public void testNoSePuedeAgregarDosVecesUnaMismaInstancia()
			throws CoordenadaInvalidaException {
		Mapa m = new Mapa();

		Unidad ce = new CentralEolica(new Coordenada(2, 2));

		assertTrue(m.agregar(ce));
		assertTrue(m.contiene(ce));
		assertFalse(m.agregar(ce));
	}

}
