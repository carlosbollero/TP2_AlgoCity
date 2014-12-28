package algo3.algocity.view.panelIzq;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;

import algo3.algocity.model.SistemaElectrico;

public class VistaTextoSisElectrico extends JTextPane  implements Observer {

	private static final long serialVersionUID = -3038338390913696162L;
	
	SistemaElectrico sistema;
	
	final String texto, pos, neg;
	
	public VistaTextoSisElectrico() {
		texto = "Sis. Electrico :";
		pos = " +";
		neg = " -";
		setBackground(null);
		setEditable(false);
		setBorder(BorderFactory.createEtchedBorder());
		setTexto(0, 0);
	}
	
	private void setTexto(int capacidad, int consumo){
		setText(texto + pos + capacidad + neg + consumo);
	}
	
	public void setSistemaElectrico(SistemaElectrico s){
		sistema = s;
		s.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		setTexto(sistema.capacidad(), sistema.consumo());
		
	}

}
