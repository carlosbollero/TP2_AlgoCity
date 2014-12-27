package algo3.algocity.view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import algo3.algocity.model.Juego;

public class VistaPanelInfo extends JPanel implements Observer {

	private static final long serialVersionUID = -7918349684154728725L;

	JTextPane textoTurno, textoPoblacion, textoOcupacion, textoDinero,
			textoMensajes;
	Juego juego;

	public VistaPanelInfo(Juego juego) {
		this.juego = juego;
		this.juego.turno().addObserver(this);
		this.juego.dinero().addObserver(this);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createTitledBorder("Info"));

		textoTurno = new JTextPane();
		textoTurno.setBackground(null);
		textoTurno.setEditable(false);
		textoTurno.setBorder(BorderFactory.createEtchedBorder());
		textoTurno.setText("Turno  " + juego.turno().getTurno());

		textoPoblacion = new JTextPane();
		textoPoblacion.setBackground(null);
		textoPoblacion.setEditable(false);
		textoPoblacion.setBorder(BorderFactory.createEtchedBorder());
		textoPoblacion.setText("Poblacion  " + juego.poblacion().getCantidad());

		textoOcupacion = new JTextPane();
		textoOcupacion.setBackground(null);
		textoOcupacion.setEditable(false);
		textoOcupacion.setBorder(BorderFactory.createEtchedBorder());
		textoOcupacion.setText("Ocupacion  "
				+ juego.poblacion().getCapacidadEmpleo());

		textoDinero = new JTextPane();
		textoDinero.setBackground(null);
		textoDinero.setEditable(false);
		textoDinero.setBorder(BorderFactory.createEtchedBorder());
		textoDinero.setText("Dinero  $" + juego.dinero().getCantidad());

		textoMensajes = new JTextPane();
		textoMensajes.setPreferredSize(new Dimension(200,150));
		textoMensajes.setBackground(null);
		textoMensajes.setEditable(false);
		TitledBorder borde = new TitledBorder("Mensajes");
		borde.setBorder(BorderFactory.createEtchedBorder());
		textoMensajes.setBorder(borde);
		textoMensajes.setText("Informacion");

		add(textoTurno);
		add(textoPoblacion);
		add(textoOcupacion);
		add(textoDinero);
		add(textoMensajes);
	}
	
	//Revisar uso
	public void cambiarMensajeInformacion (String texto){
		textoMensajes.setText(texto); 
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		textoTurno.setText("Turno  " + juego.turno().getTurno());
		textoPoblacion.setText("Poblacion  " + juego.poblacion().getCantidad());
		textoOcupacion.setText("Ocupacion  "
				+ juego.poblacion().getCapacidadEmpleo());
		textoDinero.setText("Dinero  $" + juego.dinero().getCantidad());
	}

}
