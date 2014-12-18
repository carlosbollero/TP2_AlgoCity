package algo3.algocity.view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import algo3.algocity.model.Juego;

public class VistaPanelInfo extends JPanel implements Observer {

	private static final long serialVersionUID = -7918349684154728725L;

	JTextPane textoPoblacion;
	JTextPane textoOcupacion;
	JTextPane textoTurno;
	Juego juego;

	public VistaPanelInfo(Juego juego) {
		this.juego = juego;
		this.juego.turno().addObserver(this);
		this.juego.poblacion().addObserver(this);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(200, 250));
		setBorder(BorderFactory.createTitledBorder("Info"));
		
		textoPoblacion = new JTextPane();
		textoPoblacion.setBackground(null);
		textoPoblacion.setEditable(false);
		textoPoblacion.setBorder(BorderFactory.createEtchedBorder());
		textoPoblacion.setText("Poblacion  " + juego.poblacion().getCantidad());
		
		textoOcupacion = new JTextPane();
		textoOcupacion.setBackground(null);
		textoOcupacion.setEditable(false);
		textoOcupacion.setBorder(BorderFactory.createEtchedBorder());
		textoOcupacion.setText("Ocupacion  " + juego.poblacion().getCapacidadEmpleo());
		
		textoTurno = new JTextPane();
		textoTurno.setBackground(null);
		textoTurno.setEditable(false);
		textoTurno.setBorder(BorderFactory.createEtchedBorder());
		textoTurno.setText("Turno  " + juego.turno().getTurno());
		
		add(textoTurno);
		add(textoPoblacion);
		add(textoOcupacion);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		textoTurno.setText("Turno  " + juego.turno().getTurno());
		textoPoblacion.setText("Poblacion  " + juego.poblacion().getCantidad());
		textoOcupacion.setText("Ocupacion  " + juego.poblacion().getCapacidadEmpleo());
		
	}

}
