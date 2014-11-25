import javax.swing.JFrame;

import algo3.algocity.view.*;
import algo3.algocity.model.*;
import algo3.algocity.control.*;


public class App {
	
	public static void main(String[] args){
		
		VentanaMapa ventana = new VentanaMapa();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(500, 500);
		ventana.setVisible(true);
	}

}
