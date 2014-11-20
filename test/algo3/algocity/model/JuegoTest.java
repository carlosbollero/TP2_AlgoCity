package algo3.algocity.model;

import java.util.ArrayList;

import org.junit.Test;

public class JuegoTest {
	
	
		
	@Test
	public void testAgregarPozoDeAguaEnMapaCorrespondiente(){
		
		Juego unJuego = new Juego();
		unJuego.agregarPozoDeAguaEn(3,5);
		ArrayList<Ubicable> elementos = unJuego.getContenidoEnPosicion(3,5);
		AssertTrue(elementos.contains(//algo de clase PozoDeAgua));//Ver como preguntar si tiene un pozoDeAgua sin preguntarle la clase
		
	}
	
}
