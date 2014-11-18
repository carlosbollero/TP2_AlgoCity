package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnidadTest {

	@Test
	public void testAplicarDanioAUnidadOcupable(){
		
		Edificador unEdificador = new Edificador();
		Reparable unaUnidadResidencial = unEdificador.construirUnidadResidencial();
		unaUnidadResidencial.aplicarDanio(100);
		assertEquals(0,unaUnidadResidencial.getSalud());
		
	}
	
	@Test
	public void testAplicarDanioAUnidadComercial() {

		Edificador unEdificador = new Edificador();
		Reparable unaUnidadComercial = unEdificador.construirUnidadComercial();
		unaUnidadComercial.aplicarDanio(50);
		assertEquals(50,unaUnidadComercial.getSalud());
	}
	
	@Test
	public void testAplicarDanioAUnidadEnergetica() {

		Edificador unEdificador = new Edificador();
		Reparable unaUnidadEnergetica = unEdificador.construirCentralEolica();
		unaUnidadEnergetica.aplicarDanio(50);
		assertEquals(50,unaUnidadEnergetica.getSalud());
	}
		
	
	
	
	
	
}
