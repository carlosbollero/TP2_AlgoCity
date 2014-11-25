package algo3.algocity.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

<<<<<<< HEAD
import org.junit.Test;

import java.awt.Point;

public class JuegoTest {

=======
import java.awt.Point;

import org.junit.Test;

public class JuegoTest {

>>>>>>> dev-tomas
	@Test
	public void testSePuedeCrearUnJuegoValido() {

		Juego unJuego = new Juego();

		assertTrue(unJuego.getMapaEdilicio() instanceof MapaEdilicio);
		assertTrue(unJuego.getMapaTerritorio() instanceof MapaTerritorio);
<<<<<<< HEAD
		assertTrue(unJuego.getMapaTuberias() instanceof MapaConexiones);
		assertTrue(unJuego.getMapaRutas() instanceof MapaConexiones);
		assertTrue(unJuego.getMapaLineasDeTension() instanceof MapaConexiones);
=======
		// assertTrue(unJuego.getMapaTuberias() instanceof MapaConexiones);
		// assertTrue(unJuego.getMapaRutas() instanceof MapaConexiones);
		// assertTrue(unJuego.getMapaLineasDeTension() instanceof
		// MapaConexiones);
>>>>>>> dev-tomas
	}

	@Test
	public void testAgregarPozoDeAguaEnMapaCorrespondiente() {

		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		// Busca una coordenada con terreno valido para agregar el pozo de agua

		Point puntoDeUnAgua = mapaTerritorio.getPosicionDeUnaSuperficieDeAgua();

		unJuego.agregarPozoDeAguaEn((int) puntoDeUnAgua.getX(),
				(int) puntoDeUnAgua.getY());

		MapaEdilicio mapaEdilicio = unJuego.getMapaEdilicio();
		assertFalse(mapaEdilicio.estaVacio());
		assertTrue(mapaEdilicio.tieneCoordenadaOcupada(
				(int) puntoDeUnAgua.getX(), (int) puntoDeUnAgua.getY()));
	}

	@Test
	public void testAgregarEstacionDeBomberosEnMapaCorrespondiente() {

		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		// Busca una coordenada con terreno valido para agregar la estacion de
		// bomberos
		Point puntoDeUnaTierra = mapaTerritorio
				.getPosicionDeUnaSuperficieDeTierra();

		unJuego.agregarEstacionDeBomberosEn((int) puntoDeUnaTierra.getX(),
				(int) puntoDeUnaTierra.getY());

		MapaEdilicio mapaEdilicio = unJuego.getMapaEdilicio();
		assertFalse(mapaEdilicio.estaVacio());
		assertTrue(mapaEdilicio.tieneCoordenadaOcupada(
				(int) puntoDeUnaTierra.getX(), (int) puntoDeUnaTierra.getY()));
	}

	@Test
	public void testAgregarUnidadResidencialEnMapaCorrespondiente() {

		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		// Busca una coordenada con terreno valido para agregar la unidad
		// residencial
		Point puntoDeUnaTierra = mapaTerritorio
				.getPosicionDeUnaSuperficieDeTierra();

		unJuego.agregarUnidadResidencialEn((int) puntoDeUnaTierra.getX(),
				(int) puntoDeUnaTierra.getY());

		MapaEdilicio mapaEdilicio = unJuego.getMapaEdilicio();
		assertFalse(mapaEdilicio.estaVacio());
		assertTrue(mapaEdilicio.tieneCoordenadaOcupada(
				(int) puntoDeUnaTierra.getX(), (int) puntoDeUnaTierra.getY()));
	}

	@Test
	public void testAgregarUnidadIndustrialEnMapaCorrespondiente() {

		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		// Busca una coordenada con terreno valido para agregar la unidad
		// industrial
		Point puntoDeUnaTierra = mapaTerritorio
				.getPosicionDeUnaSuperficieDeTierra();

		unJuego.agregarUnidadIndustrialEn((int) puntoDeUnaTierra.getX(),
				(int) puntoDeUnaTierra.getY());

		MapaEdilicio mapaEdilicio = unJuego.getMapaEdilicio();
		assertFalse(mapaEdilicio.estaVacio());
		assertTrue(mapaEdilicio.tieneCoordenadaOcupada(
				(int) puntoDeUnaTierra.getX(), (int) puntoDeUnaTierra.getY()));
	}

	@Test
	public void testAgregarUnidadComercialEnMapaCorrespondiente() {

		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		// Busca una coordenada con terreno valido para agregar la unidad
		// comercial
		Point puntoDeUnaTierra = mapaTerritorio
				.getPosicionDeUnaSuperficieDeTierra();

		unJuego.agregarUnidadComercialEn((int) puntoDeUnaTierra.getX(),
				(int) puntoDeUnaTierra.getY());

		MapaEdilicio mapaEdilicio = unJuego.getMapaEdilicio();
		assertFalse(mapaEdilicio.estaVacio());
		assertTrue(mapaEdilicio.tieneCoordenadaOcupada(
				(int) puntoDeUnaTierra.getX(), (int) puntoDeUnaTierra.getY()));
	}

	/*
	 * @Test public void testAgregarLineaDeTensionEnMapaCorrespondiente(){
	 * 
	 * Juego unJuego = new Juego(); MapaTerritorio mapaTerritorio =
	 * unJuego.getMapaTerritorio(); //Busca una coordenada con terreno valido
	 * para agregar la linea de tension Point puntoDeUnaTierra =
	 * mapaTerritorio.getPosicionDeUnaSuperficieDeTierra();
	 * 
	 * unJuego.agregarLineaDeTensionEn((int)puntoDeUnaTierra.getX(),
	 * (int)puntoDeUnaTierra.getY());
	 * 
	 * MapaConexiones mapaLineasDeTension = unJuego.getMapaLineasDeTension();
	 * assertFalse(mapaLineasDeTension.estaVacio());
	 * assertTrue(mapaLineasDeTension
	 * .tieneCoordenadaOcupada((int)puntoDeUnaTierra.getX(),
	 * (int)puntoDeUnaTierra.getY())); }
	 * 
	 * 
	 * @Test public void testAgregarRutaEnMapaCorrespondiente(){
	 * 
	 * Juego unJuego = new Juego(); MapaTerritorio mapaTerritorio =
	 * unJuego.getMapaTerritorio(); //Busca una coordenada con terreno valido
	 * para agregar la ruta Point puntoDeUnaTierra =
	 * mapaTerritorio.getPosicionDeUnaSuperficieDeTierra();
	 * 
	 * unJuego.agregarRutaEn((int)puntoDeUnaTierra.getX(),
	 * (int)puntoDeUnaTierra.getY());
	 * 
	 * MapaConexiones mapaRutas = unJuego.getMapaRutas();
	 * assertFalse(mapaRutas.estaVacio());
	 * assertTrue(mapaRutas.tieneCoordenadaOcupada((int)puntoDeUnaTierra.getX(),
	 * (int)puntoDeUnaTierra.getY())); }
	 * 
	 * 
	 * @Test public void testAgregarTuberiaEnMapaCorrespondiente(){
	 * 
	 * Juego unJuego = new Juego(); MapaTerritorio mapaTerritorio =
	 * unJuego.getMapaTerritorio(); //Busca una coordenada con terreno valido
	 * para agregar la tuberia Point puntoDeUnaTierra =
	 * mapaTerritorio.getPosicionDeUnaSuperficieDeTierra();
	 * 
	 * unJuego.agregarTuberiaEn((int)puntoDeUnaTierra.getX(),
	 * (int)puntoDeUnaTierra.getY());
	 * 
	 * MapaConexiones mapaTuberias = unJuego.getMapaTuberias();
	 * assertFalse(mapaTuberias.estaVacio());
	 * assertTrue(mapaTuberias.tieneCoordenadaOcupada
	 * ((int)puntoDeUnaTierra.getX(), (int)puntoDeUnaTierra.getY())); }
	 */

}
