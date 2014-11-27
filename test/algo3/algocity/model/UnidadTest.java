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
		Unidad unaUnidadResidencial = fabrica.construir();

		assertEquals(unaUnidadResidencial.consumo(), 1);
	}

	@Test
	public void testUnidadComercialTieneConsumoValido() {
		FabricaUnidades fabrica = new FabricaUnidadComercial();
		Unidad unaUnidadComercial = fabrica.construir();

		assertEquals(unaUnidadComercial.consumo(), 2);
	}

	@Test
	public void testUnidadIndustrialTieneConsumoValido() {
		FabricaUnidades fabrica = new FabricaUnidadIndustrial();
		Unidad unaUnidadIndustrial = fabrica.construir();

		assertEquals(unaUnidadIndustrial.consumo(), 5);
	}

	/**/
	/* Tests de costos de las unidades */
	/**/

	@Test
	public void testUnidadResidencialTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaUnidadResidencial();
		Unidad unaUnidadResidencial = fabrica.construir();

		assertEquals(unaUnidadResidencial.costo(), 5);
	}

	@Test
	public void testUnidadComercialTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaUnidadComercial();
		Unidad unaUnidadComercial = fabrica.construir();

		assertEquals(unaUnidadComercial.costo(), 5);
	}

	@Test
	public void testUnidadIndustrialTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaUnidadIndustrial();
		Unidad unaUnidadIndustrial = fabrica.construir();

		assertEquals(unaUnidadIndustrial.costo(), 10);
	}

	@Test
	public void testPozoDeAguaTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaPozoAgua();
		Unidad unPozoDeAgua = fabrica.construir();

		assertEquals(unPozoDeAgua.costo(), 250);
	}

	@Test
	public void testEstacionDeBomberosTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaEstacionDeBomberos();
		Unidad unaEstacionDeBomberos = fabrica.construir();

		assertEquals(unaEstacionDeBomberos.costo(), 1500);
	}

	@Test
	public void testCentralEolicaTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaCentralEolica();
		Unidad unaCentralEolica = fabrica.construir();

		assertEquals(unaCentralEolica.costo(), 1000);
	}

	@Test
	public void testCentralMineraTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaCentralMineral();
		Unidad unaCentralMinera = fabrica.construir();

		assertEquals(unaCentralMinera.costo(), 3000);
	}

	@Test
	public void testCentralNuclearTieneCostoValido() {
		FabricaUnidades fabrica = new FabricaCentralNuclear();
		Unidad unaCentralNuclear = fabrica.construir();

		assertEquals(unaCentralNuclear.costo(), 10000);
	}

	/**/
	/* Tests de capacidades de las unidades */
	/**/

	@Test
	public void testUnidadResidencialTieneCapacidadValida() {
		Edificador unEdificador = new Edificador();
		UnidadOcupable unaUnidadResidencial = unEdificador
				.construirUnidadResidencial();

		assertEquals(unaUnidadResidencial.getCapacidad(), 100);
	}

	@Test
	public void testUnidadIndustrialTieneCapacidadValida() {
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
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralEolica = unEdificador
				.construirCentralEolica();

		assertEquals(unaCentralEolica.getCapacidad(), 100);
	}

	@Test
	public void testCentralMineraTieneCapacidadAbastecimientoValida() {
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralMinera = unEdificador
				.construirCentralMinera();

		assertEquals(unaCentralMinera.getCapacidad(), 400);
	}

	@Test
	public void testCentralNuclearTieneCapacidadAbastecimientoValida() {
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
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralEolica = unEdificador
				.construirCentralEolica();

		assertEquals(unaCentralEolica.getRadioDeInfluencia(), 4);
	}

	@Test
	public void testCentralMineraTieneRadioDeInfluenciaValido() {
		Edificador unEdificador = new Edificador();
		UnidadEnergetica unaCentralMinera = unEdificador
				.construirCentralMinera();

		assertEquals(unaCentralMinera.getRadioDeInfluencia(), 10);
	}

	@Test
	public void testCentralNuclearTieneRadioDeInfluenciaValido() {
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
<<<<<<< HEAD
	
		
	//Probando los tests con el abstract factory aplicado
	@Test
	public void testUnidadResidencialTieneCostoValido2() {
		
		FabricaUnidadResidencial fabrica = new FabricaUnidadResidencial();
		UnidadOcupable unidadResidencial = fabrica.construir();
		
		assertEquals(unidadResidencial.getCosto(),5);
		
	}
=======

>>>>>>> 917b3213c37505003cd54fea865827e02bc80497
}
