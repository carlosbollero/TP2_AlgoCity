package algo3.algocity.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.LinkedList;

import org.junit.Test;

import algo3.algocity.model.catastrofes.CatastrofeGodzilla;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.NoSePuedeConstruirEnSuperficie;
import algo3.algocity.model.fabricas.FabricaTuberias;
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

	public void crearCaminoDeTuberias(Mapa mapa, Dinero dinero,
			Coordenada inicio, Coordenada fin)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, NoSePuedeConstruirEnSuperficie {
		System.out.print("[" + inicio.getX() + "," + inicio.getY() + "]");
		System.out.print("[" + fin.getX() + "," + fin.getY() + "]");
		System.out.println();
		for (int i = inicio.getX(); i != fin.getX();) {
			for (int j = inicio.getY(); j !=fin.getY();) {
				System.out.print("[" + i + "," + j + "]");
				mapa.agregar(new FabricaTuberias().construir(mapa, dinero,
						new Coordenada(i, j)));
				if (inicio.getY() < fin.getY()) {
					j++;
				} else {
					j--;
				}
			}
			if (inicio.getX() < fin.getX()) {
				i++;
			} else {
				i--;
			}
		}
		mapa.agregar(new FabricaTuberias().construir(mapa, dinero, fin));
	}

	@Test
	public void testSePuedeDaniarUnaUnidadEnergetica()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, NoSePuedeConstruirEnSuperficie,
			NoHayConexionConTuberias {
		Mapa m = new Mapa();
		
		Dinero d = new Dinero();
		Coordenada c1 = m.posicionConAgua();
//		System.out.println(c1.getX() + "," + c1.getY());
		Coordenada c2 = m.posicionConTierra();
//		System.out.println(c2.getX() + "," + c2.getY());
		PozoDeAgua p = new PozoDeAgua(m, d, c1);
		m.agregar(p);

		crearCaminoDeTuberias(m, d, c1, c2);

		SistemaElectrico s = new SistemaElectrico();
		UnidadEnergetica ue = new CentralEolica(m, d, s, c2);
		CatastrofeGodzilla g = new CatastrofeGodzilla(20, 20);
		m.agregar(ue);
		ue.addObserver(s);

		ue.aceptar(g);

		assertEquals(ue.getSalud(), 65, 0);
		assertEquals(s.capacidad, 65);
	}

}
