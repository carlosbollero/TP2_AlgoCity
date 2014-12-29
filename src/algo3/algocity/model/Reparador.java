package algo3.algocity.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Mapa;

public class Reparador implements Observer {

	private Mapa mapa;
	private ArrayList<Daniable> objetivos;

	public Reparador(Mapa mapa) {
		this.mapa = mapa;
		objetivos = new ArrayList<Daniable>();
		actualizarObjetivos();
	}

	// Para persistencia
	public Reparador() {
		objetivos = new ArrayList<Daniable>();
	}

	public void actuar() {
		actualizarObjetivos();
		for (Daniable v : objetivos) {
			v.repararse();
		}
	}
	
	
	public void actualizarObjetivos() {
		objetivos = new ArrayList<Daniable>(mapa.rutas().unidadesDaniables());
		objetivos.addAll(mapa.redElectrica().unidadesDaniables());
		objetivos.addAll(mapa.ciudad().unidadesDaniables());
	}

	@Override
	public void update(Observable o, Object arg) {
		actuar();
	}

	
	public ArrayList<Daniable> objetivos() {
		return this.objetivos;
	}
	
	
//	public HashSet<Daniable> objetivos() {
//		
//		//uso un hashset para evitar elementos repetidos
//		HashSet<Daniable> setObjetivos = new HashSet<Daniable>(this.objetivos);
//		
//		return setObjetivos;
//		//return this.objetivos;
//	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	public Element getElement(Document doc) {

		Element reparador = doc.createElement("reparador");
		// No se guarda el mapa en reparador, para no guardarlo dos veces
		// Element mapa = this.mapa.getElement(doc);
		// reparador.appendChild(mapa);

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
		reparador.mapa = mapa;

		NodeList childs = hijoDeJuego.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);
			if (child.getNodeName().equals("Objetivos")) {
				NodeList hijosDeObjetivos = child.getChildNodes();
				for (int j = 0; j < hijosDeObjetivos.getLength(); j++) {
					Node hijoDeObjetivo = hijosDeObjetivos.item(j);
					if (hijoDeObjetivo.getNodeName().equals("UnidadIndustrial")) {
						UnidadIndustrial ui = new UnidadIndustrial();
						ui.fromElement(hijoDeObjetivo);
						if(!reparador.objetivos.contains(ui)){
							reparador.objetivos.add(ui);
						}
					} else if (hijoDeObjetivo.getNodeName().equals(
							"UnidadResidencial")) {
						UnidadResidencial ur = new UnidadResidencial();
						ur.fromElement(hijoDeObjetivo);
						if(!reparador.objetivos.contains(ur)){
							reparador.objetivos.add(ur);
						}
					} else if (hijoDeObjetivo.getNodeName().equals(
							"UnidadComercial")) {
						Daniable uc = new UnidadComercial();
						uc.fromElement(hijoDeObjetivo);
						reparador.objetivos.add(uc);
					} else if (hijoDeObjetivo.getNodeName().equals(
							"CentralEolica")) {
						UnidadEnergetica ce = new CentralEolica();
						ce.fromElement(hijoDeObjetivo);
						if(!reparador.objetivos.contains(ce)){
							reparador.objetivos.add(ce);
						}
					} else if (hijoDeObjetivo.getNodeName().equals(
							"CentralMinera")) {
						CentralMinera cm = new CentralMinera();
						cm.fromElement(hijoDeObjetivo);
						if(!reparador.objetivos.contains(cm)){
							reparador.objetivos.add(cm);
						}
					} else if (hijoDeObjetivo.getNodeName().equals(
							"CentralNuclear")) {
						CentralNuclear cn = new CentralNuclear();
						cn.fromElement(hijoDeObjetivo);
						if(!reparador.objetivos.contains(cn)){
							reparador.objetivos.add(cn);
						}
					} else if (hijoDeObjetivo.getNodeName().equals("Ruta")) {
						Daniable rt = new Ruta();
						rt.fromElement(hijoDeObjetivo);
						if(!reparador.objetivos.contains(rt)){
							reparador.objetivos.add(rt);
						}
					} else if (hijoDeObjetivo.getNodeName().equals(
							"LineaTension")) {
						LineaTension lt = new LineaTension();
						lt.fromElement(hijoDeObjetivo);
						if(!reparador.objetivos.contains(lt)){
							reparador.objetivos.add(lt);
						}
					}
				}
			}
		}
		//revisar este metodo, porque vuelve a agregar los objetivos cada vez que se guarda
		//el juego
		reparador.actualizarObjetivos();
		return reparador;
	}

	public boolean equals(Reparador r) {
		if (r == this) {
			return true;
		}
		boolean resultado = true;
		Iterator<Daniable> itThis = this.objetivos().iterator();
		Iterator<Daniable> it = r.objetivos().iterator();
		while (it.hasNext() && itThis.hasNext() && resultado) {
			if (!it.next().equals(itThis.next())) {
				resultado = false;
			}
		}
		return resultado;
	}

}
