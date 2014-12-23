package algo3.algocity.view;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.Juego;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.NoSePuedeConstruirEnSuperficie;
import algo3.algocity.model.fabricas.FabricaTuberias;
import algo3.algocity.model.mapas.Coordenada;

public class VistaTuberiasTest {

	@Test
	public void testSeCreanTuberiasYSeMuestranEnLaGUI()
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, NoSePuedeConstruirEnSuperficie {
		Juego j = new Juego();
		Ventana v = new Ventana(j);
		j.mapa().agregar(
				new FabricaTuberias().construir(j.mapa(), j.dinero(),
						new Coordenada(1, 1)));
		j.mapa().agregar(
				new FabricaTuberias().construir(j.mapa(), j.dinero(),
						new Coordenada(1, 2)));
		j.mapa().agregar(
				new FabricaTuberias().construir(j.mapa(), j.dinero(),
						new Coordenada(1, 3)));
		j.mapa().agregar(
				new FabricaTuberias().construir(j.mapa(), j.dinero(),
						new Coordenada(1, 4)));
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
