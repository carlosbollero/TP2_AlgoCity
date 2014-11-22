package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnidadTest {

	/**/
	/* Tests de consumo de las unidades */
	/**/

	@Test
	public void testUnidadResidencialTieneConsumoValido() {
		// Consumo unidadResidencial = 1
		Edificador unEdificador = new Edificador();
		UnidadOcupable unaUnidadResidencial = unEdificador
				.construirUnidadResidencial();

		assertEquals(unaUnidadResidencial.getConsumo(), 1);
	}

	@Test
	public void testUnidadComercialTieneConsumoValido() {
		// Consumo unidadComercial = 2
		Edificador unEdificador = new Edificador();
		UnidadComercial unaUnidadComercial = unEdificador
				.construirUnidadComercial();

		assertEquals(unaUnidadComercial.getConsumo(), 2);
	}

	@Test
	public void testUnidadIndustrialTieneConsumoValido() {
		// Consumo unidadIndustrial = 5
		Edificador unEdificador = new Edificador();
		UnidadOcupable unaUnidadIndustrial = unEdificador
				.construirUnidadIndustrial();

		assertEquals(unaUnidadIndustrial.getConsumo(), 5);
	}

	/**/
	/* Tests de costos de las unidades */
	/**/

	@Test
	public void testUnidadResidencialTieneCostoValido() {
		// Costo unidadResidencial = 5
		Edificador unEdificador = new Edificador();
		Unidad unaUnidadResidencial = unEdificador.construirUnidadResidencial();

		assertEquals(unaUnidadResidencial.getCosto(), 5);
	}

	@Test
	public void testUnidadComercialTieneCostoValido() {
		// Costo unidadComercial = 5
		Edificador unEdificador = new Edificador();
		Unidad unaUnidadComercial = unEdificador.construirUnidadComercial();

		assertEquals(unaUnidadComercial.getCosto(), 5);
	}

	@Test
	public void testUnidadIndustrialTieneCostoValido() {
		// Costo unidadIndsutrial = 10
		Edificador unEdificador = new Edificador();
		Unidad unaUnidadIndustrial = unEdificador.construirUnidadIndustrial();

		assertEquals(unaUnidadIndustrial.getCosto(), 10);
	}

	@Test
	public void testPozoDeAguaTieneCostoValido() {
		// Costo pozoDeAgua = 250
		Edificador unEdificador = new Edificador();
		Unidad unPozoDeAgua = unEdificador.construirPozoDeAgua();

		assertEquals(unPozoDeAgua.getCosto(), 250);
	}

	@Test
	public void testEstacionDeBomberosTieneCostoValido() {
		// Costo estacionDeBomberos = 1500
		Edificador unEdificador = new Edificador();
		Unidad unaEstacionDeBomberos = unEdificador
				.construirEstacionDeBomberos();

		assertEquals(unaEstacionDeBomberos.getCosto(), 1500);
	}

	@Test
	public void testCentralEolicaTieneCostoValido() {
		// Costo centralEolica = 1000
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralEolica = unEdificador
				.construirCentralEolica();

		assertEquals(unaCentralEolica.getCosto(), 1000);
	}

	@Test
	public void testCentralMineraTieneCostoValido() {
		// Costo centralMinera = 3000
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralMinera = unEdificador
				.construirCentralMinera();

		assertEquals(unaCentralMinera.getCosto(), 3000);
	}

	@Test
	public void testCentralNuclearTieneCostoValido() {
		// Costo centralNuclear = 10000
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralNuclear = unEdificador
				.construirCentralNuclear();

		assertEquals(unaCentralNuclear.getCosto(), 10000);
	}

	/**/
	/* Tests de capacidades de las unidades */
	/**/

	@Test
	public void testUnidadResidencialTieneCapacidadValida() {
		// Capacidad unidadResidencial = 100
		Edificador unEdificador = new Edificador();
		UnidadOcupable unaUnidadResidencial = unEdificador
				.construirUnidadResidencial();

		assertEquals(unaUnidadResidencial.getCapacidad(), 100);
	}

	@Test
	public void testUnidadIndustrialTieneCapacidadValida() {
		// Capacidad unidadIndustrial = 25
		Edificador unEdificador = new Edificador();
		UnidadOcupable unaUnidadIndustrial = unEdificador
				.construirUnidadIndustrial();

		assertEquals(unaUnidadIndustrial.getCapacidad(), 25);
	}

	/**/
	/* Tests de capacidades electricas de abastecimiento de unidades energeticas */
	/**/

	@Test
	public void testCentralEolicaTieneCapacidadAbastecimientoValida() {
		// Capacidad de abastecimiento centralEolica = 100
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralEolica = unEdificador
				.construirCentralEolica();

		assertEquals(unaCentralEolica.getCapacidad(), 100);
	}

	@Test
	public void testCentralMineraTieneCapacidadAbastecimientoValida() {
		// Capacidad de abastecimiento centralMinera = 400
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralMinera = unEdificador
				.construirCentralMinera();

		assertEquals(unaCentralMinera.getCapacidad(), 400);
	}

	@Test
	public void testCentralNuclearTieneCapacidadAbastecimientoValida() {
		// Capacidad de abastecimiento centralNuclear = 1000
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralNuclear = unEdificador
				.construirCentralNuclear();

		assertEquals(unaCentralNuclear.getCapacidad(), 1000);
	}

	/**/
	/* Tests de radio de influencia de unidades energeticas */
	/**/

	@Test
	public void testCentralEolicaTieneRadioDeInfluenciaValido() {
		// Radio de influencia centralEolica = 4
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralEolica = unEdificador
				.construirCentralEolica();

		assertEquals(unaCentralEolica.getRadioDeInfluencia(), 4);
	}

	@Test
	public void testCentralMineraTieneRadioDeInfluenciaValido() {
		// Radio de influencia centralMinera = 10
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralMinera = unEdificador
				.construirCentralMinera();

		assertEquals(unaCentralMinera.getRadioDeInfluencia(), 10);
	}

	@Test
	public void testCentralNuclearTieneRadioDeInfluenciaValido() {
		// Radio de influencia centralNuclear = 25
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralNuclear = unEdificador
				.construirCentralNuclear();

		assertEquals(unaCentralNuclear.getRadioDeInfluencia(), 25);
	}

	/**/
	/* Tests de aplique de danios/reparaciones a las unidades */
	/**/

	@Test
	public void testAplicarDanioAUnidadOcupable() {

		Edificador unEdificador = new Edificador();
		Reparable unaUnidadResidencial = unEdificador
				.construirUnidadResidencial();
		unaUnidadResidencial.aplicarDanio(100);

		assertEquals(0, unaUnidadResidencial.getSalud());

	}

	@Test
	public void testAplicarDanioAUnidadComercial() {

		Edificador unEdificador = new Edificador();
		Reparable unaUnidadComercial = unEdificador.construirUnidadComercial();
		unaUnidadComercial.aplicarDanio(50);

		assertEquals(50, unaUnidadComercial.getSalud());
	}

	@Test
	public void testAplicarDanioAUnidadEnergetica() {

		Edificador unEdificador = new Edificador();
		Reparable unaUnidadEnergetica = unEdificador.construirCentralEolica();
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

		Edificador unEdificador = new Edificador();
		UnidadOcupable unaUnidadResidencial = unEdificador
				.construirUnidadResidencial();
		unaUnidadResidencial.agregarHabitantes(3);

		assertEquals(unaUnidadResidencial.getOcupacion(), 3);
	}

	@Test
	public void testOcupacionDeUnidadIndustrialAumentaAlRecibirHabitantes() {

		Edificador unEdificador = new Edificador();
		UnidadOcupable unaUnidadIndustrial = unEdificador
				.construirUnidadIndustrial();
		unaUnidadIndustrial.agregarHabitantes(1);

		assertEquals(unaUnidadIndustrial.getOcupacion(), 1);
	}

	@Test
	public void testOcupacionDeUnidadResidencialDisminuyeAlDespedirHabitantes() {

		Edificador unEdificador = new Edificador();
		UnidadOcupable unaUnidadResidencial = unEdificador
				.construirUnidadResidencial();
		unaUnidadResidencial.agregarHabitantes(5);

		assertEquals(unaUnidadResidencial.getOcupacion(), 5);

		unaUnidadResidencial.quitarHabitantes(2);

		assertEquals(unaUnidadResidencial.getOcupacion(), 3);
	}

	@Test
	public void testOcupacionDeUnidadIndustrialDisminuyeAlDespedirHabitantes() {

		Edificador unEdificador = new Edificador();
		UnidadOcupable unaUnidadIndustrial = unEdificador
				.construirUnidadIndustrial();
		unaUnidadIndustrial.agregarHabitantes(11);

		assertEquals(unaUnidadIndustrial.getOcupacion(), 11);

		unaUnidadIndustrial.quitarHabitantes(1);

		assertEquals(unaUnidadIndustrial.getOcupacion(), 10);
	}

	@Test
	public void testNoSePuedeSobrepasarLaCapacidadDeUnidadResidencial() {

		Edificador unEdificador = new Edificador();
		UnidadOcupable unaUnidadResidencial = unEdificador
				.construirUnidadResidencial();
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

		Edificador unEdificador = new Edificador();
		UnidadOcupable unaUnidadIndustrial = unEdificador
				.construirUnidadIndustrial();
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
