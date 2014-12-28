package algo3.algocity.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import algo3.algocity.model.Juego;
import algo3.algocity.model.excepciones.NoSeEncontroElFicheroException;
import algo3.algocity.view.vistaInicial.VistaInicial;
import algo3.algocity.view.vistaInicial.VistaJugadorExistente;
import algo3.algocity.view.vistaInicial.VistaJugadorNuevo;
import algo3.algocity.view.vistaInicial.VistaPuntajes;

public class VentanaInicial extends JFrame {

	private static final long serialVersionUID = 832543094709914213L;

	JPanel panelFondo;
	AudioStream audioStream;

	public VentanaInicial() throws LineUnavailableException, IOException,
			UnsupportedAudioFileException, SAXException,
			ParserConfigurationException, NoSeEncontroElFicheroException {
		super("Algoritmos 3 | AlgoCity");
		initPanelFondo();
		setPanelFondo();
		acomodar();
		initSonido();
	}

	private void initSonido() throws LineUnavailableException, IOException,
			UnsupportedAudioFileException {
		// Clip sonido = AudioSystem.getClip();
		// File file = new File("sound/SummerTown.wav");
		// sonido.open(AudioSystem.getAudioInputStream(file));
		// sonido.loop(Clip.LOOP_CONTINUOUSLY);

		// InputStream in = new FileInputStream(new
		// File("sound/SummerTown.wav"));
		InputStream in = new FileInputStream(new File(
				"sound/SimCityMusicTheme.wav"));

		audioStream = new AudioStream(in);
		AudioPlayer.player.start(audioStream);
	}

	private void stopSonido() {
		AudioPlayer.player.stop(audioStream);
	}

	private void initPanelFondo() {
		/* Creo el unico panel que tiene la ventana de inicio */
		this.panelFondo = new JPanel();
	}

	private void setPanelFondo() throws SAXException, IOException,
			ParserConfigurationException, NoSeEncontroElFicheroException {

		panelFondo.setLayout(new CardLayout());

		VistaInicial vista1 = new VistaInicial(this);
		VistaJugadorNuevo vista3 = new VistaJugadorNuevo(this);
		VistaJugadorExistente vista4 = new VistaJugadorExistente(this);
		VistaPuntajes vista5 = new VistaPuntajes(this);

		/* El panel del fondo es uno solo y se va intercambiando su contenido */
		panelFondo.add(vista1, "vistaInicial");
		panelFondo.add(vista3, "vistaJugNuevo");
		panelFondo.add(vista4, "vistaJugExistente");
		panelFondo.add(vista5, "vistaPuntajes");

		add(panelFondo);

		mostrarVistaInicial();
	}

	public void mostrarVistaInicial() {
		((CardLayout) panelFondo.getLayout()).show(panelFondo, "vistaInicial");
	}

	public void mostrarVistaJugadorNuevo() {
		((CardLayout) panelFondo.getLayout()).show(panelFondo, "vistaJugNuevo");
	}

	public void mostrarVistaJugadorExistente() {
		((CardLayout) panelFondo.getLayout()).show(panelFondo,
				"vistaJugExistente");
	}

	public void mostrarVistaPuntajes() {
		((CardLayout) panelFondo.getLayout()).show(panelFondo, "vistaPuntajes");
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
		// devuelve la instancia de juego que corresponda

		// TODO Auto-generated method stub
		return null;
	}

	public void ocultar() {
		setVisible(false);

	}

	public void cerrar() {
		this.dispose();
		stopSonido();

	}

}
