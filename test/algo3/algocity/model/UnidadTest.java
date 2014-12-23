package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.EstacionDeBomberos;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Coordenada;

public class UnidadTest {

	/**/
	/* Tests de consumo de las unidades */
	/**/

	@Test
	public void testUnidadResidencialTieneConsumoValido() {
		Unidad unaUnidadResidencial = new UnidadResidencial(
				new Coordenada(1, 1));

		assertEquals(unaUnidadResidencial.consumo(), 1);
	}

	@Test
	public void testUnidadComercialTieneConsumoValido() {
		Unidad unaUnidadComercial = new UnidadComercial(new Coordenada(1, 1));

		assertEquals(unaUnidadComercial.consumo(), 2);
	}

	@Test
	public void testUnidadIndustrialTieneConsumoValido() {
		Unidad unaUnidadIndustrial = new UnidadIndustrial();

		assertEquals(unaUnidadIndustrial.consumo(), 5);
	}

	/**/
	/* Tests de costos de las unidades */
	/**/

	@Test
	public void testUnidadResidencialTieneCostoValido() {
		Unidad unaUnidadResidencial = new UnidadResidencial();

		assertEquals(unaUnidadResidencial.costo(), 5);
	}

	@Test
	public void testUnidadComercialTieneCostoValido() {
		Unidad unaUnidadComercial = new UnidadComercial();

		assertEquals(unaUnidadComercial.costo(), 5);
	}

	@Test
	public void testUnidadIndustrialTieneCostoValido() {
		Unidad unaUnidadIndustrial = new UnidadIndustrial();

		assertEquals(unaUnidadIndustrial.costo(), 10);
	}

	@Test
	public void testPozoDeAguaTieneCostoValido() {
		Unidad unPozoDeAgua = new PozoDeAgua();

		assertEquals(unPozoDeAgua.costo(), 250);
	}

	@Test
	public void testEstacionDeBomberosTieneCostoValido() {
		Unidad unaEstacionDeBomberos = new EstacionDeBomberos();

		assertEquals(unaEstacionDeBomberos.costo(), 1500);
	}

	@Test
	public void testCentralEolicaTieneCostoValido() {
		Unidad unaCentralEolica = new CentralEolica();

		assertEquals(unaCentralEolica.costo(), 1000);
	}

	@Test
	public void testCentralMineraTieneCostoValido() {
		Unidad unaCentralMinera = new CentralMinera();

		assertEquals(unaCentralMinera.costo(), 3000);
	}

	@Test
	public void testCentralNuclearTieneCostoValido() {
		Unidad unaCentralNuclear = new CentralNuclear();

		assertEquals(unaCentralNuclear.costo(), 10000);
	}

	/**/
	/* Tests de capacidades de las unidades */
	/**/

	@Test
	public void testUnidadResidencialTieneCapacidadValida() {
		// Capacidad unidadResidencial = 100
		UnidadResidencial unaUnidadResidencial = new UnidadResidencial();

		assertEquals(unaUnidadResidencial.capacidad(), 100);
	}

	@Test
	public void testUnidadIndustrialTieneCapacidadValida() {
		// Capacidad unidadIndustrial = 25
		UnidadIndustrial unaUnidadIndustrial = new UnidadIndustrial();

		assertEquals(unaUnidadIndustrial.capacidad(), 25);
	}

	/**/
	/* Tests de capacidades electricas de abastecimiento de unidades energeticas */
	/**/

	@Test
	public void testCentralEolicaTieneCapacidadAbastecimientoValida() {
		// Capacidad de abastecimiento centralEolica = 100
		CentralEolica unaCentralEolica = new CentralEolica();

		assertEquals(unaCentralEolica.getCapacidad(), 100);
	}

	@Test
	public void testCentralMineraTieneCapacidadAbastecimientoValida() {
		// Capacidad de abastecimiento centralMinera = 400
		CentralMinera unaCentralMinera = new CentralMinera();

		assertEquals(unaCentralMinera.getCapacidad(), 400);
	}

	@Test
	public void testCentralNuclearTieneCapacidadAbastecimientoValida() {
		// Capacidad de abastecimiento centralNuclear = 1000
		CentralNuclear unaCentralNuclear = new CentralNuclear();

		assertEquals(unaCentralNuclear.getCapacidad(), 1000);
	}

	/**/
	/* Tests de radio de influencia de unidades energeticas */
	/**/

	@Test
	public void testCentralEolicaTieneRadioDeInfluenciaValido() {
		// Radio de influencia centralEolica = 4
		CentralEolica unaCentralEolica = new CentralEolica();
		assertEquals(unaCentralEolica.getRadio(), 4);
	}

	@Test
	public void testCentralMineraTieneRadioDeInfluenciaValido() {
		// Radio de influencia centralMinera = 10
		CentralMinera unaCentralMinera = new CentralMinera();

		assertEquals(unaCentralMinera.getRadio(), 10);
	}

	@Test
	public void testCentralNuclearTieneRadioDeInfluenciaValido() {
		// Radio de influencia centralNuclear = 25
		CentralNuclear unaCentralNuclear = new CentralNuclear();
		assertEquals(unaCentralNuclear.getRadio(), 25);
	}

	/**/
	/* Tests de aplique de danios/reparaciones a las unidades */
	/**/

	@Test
	public void testAplicarDanioAUnidadOcupable() {
		Daniable unaUnidadResidencial = new UnidadResidencial();

		unaUnidadResidencial.aplicarDanio(100);

		assertEquals(0, unaUnidadResidencial.getSalud(), 0);

	}

	@Test
	public void testAplicarDanioAUnidadComercial() {
		Daniable unaUnidadComercial = new UnidadComercial();
		unaUnidadComercial.aplicarDanio(50);

		assertEquals(50, unaUnidadComercial.getSalud(), 0);
	}

	@Test
	public void testAplicarDanioAUnidadEnergetica() {
		Daniable unaUnidadEnergetica = new CentralEolica();
		unaUnidadEnergetica.aplicarDanio(50);

		assertEquals(50, unaUnidadEnergetica.getSalud(), 0);
	}
}

// TODO faltan tests de reparaciones

