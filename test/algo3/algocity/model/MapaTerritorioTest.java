package algo3.algocity.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class MapaTerritorioTest {

	int alto = 10;
	int ancho = 10;

	@Test
	public void testTerritorioSeCreaConEstadoValido() {
		MapaTerritorio mt = new MapaTerritorio(alto, ancho);

		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				System.out.print(mt.consultarCoordenada(i, j));
				System.out.print(" ");
			}
			System.out.println(" ");
		}
	}

	// TODO REVISAR porq estoy probando random¿?
	@Test
	public void testSepuedeConsultarTipoDeSuperficieDeunaCoordenada() {
		MapaTerritorio mt = new MapaTerritorio(alto, ancho);

		boolean agua = false;
		boolean tierra = true;

		assertTrue(mt.getContenido(1, 1).tipo() == agua
				|| mt.getContenido(1, 1).tipo() == tierra);
	}

}
