package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZonaResidencialTest {

	
/**Prueba modificacion test**/
	
	@Test
	public void testLaResidenciaCreadaEsValida() {
		
		UnidadResidencial r = new UnidadResidencial();
		
		assertEquals(5, r.getCosto());
		assertEquals(1, r.getArea());
		assertEquals(100, r.getCapacidad());
		assertEquals(0, r.getOcupacion());		
		assertEquals(1, r.getConsumo());
		assertEquals(0, r.getDanios());
	}

	@Test
	public void testLaResidenciaPuedeRecibirDanios(){
		UnidadResidencial r = new UnidadResidencial();
		
		r.aplicarDanio(50);
		
		assertEquals(50, r.getDanios());
	}
	
	@Test
	public void testLaResidenciaPuedeRecibirMasDeUnDanio(){
		UnidadResidencial r = new UnidadResidencial();
		
		r.aplicarDanio(25);
		r.aplicarDanio(50);
		
		assertEquals(75, r.getDanios());
	}
	
	@Test
	public void testLaResidenciaNoPuedeRecibirMasDe100DeDanio(){
		UnidadResidencial r = new UnidadResidencial();
		
		r.aplicarDanio(50);
		r.aplicarDanio(60);
		
		assertNotEquals(110, r.getDanios());
		assertEquals(100, r.getDanios());
	}
	
	@Test
	public void testSePuedeSaberSiUnaResidenciaEstaOcupada(){
		UnidadResidencial r = new UnidadResidencial();
		Ocupable o = r;
		
		
		assertFalse(r.estaOcupada());
		
		o.agregar(100);
		
		assertTrue(r.estaOcupada());
	}
	
	@Test
	public void testSePuedeConsultarDisponibilidadAResidencia(){
		UnidadResidencial r = new UnidadResidencial();
		Ocupable o = r;
		
		o.agregar(48);
		
		assertEquals(52, r.consultarDisponibilidad());
	}

}
