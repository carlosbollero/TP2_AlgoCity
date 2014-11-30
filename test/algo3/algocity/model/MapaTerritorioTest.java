package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.mapas.MapaTerritorio;

public class MapaTerritorioTest {

	int alto = 10;
	int ancho = 10;
	boolean agua = false;
	boolean tierra = true;

	@Test
	public void testTerritorioSeCreaConEstadoValido() {
		MapaTerritorio mt = new MapaTerritorio(alto, ancho);

		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				boolean posActual = mt.consultarCoordenada(i, j);
				assertTrue(posActual == agua || posActual == tierra);
				if (posActual == tierra){
					System.out.print(0);
				}else{
					System.out.print(4);
				}
				
				System.out.print(" ");
			}
			System.out.println(" ");
		}
	}

}
