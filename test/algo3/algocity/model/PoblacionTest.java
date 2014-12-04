package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoblacionTest {

	@Test
	public void testSeCreaConEstadoValido() {
		Poblacion p = new Poblacion();

		assertEquals(0, p.getCantidad());
	}

	@Test
	public void testLaPoblacionPuedeCrecer() {
		Poblacion p = new Poblacion();

		assertTrue(p.getCantidad() == 0);

		p.aumentar();

		assertTrue(p.getCantidad() > 0);
	}
	
	@Test
	public void testLaPoblacionPuedeCrecerUnaCantidadFija() {
		Poblacion p = new Poblacion();

		assertTrue(p.getCantidad() == 0);

		p.aumentar(100);

		assertEquals(p.getCantidad(), 100);
	}

	@Test
	public void testLaPoblacionPuedeDecrecer() {
		Poblacion p = new Poblacion();

		assertTrue(p.getCantidad() == 0);

		p.aumentar();
		int referencia = p.getCantidad();

		assertTrue(referencia > 0);

		p.disminuir();

		assertTrue(p.getCantidad() < referencia);
	}
	
	@Test
	public void testLaPoblacionPuedeDecrecerUnaCantidadFija() {
		Poblacion p = new Poblacion();

		assertTrue(p.getCantidad() == 0);

		p.aumentar(100);

		assertEquals(p.getCantidad(), 100);
		
		p.disminuir(50);
		
		assertEquals(p.getCantidad(), 50);
	}

	@Test
	public void testLaPoblacionReaccionaAlPasoDeUnTurno() {
		Poblacion p = new Poblacion();
		Turno t = new Turno();
		
		t.iniciarHilo();
		t.addObserver(p);
		int referencia = p.getCantidad();

		assertTrue(referencia == 0);
		assertTrue(t.estaVivo());

		p.setIndice(1); 	//positivo crece
							//negativo decrece
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertTrue(p.getCantidad() > referencia);
		
	}
	
	@Test
	public void testLaPoblacionPuedeTenerEstadoCreciendo(){
		Poblacion p = new Poblacion();
		Turno t = new Turno();
		
		t.addObserver(p);
		int referencia = p.getCantidad();
		
		assertTrue(referencia == 0);
		
		p.setIndice(1);
		t.avanzar();
		
		System.out.println(p.getCantidad());
		assertTrue(p.getCantidad() > referencia);
	}
	
	@Test
	public void testLaPoblacionPuedeTenerEstadoDecreciendo(){
		Poblacion p = new Poblacion();
		Turno t = new Turno();
		
		t.addObserver(p);
		int referencia = p.getCantidad();
		
		assertTrue(referencia == 0);
		
		p.setIndice(-1);
		t.avanzar();
		
		System.out.println(p.getCantidad());
		assertTrue(p.getCantidad() < referencia);
	}
	
	@Test
	public void testLaPoblacionPuedeTenerEstadoEstable(){
		Poblacion p = new Poblacion();
		Turno t = new Turno();
		
		t.addObserver(p);
		int referencia = p.getCantidad();
		
		assertTrue(referencia == 0);
		
		p.setIndice(0);
		t.avanzar();
		
		System.out.println(p.getCantidad());
		assertTrue(p.getCantidad() == referencia);
	}
	
	@Test
	public void testLaPoblacionPuedeTenerTresEstados(){
		Poblacion p = new Poblacion();
		Turno t = new Turno();
		
		t.addObserver(p);
		int referencia = p.getCantidad();
		
		System.out.println(p.getCantidad());
		assertTrue(referencia == 0);
		
		p.setIndice(1);
		t.avanzar();
		
		System.out.println(p.getCantidad());
		assertTrue(p.getCantidad() > referencia);
		
		referencia = p.getCantidad();
		p.setIndice(-1);
		t.avanzar();
		
		System.out.println(p.getCantidad());
		assertTrue(p.getCantidad() < referencia);
		
	}

}
