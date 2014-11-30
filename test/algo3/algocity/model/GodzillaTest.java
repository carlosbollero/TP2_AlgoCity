package algo3.algocity.model;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.junit.Test;

import algo3.algocity.model.catastrofes.CatastrofeGodzilla;
import algo3.algocity.model.mapas.MapaEdilicio;

public class GodzillaTest {
	
	int alto = 20;
	int ancho = 20;
	
	MapaEdilicio me;
	CatastrofeGodzilla g;

	@Test
	public void testSePuedeDaniarUnaUnidadResidencial() {
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		UnidadResidencial ur = new UnidadResidencial();
		
		ur.aceptar(g);
		
		assertEquals(ur.getSalud(), 0);
	}
	
	@Test
	public void testSePuedeDaniarUnaUnidadComercial() {
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		UnidadComercial uc = new UnidadComercial();
		
		uc.aceptar(g);
		
		assertEquals(uc.getSalud(), 25);
	}
	
	@Test
	public void testSePuedeDaniarUnaUnidadIndustrial() {
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		UnidadIndustrial ui = new UnidadIndustrial();
		
		ui.aceptar(g);
		
		assertEquals(ui.getSalud(), 60);
	}
	
	@Test
	public void testSePuedeDaniarUnaLineaDeTension() {
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		LineaTension l = new LineaTension();
		
		l.aceptar(g);
		
		assertEquals(l.estado(), false);
	}
	
	@Test
	public void testSePuedeDaniarUnaRuta() {
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		Ruta r = new Ruta();
		
		r.aceptar(g);
		
		assertEquals(r.estado(), false);
	}
	
	@Test
	public void testGodzillaGenerarUnCaminoRecto(){
		me = new MapaEdilicio(alto, ancho);
		g = new CatastrofeGodzilla(me);
		
		ArrayList<Point> camino = g.genCaminoRecto();
		
		boolean resultado = true;
		Point p;
		Point q;
		for (int i = 0; i < camino.size(); i++){
			p = camino.get(i);		
			if (i + 1 >= camino.size()){
				break;
			}
			q = camino.get(i + 1);			
			if (!((Math.abs(p.x - q.x) == 1) && (p.y == q.y))&&(!((p.x == q.x) && (Math.abs(p.y - q.y) == 1))&&!((Math.abs(p.x - q.x) == 1) && (Math.abs(p.y - q.y) == 1)))) {
				resultado = false;
			}
				
		}
		assertTrue(resultado);
		
	}
	

}
