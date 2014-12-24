package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.NoSePuedeConstruirEnSuperficie;
import algo3.algocity.model.fabricas.FabricaCentralEolica;
import algo3.algocity.model.fabricas.FabricaCentralMinera;
import algo3.algocity.model.fabricas.FabricaCentralNuclear;
import algo3.algocity.model.fabricas.FabricaPozoAgua;
import algo3.algocity.model.fabricas.FabricaRuta;
import algo3.algocity.model.fabricas.FabricaTuberias;
import algo3.algocity.model.fabricas.FabricaUnidadResidencial;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class SistemaElectricoTest {

	@Test
	public void testSeAumentaLaCapacidadAlCrearUnidadesEnergeticas()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, NoSePuedeConstruirEnSuperficie,
			NoHayConexionConTuberias, CoordenadaInvalidaException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		SistemaElectrico s = new SistemaElectrico();

		m.setTerritorioAguaParaTest();
		m.agregar(new FabricaPozoAgua()
				.construir(m, d, s, new Coordenada(0, 1)));
		m.agregar(new FabricaTuberias().construir(m, d, new Coordenada(0, 1)));
		m.agregar(new FabricaTuberias().construir(m, d, new Coordenada(0, 0)));
		m.setTerritorioTierraParaTest();
		m.agregar(new FabricaCentralEolica().construir(m, d, s, new Coordenada(
				0, 0)));

		assertEquals(s.capacidad(), 100);

		m.agregar(new FabricaTuberias().construir(m, d, new Coordenada(1, 0)));
		m.agregar(new FabricaCentralMinera().construir(m, d, s, new Coordenada(
				1, 0)));

		assertEquals(s.capacidad(), 500);

		m.agregar(new FabricaTuberias().construir(m, d, new Coordenada(2, 0)));
		m.agregar(new FabricaCentralNuclear().construir(m, d, s,
				new Coordenada(2, 0)));

		assertEquals(s.capacidad(), 1500);

	}

	@Test
	public void testSeAumentaElConsumoAlCrearUnidadesQueConsumen()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, NoSePuedeConstruirEnSuperficie,
			NoHayConexionConTuberias, CapacidadElectricaInsuficienteException,
			NoHayConexionConRutas, NoHayConexionConRedElectrica,
			CoordenadaInvalidaException {
		Mapa m = new Mapa();
		Dinero d = new Dinero();
		SistemaElectrico s = new SistemaElectrico();

		m.setTerritorioAguaParaTest();
		m.agregar(new FabricaPozoAgua()
				.construir(m, d, s, new Coordenada(0, 1)));
		m.agregar(new FabricaTuberias().construir(m, d, new Coordenada(0, 1)));
		m.agregar(new FabricaTuberias().construir(m, d, new Coordenada(0, 0)));
		m.setTerritorioTierraParaTest();
		m.agregar(new FabricaCentralEolica().construir(m, d, s, new Coordenada(
				0, 0)));

		assertEquals(s.capacidad(), 100);

		m.agregar(new FabricaRuta().construir(m, d, new Coordenada(1, 1)));
		m.agregar(new FabricaRuta().construir(m, d, new Coordenada(2, 1)));
		m.agregar(new FabricaRuta().construir(m, d, new Coordenada(3, 1)));
		m.agregar(new FabricaRuta().construir(m, d, new Coordenada(4, 1)));
		m.agregar(new FabricaUnidadResidencial().construir(m, d, s,
				new Coordenada(1, 0)));
		m.agregar(new FabricaUnidadResidencial().construir(m, d, s,
				new Coordenada(2, 0)));
		m.agregar(new FabricaUnidadResidencial().construir(m, d, s,
				new Coordenada(3, 0)));
		m.agregar(new FabricaUnidadResidencial().construir(m, d, s,
				new Coordenada(4, 0)));

		assertEquals(s.consumo(), 4);
	}

}
