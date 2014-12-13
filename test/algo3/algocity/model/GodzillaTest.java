package algo3.algocity.model;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import algo3.algocity.model.catastrofes.CatastrofeGodzilla;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.mapas.MapaEdilicio;

public class GodzillaTest {
	
	int alto = 20;
	int ancho = 20;
	
	Mapa me;
	CatastrofeGodzilla g;

	@Test
	public void testSePuedeDaniarUnaUnidadResidencial() {
		me = new Mapa();
		CatastrofeGodzilla g = new CatastrofeGodzilla(20,20);
		UnidadResidencial ur = new UnidadResidencial(1,1);
		
		ur.aceptar(g);
		
		assertEquals(ur.getSalud(), 0, 0);
	}
	
	@Test
	public void testSePuedeDaniarUnaUnidadComercial() {
		me = new MapaEdilicio(alto, ancho);
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		UnidadComercial uc = new UnidadComercial(1,1);
		
		uc.aceptar(g);
		
		assertEquals(uc.getSalud(), 25, 0);
	}
	
	@Test
	public void testSePuedeDaniarUnaUnidadIndustrial() {
		me = new MapaEdilicio(alto, ancho);
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		UnidadIndustrial ui = new UnidadIndustrial(1,1);
		
		ui.aceptar(g);
		
		assertEquals(ui.getSalud(), 60, 0);
	}
	
	@Test
	public void testSePuedeDaniarUnaLineaDeTension() {
		me = new MapaEdilicio(alto, ancho);
		CatastrofeGodzilla g = new CatastrofeGodzilla(me);
		LineaTension l = new LineaTension();
		
		l.aceptar(g);
		
		assertEquals(l.estado(), false);
	}
	
	@Test
	public void testSePuedeDaniarUnaRuta() {
		me = new MapaEdilicio(alto, ancho);
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
