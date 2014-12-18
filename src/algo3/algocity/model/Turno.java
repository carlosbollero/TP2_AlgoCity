package algo3.algocity.model;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Turno extends Observable{

	int numero;
	Timer timer;
	long delay;
	
	TimerTask tarea = new TimerTask() {		
		@Override
		public void run() {
			avanzar();			
		}
	};

	public Turno() {
		numero = 1;
		delay = 5000;
		timer = new Timer();
		timer.schedule(tarea, delay, delay);
	}

	public int getTurno() {
		return numero;
	}
	
	public long getDelay(){
		return delay;
	}

	public void avanzar() {
		numero++;
		setChanged();
		notifyObservers();
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	public Element getElement(Document doc) {

		Element turnos = doc.createElement("Turnos");

		Element numero = doc.createElement("numero");
		turnos.appendChild(numero);
		numero.setTextContent(String.valueOf(this.numero));

		return turnos;
	}

	public static Turno fromElement(Node hijoDeJuego) {
		Turno turno = new Turno();

		NodeList childs = hijoDeJuego.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);
			if (child.getNodeName().equals("numero")) {
				turno.numero = Integer.valueOf(child.getTextContent());
			}
		}
		return turno;
	}

}