package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.catastrofes.CatastrofeTerremoto;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Mapa;

public class CatastrofeTerremotoTest {
	
	Mapa m;

	@Test
	public void testTerremotoAplicaDanioASuEpicentro() {
		m = new Mapa(10, 10);

		UnidadResidencial u1 = new UnidadResidencial(3, 3);

		m.agregar(u1, 3, 3);

		assertEquals(100, u1.getSalud(), 0);

		// Creacion de un terremoto con epicentro en (3,3)
		CatastrofeTerremoto catastrofe = new CatastrofeTerremoto(m, 3, 3);

		assertEquals(0, u1.getSalud(), 0);
	}

	@Test
	public void testTerremotoAplicaDanioCorrespondienteAUnidadesAlrededor() {
		m  = new Mapa(10, 10);

		UnidadResidencial ur1 = new UnidadResidencial(1, 1);
		UnidadComercial uc1 = new UnidadComercial(1, 2);
		CentralEolica ce1 = new CentralEolica(2, 3);
		CentralMinera cm1 = new CentralMinera(3, 2);
		CentralNuclear cn1 = new CentralNuclear(4, 2);
		UnidadResidencial ur2 = new UnidadResidencial(10, 10);
		UnidadResidencial ur3 = new UnidadResidencial(1, 4);

		m.agregar(ur1, 1, 1);
		m.agregar(uc1, 1, 2);
		m.agregar(ur3, 1, 4);
		m.agregar(ce1, 2, 3);
		m.agregar(cm1, 3, 2);
		m.agregar(cn1, 4, 2);
		m.agregar(ur2, 10, 10);

		assertEquals(100, ur1.getSalud(), 0);
		assertEquals(100, uc1.getSalud(), 0);
		assertEquals(100, ce1.getSalud(), 0);
		assertEquals(100, cm1.getSalud(), 0);
		assertEquals(100, cn1.getSalud(), 0);
		assertEquals(100, ur2.getSalud(), 0);
		assertEquals(100, ur3.getSalud(), 0);

		// Creacion de un terremoto con epicentro en (1,1)
		CatastrofeTerremoto catastrofe = new CatastrofeTerremoto(m, 1, 1);

		// Distancias calculadas por Pitagoras
		assertEquals(0, ur1.getSalud(), 0);
		assertEquals(1.5, uc1.getSalud(), 0);
		assertEquals(3.35, ce1.getSalud(), 0.1);
		assertEquals(3.35, cm1.getSalud(), 0.1);
		assertEquals(4.74, cn1.getSalud(), 0.1);
		assertEquals(19.09, ur2.getSalud(), 0.1);
		assertEquals(4.5, ur3.getSalud(), 0.1);
	}

}