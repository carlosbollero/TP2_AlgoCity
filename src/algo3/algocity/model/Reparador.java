package algo3.algocity.model;

import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.EstacionDeBomberos;
import algo3.algocity.model.construcciones.PozoDeAgua;
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

	// Para persistencia
	public Reparador() {
		this.objetivos = new ArrayList<Daniable>();
	}

	public void addObjetivo(Daniable d) {
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

	public ArrayList<Daniable> objetivos() {
		return this.objetivos;
	}

	public Mapa mapa() {
		return this.mapa;
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	public Element getElement(Document doc) {

		Element reparador = doc.createElement("reparador");
		//No se guarda el mapa en reparador, para no guardarlo dos veces
//		Element mapa = this.mapa.getElement(doc);
//		reparador.appendChild(mapa);
		
		Element objetivos = doc.createElement("Objetivos");
		reparador.appendChild(objetivos);
		for (Daniable d : this.objetivos) {
			Element objetivo = d.getElement(doc);
			objetivos.appendChild(objetivo);
		}
		return reparador;
	}


	public static Reparador fromElement(Node hijoDeJuego, Mapa mapa) {

		Reparador reparador = new Reparador();

		NodeList childs = hijoDeJuego.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);
			if (child.getNodeName().equals("Objetivos")) {
				NodeList hijosDeObjetivos = child
						.getChildNodes();
				for (int j = 0; j < hijosDeObjetivos.getLength(); j++) {
					Node hijoDeObjetivo = hijosDeObjetivos
							.item(j);
					if (hijoDeObjetivo.getNodeName().equals(
							"UnidadIndustrial")) {
						UnidadIndustrial ui = new UnidadIndustrial();
						ui.fromElement(hijoDeObjetivo);
						reparador.objetivos.add(ui);
					} else if (hijoDeObjetivo.getNodeName().equals(
							"UnidadResidencial")) {
						UnidadResidencial ur = new UnidadResidencial();
						ur.fromElement(hijoDeObjetivo);
						reparador.objetivos.add(ur);
					} else if (hijoDeObjetivo.getNodeName().equals(
							"UnidadComercial")) {
						UnidadComercial uc = new UnidadComercial();
						uc.fromElement(hijoDeObjetivo);
						reparador.objetivos.add(uc);
					} else if (hijoDeObjetivo.getNodeName().equals(
							"CentralEolica")) {
						CentralEolica ce = new CentralEolica();
						ce.fromElement(hijoDeObjetivo);
						reparador.objetivos.add(ce);
					} else if (hijoDeObjetivo.getNodeName().equals(
							"CentralMinera")) {
						CentralMinera cm = new CentralMinera();
						cm.fromElement(hijoDeObjetivo);
						reparador.objetivos.add(cm);
					} else if (hijoDeObjetivo.getNodeName().equals(
							"CentralNuclear")) {
						CentralNuclear cn = new CentralNuclear();
						cn.fromElement(hijoDeObjetivo);
						reparador.objetivos.add(cn);
					} else if (hijoDeObjetivo.getNodeName().equals(
							"EstacionDeBomberos")) {
						EstacionDeBomberos eb = new EstacionDeBomberos();
						eb.fromElement(hijoDeObjetivo);
						reparador.objetivos.add(eb);
					} else if (hijoDeObjetivo.getNodeName().equals(
							"PozoDeAgua")) {
						PozoDeAgua pa = new PozoDeAgua();
						pa.fromElement(hijoDeObjetivo);
						reparador.objetivos.add(pa);
					} else if (hijoDeObjetivo.getNodeName()
							.equals("Ruta")) {
						Ruta rt = new Ruta();
						rt.fromElement(hijoDeObjetivo);
						reparador.objetivos.add(rt);
					} else if (hijoDeObjetivo.getNodeName().equals(
							"LineaTension")) {
						LineaTension lt = new LineaTension();
						lt.fromElement(hijoDeObjetivo);
						reparador.objetivos.add(lt);
					}
				}		
			}
			reparador.mapa = mapa;
		}
		return reparador;
	}

	public boolean equals(Reparador r) {
		if (r == this) {
			return true;
		} 
		boolean resultado = true;
		Iterator<Daniable> itThis = this.objetivos().iterator();
		Iterator<Daniable> it = r.objetivos().iterator();
		while(it.hasNext() && itThis.hasNext() && resultado){
			if(!it.next().equals(itThis.next())){
				resultado = false;
			}
		}
		return resultado;
	}
}
