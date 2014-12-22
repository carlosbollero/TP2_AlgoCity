package algo3.algocity.model;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Mapa;

public class Reparador implements Visitante {

	private Mapa mapa;
	private ArrayList<Daniable> objetivos;

	public Reparador(Mapa mapa) {
		this.mapa = mapa;
		this.objetivos = mapa.unidadesDaniables();
	}

	//Para persistencia
	public Reparador() {
		// TODO Auto-generated constructor stub
	}
	
	public void addObjetivo(Daniable d){
		objetivos.add(d);
	}

	public void actuar() {
		for (Daniable v : this.objetivos) {
			v.aceptar(this);
		}
	}

	public void actualizarObjetivos() {
		this.objetivos = mapa.unidadesDaniables();
	}

	@Override
	public void visitar(UnidadResidencial unaUnidadResidencial) {
		unaUnidadResidencial.repararse();
	}

	@Override
	public void visitar(UnidadComercial unaUnidadComercial) {
		unaUnidadComercial.repararse();
	}

	@Override
	public void visitar(UnidadIndustrial unaUnidadIndustrial) {
		unaUnidadIndustrial.repararse();
	}

	@Override
	public void visitar(UnidadEnergetica unaUnidadEnergetica) {
		unaUnidadEnergetica.repararse();
	}

	@Override
	public void visitar(LineaTension unaLineaTension) {
		unaLineaTension.repararse();
	}

	@Override
	public void visitar(Ruta unaRuta) {
		unaRuta.repararse();
	}

	@Override
	public void visitar(Daniable unaUnidad) {
		unaUnidad.repararse();
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	public Element getElement(Document doc) {

		Element reparador = doc.createElement("Reparador");

		Element objetivos = doc.createElement("Objetivos");
		reparador.appendChild(objetivos);
		for (Daniable d : this.objetivos) {
			Element objetivo = d.getElement(doc);
			objetivos.appendChild(objetivo);
		}

		return reparador;
	}

	public static Reparador fromElement(Node hijoDeJuego) {
		
		Reparador reparador = new Reparador();
		
		NodeList childs = hijoDeJuego.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);
			if (child.getNodeName().equals("Objetivos")) {
				Daniable d = null;
				reparador.addObjetivo(d.fromElement(child));
			}
		}
		return reparador;		
	}

}
