package algo3.algocity.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.catastrofes.CatastrofeGodzilla;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.fabricas.FabricaLineaTension;
import algo3.algocity.model.fabricas.FabricaUnidadComercial;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class IntegracionTest {

	int alto = 10;
	int ancho = 10;

	@Test
	public void testSePuedeAgregarUnaNuevaUnidadComercialAlMapaUsandoFabricasYDaniarla()
			throws FondosInsuficientesException,
			NoSeCumplenLosRequisitosException,
			CapacidadElectricaInsuficienteException {

		Mapa map = new Mapa();
		Dinero d = new Dinero();
		SistemaElectrico s = new SistemaElectrico();
		FabricaUnidadComercial fuc = new FabricaUnidadComercial();
		map.setTerritorioTierraParaTest();
		UnidadComercial uc = fuc.construir(map, d, s, new Coordenada(2, 2));
		CatastrofeGodzilla god = new CatastrofeGodzilla(map);
		uc.agregarseA(map);
		uc.aceptar(god);

		assertEquals(uc.getSalud(), 25, 0);

	}

	@Test
	public void SePuedeLlenarTodoElMapaDeUnidadesYGodzillaDestrulleAlgunasDeEllastest() throws NoSeCumplenLosRequisitosException{

		Mapa map = new Mapa();
		Dinero d = new Dinero();
		FabricaLineaTension flt = new FabricaLineaTension();
		map.setTerritorioTierraParaTest();
		for (int j = 0; j < map.ancho(); j++) {
			for (int i = 0; i < map.alto(); i++) {
				Conector lt = flt.construir(map, new Coordenada(i, j));
				map.agregar(lt);				
			}
		}

		CatastrofeGodzilla god = new CatastrofeGodzilla(map);

		ArrayList<Daniable> listaObjectivosGodzilla = map
				.getDaniablesEnElCaminoDe(god.generarCaminoRectoParaTests());
		god.actuar(listaObjectivosGodzilla);

		Iterator<Daniable> it = listaObjectivosGodzilla.iterator();
		while (it.hasNext()) {
			Daniable uni = it.next();
			assertEquals(uni.getSalud(), 0, 0);
		}
	}
}
