package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnidadResidencialTest {

	
	
	@Test
	public void testLaResidenciaCreadaEsValida() {
		
		UnidadOcupable r = new UnidadResidencial();
		
		assertEquals(5, r.getCosto());
		assertEquals(1, r.getArea());
		assertEquals(100, r.getCapacidad());
		assertEquals(0, r.getOcupacion());		
		assertEquals(1, r.getConsumo());
		assertEquals(0, r.getDanios());
	}

	@Test
	public void testLaResidenciaPuedeRecibirDanios(){
		UnidadOcupable r = new UnidadResidencial();
		
		r.aplicarDanio(50);
		
		assertEquals(50, r.getDanios());
	}
	
	@Test
	public void testLaResidenciaPuedeRecibirMasDeUnDanio(){
		UnidadOcupable r = new UnidadResidencial();
		
		r.aplicarDanio(25);
		r.aplicarDanio(50);
		
		assertEquals(75, r.getDanios());
	}
	
	@Test
	public void testLaResidenciaNoPuedeRecibirMasDe100DeDanio(){
		UnidadOcupable r = new UnidadResidencial();
		
		r.aplicarDanio(50);
		r.aplicarDanio(60);
		
		assertNotEquals(110, r.getDanios());
		assertEquals(100, r.getDanios());
	}
	
	@Test
	public void testSePuedeSaberSiUnaResidenciaEstaOcupada(){
		Ocupable r = new UnidadResidencial();
		Ocupable o = r;
		
		
		assertFalse(r.estaOcupada());
		
		for (int i = 0; i < 25; i++){
			o.agregar();
		}		
		
		assertTrue(r.estaOcupada());
	}
	
	@Test
	public void testSePuedeConsultarDisponibilidadAResidencia(){
		Ocupable r = new UnidadResidencial();
		Ocupable o = r;
		
		//numero arbitrario
		for (int i = 0; i < 12; i++){
			o.agregar();
		}		
		
		assertEquals(52, r.consultarDisponibilidad());
	}

}
