import algo3.algocity.model.Juego;
import algo3.algocity.view.Ventana;

public class App {

	public static void main(String arg[]) {

		Juego juego = new Juego();
		juego.iniciar();
		Ventana ventana = new Ventana(juego);
	}

}
