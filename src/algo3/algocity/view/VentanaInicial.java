package algo3.algocity.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import algo3.algocity.model.Juego;

public class VentanaInicial extends JFrame {

	private static final long serialVersionUID = 832543094709914213L;

	JPanel panelFondo;

	public VentanaInicial() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		super("Algoritmos 3 | AlgoCity");
		initPanelFondo();
		setPanelFondo();
		acomodar();
		initSonido();
	}

	private void initSonido() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		Clip sonido = AudioSystem.getClip();
		File file = new File("sound/SummerTown.wav");
		sonido.open(AudioSystem.getAudioInputStream(file));
		sonido.loop(Clip.LOOP_CONTINUOUSLY);
	}

	private void initPanelFondo() {

		/* Creo el unico panel que tiene la ventana de inicio */
		this.panelFondo = new JPanel();
	}

	private void setPanelFondo() {

		panelFondo.setLayout(new CardLayout());

		VistaInicial vista1 = new VistaInicial(this);
		VistaJugadorNuevoOExistente vista2 = new VistaJugadorNuevoOExistente(
				this);
		VistaJugadorNuevo vista3 = new VistaJugadorNuevo(this);
		VistaJugadorExistente vista4 = new VistaJugadorExistente(this);

		/* El panel del fondo es uno solo y se va intercambiando su contenido */
		panelFondo.add(vista1, "vistaInicial");
		panelFondo.add(vista2, "vistaJugNuevoOExist");
		panelFondo.add(vista3, "vistaJugNuevo");
		panelFondo.add(vista4, "vistaJugExistente");

		add(panelFondo);

		mostrarVistaInicial();
		// mostrarVistaJugadorNuevoOExistente();
		// mostrarVistaJugadorNuevo();
		// mostrarVistaJugadorExistente();
	}

	public void mostrarVistaInicial() {
		((CardLayout) panelFondo.getLayout()).show(panelFondo, "vistaInicial");
	}

	public void mostrarVistaJugadorNuevoOExistente() {
		((CardLayout) panelFondo.getLayout()).show(panelFondo,
				"vistaJugNuevoOExist");
	}

	public void mostrarVistaJugadorNuevo() {
		((CardLayout) panelFondo.getLayout()).show(panelFondo, "vistaJugNuevo");
	}

	public void mostrarVistaJugadorExistente() {
		((CardLayout) panelFondo.getLayout()).show(panelFondo,
				"vistaJugExistente");
	}

	private void acomodar() {
		setPreferredSize(new Dimension(800, 600));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();

		// agregado para que tenga tamanio fijo
		setResizable(false);
	}

	public Juego comenzar() {
		//devuelve la instancia de juego que corresponda
		
		// TODO Auto-generated method stub
		return null;
	}

	public void ocultar() {
		setVisible(false);
		
	}

	public void cerrar() {
		this.dispose();
		
	}

}
