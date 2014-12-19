package algo3.algocity.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class ReparadorTest {

	@Test
	public void testReparadorAplicaAUnidadesCorrespondientes() {

		Mapa m = new Mapa();

		UnidadResidencial ur1 = new UnidadResidencial(new Coordenada(1, 1));
		UnidadComercial uc1 = new UnidadComercial(new Coordenada(1, 2));
		CentralEolica ce1 = new CentralEolica(new Coordenada(2, 3));
		CentralMinera cm1 = new CentralMinera(new Coordenada(3, 2));
		CentralNuclear cn1 = new CentralNuclear(new Coordenada(4, 1));
		UnidadResidencial ur2 = new UnidadResidencial(new Coordenada(10, 10));
		UnidadResidencial ur3 = new UnidadResidencial(new Coordenada(1, 4));
		UnidadIndustrial ui1 = new UnidadIndustrial(new Coordenada(5, 5));
		LineaTension lt = new LineaTension(new Coordenada(1, 1));
		Ruta rt = new Ruta(new Coordenada(1, 2));

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

		ur1.aplicarDanio(50);
		uc1.aplicarDanio(50);
		ce1.aplicarDanio(50);
		cm1.aplicarDanio(50);
		cn1.aplicarDanio(50);
		ur2.aplicarDanio(50);
		ur3.aplicarDanio(50);
		ui1.aplicarDanio(50);
		lt.aplicarDanio(50);
		rt.aplicarDanio(50);

		assertEquals(50, ur1.getSalud(), 0);
		assertEquals(50, uc1.getSalud(), 0);
		assertEquals(50, ce1.getSalud(), 0);
		assertEquals(50, cm1.getSalud(), 0);
		assertEquals(50, cn1.getSalud(), 0);
		assertEquals(50, ur2.getSalud(), 0);
		assertEquals(50, ur3.getSalud(), 0);
		assertEquals(50, ui1.getSalud(), 0);
		assertEquals(50, lt.getSalud(), 0);
		assertEquals(50, rt.getSalud(), 0);

		Reparador rep = new Reparador(m);
		rep.actuar();

		assertEquals(60, ur1.getSalud(), 0);
		assertEquals(57, uc1.getSalud(), 0);
		assertEquals(65, ce1.getSalud(), 0);
		assertEquals(60, cm1.getSalud(), 0);
		assertEquals(53, cn1.getSalud(), 0);
		assertEquals(60, ur2.getSalud(), 0);
		assertEquals(60, ur3.getSalud(), 0);
		assertEquals(53, ui1.getSalud(), 0);
		assertEquals(100, lt.getSalud(), 0);
		assertEquals(100, rt.getSalud(), 0);
	}

}
