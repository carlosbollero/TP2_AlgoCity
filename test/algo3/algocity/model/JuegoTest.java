package algo3.algocity.model;

import static org.junit.Assert.*;


import org.junit.Test;

public class JuegoTest {
	
			
	
	@Test
	public void testSePuedeCrearUnJuegoValido(){
		
		Juego unJuego = new Juego();
		
		assertTrue(unJuego.getMapaEdilicio() instanceof MapaEdilicio);
		assertTrue(unJuego.getMapaTerritorio() instanceof MapaTerritorio);
		//assertTrue(unJuego.getMapaTuberias() instanceof MapaConexiones);
		//assertTrue(unJuego.getMapaRutas() instanceof MapaConexiones);
		//assertTrue(unJuego.getMapaLineasDeTension() instanceof MapaConexiones);
	}
	
	@Test
	public void testAgregarPozoDeAguaEnMapaCorrespondiente(){
		
		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		//Busca una coordenada con terreno valido para agregar el pozo de agua
		int[] coordenadaDeUnAgua = mapaTerritorio.getPosicionDeUnaSuperficieDeAgua();	
		
		unJuego.agregarPozoDeAguaEn(coordenadaDeUnAgua[0], coordenadaDeUnAgua[1]);
		
		MapaEdilicio mapaEdilicio = unJuego.getMapaEdilicio();		
		assertFalse(mapaEdilicio.estaVacio());
		assertTrue(mapaEdilicio.tieneCoordenadaOcupada(coordenadaDeUnAgua[0], coordenadaDeUnAgua[1]));
	}
	
	
	@Test
	public void testAgregarEstacionDeBomberosEnMapaCorrespondiente(){
		
		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		//Busca una coordenada con terreno valido para agregar la estacion de bomberos
		int[] coordenadaDeUnaTierra = mapaTerritorio.getPosicionDeUnaSuperficieDeTierra();	
		
		unJuego.agregarEstacionDeBomberosEn(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]);
		
		MapaEdilicio mapaEdilicio = unJuego.getMapaEdilicio();		
		assertFalse(mapaEdilicio.estaVacio());
		assertTrue(mapaEdilicio.tieneCoordenadaOcupada(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]));
	}
	
	
	@Test
	public void testAgregarUnidadResidencialEnMapaCorrespondiente(){

		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		//Busca una coordenada con terreno valido para agregar la unidad residencial
		int[] coordenadaDeUnaTierra = mapaTerritorio.getPosicionDeUnaSuperficieDeTierra();	
		
		unJuego.agregarUnidadResidencialEn(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]);
		
		MapaEdilicio mapaEdilicio = unJuego.getMapaEdilicio();		
		assertFalse(mapaEdilicio.estaVacio());
		assertTrue(mapaEdilicio.tieneCoordenadaOcupada(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]));
	}
	
	
	@Test
	public void testAgregarUnidadIndustrialEnMapaCorrespondiente(){

		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		//Busca una coordenada con terreno valido para agregar la unidad industrial
		int[] coordenadaDeUnaTierra = mapaTerritorio.getPosicionDeUnaSuperficieDeTierra();	
		
		unJuego.agregarUnidadIndustrialEn(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]);
		
		MapaEdilicio mapaEdilicio = unJuego.getMapaEdilicio();		
		assertFalse(mapaEdilicio.estaVacio());
		assertTrue(mapaEdilicio.tieneCoordenadaOcupada(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]));
	}
	
	
	@Test
	public void testAgregarUnidadComercialEnMapaCorrespondiente(){

		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		//Busca una coordenada con terreno valido para agregar la unidad comercial
		int[] coordenadaDeUnaTierra = mapaTerritorio.getPosicionDeUnaSuperficieDeTierra();	
		
		unJuego.agregarUnidadComercialEn(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]);
		
		MapaEdilicio mapaEdilicio = unJuego.getMapaEdilicio();		
		assertFalse(mapaEdilicio.estaVacio());
		assertTrue(mapaEdilicio.tieneCoordenadaOcupada(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]));
	}
	
	
	/*Pendiente hasta que se termine de implementar MapaConexiones
	@Test
	public void testAgregarLineaDeTensionEnMapaCorrespondiente(){
		
		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		//Busca una coordenada con terreno valido para agregar la linea de tension
		int[] coordenadaDeUnaTierra = mapaTerritorio.getPosicionDeUnaSuperficieDeTierra();	
		
		unJuego.agregarLineaDeTensionEn(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]);
		
		MapaConexiones mapaLineasDeTension = unJuego.getMapaLineasDeTension();
		assertFalse(mapaLineasDeTension.estaVacio());
		assertTrue(mapaLineasDeTension.tieneCoordenadaOcupada(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]));
	}
	
	
	@Test
	public void testAgregarRutaEnMapaCorrespondiente(){

		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		//Busca una coordenada con terreno valido para agregar la ruta
		int[] coordenadaDeUnaTierra = mapaTerritorio.getPosicionDeUnaSuperficieDeTierra();	
		
		unJuego.agregarRutaEn(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]);
		
		MapaConexiones mapaRutas = unJuego.getMapaRutas();
		assertFalse(mapaRutas.estaVacio());
		assertTrue(mapaRutas.tieneCoordenadaOcupada(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]));
		
	}
	
	
	@Test
	public void testAgregarTuberiaEnMapaCorrespondiente(){
		
		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		//Busca una coordenada con terreno valido para agregar la tuberia
		int[] coordenadaDeUnaTierra = mapaTerritorio.getPosicionDeUnaSuperficieDeAgua();	
		
		unJuego.agregarTuberiaEn(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]);
		
		MapaConexiones mapaTuberias = unJuego.getMapaTuberias();
		assertFalse(mapaTuberias.estaVacio());
		assertTrue(mapaTuberias.tieneCoordenadaOcupada(coordenadaDeUnaTierra[0], coordenadaDeUnaTierra[1]));	
	}
	*/
	
	
}
