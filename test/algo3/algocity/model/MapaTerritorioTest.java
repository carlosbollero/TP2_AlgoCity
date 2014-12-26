package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.MapaTerritorio;

public class MapaTerritorioTest {

	int tamanio = 10;
	MapaTerritorio mt;

	@Test
	public void testTerritorioSeCreaConEstadoValido() {
		mt = new MapaTerritorio(tamanio);
		

		for (int x = 0; x < tamanio; x++) {
			for (int y = 0; y < tamanio; y++) {
				Coordenada p = new Coordenada(x, y);
				assertTrue(mt.superficie(p).esAgua()
						|| mt.superficie(p).esTierra());
			}
		}
	}
	
	/*Este test puede llegar a fallar en el caso particular que el mapa se cree
	 * sin ninguna posicion con agua*/
	@Test
	public void testSePuedeConsultarSuSePuedeConstruirEnUnaCoordenadaDeAgua()
			throws SuperficieInvalidaParaConstruir {
		mt = new MapaTerritorio(tamanio);
		
		Coordenada coord = mt.posicionConAgua();
		Unidad p = new PozoDeAgua(new Coordenada(coord.getX(), coord.getY()));
		
		assertTrue(mt.sePuedeConstruir(p));
		
		
		
	}
	
	

}
