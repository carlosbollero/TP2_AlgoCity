package algo3.algocity.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import algo3.algocity.model.fabricas.FabricaCentralEolica;
import algo3.algocity.model.fabricas.FabricaCentralMineral;
import algo3.algocity.model.fabricas.FabricaCentralNuclear;
import algo3.algocity.model.fabricas.FabricaEstacionDeBomberos;
import algo3.algocity.model.fabricas.FabricaPozoAgua;
import algo3.algocity.model.fabricas.FabricaUnidadComercial;
import algo3.algocity.model.fabricas.FabricaUnidadIndustrial;
import algo3.algocity.model.fabricas.FabricaUnidadResidencial;
import algo3.algocity.model.fabricas.FabricaUnidades;

public class UnidadTest {

	/**/
	/* Tests de consumo de las unidades */
	/**/

	@Test
	public void testUnidadResidencialTieneConsumoValido() {
		Unidad unaUnidadResidencial = new UnidadResidencial();

		assertEquals(unaUnidadResidencial.consumo(), 1);
	}

	@Test
	public void testUnidadComercialTieneConsumoValido() {
		Unidad unaUnidadComercial = new UnidadComercial();

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

		assertEquals(unaUnidadResidencial.getCapacidad(), 100);
	}

	@Test
	public void testUnidadIndustrialTieneCapacidadValida() {
		// Capacidad unidadIndustrial = 25
		UnidadIndustrial unaUnidadIndustrial = new UnidadIndustrial();

		assertEquals(unaUnidadIndustrial.getCapacidad(), 25);
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
		assertEquals(unaCentralEolica.getRadioDeInfluencia(), 4);
	}

	@Test
	public void testCentralMineraTieneRadioDeInfluenciaValido() {
		// Radio de influencia centralMinera = 10
		CentralMinera unaCentralMinera = new CentralMinera();

		assertEquals(unaCentralMinera.getRadioDeInfluencia(), 10);
	}

	@Test
	public void testCentralNuclearTieneRadioDeInfluenciaValido() {
		// Radio de influencia centralNuclear = 25
		CentralNuclear unaCentralNuclear = new CentralNuclear();
		assertEquals(unaCentralNuclear.getRadioDeInfluencia(), 25);
	}

	/**/
	/* Tests de aplique de danios/reparaciones a las unidades */
	/**/

	@Test
	public void testAplicarDanioAUnidadOcupable() {
		Reparable unaUnidadResidencial = new UnidadResidencial();

		unaUnidadResidencial.aplicarDanio(100);

		assertEquals(0, unaUnidadResidencial.getSalud(), 0);

	}

	@Test
	public void testAplicarDanioAUnidadComercial() {
		Reparable unaUnidadComercial = new UnidadComercial();
		unaUnidadComercial.aplicarDanio(50);

		assertEquals(50, unaUnidadComercial.getSalud(), 0);
	}

	@Test
	public void testAplicarDanioAUnidadEnergetica() {
		Reparable unaUnidadEnergetica = new CentralEolica();
		unaUnidadEnergetica.aplicarDanio(50);

		assertEquals(50, unaUnidadEnergetica.getSalud(), 0);
	}

	// TODO faltan tests de reparaciones

	/**/
	/* Tests de control de habitantes de las unidades */
	/**/

	@Test
	public void testOcupacionDeUnidadResidencialAumentaAlAgregarHabitantes() {

		UnidadResidencial unaUnidadResidencial = new UnidadResidencial();
		unaUnidadResidencial.agregarHabitantes(3);

		assertEquals(unaUnidadResidencial.getOcupacion(), 3);
	}

	@Test
	public void testOcupacionDeUnidadIndustrialAumentaAlRecibirHabitantes() {
		UnidadIndustrial unaUnidadIndustrial = new UnidadIndustrial();
		unaUnidadIndustrial.agregarHabitantes(1);

		assertEquals(unaUnidadIndustrial.getOcupacion(), 1);
	}

	@Test
	public void testOcupacionDeUnidadResidencialDisminuyeAlDespedirHabitantes() {
		UnidadResidencial unaUnidadResidencial = new UnidadResidencial();

		unaUnidadResidencial.agregarHabitantes(5);

		assertEquals(unaUnidadResidencial.getOcupacion(), 5);

		unaUnidadResidencial.quitarHabitantes(2);

		assertEquals(unaUnidadResidencial.getOcupacion(), 3);
	}

	@Test
	public void testOcupacionDeUnidadIndustrialDisminuyeAlDespedirHabitantes() {
		UnidadIndustrial unaUnidadIndustrial = new UnidadIndustrial();
		unaUnidadIndustrial.agregarHabitantes(11);

		assertEquals(unaUnidadIndustrial.getOcupacion(), 11);

		unaUnidadIndustrial.quitarHabitantes(1);

		assertEquals(unaUnidadIndustrial.getOcupacion(), 10);
	}

	@Test
	public void testNoSePuedeSobrepasarLaCapacidadDeUnidadResidencial() {
		UnidadResidencial unaUnidadResidencial = new UnidadResidencial();
		unaUnidadResidencial.agregarHabitantes(100); // --> Esta al limite la
														// capacidad de la
														// unidadResidencial

		assertEquals(unaUnidadResidencial.getOcupacion(), 100);

		unaUnidadResidencial.agregarHabitantes(1);

		assertFalse(unaUnidadResidencial.getOcupacion() == 101);

		// La ocupacion sigue siendo la misma luego de haber intentado agregar
		// mas habitantes
		assertEquals(unaUnidadResidencial.getOcupacion(), 100);
	}

	@Test
	public void testNoSePuedeSobrepasarLaCapacidadDeUnidadIndustrial() {
		UnidadIndustrial unaUnidadIndustrial = new UnidadIndustrial();
		unaUnidadIndustrial.agregarHabitantes(25); // --> Esta al limite
													// lacapacidad de la

		unaUnidadIndustrial.agregarHabitantes(25); // --> Esta al limite la
													// capacidad de la
													// unidadResidencial

		assertEquals(unaUnidadIndustrial.getOcupacion(), 25);

		unaUnidadIndustrial.agregarHabitantes(1);

		assertFalse(unaUnidadIndustrial.getOcupacion() == 26);

		// La ocupacion sigue siendo la misma luego de haber intentado agregar
		// mas habitantes
		assertEquals(unaUnidadIndustrial.getOcupacion(), 25);
	}
}
