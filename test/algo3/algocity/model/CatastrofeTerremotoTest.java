package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.catastrofes.CatastrofeTerremoto;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class CatastrofeTerremotoTest {

	Mapa m;

	@Test
	public void testTerremotoAplicaDanioASuEpicentro()
			throws CoordenadaInvalidaException {
		m = new Mapa();

		UnidadResidencial u1 = new UnidadResidencial(new Coordenada(3, 3));

		m.agregar(u1);

		assertEquals(100, u1.getSalud(), 0);

		// Creacion de un terremoto con epicentro en (3,3)
		CatastrofeTerremoto catastrofe = new CatastrofeTerremoto(m, 3, 3);
		catastrofe.iniciar();

		assertEquals(0, u1.getSalud(), 0);
	}

	@Test
	public void testTerremotoAplicaDanioCorrespondienteAUnidadesAlrededor()
			throws CoordenadaInvalidaException {
		m = new Mapa();

		UnidadResidencial ur1 = new UnidadResidencial(new Coordenada(1, 1));
		UnidadComercial uc1 = new UnidadComercial(new Coordenada(1, 2));
		UnidadEnergetica ce1 = new CentralEolica(new Coordenada(2, 3));
		CentralMinera cm1 = new CentralMinera(new Coordenada(3, 2));
		CentralNuclear cn1 = new CentralNuclear(new Coordenada(4, 2));
		UnidadResidencial ur2 = new UnidadResidencial(new Coordenada(10, 10));
		UnidadResidencial ur3 = new UnidadResidencial(new Coordenada(1, 4));
		UnidadIndustrial ui1 = new UnidadIndustrial(new Coordenada(5, 5));
		LineaTension lt = new LineaTension(new Coordenada(3, 1));
		Ruta rt = new Ruta(new Coordenada(4, 3));

		m.agregar(ur1);
		m.agregar(uc1);
		m.agregar(ur3);
		m.agregar(ce1);
		m.agregar(cm1);
		m.agregar(cn1);
		m.agregar(ur2);
		m.agregar(ui1);
		m.agregar(lt);
		m.agregar(rt);

		assertEquals(100, ur1.getSalud(), 0);
		assertEquals(100, uc1.getSalud(), 0);
		assertEquals(100, ce1.getSalud(), 0);
		assertEquals(100, cm1.getSalud(), 0);
		assertEquals(100, cn1.getSalud(), 0);
		assertEquals(100, ur2.getSalud(), 0);
		assertEquals(100, ur3.getSalud(), 0);
		assertEquals(100, ui1.getSalud(), 0);
		assertEquals(100, lt.getSalud(), 0);
		assertEquals(100, rt.getSalud(), 0);

		// Creacion de un terremoto con epicentro en (1,1)
		CatastrofeTerremoto catastrofe = new CatastrofeTerremoto(m, 1, 1);
		catastrofe.iniciar();

		assertEquals(0, ur1.getSalud(), 0);
		assertEquals(1.5, uc1.getSalud(), 0);
		assertEquals(3.0, ce1.getSalud(), 0.1);
		assertEquals(3.0, cm1.getSalud(), 0.1);
		assertEquals(4.5, cn1.getSalud(), 0.1);
		assertEquals(18.0, ur2.getSalud(), 0.1);
		assertEquals(4.5, ur3.getSalud(), 0.1);
		assertEquals(7.5, ui1.getSalud(), 0);
		assertEquals(3.0, lt.getSalud(), 0);
		assertEquals(4.5, rt.getSalud(), 0);

	}

	@Test
	public void testTerremotoAplicaDanioAConectoresDaniablesAlrededor()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, CoordenadaInvalidaException {
		Dinero d = new Dinero();
		m = new Mapa();
		m.setTerritorioTierraParaTest();

		LineaTension lt = new LineaTension(m, d, new Coordenada(3, 5));
		Ruta rt = new Ruta(m, d, new Coordenada(4, 5));
		m.agregar(lt);
		m.agregar(rt);

		assertEquals(100, lt.getSalud(), 0);
		assertEquals(100, rt.getSalud(), 0);

		CatastrofeTerremoto catastrofe = new CatastrofeTerremoto(m, 5, 5);
		catastrofe.iniciar();

		assertEquals(3, lt.getSalud(), 0);
		assertEquals(1.5, rt.getSalud(), 0);
	}

}