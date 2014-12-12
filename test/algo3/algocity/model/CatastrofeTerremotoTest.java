package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.catastrofes.CatastrofeTerremoto;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.EstacionDeBomberos;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class CatastrofeTerremotoTest {

	Mapa m;

	@Test
	public void testTerremotoAplicaDanioASuEpicentro() {
		m = new Mapa(10, 10);

		UnidadResidencial u1 = new UnidadResidencial(3, 3);

		m.agregar(u1);

		assertEquals(100, u1.getSalud(), 0);

		// Creacion de un terremoto con epicentro en (3,3)
		CatastrofeTerremoto catastrofe = new CatastrofeTerremoto(m, 3, 3);

		assertEquals(0, u1.getSalud(), 0);
	}

	@Test
	public void testTerremotoAplicaDanioCorrespondienteAUnidadesAlrededor() {
		m = new Mapa(10, 10);

		UnidadResidencial ur1 = new UnidadResidencial(1, 1);
		UnidadComercial uc1 = new UnidadComercial(1, 2);
		CentralEolica ce1 = new CentralEolica(2, 3);
		CentralMinera cm1 = new CentralMinera(3, 2);
		CentralNuclear cn1 = new CentralNuclear(4, 2);
		UnidadResidencial ur2 = new UnidadResidencial(10, 10);
		UnidadResidencial ur3 = new UnidadResidencial(1, 4);

		m.agregar(ur1);
		m.agregar(uc1);
		m.agregar(ur3);
		m.agregar(ce1);
		m.agregar(cm1);
		m.agregar(cn1);
		m.agregar(ur2);

		assertEquals(100, ur1.getSalud(), 0);
		assertEquals(100, uc1.getSalud(), 0);
		assertEquals(100, ce1.getSalud(), 0);
		assertEquals(100, cm1.getSalud(), 0);
		assertEquals(100, cn1.getSalud(), 0);
		assertEquals(100, ur2.getSalud(), 0);
		assertEquals(100, ur3.getSalud(), 0);

		// Creacion de un terremoto con epicentro en (1,1)
		CatastrofeTerremoto catastrofe = new CatastrofeTerremoto(m, 1, 1);

		assertEquals(0, ur1.getSalud(), 0);
		assertEquals(1.5, uc1.getSalud(), 0);
		assertEquals(3.0, ce1.getSalud(), 0.1);
		assertEquals(3.0, cm1.getSalud(), 0.1);
		assertEquals(4.5, cn1.getSalud(), 0.1);
		assertEquals(18.0, ur2.getSalud(), 0.1);
		assertEquals(4.5, ur3.getSalud(), 0.1);
	}

	@Test
	public void testTerremotoNoAplicaDanioAUnidadesNoDaniablesAlrededor() {
		m = new Mapa(10, 10);

		EstacionDeBomberos eb = new EstacionDeBomberos(1, 1);
		PozoDeAgua pa = new PozoDeAgua(2, 2);

		m.agregar(eb);
		m.agregar(pa);

		// Creacion de un terremoto con epicentro en (1,1)
		CatastrofeTerremoto catastrofe = new CatastrofeTerremoto(m, 1, 1);

		assertEquals(100, eb.getSalud(), 0);
		assertEquals(100, pa.getSalud(), 0);
	}

	@Test
	public void testTerremotoAplicaDanioAConectoresDaniablesAlrededor()
			throws NoSeCumplenLosRequisitosException {
		m = new Mapa(10, 10);
		m.setTerritorioTierraParaTest();

		LineaTension lt = new LineaTension(m, 3, 5);
		Ruta rt = new Ruta(m, 4, 5);

		assertEquals(100, lt.getSalud(), 0);
		assertEquals(100, rt.getSalud(), 0);

		CatastrofeTerremoto catastrofe = new CatastrofeTerremoto(m, 5, 5);

		assertEquals(3, lt.getSalud(), 0);
		assertEquals(1.5, rt.getSalud(), 0);
	}

}