package algo3.algocity.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.mapas.MapaTerritorio;

public class MapaTerritorioTest {

	int alto = 10;
	int ancho = 10;
	MapaTerritorio mt;

	@Test
	public void testTerritorioSeCreaConEstadoValido() {
		mt = new MapaTerritorio(alto, ancho);
		

		for (int x = 0; x < alto; x++) {
			for (int y = 0; y < ancho; y++) {
				Point p = new Point(x, y);
				assertTrue(mt.superficie(p).esAgua()
						|| mt.superficie(p).esTierra());
			}

		}
	}
	
	@Test
	public void testSePuedeConsultarSuSePuedeConstruirEnUnaCoordenadaDeAgua(){
		mt = new MapaTerritorio(alto, ancho);
		
		Point coord = mt.posicionConAgua();
		Unidad p = new PozoDeAgua(coord.x, coord.y);
		
		assertTrue(mt.sePuedeConstruir(p));
		
		
		
	}
	
	

}
