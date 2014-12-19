package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.catastrofes.CatastrofeTerremoto;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.fabricas.FabricaCentralEolica;
import algo3.algocity.model.fabricas.FabricaCentralMinera;
import algo3.algocity.model.fabricas.FabricaCentralNuclear;
import algo3.algocity.model.fabricas.FabricaConectores;
import algo3.algocity.model.fabricas.FabricaEnergetica;
import algo3.algocity.model.fabricas.FabricaEstacionDeBomberos;
import algo3.algocity.model.fabricas.FabricaLineaTension;
import algo3.algocity.model.fabricas.FabricaPozoAgua;
import algo3.algocity.model.fabricas.FabricaRuta;
import algo3.algocity.model.fabricas.FabricaTuberias;
import algo3.algocity.model.fabricas.FabricaUnidadComercial;
import algo3.algocity.model.fabricas.FabricaUnidadIndustrial;
import algo3.algocity.model.fabricas.FabricaUnidadResidencial;
import algo3.algocity.model.fabricas.FabricaUnidades;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class MapasIntegralTest {

	int alto = 10;
	int ancho = 20;

	FabricaUnidades fu;
	FabricaEnergetica fe;
	FabricaConectores fc;
	
	/*
	 * 
	 * HAY QUE CAMBIAR TODOS LOS CONSTRUCTORES
	 * TIENEN Q INCLUIR SISTEMAELECTRICO Y
	 * RECIBIR TIPO COORDENADA 
	 * 
	 */
	
	
	
	

	@Test
	public void testSeCreaUnidadResidencialSiCumpleConRequisitos()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException {
		Mapa m = new Mapa();
		Dinero dinero = new Dinero();
		m.setTerritorioTierraParaTest();

		// try {
		// CONSTRUYO UN POZO DE AGUA
		PozoDeAgua p = new PozoDeAgua(4, 2);
		m.agregar(p);

		// construyo red de tuberias
		fc = new FabricaTuberias();
		Conector t = fc.construir(m, 4, 2);
		m.agregar(t);
		t = fc.construir(m, 3, 2);
		m.agregar(t);
		t = fc.construir(m, 2, 2);
		m.agregar(t);

		// CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA
		fe = new FabricaCentralEolica();
		UnidadEnergetica ue = fe.construir(m, dinero, 2, 2);
		m.agregar(ue);

		assertTrue(m.contiene(ue));

		// CONSTRUYO LINEAS DE TENSION
		fc = new FabricaLineaTension();
		for (int i = 2; i <= 4; i++) {
			fc = new FabricaLineaTension();
			Conector lt = fc.construir(m, 2, i);
			m.agregar(lt);
			fc = new FabricaRuta();
			Conector r = fc.construir(m, 2, i);
			m.agregar(r);
		}

		// CONSTRUYO UNA UNIDAD RESIDENCIAL CONECTADA A LA CENTRAL
		// ENERGETICA
		fu = new FabricaUnidadResidencial();
		Unidad ur = fu.construir(m, dinero, 2, 4);
		m.agregar(ur);

		assertTrue(m.contiene(ur));

		// } catch (NoSeCumplenLosRequisitosException e) {
		// // System.out.println(e);
		// fail(e);
		// }
	}

	@Test
	public void testSelanzaExcepcionAlQuererConstruirindustriaYNoCumplirLosRequisitos()
			throws FondosInsuficientesException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();

		fu = new FabricaUnidadIndustrial();
		Coordenada p = m.posicionConTierra();

		try {
			Unidad u = fu.construir(m, d, p.getX(), p.getY());
			m.agregar(u);
			assertTrue(m.contiene(u));

		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}

	@Test
	public void testSelanzaExcepcionAlQuererConstruirResidenciaYNoCumplirLosRequisitos()
			throws FondosInsuficientesException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		fu = new FabricaUnidadResidencial();
		Coordenada p = m.posicionConTierra();

		try {
			Unidad u = fu.construir(m, d, p.getX(), p.getY());
			m.agregar(u);
			assertTrue(m.contiene(u));

		} catch (NoSeCumplenLosRequisitosException e) {
			assertNotNull(e);
			System.out.println(e.toString());
		}
	}

	@Test
	public void testAgregarPozoDeAguaSiCumpleConLosRequisitos()
			throws FondosInsuficientesException,
			NoSeCumplenLosRequisitosException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioAguaParaTest();

		fu = new FabricaPozoAgua();

		Coordenada p = m.posicionConAgua();

		PozoDeAgua u = (PozoDeAgua) fu.construir(m, d, p.getX(), p.getY());
		m.agregar(u);

		assertTrue(m.contiene(u));

	}

	@Test
	public void testAgregarEstacionDeBomberosSiCumpleConLosRequisitos()
			throws FondosInsuficientesException,
			NoSeCumplenLosRequisitosException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();

		fu = new FabricaEstacionDeBomberos();

		Coordenada p = m.posicionConTierra();

		Unidad u = fu.construir(m, d, p.getX(), p.getY());
		m.agregar(u);

		assertTrue(m.contiene(u));

	}

	@Test
	public void testAgregarCentralEolicaSiCumpleConLosRequisitos()
			throws FondosInsuficientesException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioTierraParaTest();
		PozoDeAgua pozo = new PozoDeAgua(1, 1);
		m.agregar(pozo);

		// CREAR RED DE TUBERIAS
		try {
			fc = new FabricaTuberias();
			for (int i = 0; i < 10; i++) {
				Conector tub = fc.construir(m, 1, 1 + i);
				m.agregar(tub);
			}

			// CREAR CENTRAL EOLICA
			fe = new FabricaCentralEolica();

			Unidad u = fe.construir(m, d, 1, 10);
			m.agregar(u);

			assertTrue(m.contiene(u));
		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}

	@Test
	public void testlasUnidadesDentroDelRadioDeUnaCentralEolicaEstanProvistasDeElectricidad()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioTierraParaTest();

		// CONSTRUYO UN POZO DE AGUA
		PozoDeAgua p = new PozoDeAgua(4, 2);
		m.agregar(p);

		// construyo red de tuberias
		fc = new FabricaTuberias();
		Conector t = fc.construir(m, 4, 2);
		m.agregar(t);
		t = fc.construir(m, 3, 2);
		m.agregar(t);
		t = fc.construir(m, 2, 2);
		m.agregar(t);

		fc = new FabricaRuta();
		Conector r = fc.construir(m, 4, 2);
		m.agregar(r);
		r = fc.construir(m, 3, 2);
		m.agregar(r);
		r = fc.construir(m, 2, 2);

		// CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA
		fe = new FabricaCentralEolica();
		UnidadEnergetica ue = fe.construir(m, d, 2, 2);
		m.agregar(ue);

		assertTrue(m.contiene(ue));

		// CONSTRUYO UNA UNIDAD RESIDENCIAL QUE DEBE TENER ELECTRICIDAD
		// POR ESTAR DENTRO DEL RADIO DE LA UNIDAD ENERGETICA
		fu = new FabricaUnidadResidencial();
		Unidad ur = fu.construir(m, d, 3, 2);
		m.agregar(ur);

		assertTrue(m.contiene(ur));
	}

	@Test
	public void testlasUnidadesDentroDelRadioDeUnaCentralMineraEstanProvistasDeElectricidad()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException {

		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioTierraParaTest();

		// CONSTRUYO UN POZO DE AGUA
		PozoDeAgua p = new PozoDeAgua(4, 2);
		m.agregar(p);

		// construyo red de tuberias
		fc = new FabricaTuberias();
		Conector t = fc.construir(m, 4, 2);
		m.agregar(t);
		t = fc.construir(m, 3, 2);
		m.agregar(t);
		t = fc.construir(m, 2, 2);
		m.agregar(t);
		t = fc.construir(m, 1, 2);
		m.agregar(t);

		fc = new FabricaRuta();
		Conector r = fc.construir(m, 4, 2);
		m.agregar(r);
		r = fc.construir(m, 3, 2);
		m.agregar(r);
		r = fc.construir(m, 2, 2);
		m.agregar(r);
		r = fc.construir(m, 1, 2);

		// CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA
		fe = new FabricaCentralMinera();
		UnidadEnergetica ue = fe.construir(m, d, 2, 2);
		m.agregar(ue);

		assertTrue(m.contiene(ue));

		// CONSTRUYO UNA UNIDAD RESIDENCIAL CONECTADA A LA CENTRAL
		// ENERGETICA
		fu = new FabricaUnidadResidencial();
		Unidad ur = fu.construir(m, d, 3, 2);
		m.agregar(ur);

		assertTrue(m.contiene(ur));
	}

	@Test
	public void testlasUnidadesDentroDelRadioDeUnaCentralNuclearEstanProvistasDeElectricidad()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException {

		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioTierraParaTest();

		// CONSTRUYO UN POZO DE AGUA
		PozoDeAgua p = new PozoDeAgua(4, 2);
		m.agregar(p);

		// construyo red de tuberias
		fc = new FabricaTuberias();
		Conector t = fc.construir(m, 4, 2);
		m.agregar(t);
		t = fc.construir(m, 3, 2);
		m.agregar(t);
		t = fc.construir(m, 2, 2);
		m.agregar(t);

		fc = new FabricaRuta();
		Conector r = fc.construir(m, 4, 2);
		m.agregar(r);
		r = fc.construir(m, 3, 2);
		m.agregar(r);
		r = fc.construir(m, 2, 2);

		// CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA
		fe = new FabricaCentralNuclear();
		UnidadEnergetica ue = fe.construir(m, d, 2, 2);
		m.agregar(ue);

		assertTrue(m.contiene(ue));

		// CONSTRUYO UNA UNIDAD RESIDENCIAL CONECTADA A LA CENTRAL
		// ENERGETICA
		fu = new FabricaUnidadComercial();
		Unidad uc = fu.construir(m, d, 3, 2);
		m.agregar(uc);

		assertTrue(m.contiene(uc));
	}

	@Test
	public void testSeDanianUnidadesDelMapaYElReparadorLasRepara()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioTierraParaTest();

		// CONSTRUYO UN POZO DE AGUA
		PozoDeAgua p = new PozoDeAgua(4, 2);
		m.agregar(p);

		// construyo red de tuberias
		fc = new FabricaTuberias();
		Conector t = fc.construir(m, 4, 2);
		m.agregar(t);
		t = fc.construir(m, 3, 2);
		m.agregar(t);
		t = fc.construir(m, 2, 2);
		m.agregar(t);
		t = fc.construir(m, 4, 3);
		m.agregar(t);
		t = fc.construir(m, 4, 4);
		m.agregar(t);

		// CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA
		fe = new FabricaCentralEolica();
		UnidadEnergetica ue = fe.construir(m, d, 2, 2);
		m.agregar(ue);

		assertTrue(m.contiene(ue));

		// CONSTRUYO LINEAS DE TENSION
		fc = new FabricaLineaTension();
		for (int i = 2; i <= 4; i++) {
			fc = new FabricaLineaTension();
			Conector lt = fc.construir(m, i, 2);
			m.agregar(lt);
			fc = new FabricaRuta();
			Conector r = fc.construir(m, i, 2);
			m.agregar(r);
		}
		assertEquals(100, ue.getSalud(), 0);

		// Danio a la central
		CatastrofeTerremoto ct = new CatastrofeTerremoto(m, 2, 2);

		assertEquals(0, ue.getSalud(), 0);

		// Reparo a la central
		fu = new FabricaEstacionDeBomberos();
		Unidad eb = fu.construir(m, d, 4, 4);
		m.agregar(eb);

		m.reparar();

		assertEquals(15, ue.getSalud(), 0);
	}

	/* Tests negativos */
	@Test
	public void testLasUnidadesNoSeAgreganSalvoQueSeCumplanLasCondiciones()
			throws FondosInsuficientesException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioAguaParaTest();

		try {
			/* tiran excepcion */
			fu = new FabricaUnidadResidencial();
			Unidad ur = fu.construir(m, d, 1, 1);
			fu = new FabricaUnidadIndustrial();
			Unidad ui = fu.construir(m, d, 1, 2);
			fu = new FabricaUnidadComercial();
			Unidad uc = fu.construir(m, d, 2, 1);

			fe = new FabricaCentralEolica();
			UnidadEnergetica ce = fe.construir(m, d, 2, 2);
			fe = new FabricaCentralMinera();
			UnidadEnergetica cm = fe.construir(m, d, 2, 3);
			fe = new FabricaCentralNuclear();
			UnidadEnergetica cn = fe.construir(m, d, 3, 2);

			fc = new FabricaLineaTension();
			Conector lt = fc.construir(m, 3, 3);
			fc = new FabricaRuta();
			Conector rt = fc.construir(m, 3, 4);

			/* no tira excepcion(pues territorio es agua) */
			fc = new FabricaTuberias();
			Conector tb = fc.construir(m, 4, 4);

			m.agregar(ur);
			m.agregar(uc);
			m.agregar(ui);
			m.agregar(ce);
			m.agregar(cm);
			m.agregar(cn);
			m.agregar(lt);
			m.agregar(rt);
			m.agregar(tb);

			assertFalse(m.contiene(ur));
			assertFalse(m.contiene(uc));
			assertFalse(m.contiene(ui));
			assertFalse(m.contiene(ce));
			assertFalse(m.contiene(cm));
			assertFalse(m.contiene(cn));

		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}

	}

}
