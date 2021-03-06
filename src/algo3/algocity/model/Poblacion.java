package algo3.algocity.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import algo3.algocity.model.mapas.MapaEdilicio;

public class Poblacion implements Observer {
	int cantidad;
	int capacidadHabitacional;
	int capacidadEmpleo;
	int indiceCrecimiento;
	int tasa;
	EstadoPoblacion estadoActual;

	Mapa mapa;

	public Poblacion() {
		cantidad = Constantes.POBLACION_INICIAL;
		capacidadHabitacional = 0;
		capacidadEmpleo = 0;
		indiceCrecimiento = 0;
		tasa = 20;
		estadoActual = new EstadoPoblacionEstable();
	}

	public Poblacion(Mapa mapa) {
		cantidad = 0;
		capacidadHabitacional = 0;
		capacidadEmpleo = 0;
		indiceCrecimiento = 0;
		tasa = 20;
		estadoActual = new EstadoPoblacionEstable();
		// this.mapa = mapa;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getCapacidadHabitacional() {
		return capacidadHabitacional;
	}

	public int getCapacidadEmpleo() {
		return capacidadEmpleo;
	}
	
	public void setEstadoPoblacion(EstadoPoblacion e){
		estadoActual = e;
	}

	public void aumentar() {
		cantidad += tasa;
	}

	public void aumentar(int cantidad) {
		this.cantidad += cantidad;
	}


	@Override
	public void update(Observable arg0, Object arg1) {

		try {
			Method update = getClass().getMethod("update", arg0.getClass(),
					Object.class);
			update.invoke(this, arg0, arg1);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Turno arg0, Object arg1){
		if(!(mapa == null)){
			actualizar(mapa);
		}
		estadoActual.operar(this);
		//System.out.println("UPDATE TURNO");
	}
	
	public void update(Mapa arg0, Object arg1){
		System.out.println("UPDATE MAPA");
		this.mapa = arg0;
		actualizar(arg0);		
//		if(capacidadHabitacional == capacidadEmpleo ){
//			setIndice(0);
//		}else if(capacidadHabitacional < capacidadEmpleo){
//			//setIndice(((capacidadHabitacional/capacidadEmpleo) * 10));
//			setIndice(1);
//		}else if(capacidadHabitacional > capacidadEmpleo){
//			//setIndice(((capacidadHabitacional/capacidadEmpleo) * 10));
//			setIndice(-1);
//		}
	}
	
	public void update(MapaEdilicio arg0, Object arg1){
		
	}

	public void disminuir() {
		cantidad -= tasa;
		if(cantidad < 0) cantidad = 0;
	}

	public void disminuir(int cantidad) {
		this.cantidad -= cantidad;
	}

	public void setIndice(int indice) {
		indiceCrecimiento = indice;
		actualizarIndice();
	}

	// public void setMapa(Mapa mapa) {
	// this.mapa = mapa;
	// }

	public void actualizarIndice() {
		if (indiceCrecimiento > 0) {
			estadoActual = new EstadoPoblacionCreciendo();
		} else if (indiceCrecimiento < 0) {
			estadoActual = new EstadoPoblacionDecreciendo();
		} else {
			estadoActual = new EstadoPoblacionEstable();
		}
	}

	private void actualizarCapacidadHabitacional(Mapa mapa) {
		capacidadHabitacional = mapa.capacidadDePoblacion();
	}

	private void actualizarCapacidadEmpleo(Mapa mapa) {
		capacidadEmpleo = mapa.capacidadDeEmpleo();
	}

	public void actualizar(Mapa mapa) {
		this.actualizarCapacidadHabitacional(mapa);
		this.actualizarCapacidadEmpleo(mapa);
		setIndice(capacidadHabitacional - capacidadEmpleo);

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

		Element tasa = doc.createElement("Tasa");
		poblacion.appendChild(tasa);
		tasa.setTextContent(String.valueOf(this.tasa));

		return poblacion;
	}

	public static Poblacion fromElement(Node hijoDeJuego, Mapa mapa) {
		// Poblacion poblacion = new Poblacion();
		Poblacion poblacion = new Poblacion(mapa);
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
			} else if (child.getNodeName().equals("IndiceCrecimiento")) {
				poblacion.indiceCrecimiento = Integer.valueOf(child
						.getTextContent());
			} else if (child.getNodeName().equals("Tasa")) {
				poblacion.tasa = Integer.valueOf(child.getTextContent());
			}
		}
		poblacion.actualizar(mapa);
		return poblacion;
	}

	public boolean equals(Poblacion p) {
		if (this == p) {
			return true;
		} else if (p.cantidad == this.cantidad
				&& p.capacidadHabitacional == this.capacidadHabitacional
				&& p.capacidadEmpleo == this.capacidadEmpleo
				&& p.indiceCrecimiento == this.indiceCrecimiento
				&& p.tasa == this.tasa) {
			return true;
		}
		return false;
	}

}