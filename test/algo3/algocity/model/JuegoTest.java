package algo3.algocity.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class JuegoTest {
	
			
	@Test
	public void testAgregarPozoDeAguaEnMapaCorrespondiente(){
		
		Juego unJuego = new Juego();
		MapaTerritorio mapaTerritorio = unJuego.getMapaTerritorio();
		int[] coordenadaDeUnAgua = mapaTerritorio.getPosicionDeUnaSuperficieDeAgua();	
		
		unJuego.agregarPozoDeAguaEn(coordenadaDeUnAgua[0], coordenadaDeUnAgua[1]);
		
		MapaEdilicio mapaEdilicio = unJuego.getMapaEdilicio();		
		assertFalse(mapaEdilicio.estaVacio());
		assertTrue(mapaEdilicio.tieneCoordenadaOcupada(coordenadaDeUnAgua[0], coordenadaDeUnAgua[1]));
	}
	
	
	
	
	
	
	
}
