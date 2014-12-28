package algo3.algocity.model;

import java.util.Observable;
import java.util.Observer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;

public class SistemaElectrico implements Observer {
	
	private int capacidad;
	private int consumo;
	
	public SistemaElectrico() {
		capacidad = 0;	
	}
	
	public void aumentarCapacidad(int cantidad){
		capacidad += cantidad;
	}
	
	public void disminuirCapacidad(int cantidad){
		capacidad -= cantidad;
	}
	
	public void consumir(int cantidad) throws CapacidadElectricaInsuficienteException{
		if (consumo + cantidad > capacidad){
			throw new CapacidadElectricaInsuficienteException();
		}
		consumo += cantidad;
	}

	
	/*
	 * SistemaElectrico observa a las unidades energeticas
	 */
	@Override
	public void update(Observable o, Object arg) {
		disminuirCapacidad((int)arg);
	}
	
	public int capacidad(){
		return capacidad;
	}
	
	public int consumo(){
		return consumo;
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/

	public Element getElement(Document doc) {

		Element sistemaElectrico = doc.createElement("SistemaElectrico");

		Element capacidad = doc.createElement("capacidad");
		capacidad.setTextContent(String.valueOf(this.capacidad));
		sistemaElectrico.appendChild(capacidad);

		Element consumo = doc.createElement("consumo");
		consumo.setTextContent(String.valueOf(this.consumo));
		sistemaElectrico.appendChild(consumo);

		return sistemaElectrico;
	}

	// TODO
	public static SistemaElectrico fromElement(Node hijoDeJuego) {

		SistemaElectrico sistemaElectrico = new SistemaElectrico();

		NodeList childs = hijoDeJuego.getChildNodes();

		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);

			if (child.getNodeName().equals("capacidad")) {
				sistemaElectrico.capacidad = Integer.valueOf(child
						.getTextContent());
			} else if (child.getNodeName().equals("consumo")) {
				sistemaElectrico.consumo = Integer.valueOf(child
						.getTextContent());
			}
		}
		return sistemaElectrico;
	}

}
