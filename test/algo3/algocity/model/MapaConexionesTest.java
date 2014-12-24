package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class MapaConexionesTest {

	int alto = 10;
	int ancho = 10;

	@Test
	public void testSePuedeAgregarUnConectorAlMapa()
			throws CoordenadaInvalidaException {
		Mapa m = new Mapa();
		Conector c = new LineaTension(new Coordenada(1, 1));

		assertTrue(m.agregar(c));
	}

	@Test
	public void testSePuedeAgregarMasDeUnConectorAlMapa()
			throws CoordenadaInvalidaException {
		Mapa m = new Mapa();
		Conector c1 = new Tuberia(new Coordenada(1, 1));
		Conector c2 = new Tuberia(new Coordenada(2, 1));
		Conector c3 = new Tuberia(new Coordenada(3, 1));

		assertTrue(m.agregar(c1));
		assertTrue(m.agregar(c2));
		assertTrue(m.agregar(c3));
	}

	@Test
	public void testNoSePuedeAgregarDosConectoresDeIgualCoordenada()
			throws CoordenadaInvalidaException {
		Mapa m = new Mapa();
		Conector c1 = new Ruta(new Coordenada(1, 1));
		Conector c2 = new Ruta(new Coordenada(1, 1));

		assertTrue(m.agregar(c1));
		assertTrue(m.contiene(c1));
		assertFalse(m.agregar(c2));
		assertFalse(m.contiene(c2));
	}

	@Test
	public void testSePuedeConsultarSiDosCoordenadasEstanConectadas()
			throws CoordenadaInvalidaException {
		Mapa m = new Mapa();
		Conector c1 = new Ruta(new Coordenada(1, 1));
		Conector c2 = new Ruta(new Coordenada(2, 2));

		m.agregar(c1);
		m.agregar(c2);

		assertFalse(m.rutas().hayConexion(c1.coordenada(), c2.coordenada()));

		Conector c3 = new Ruta(new Coordenada(3, 3));
		Conector c4 = new Ruta(new Coordenada(3, 4));

		m.agregar(c3);
		m.agregar(c4);

		assertFalse(m.rutas().hayConexion(c1.coordenada(), c3.coordenada()));
		assertFalse(m.rutas().hayConexion(c1.coordenada(), c4.coordenada()));
		assertFalse(m.rutas().hayConexion(c2.coordenada(), c3.coordenada()));
		assertFalse(m.rutas().hayConexion(c2.coordenada(), c4.coordenada()));
		assertTrue(m.rutas().hayConexion(c3.coordenada(), c4.coordenada()));

	}

}