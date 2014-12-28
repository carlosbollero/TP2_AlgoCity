package algo3.algocity.view.panelIzq;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class VistaTextoMensajes extends JTextPane  implements Observer{

	private static final long serialVersionUID = 3806432635990925309L;
	
	TitledBorder borde;
	ArrayBlockingQueue<String> cola;
	
	public VistaTextoMensajes() {
		cola = new ArrayBlockingQueue<String>(8);
		setPreferredSize(new Dimension(200,150));
		setBackground(null);
		setEditable(false);
		borde = new TitledBorder("Mensajes");
		borde.setBorder(BorderFactory.createEtchedBorder());
		setBorder(borde);
		cola.offer("Informacion");
		setMensajes();
	}

	private void setMensajes() {
		String texto = "";
		for(String s : cola){
			texto += s + "\n";
		}
		setText(texto);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(!cola.offer((String)arg1)){
			cola.poll();
			cola.offer((String)arg1);
		}
		setMensajes();
		revalidate();
		repaint();
		
	}

}
