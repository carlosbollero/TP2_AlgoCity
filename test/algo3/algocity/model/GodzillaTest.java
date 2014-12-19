package algo3.algocity.model;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.LinkedList;

import org.junit.Test;

import algo3.algocity.model.catastrofes.CatastrofeGodzilla;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class GodzillaTest {

	int alto = 10;
	int ancho = 10;

	Mapa me;
	CatastrofeGodzilla g;

	@Test
	public void testSePuedeDaniarUnaUnidadResidencial() {

		me = new Mapa();
		CatastrofeGodzilla g = new CatastrofeGodzilla(20, 20);
		UnidadResidencial ur = new UnidadResidencial(new Coordenada(1, 1));

		ur.aceptar(g);

		assertEquals(ur.getSalud(), 0, 0);
	}

	@Test
	public void testSePuedeDaniarUnaUnidadComercial() {
		me = new Mapa();
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		UnidadComercial uc = new UnidadComercial(new Coordenada(1, 1));

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

		LinkedList<Point> camino = g.genCaminoRecto();

		boolean resultado = true;
		Point p;
		Point q;
		for (int i = 0; i < camino.size(); i++) {
			p = camino.get(i);
			if (i + 1 >= camino.size()) {
				break;
			}
			q = camino.get(i + 1);
			if (!((Math.abs(p.x - q.x) == 1) && (p.y == q.y))
					&& (!((p.x == q.x) && (Math.abs(p.y - q.y) == 1)) && !((Math
							.abs(p.x - q.x) == 1) && (Math.abs(p.y - q.y) == 1)))) {
				resultado = false;
			}
		}
		assertTrue(resultado);
	}

}
