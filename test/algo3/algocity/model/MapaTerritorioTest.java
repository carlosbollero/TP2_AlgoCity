package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.mapas.Coordenada;
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
				Coordenada p = new Coordenada(x, y);
				assertTrue(mt.superficie(p).esAgua()
						|| mt.superficie(p).esTierra());
			}
		}
	}
	
	/*Este test puede llegar a fallar en el caso particular que el mapa se cree
	 * sin ninguna posicion con agua*/
	@Test
	public void testSePuedeConsultarSuSePuedeConstruirEnUnaCoordenadaDeAgua(){
		mt = new MapaTerritorio(alto, ancho);
		
		Coordenada coord = mt.posicionConAgua();
		Unidad p = new PozoDeAgua(new Coordenada(mt.posicionConAgua().getX(), mt.posicionConAgua().getY()));
		
		assertTrue(mt.sePuedeConstruir(p));
		
		
		
	}
	
	

}
