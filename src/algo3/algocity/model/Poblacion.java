package algo3.algocity.model;

import java.util.Observable;
import java.util.Observer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.estadosPoblacion.EstadoPoblacion;
import algo3.algocity.model.estadosPoblacion.EstadoPoblacionCreciendo;
import algo3.algocity.model.estadosPoblacion.EstadoPoblacionDecreciendo;
import algo3.algocity.model.estadosPoblacion.EstadoPoblacionEstable;
import algo3.algocity.model.mapas.Mapa;

public class Poblacion extends Observable implements Observer {
	int cantidad;
	int capacidadHabitacional;
	int capacidadEmpleo;
	int indiceCrecimiento;
	EstadoPoblacion estadoActual;
	Mapa mapa;

	public Poblacion() {
		cantidad = 0;
		capacidadHabitacional = 0;
		capacidadEmpleo = 0;
		indiceCrecimiento = 0;
		estadoActual = new EstadoPoblacionCreciendo();
	}

	public Poblacion(Mapa mapa) {
		cantidad = 0;
		capacidadEmpleo = 0;
		capacidadEmpleo = 0;
		indiceCrecimiento = 0;
		estadoActual = null;
		this.mapa = mapa;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getCapacidadHabitacional() {
		return this.capacidadHabitacional;
	}

	public int getCapacidadEmpleo() {
		return this.capacidadEmpleo;
	}

	public void aumentar() {
		cantidad++;
	}

	public void aumentar(int cantidad) {
		this.cantidad += cantidad;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		estadoActual.operar(this);
	}

	public void disminuir() {
		cantidad--;
	}

	public void disminuir(int cantidad) {
		this.cantidad -= cantidad;
	}

	public void setIndice(int indice) {
		indiceCrecimiento = indice;
		actualizarIndice();
	}

	private void actualizarIndice() {
		if (indiceCrecimiento > 0) {
			estadoActual = new EstadoPoblacionCreciendo();
		} else if (indiceCrecimiento < 0) {
			estadoActual = new EstadoPoblacionDecreciendo();
		} else {
			estadoActual = new EstadoPoblacionEstable();
		}
	}

	private void actualizarCapacidadHabitacional() {
		this.capacidadHabitacional = mapa.capacidadDePoblacion();
	}

	private void actualizarCapacidadEmpleo() {
		this.capacidadEmpleo = mapa.capacidadDeEmpleo();
	}

	public void actualizar() {
		this.actualizarCapacidadHabitacional();
		this.actualizarCapacidadEmpleo();
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/

	public Element getElement(Document doc) {
		Element poblacion = doc.createElement("Poblacion");

		Element cantidad = doc.createElement("Cantidad");
		poblacion.appendChild(cantidad);
		cantidad.setTextContent(String.valueOf(this.cantidad));

		Element capacidadHabitacional = doc
				.createElement("CapacidadHabitacional");
		poblacion.appendChild(capacidadHabitacional);
		capacidadHabitacional.setTextContent(String
				.valueOf(this.capacidadHabitacional));

		Element capacidadEmpleo = doc.createElement("CapacidadEmpleo");
		poblacion.appendChild(capacidadEmpleo);
		capacidadEmpleo.setTextContent(String.valueOf(this.capacidadEmpleo));

		Element indiceCrecimiento = doc.createElement("IndiceCrecimiento");
		poblacion.appendChild(indiceCrecimiento);
		indiceCrecimiento
				.setTextContent(String.valueOf(this.indiceCrecimiento));

		return poblacion;
	}

	public static Poblacion fromElement(Node hijoDeJuego) {
		Poblacion poblacion = new Poblacion();

		NodeList childs = hijoDeJuego.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);
			if (child.getNodeName().equals("Cantidad")) {
				poblacion.cantidad = Integer.valueOf(child.getTextContent());
			} else if (child.getNodeName().equals("CapacidadHabitacional")) {
				poblacion.capacidadHabitacional = Integer.valueOf(child
						.getTextContent());
			} else if (child.getNodeName().equals("CapacidadEmpleo")) {
				poblacion.capacidadEmpleo = Integer.valueOf(child
						.getTextContent());
			} else if(child.getNodeName().equals("IndiceCrecimiento")) {
				poblacion.indiceCrecimiento = Integer.valueOf(child.getTextContent());
			}
		}
		return poblacion;
	}
	
	public boolean equals(Poblacion p){
		if(this == p){
			return true;
		} else if(p.cantidad == this.cantidad && p.capacidadHabitacional == this.capacidadHabitacional && p.capacidadEmpleo == this.capacidadEmpleo && p.indiceCrecimiento == this.indiceCrecimiento){
			return true;
		}
		return false;
	}
}