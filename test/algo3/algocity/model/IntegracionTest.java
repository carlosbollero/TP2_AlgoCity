package algo3.algocity.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.catastrofes.CatastrofeGodzilla;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.fabricas.FabricaLineaTension;
import algo3.algocity.model.fabricas.FabricaUnidadComercial;
import algo3.algocity.model.mapas.Mapa;

public class IntegracionTest {

	int alto = 10;
	int ancho = 10;

	@Test
	public void testSePuedeAgregarUnaNuevaUnidadComercialAlMapaUsandoFabricasYDaniarla() {

		Mapa map = new Mapa();
		FabricaUnidadComercial fuc = new FabricaUnidadComercial();
		map.setTerritorioTierraParaTest();
		try {
			UnidadComercial uc = fuc.construir(map, 2, 2);
			CatastrofeGodzilla god = new CatastrofeGodzilla(map);
			uc.agregarseA(map);
			uc.aceptar(god);

			assertEquals(uc.getSalud(), 25, 0);

		} catch (NoSeCumplenLosRequisitosException e) {

		}
	}

	
//	HAY QUE MODIFICAR ESTE TEST
	@Test
	public void SePuedeLlenarTodoElMapaDeUnidadesYGodzillaDestrulleAlgunasDeEllastest() {

		int x = 10;
		int y = 50;

		Mapa map = new Mapa();
		FabricaLineaTension flt = new FabricaLineaTension();
		map.setTerritorioTierraParaTest();
		for (int j = 0; j < y; j++) {
			for (int i = 0; i < x; i++) {
				try {
					Conector lt = flt.construir(map, i, j);
					//lt.agregarseA(map);
					map.agregar(lt);
				} catch (NoSeCumplenLosRequisitosException e) {
					System.out.print(e);
				}

			}

		}

		CatastrofeGodzilla god = new CatastrofeGodzilla(map);

		ArrayList<Daniable> listaObjectivosGodzilla = map
				.getDaniablesEnElCaminoDe(god.generarCaminoRectoParaTests());
		god.actuar(listaObjectivosGodzilla);

		Iterator<Daniable> it = listaObjectivosGodzilla.iterator();
		while (it.hasNext()) {
			Daniable uni = it.next();

			System.out.println(uni.getSalud());
			assertEquals(uni.getSalud(), 0, 0);
		}
	}
}
