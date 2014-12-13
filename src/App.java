import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

	public static void main(String arg[]) {
		
		
		JFrame ventana = new JFrame();
		JPanel vistaMapa = new JPanel();
		
		ventana.setSize(400, 500);
		
		vistaMapa.setLayout(new GridLayout());
		ventana.getContentPane().add(vistaMapa);
		
		
		

		// Juego juego = new Juego();
		// juego.iniciar();
	}

}
