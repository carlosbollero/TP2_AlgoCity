package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZonaResidencialTest {

	@Test
	public void testLaResidenciaCreadaEsValida() {
		
		ZonaResidencial r = new ZonaResidencial();
		
		assertEquals(5, r.getCosto());
		assertEquals(1, r.getArea());
		assertEquals(100, r.getCapacidad());
		assertEquals(0, r.getOcupacion());		
		assertEquals(1, r.getConsumo());
		assertEquals(0, r.getDanios());
	}

	@Test
	public void testLaResidenciaPuedeRecibirDanios(){
		ZonaResidencial r = new ZonaResidencial();
		
		r.aplicarDanio(50);
		
		assertEquals(50, r.getDanios());
	}
	
	@Test
	public void testLaResidenciaPuedeRecibirMasDeUnDanio(){
		ZonaResidencial r = new ZonaResidencial();
		
		r.aplicarDanio(25);
		r.aplicarDanio(50);
		
		assertEquals(75, r.getDanios());
	}
	
	@Test
	public void testLaResidenciaNoPuedeRecibirMasDe100DeDanio(){
		ZonaResidencial r = new ZonaResidencial();
		
		r.aplicarDanio(50);
		r.aplicarDanio(60);
		
		assertNotEquals(110, r.getDanios());
		assertEquals(100, r.getDanios());
	}
	
	@Test
	public void testSePuedeConsultarDisponibilidadAResidencia(){
		ZonaResidencial r = new ZonaResidencial();
		
		assertFalse(r.estaOcupada());
	}

}
