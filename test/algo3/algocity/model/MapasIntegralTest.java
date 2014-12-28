package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.catastrofes.CatastrofeTerremoto;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
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
	 * HAY QUE CAMBIAR TODOS LOS CONSTRUCTORES TIENEN Q INCLUIR SISTEMAELECTRICO
	 * Y RECIBIR TIPO COORDENADA
	 */

	@Test
	public void testSeCreaUnidadResidencialSiCumpleConRequisitos()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, SuperficieInvalidaParaConstruir,
			NoHayConexionConTuberias, CapacidadElectricaInsuficienteException,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			CoordenadaInvalidaException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioTierraParaTest();

		// try {
		// CONSTRUYO UN POZO DE AGUA
		PozoDeAgua p = new PozoDeAgua(new Coordenada(4, 2));
		m.agregar(p);

		// construyo red de tuberias
		fc = new FabricaTuberias();
		Conector t = fc.construir(m, d, new Coordenada(4, 2));
		m.agregar(t);
		t = fc.construir(m, d, new Coordenada(3, 2));
		m.agregar(t);
		// t = fc.construir(m, d, new Coordenada(2, 2));
		// m.agregar(t);

		// CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA
		fe = new FabricaCentralEolica();
		UnidadEnergetica ue = fe.construir(m, d, new Coordenada(2, 2));
		m.agregar(ue);

		assertTrue(m.contiene(ue));

		// CONSTRUYO LINEAS DE TENSION
		fc = new FabricaLineaTension();
		for (int i = 2; i <= 4; i++) {
			fc = new FabricaLineaTension();
			Conector lt = fc.construir(m, d, new Coordenada(2, i));
			m.agregar(lt);
			fc = new FabricaRuta();
			Conector r = fc.construir(m, d, new Coordenada(2, i));
			m.agregar(r);
		}

		// CONSTRUYO UNA UNIDAD RESIDENCIAL CONECTADA A LA CENTRAL
		// ENERGETICA
		fu = new FabricaUnidadResidencial();
		Unidad ur = fu.construir(m, d, new Coordenada(2, 4));
		m.agregar(ur);

		assertTrue(m.contiene(ur));

		// } catch (NoSeCumplenLosRequisitosException e) {
		// // System.out.println(e);
		// fail(e);
		// }
	}

	@Test
	public void testSelanzaExcepcionAlQuererConstruirindustriaYNoCumplirLosRequisitos()
			throws FondosInsuficientesException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoSeCumplenLosRequisitosException,
			CoordenadaInvalidaException, SuperficieInvalidaParaConstruir {
		Mapa m = new Mapa();
		Dinero d = new Dinero();

		fu = new FabricaUnidadIndustrial();
		Coordenada p = m.posicionConTierra();

		try {
			Unidad u = fu.construir(m, d, p);
			m.agregar(u);
			assertTrue(m.contiene(u));
		} catch (NoHayConexionConRedElectrica er) {
			System.out.println(er);
		}
	}

	@Test
	public void testSelanzaExcepcionAlQuererConstruirResidenciaYNoCumplirLosRequisitos()
			throws FondosInsuficientesException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRedElectrica, NoSeCumplenLosRequisitosException,
			CoordenadaInvalidaException, SuperficieInvalidaParaConstruir {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		fu = new FabricaUnidadResidencial();
		Coordenada p = m.posicionConTierra();

		try {
			Unidad u = fu.construir(m, d, p);
			m.agregar(u);
			assertTrue(m.contiene(u));
		} catch (NoHayConexionConRutas er) {
			System.out.println(er);
		}
	}

	@Test
	public void testAgregarPozoDeAguaSiCumpleConLosRequisitos()
			throws FondosInsuficientesException,
			NoSeCumplenLosRequisitosException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			CoordenadaInvalidaException, SuperficieInvalidaParaConstruir {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioAguaParaTest();

		fu = new FabricaPozoAgua();

		Coordenada p = m.posicionConAgua();

		PozoDeAgua u = (PozoDeAgua) fu.construir(m, d, p);
		m.agregar(u);

		assertTrue(m.contiene(u));

	}

	@Test
	public void testAgregarEstacionDeBomberosSiCumpleConLosRequisitos()
			throws FondosInsuficientesException,
			NoSeCumplenLosRequisitosException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			CoordenadaInvalidaException, SuperficieInvalidaParaConstruir {
		Mapa m = new Mapa();
		Dinero d = new Dinero();

		fu = new FabricaEstacionDeBomberos();

		Coordenada p = m.posicionConTierra();

		Unidad u = fu.construir(m, d, p);
		m.agregar(u);

		assertTrue(m.contiene(u));

	}

	@Test
	public void testAgregarCentralEolicaSiCumpleConLosRequisitos()
			throws FondosInsuficientesException,
			NoSeCumplenLosRequisitosException, SuperficieInvalidaParaConstruir,
			NoHayConexionConTuberias, CoordenadaInvalidaException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioTierraParaTest();
		PozoDeAgua pozo = new PozoDeAgua(new Coordenada(1, 1));
		m.agregar(pozo);

		// CREAR RED DE TUBERIAS
		fc = new FabricaTuberias();
		for (int i = 0; i < 10; i++) {
			Conector tub = fc.construir(m, d, new Coordenada(1, 1 + i));
			m.agregar(tub);
		}

		// CREAR CENTRAL EOLICA
		fe = new FabricaCentralEolica();

		Unidad u = fe.construir(m, d, new Coordenada(1, 10));
		m.agregar(u);

		assertTrue(m.contiene(u));
	}

	@Test
	public void testlasUnidadesDentroDelRadioDeUnaCentralEolicaEstanProvistasDeElectricidad()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			SuperficieInvalidaParaConstruir, CoordenadaInvalidaException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioTierraParaTest();

		// CONSTRUYO UN POZO DE AGUA
		PozoDeAgua p = new PozoDeAgua(new Coordenada(4, 2));
		m.agregar(p);

		// construyo red de tuberias
		fc = new FabricaTuberias();
		Conector t = fc.construir(m, d, new Coordenada(4, 2));
		m.agregar(t);
		t = fc.construir(m, d, new Coordenada(3, 2));
		m.agregar(t);
		t = fc.construir(m, d, new Coordenada(2, 2));
		m.agregar(t);

		fc = new FabricaRuta();
		Conector r = fc.construir(m, d, new Coordenada(4, 2));
		m.agregar(r);
		r = fc.construir(m, d, new Coordenada(3, 2));
		m.agregar(r);
		r = fc.construir(m, d, new Coordenada(2, 2));

		// CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA
		fe = new FabricaCentralEolica();
		UnidadEnergetica ue = fe.construir(m, d, new Coordenada(2, 2));
		m.agregar(ue);

		assertTrue(m.contiene(ue));

		// CONSTRUYO UNA UNIDAD RESIDENCIAL QUE DEBE TENER ELECTRICIDAD
		// POR ESTAR DENTRO DEL RADIO DE LA UNIDAD ENERGETICA
		fu = new FabricaUnidadResidencial();
		Unidad ur = fu.construir(m, d, new Coordenada(3, 2));
		m.agregar(ur);

		assertTrue(m.contiene(ur));
	}

	@Test
	public void testlasUnidadesDentroDelRadioDeUnaCentralMineraEstanProvistasDeElectricidad()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			SuperficieInvalidaParaConstruir, CoordenadaInvalidaException {

		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioTierraParaTest();

		// CONSTRUYO UN POZO DE AGUA
		PozoDeAgua p = new PozoDeAgua(new Coordenada(4, 2));
		m.agregar(p);

		// construyo red de tuberias
		fc = new FabricaTuberias();
		Conector t = fc.construir(m, d, new Coordenada(4, 2));
		m.agregar(t);
		t = fc.construir(m, d, new Coordenada(3, 2));
		m.agregar(t);
		t = fc.construir(m, d, new Coordenada(2, 2));
		m.agregar(t);
		t = fc.construir(m, d, new Coordenada(1, 2));
		m.agregar(t);

		fc = new FabricaRuta();
		Conector r = fc.construir(m, d, new Coordenada(4, 2));
		m.agregar(r);
		r = fc.construir(m, d, new Coordenada(3, 2));
		m.agregar(r);
		r = fc.construir(m, d, new Coordenada(2, 2));
		m.agregar(r);
		r = fc.construir(m, d, new Coordenada(1, 2));

		// CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA
		fe = new FabricaCentralMinera();
		UnidadEnergetica ue = fe.construir(m, d, new Coordenada(2, 2));
		m.agregar(ue);

		assertTrue(m.contiene(ue));

		// CONSTRUYO UNA UNIDAD RESIDENCIAL CONECTADA A LA CENTRAL
		// ENERGETICA
		fu = new FabricaUnidadResidencial();
		Unidad ur = fu.construir(m, d, new Coordenada(3, 2));
		m.agregar(ur);

		assertTrue(m.contiene(ur));
	}

	@Test
	public void testlasUnidadesDentroDelRadioDeUnaCentralNuclearEstanProvistasDeElectricidad()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			SuperficieInvalidaParaConstruir, CoordenadaInvalidaException {

		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioTierraParaTest();

		// CONSTRUYO UN POZO DE AGUA
		PozoDeAgua p = new PozoDeAgua(new Coordenada(4, 2));
		m.agregar(p);

		// construyo red de tuberias
		fc = new FabricaTuberias();
		Conector t = fc.construir(m, d, new Coordenada(4, 2));
		m.agregar(t);
		t = fc.construir(m, d, new Coordenada(3, 2));
		m.agregar(t);
		t = fc.construir(m, d, new Coordenada(2, 2));
		m.agregar(t);

		fc = new FabricaRuta();
		Conector r = fc.construir(m, d, new Coordenada(4, 2));
		m.agregar(r);
		r = fc.construir(m, d, new Coordenada(3, 2));
		m.agregar(r);
		r = fc.construir(m, d, new Coordenada(2, 2));

		// CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA
		fe = new FabricaCentralNuclear();
		UnidadEnergetica ue = fe.construir(m, d, new Coordenada(2, 2));
		m.agregar(ue);

		assertTrue(m.contiene(ue));

		// CONSTRUYO UNA UNIDAD RESIDENCIAL CONECTADA A LA CENTRAL
		// ENERGETICA
		fu = new FabricaUnidadComercial();
		Unidad uc = fu.construir(m, d, new Coordenada(3, 2));
		m.agregar(uc);

		assertTrue(m.contiene(uc));
	}

	@Test
	public void testSeDanianUnidadesDelMapaYElReparadorLasRepara()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, SuperficieInvalidaParaConstruir,
			NoHayConexionConTuberias, CapacidadElectricaInsuficienteException,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			CoordenadaInvalidaException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		m.setTerritorioTierraParaTest();

		// CONSTRUYO UN POZO DE AGUA
		PozoDeAgua p = new PozoDeAgua(new Coordenada(4, 2));
		m.agregar(p);

		// construyo red de tuberias
		fc = new FabricaTuberias();
		Conector t = fc.construir(m, d, new Coordenada(4, 2));
		m.agregar(t);
		t = fc.construir(m, d, new Coordenada(3, 2));
		m.agregar(t);
		t = fc.construir(m, d, new Coordenada(2, 2));
		m.agregar(t);
		t = fc.construir(m, d, new Coordenada(4, 3));
		m.agregar(t);
		t = fc.construir(m, d, new Coordenada(4, 4));
		m.agregar(t);

		// CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA
		fe = new FabricaCentralEolica();
		UnidadEnergetica ue = fe.construir(m, d, new Coordenada(2, 2));
		m.agregar(ue);

		assertTrue(m.contiene(ue));

		// CONSTRUYO LINEAS DE TENSION
		fc = new FabricaLineaTension();
		for (int i = 2; i <= 4; i++) {
			fc = new FabricaLineaTension();
			Conector lt = fc.construir(m, d, new Coordenada(i, 2));
			m.agregar(lt);
			fc = new FabricaRuta();
			Conector r = fc.construir(m, d, new Coordenada(i, 2));
			m.agregar(r);
		}
		assertEquals(100, ue.getSalud(), 0);

		// Danio a la central
		CatastrofeTerremoto ct = new CatastrofeTerremoto(m, 2, 2);
		ct.iniciar();

		assertEquals(0, ue.getSalud(), 0);

		// Reparo a la central
		fu = new FabricaEstacionDeBomberos();
		Unidad eb = fu.construir(m, d, new Coordenada(4, 4));
		m.agregar(eb);

		m.reparar();

		assertEquals(15, ue.getSalud(), 0);
	}
}
