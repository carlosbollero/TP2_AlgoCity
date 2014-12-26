package algo3.algocity.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.catastrofes.CatastrofeGodzilla;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.fabricas.FabricaTuberias;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class GodzillaTest {

	Mapa me;
	CatastrofeGodzilla g;

	@Test
	public void testSePuedeDaniarUnaUnidadResidencial() {

		me = new Mapa();
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		UnidadResidencial ur = new UnidadResidencial(new Coordenada(1, 1));

		ur.aceptar(g);

		assertEquals(ur.getSalud(), 0, 0);
	}

	@Test
	public void testSePuedeDaniarUnaUnidadComercial() {
		me = new Mapa();
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		Daniable uc = new UnidadComercial(new Coordenada(1, 1));

		uc.aceptar(g);

		assertEquals(uc.getSalud(), 25, 0);
	}

	@Test
	public void testSePuedeDaniarUnaUnidadIndustrial() {
		me = new Mapa();
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		UnidadIndustrial ui = new UnidadIndustrial(new Coordenada(1, 1));

		ui.aceptar(g);

		assertEquals(ui.getSalud(), 60, 0);
	}

	@Test
	public void testSePuedeDaniarUnaLineaDeTension() {
		me = new Mapa();
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		LineaTension l = new LineaTension();

		l.aceptar(g);

		assertEquals(l.estado(), false);
	}

	@Test
	public void testSePuedeDaniarUnaRuta() {
		me = new Mapa();
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		Ruta r = new Ruta();

		r.aceptar(g);

		assertEquals(r.estado(), false);
	}

	@Test
	public void testGodzillaGenerarUnCaminoRecto() {
		me = new Mapa();
		g = new CatastrofeGodzilla(me);

		LinkedList<Coordenada> camino = g.genCaminoRecto();

		boolean resultado = true;
		Coordenada p;
		Coordenada q;
		for (int i = 0; i < camino.size(); i++) {
			p = camino.get(i);
			if (i + 1 >= camino.size()) {
				break;
			}
			q = camino.get(i + 1);
			if (!((Math.abs(p.getX() - q.getX()) == 1) && (p.getY() == q.getY()))
					&& (!((p.getX() == q.getX()) && (Math.abs(p.getY()
							- q.getY()) == 1)) && !((Math.abs(p.getX()
							- q.getX()) == 1) && (Math.abs(p.getY() - q.getY()) == 1)))) {
				resultado = false;
			}
		}
		assertTrue(resultado);
	}

	@Test
	public void testSePuedeDaniarUnaUnidadEnergetica()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, SuperficieInvalidaParaConstruir,
			NoHayConexionConTuberias, CoordenadaInvalidaException {
		Mapa m = new Mapa();

		Dinero d = new Dinero();
		m.setTerritorioAguaParaTest();
		PozoDeAgua p = new PozoDeAgua(m, d, new Coordenada(1, 1));
		m.agregar(p);

		m.setTerritorioTierraParaTest();

		m.agregar(new FabricaTuberias().construir(m, d, new Coordenada(1, 1)));
		m.agregar(new FabricaTuberias().construir(m, d, new Coordenada(1, 2)));
		m.agregar(new FabricaTuberias().construir(m, d, new Coordenada(1, 3)));

		UnidadEnergetica ue = new CentralEolica(m, d, new Coordenada(1, 3));
		CatastrofeGodzilla g = new CatastrofeGodzilla(m);
		m.agregar(ue);
		ue.addObserver(m.sistemaElectrico());

		ue.aceptar(g);

		assertEquals(ue.getSalud(), 65, 0);
		assertEquals(m.sistemaElectrico().capacidad(), 65);
	}

	@Test
	public void testSePuedeDaniarUnaCentralMinera()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, SuperficieInvalidaParaConstruir,
			NoHayConexionConTuberias, CoordenadaInvalidaException {
		Mapa m = new Mapa();

		Dinero d = new Dinero();
		m.setTerritorioAguaParaTest();
		PozoDeAgua p = new PozoDeAgua(m, d, new Coordenada(1, 1));
		m.agregar(p);

		m.setTerritorioTierraParaTest();

		m.agregar(new FabricaTuberias().construir(m, d, new Coordenada(1, 1)));
		m.agregar(new FabricaTuberias().construir(m, d, new Coordenada(1, 2)));
		m.agregar(new FabricaTuberias().construir(m, d, new Coordenada(1, 3)));

		UnidadEnergetica ue = new CentralMinera(m, d, new Coordenada(1, 3));
		CatastrofeGodzilla g = new CatastrofeGodzilla(m);
		m.agregar(ue);
		ue.addObserver(m.sistemaElectrico());

		ue.aceptar(g);

		assertEquals(ue.getSalud(), 65, 0);
		assertEquals(m.sistemaElectrico().capacidad(), 260);
	}

}
