package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class GodzillaTest {

	@Test
	public void testSePuedeDaniarUnaUnidadResidencial() {
		CatastrofeGodzilla g = new CatastrofeGodzilla();
		UnidadResidencial ur = new UnidadResidencial();
		
		ur.aceptar(g);
		
		assertEquals(ur.getSalud(), 0);
	}
	
	@Test
	public void testSePuedeDaniarUnaUnidadComercial() {
		CatastrofeGodzilla g = new CatastrofeGodzilla();
		UnidadComercial uc = new UnidadComercial();
		
		uc.aceptar(g);
		
		assertEquals(uc.getSalud(), 25);
	}
	
	@Test
	public void testSePuedeDaniarUnaUnidadIndustrial() {
		CatastrofeGodzilla g = new CatastrofeGodzilla();
		UnidadIndustrial ui = new UnidadIndustrial();
		
		ui.aceptar(g);
		
		assertEquals(ui.getSalud(), 60);
	}
	
	@Test
	public void testSePuedeDaniarUnaLineaDeTension() {
		CatastrofeGodzilla g = new CatastrofeGodzilla();
		LineaTension l = new LineaTension();
		
		l.aceptar(g);
		
		assertEquals(l.estado(), false);
	}
	
	@Test
	public void testSePuedeDaniarUnaRuta() {
		CatastrofeGodzilla g = new CatastrofeGodzilla();
		Ruta r = new Ruta();
		
		r.aceptar(g);
		
		assertEquals(r.estado(), false);
	}

}
