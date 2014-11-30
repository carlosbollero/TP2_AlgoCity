package algo3.algocity.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import algo3.algocity.model.catastrofes.CatastrofeTerremoto;
import algo3.algocity.model.fabricas.FabricaUnidadResidencial;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.mapas.MapaEdilicio;

public class CatastrofeTerremotoTest {

	@Test
	public void testTerremotoAplicaDanioASuEpicentro() {
		MapaEdilicio me = new MapaEdilicio(10, 10);

		UnidadResidencial u1 = new UnidadResidencial(3, 3);

		me.agregar(u1, 3, 3);

		assertEquals(100, u1.getSalud(), 0);

		// Creacion de un terremoto con epicentro en (3,3)
		CatastrofeTerremoto catastrofe = new CatastrofeTerremoto(me, 3, 3);

		assertEquals(0, u1.getSalud(), 0);
	}

	@Test
	public void testTerremotoAplicaDanioCorrespondienteAUnidadesAlrededor() {
		MapaEdilicio me = new MapaEdilicio(10, 10);

		UnidadResidencial ur1 = new UnidadResidencial(1, 1);
		UnidadComercial uc1 = new UnidadComercial(1, 2);
		CentralEolica ce1 = new CentralEolica(2, 3);
		CentralMinera cm1 = new CentralMinera(3, 2);
		CentralNuclear cn1 = new CentralNuclear(4, 2);
		UnidadResidencial ur2 = new UnidadResidencial(10, 10);

		me.agregar(ur1, 1, 1);
		me.agregar(uc1, 1, 2);
		me.agregar(ce1, 2, 3);
		me.agregar(cm1, 3, 2);
		me.agregar(cn1, 4, 2);
		me.agregar(ur2, 10, 10);

		assertEquals(100, ur1.getSalud(), 0);
		assertEquals(100, uc1.getSalud(), 0);
		assertEquals(100, ce1.getSalud(), 0);
		assertEquals(100, cm1.getSalud(), 0);
		assertEquals(100, cn1.getSalud(), 0);
		assertEquals(100, ur2.getSalud(), 0);

		// Creacion de un terremoto con epicentro en (1,1)
		CatastrofeTerremoto catastrofe = new CatastrofeTerremoto(me, 1, 1);

		// Distancias calculadas por Pitagoras
		assertEquals(0, ur1.getSalud(), 0);
		assertEquals(1.5, uc1.getSalud(), 0);
		assertEquals(3.35, ce1.getSalud(), 0.1);
		assertEquals(3.35, cm1.getSalud(), 0.1);
		assertEquals(4.74, cn1.getSalud(), 0.1);
		assertEquals(19.09, ur2.getSalud(), 0.1);

	}

}
