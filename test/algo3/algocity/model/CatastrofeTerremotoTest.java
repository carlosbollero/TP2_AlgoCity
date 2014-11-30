package algo3.algocity.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CatastrofeTerremotoTest {

	@Test
	public void testTerremotoAplicaDanioALasUnidadesDentroDeSuRadio() {
		MapaEdilicio me = new MapaEdilicio(10, 10);
		ArrayList<Mapa> mapas = new ArrayList<Mapa>();
		mapas.add(me);
		
		FabricaUnidadResidencial fabrica = new FabricaUnidadResidencial();
		UnidadResidencial u1 = (UnidadResidencial)fabrica.construir(mapas, 3, 3);
		UnidadResidencial u2 = (UnidadResidencial)fabrica.construir(mapas, 4, 3);

		me.agregar(u1, 3, 3);
		me.agregar(u2, 4, 3);
		
		
		assertEquals(100,u1.getSalud(),0);
		assertEquals(100,u2.getSalud(),0);
		
		CatastrofeTerremoto catastrofe = new CatastrofeTerremoto(me,3,3);
		
		assertEquals(0,u1.getSalud(),0);
		assertEquals(1.5,u2.getSalud(),0);
		
		

	}

}
