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
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.fabricas.FabricaCentralEolica;
import algo3.algocity.model.fabricas.FabricaLineaTension;
import algo3.algocity.model.fabricas.FabricaPozoAgua;
import algo3.algocity.model.fabricas.FabricaRuta;
import algo3.algocity.model.fabricas.FabricaTuberias;
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
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			SuperficieInvalidaParaConstruir, CoordenadaInvalidaException {

		Mapa map = new Mapa();
		Dinero d = new Dinero();
		map.setTerritorioAguaParaTest();
		map.agregar(new FabricaPozoAgua().construir(map, d,
				new Coordenada(1, 1)));
		map.agregar(new FabricaTuberias().construir(map, d,
				new Coordenada(1, 1)));
		map.agregar(new FabricaTuberias().construir(map, d,
				new Coordenada(1, 2)));
		map.agregar(new FabricaTuberias().construir(map, d,
				new Coordenada(2, 2)));
		map.setTerritorioTierraParaTest();
		map.agregar(new FabricaCentralEolica().construir(map, d,
				new Coordenada(1, 2)));
		FabricaUnidadComercial fuc = new FabricaUnidadComercial();
		map.agregar(new FabricaRuta().construir(map, d, new Coordenada(2, 1)));

		UnidadComercial uc = fuc.construir(map, d, new Coordenada(2, 2));
		CatastrofeGodzilla god = new CatastrofeGodzilla(map);
		uc.agregarseA(map);
		uc.aceptar(god);

		assertEquals(uc.getSalud(), 25, 0);

	}

	@Test
	public void testSePuedeLlenarTodoElMapaDeUnidadesYGodzillaDestrulleAlgunasDeEllas()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, CoordenadaInvalidaException,
			SuperficieInvalidaParaConstruir {

		Mapa map = new Mapa();
		Dinero d = new Dinero();
		FabricaLineaTension flt = new FabricaLineaTension();
		map.setTerritorioTierraParaTest();
		for (int j = 0; j < map.tamanio(); j++) {
			for (int i = 0; i < map.tamanio(); i++) {
				Conector lt = flt.construir(map, d, new Coordenada(i, j));
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
