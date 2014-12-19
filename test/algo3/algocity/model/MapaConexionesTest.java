package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.MapaConexiones;

public class MapaConexionesTest {

	int alto = 10;
	int ancho = 10;

	@Test
	public void testSePuedeAgregarUnConectorAlMapa() {
		MapaConexiones mc = new MapaConexiones(alto, ancho);
		Conector c = new LineaTension(new Coordenada(1, 1));

		assertTrue(mc.agregar(c));
	}

	@Test
	public void testSePuedeAgregarMasDeUnConectorAlMapa() {
		MapaConexiones mc = new MapaConexiones(alto, ancho);
		Conector c1 = new Tuberia(new Coordenada(1, 1));
		Conector c2 = new Tuberia(new Coordenada(2, 1));
		Conector c3 = new Tuberia(new Coordenada(3, 1));

		assertTrue(mc.agregar(c1));
		assertTrue(mc.agregar(c2));
		assertTrue(mc.agregar(c3));
	}

	@Test
	public void testNoSePuedeAgregarDosConectoresDeIgualCoordenada() {
		MapaConexiones mc = new MapaConexiones(alto, ancho);
		Conector c1 = new Ruta(new Coordenada(1, 1));
		Conector c2 = new Ruta(new Coordenada(1, 1));

		assertTrue(mc.agregar(c1));
		assertTrue(mc.contiene(c1));
		assertFalse(mc.agregar(c2));
		assertFalse(mc.contiene(c2));
	}

	@Test
	public void testSePuedeConsultarSiDosCoordenadasEstanConectadas() {
		MapaConexiones mc = new MapaConexiones(alto, ancho);
		Conector c1 = new Ruta(new Coordenada(1, 1));
		Conector c2 = new Ruta(new Coordenada(2, 2));

		mc.agregar(c1);
		mc.agregar(c2);

		assertFalse(mc.hayConexion(mc.coordenadas(c1), mc.coordenadas(c2)));

		Conector c3 = new Ruta(new Coordenada(3, 3));
		Conector c4 = new Ruta(new Coordenada(3, 4));

		mc.agregar(c3);
		mc.agregar(c4);

		assertFalse(mc.hayConexion(mc.coordenadas(c1), mc.coordenadas(c3)));
		assertFalse(mc.hayConexion(mc.coordenadas(c1), mc.coordenadas(c4)));
		assertFalse(mc.hayConexion(mc.coordenadas(c2), mc.coordenadas(c3)));
		assertFalse(mc.hayConexion(mc.coordenadas(c2), mc.coordenadas(c4)));
		assertTrue(mc.hayConexion(mc.coordenadas(c3), mc.coordenadas(c4)));

	}

}