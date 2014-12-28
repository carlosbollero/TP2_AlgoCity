import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import algo3.algocity.model.excepciones.NoSeEncontroElFicheroException;
import algo3.algocity.view.VentanaInicial;

public class App {

	public static void main(String arg[]) throws LineUnavailableException,

			IOException, UnsupportedAudioFileException, SAXException,
			ParserConfigurationException, NoSeEncontroElFicheroException{
		VentanaInicial ventanaInicio = new VentanaInicial();
	}

}
