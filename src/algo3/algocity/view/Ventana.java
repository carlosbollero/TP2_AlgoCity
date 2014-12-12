package algo3.algocity.view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	
	private static final long serialVersionUID = -4435193356021844493L;
	
	int tamanio = 20;

	public Ventana(int tamanio){
		setTitle("Algoritmos 3 | AlgoCity");
		Container contenedor = getContentPane();
        contenedor.setLayout(new GridLayout(this.tamanio,this.tamanio));
        for (int x = 0; x < tamanio; x++) {
            for (int y = 0; y < tamanio; y++) {
                contenedor.add(new JPanel());

            }
        }

		
	}

}
