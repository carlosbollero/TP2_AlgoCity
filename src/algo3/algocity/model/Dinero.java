package algo3.algocity.model;

import java.util.Observable;
import java.util.Observer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.mapas.Mapa;

public class Dinero extends Observable implements Observer {

	Turno turno;
	Poblacion poblacion;

	int cantidad;

	public Dinero() {
		turno = new Turno();
		poblacion = new Poblacion();		
		cantidad = Constantes.DINERO_INICIAL;
	}

	public Dinero(Poblacion p, Turno t) {
		poblacion = p;
		turno = t;
		cantidad = Constantes.DINERO_INICIAL;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		cobrarImpuestos();
	}

	public int getCantidad() {
		return cantidad;
	}
	
	private void cobrarImpuestos(){
		if (turno.getTurno() % Constantes.CANT_TURNOS_IMPUESTOS == 0) {
			cantidad += poblacion.getCantidad() * Constantes.IMPUESTO_POR_HABITANTE;
		}
	}

	// public void cobrar(int costo){
	// cantidad -= costo;
	// }

	public boolean cobrar(int costo) throws FondosInsuficientesException {
		if (cantidad < costo) {
			throw new FondosInsuficientesException();
		}
		cantidad -= costo;
		setChanged();
		notifyObservers();
		return true;
	}
	
	public void add(int cantidad){
		this.cantidad += cantidad;
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**
	 * ********************************************************************/


	public Element getElement(Document doc) {

		Element dinero = doc.createElement("Dinero");

		Element turno = this.turno.getElement(doc);
		dinero.appendChild(turno);

		Element poblacion = this.poblacion.getElement(doc);
		dinero.appendChild(poblacion);

		Element cantidad = doc.createElement("Cantidad");
		cantidad.setTextContent(String.valueOf(this.cantidad));
		dinero.appendChild(cantidad);

		return dinero;
	}

	public static Dinero fromElement(Node hijoDeJuego,Mapa mapa, Turno t, Poblacion p) {
		Dinero dinero = new Dinero(p,t);
		NodeList childs = hijoDeJuego.getChildNodes();

		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);

			if (child.getNodeName().equals("Turnos")) {
				dinero.turno = Turno.fromElement(child);
			} else if (child.getNodeName().equals("Poblacion")) {
				dinero.poblacion = Poblacion.fromElement(child,mapa);
			} else if (child.getNodeName().equals("Cantidad")) {
				dinero.cantidad = Integer.valueOf(child.getTextContent());
			}
		}
		//dinero.cobrarImpuestos();
		return dinero;
	}


}
