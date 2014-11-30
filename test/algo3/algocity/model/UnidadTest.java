package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnidadTest {

	/**/
	/* Tests de consumo de las unidades */
	/**/

	@Test
	public void testUnidadResidencialTieneConsumoValido() {
		FabricaUnidades fabrica = new FabricaUnidadResidencial();
		Unidad unaUnidadResidencial = fabrica.construir(null, null, null);

		assertEquals(unaUnidadResidencial.consumo(), 1);
	}

	@Test
	public void testUnidadComercialTieneConsumoValido() {
		FabricaUnidades fabrica = new FabricaUnidadComercial();
		Unidad unaUnidadComercial = fabrica.construir(null, null, null);

		assertEquals(unaUnidadComercial.consumo(), 2);
	}

	@Test
	public void testUnidadIndustrialTieneConsumoValido() {
		FabricaUnidades fabrica = new FabricaUnidadIndustrial();
		Unidad unaUnidadIndustrial = fabrica.construir(null, null, null);

		assertEquals(unaUnidadIndustrial.consumo(), 5);
	}

	/**/
	/* Tests de costos de las unidades */
	/**/

	@Test
	public void testUnidadResidencialTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaUnidadResidencial();
		Unidad unaUnidadResidencial = fabrica.construir(null, null, null);

		assertEquals(unaUnidadResidencial.costo(), 5);
	}

	@Test
	public void testUnidadComercialTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaUnidadComercial();
		Unidad unaUnidadComercial = fabrica.construir(null, null, null);

		assertEquals(unaUnidadComercial.costo(), 5);
	}

	@Test
	public void testUnidadIndustrialTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaUnidadIndustrial();
		Unidad unaUnidadIndustrial = fabrica.construir(null, null, null);

		assertEquals(unaUnidadIndustrial.costo(), 10);
	}

	@Test
	public void testPozoDeAguaTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaPozoAgua();
		Unidad unPozoDeAgua = fabrica.construir(null, null, null);

		assertEquals(unPozoDeAgua.costo(), 250);
	}

	@Test
	public void testEstacionDeBomberosTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaEstacionDeBomberos();
		Unidad unaEstacionDeBomberos = fabrica.construir(null, null, null);

		assertEquals(unaEstacionDeBomberos.costo(), 1500);
	}

	@Test
	public void testCentralEolicaTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaCentralEolica();
		Unidad unaCentralEolica = fabrica.construir(null, null, null);

		assertEquals(unaCentralEolica.costo(), 1000);
	}

	@Test
	public void testCentralMineraTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaCentralMineral();
		Unidad unaCentralMinera = fabrica.construir(null, null, null);

		assertEquals(unaCentralMinera.costo(), 3000);
	}

	@Test
	public void testCentralNuclearTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaCentralNuclear();
		Unidad unaCentralNuclear = fabrica.construir(null, null, null);

		assertEquals(unaCentralNuclear.costo(), 10000);
	}

	/**/
	/* Tests de capacidades de las unidades */
	/**/

	@Test
	public void testUnidadResidencialTieneCapacidadValida() {
		// Capacidad unidadResidencial = 100

		FabricaUnidadResidencial fabrica = new FabricaUnidadResidencial();
		UnidadResidencial unaUnidadResidencial = (UnidadResidencial)fabrica.construir(null, null, null);

		assertEquals(unaUnidadResidencial.getCapacidad(), 100);
	}

	@Test
	public void testUnidadIndustrialTieneCapacidadValida() {
		// Capacidad unidadIndustrial = 25
		FabricaUnidadIndustrial fabrica = new FabricaUnidadIndustrial();
		UnidadIndustrial unaUnidadIndustrial = (UnidadIndustrial)fabrica.construir(null, null, null);

		assertEquals(unaUnidadIndustrial.getCapacidad(), 25);
	}

	/**/
	/* Tests de capacidades electricas de abastecimiento de unidades energeticas */
	/**/

	@Test
	public void testCentralEolicaTieneCapacidadAbastecimientoValida() {
		// Capacidad de abastecimiento centralEolica = 100
		FabricaCentralEolica fabrica = new FabricaCentralEolica();
		CentralEolica unaCentralEolica = (CentralEolica)fabrica.construir(null, null, null);

		assertEquals(unaCentralEolica.getCapacidad(), 100);
	}

	@Test
	public void testCentralMineraTieneCapacidadAbastecimientoValida() {
		// Capacidad de abastecimiento centralMinera = 400 Edificador
		FabricaCentralMineral fabrica = new FabricaCentralMineral();
		CentralMinera unaCentralMinera = (CentralMinera)fabrica.construir(null, null, null);

		assertEquals(unaCentralMinera.getCapacidad(), 400);
	}

	@Test
	public void testCentralNuclearTieneCapacidadAbastecimientoValida() {
		// Capacidad de abastecimiento centralNuclear = 1000
		FabricaCentralNuclear fabrica = new FabricaCentralNuclear();
		CentralNuclear unaCentralNuclear = (CentralNuclear)fabrica.construir(null, null, null);

		assertEquals(unaCentralNuclear.getCapacidad(), 1000);
	}


	/**/
	/* Tests de radio de influencia de unidades energeticas */
	/**/

	@Test
	public void testCentralEolicaTieneRadioDeInfluenciaValido() {
		// Radio de influencia centralEolica = 4
		FabricaCentralEolica fabrica = new FabricaCentralEolica();
		CentralEolica unaCentralEolica = (CentralEolica)fabrica.construir(null, null, null);

		assertEquals(unaCentralEolica.getRadioDeInfluencia(), 4);
	}

	@Test
	public void testCentralMineraTieneRadioDeInfluenciaValido() {
		// Radio de influencia centralMinera = 10
		FabricaCentralMineral fabrica = new FabricaCentralMineral();
		CentralMinera unaCentralMinera = (CentralMinera)fabrica.construir(null, null, null);

		assertEquals(unaCentralMinera.getRadioDeInfluencia(), 10);
	}

	@Test
	public void testCentralNuclearTieneRadioDeInfluenciaValido() {
		// Radio de influencia centralNuclear = 25
		FabricaCentralNuclear fabrica = new FabricaCentralNuclear();
		CentralNuclear unaCentralNuclear = (CentralNuclear)fabrica.construir(null, null, null);

		assertEquals(unaCentralNuclear.getRadioDeInfluencia(), 25);
	}

	/**/
	/* Tests de aplique de danios/reparaciones a las unidades */
	/**/

	@Test
	public void testAplicarDanioAUnidadOcupable() {

		FabricaUnidadResidencial fabrica = new FabricaUnidadResidencial();
		Reparable unaUnidadResidencial = (UnidadResidencial)fabrica.construir(null, null, null);

		unaUnidadResidencial.aplicarDanio(100);

		assertEquals(0, unaUnidadResidencial.getSalud());

	}

	@Test
	public void testAplicarDanioAUnidadComercial() {

		FabricaUnidadComercial fabrica = new FabricaUnidadComercial();
		Reparable unaUnidadComercial = (Reparable)fabrica.construir(null, null, null);
		unaUnidadComercial.aplicarDanio(50);

		assertEquals(50, unaUnidadComercial.getSalud());
	}

	@Test
	public void testAplicarDanioAUnidadEnergetica() {

		FabricaCentralEolica fabrica = new FabricaCentralEolica();
		Reparable unaUnidadEnergetica = (Reparable)fabrica.construir(null, null, null);
		unaUnidadEnergetica.aplicarDanio(50);

		assertEquals(50, unaUnidadEnergetica.getSalud());
	}

	// TODO faltan tests de reparaciones, ver como terminamos definiendo este
	// tema

	/**/
	/* Tests de control de habitantes de las unidades */
	/**/

	@Test
	public void testOcupacionDeUnidadResidencialAumentaAlAgregarHabitantes() {

		FabricaUnidadResidencial fabrica = new FabricaUnidadResidencial();
		UnidadResidencial unaUnidadResidencial = (UnidadResidencial)fabrica.construir(null, null, null);
		unaUnidadResidencial.agregarHabitantes(3);

		assertEquals(unaUnidadResidencial.getOcupacion(), 3);
	}

	@Test
	public void testOcupacionDeUnidadIndustrialAumentaAlRecibirHabitantes() {

		FabricaUnidadIndustrial fabrica = new FabricaUnidadIndustrial();
		UnidadIndustrial unaUnidadIndustrial = (UnidadIndustrial)fabrica.construir(null, null, null);
		unaUnidadIndustrial.agregarHabitantes(1);

		assertEquals(unaUnidadIndustrial.getOcupacion(), 1);
	}

	@Test
	public void testOcupacionDeUnidadResidencialDisminuyeAlDespedirHabitantes() {

		FabricaUnidadResidencial fabrica = new FabricaUnidadResidencial();
		UnidadResidencial unaUnidadResidencial = (UnidadResidencial)fabrica.construir(null, null, null);

		unaUnidadResidencial.agregarHabitantes(5);

		assertEquals(unaUnidadResidencial.getOcupacion(), 5);

		unaUnidadResidencial.quitarHabitantes(2);

		assertEquals(unaUnidadResidencial.getOcupacion(), 3);
	}

	@Test
	public void testOcupacionDeUnidadIndustrialDisminuyeAlDespedirHabitantes() {

		FabricaUnidadIndustrial fabrica = new FabricaUnidadIndustrial();
		UnidadIndustrial unaUnidadIndustrial = (UnidadIndustrial)fabrica.construir(null, null, null);
		unaUnidadIndustrial.agregarHabitantes(11);

		assertEquals(unaUnidadIndustrial.getOcupacion(), 11);

		unaUnidadIndustrial.quitarHabitantes(1);

		assertEquals(unaUnidadIndustrial.getOcupacion(), 10);
	}

	@Test
	public void testNoSePuedeSobrepasarLaCapacidadDeUnidadResidencial() {

		FabricaUnidadResidencial fabrica = new FabricaUnidadResidencial();
		UnidadResidencial unaUnidadResidencial = (UnidadResidencial)fabrica.construir(null, null, null);
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

		FabricaUnidadIndustrial fabrica = new FabricaUnidadIndustrial();
		UnidadIndustrial unaUnidadIndustrial = (UnidadIndustrial)fabrica.construir(null, null, null);
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
