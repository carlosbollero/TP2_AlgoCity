package algo3.algocity.view;

import org.junit.Test;

import algo3.algocity.model.Juego;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.NoSePuedeConstruirEnSuperficie;
import algo3.algocity.model.fabricas.FabricaTuberias;
import algo3.algocity.model.mapas.Coordenada;

public class VistaTuberiasTest {

	@Test
	public void testSeCreanTuberiasYSeMuestranEnLaGUI()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, NoSePuedeConstruirEnSuperficie, CoordenadaInvalidaException {
		Juego j = new Juego();
		Ventana v = new Ventana(j);
		j.mapa().agregar(
				new FabricaTuberias().construir(j.mapa(), j.dinero(),
						new Coordenada(1, 1)));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j.mapa().agregar(
				new FabricaTuberias().construir(j.mapa(), j.dinero(),
						new Coordenada(1, 2)));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j.mapa().agregar(
				new FabricaTuberias().construir(j.mapa(), j.dinero(),
						new Coordenada(1, 3)));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j.mapa().agregar(
				new FabricaTuberias().construir(j.mapa(), j.dinero(),
						new Coordenada(1, 4)));

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
