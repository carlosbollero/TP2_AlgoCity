package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnidadZonalTest {

	@Test
	public void testUnidadComercialTieneCostoValido() {
		
		assertEquals(5,UnidadComercial.COSTO);
		
		UnidadComercial unaUnidadComercial = new UnidadComercial();
		assertEquals(5,unaUnidadComercial.getCosto());
	}
	
	@Test
	public void testUnidadIndustrialTieneCostoValido() {
		
		assertEquals(10,UnidadIndustrial.COSTO);
		
		UnidadIndustrial unaUnidadIndustrial = new UnidadIndustrial();
		assertEquals(10,unaUnidadIndustrial.getCosto());
	}
	
	@Test
	public void testUnidadResidenciallTieneCostoValido() {
		
		assertEquals(5,Ocupable.COSTO);
		
		Ocupable unaUnidadResidencial = new UnidadResidencial();
		assertEquals(5,unaUnidadResidencial.getCosto());
	}
	
	@Test
	public void testUnidadComercialTieneConsumoValido() {
		
		UnidadComercial unaUnidadComercial = new UnidadComercial();
		assertEquals(2,unaUnidadComercial.getConsumo());
		
	}

	@Test
	public void testUnidadIndustrialTieneConsumoValido() {
		
		UnidadIndustrial unaUnidadIndustrial = new UnidadIndustrial();
		assertEquals(5,unaUnidadIndustrial.getConsumo());
		
	}
	
	@Test
	public void testUnidadResidencialTieneConsumoValido() {
		
		Ocupable unaUnidadResidencial = new UnidadResidencial();
		assertEquals(1,unaUnidadResidencial.getConsumo());
		
	}
	
	@Test
	public void testUnidadResidencialTieneCapacidadValida() {
		
		Ocupable unaUnidadResidencial = new UnidadResidencial();
		assertEquals(100,unaUnidadResidencial.getCapacidad());
		
	}
	
	@Test
	public void testUnidadIndustrialTieneCapacidadValida() {
		
		UnidadIndustrial unaUnidadIndustrial = new UnidadIndustrial();
		assertEquals(25,unaUnidadIndustrial.getCapacidad());
		
	}
}
