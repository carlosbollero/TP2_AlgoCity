package algo3.algocity.model.construcciones;

import java.awt.Point;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class UnidadComercial extends Unidad implements Daniable, Visitable {

	int consumo;
	final double ESTADOINICIAL = 100;
	double porcentajeDanios;

	public UnidadComercial() {
		this.costo = 5;
		this.consumo = 2;
	}

	public UnidadComercial(int x, int y) {
		coordenadas = new Coordenada(x, y);
		this.costo = 5;
		this.consumo = 2;
	}

	public UnidadComercial(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		this.costo = 5;
		this.consumo = 2;
		coordenadas = new Coordenada(x, y);
		if (!(esConstruibleEn(mapa.superficie(coordenadas)) && hayConexionesEn(mapa))) {
			throw new NoSeCumplenLosRequisitosException();
		}
	}

	public int consumo() {
		return this.consumo;
	}

	@Override
	public void repararse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void aplicarDanio(double cantidad) {
		this.porcentajeDanios += cantidad;
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		}
	}

	@Override
	public double getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);

	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 75;

	}

	private boolean hayConexionesEn(Mapa mapa) {
		return (mapa.hayConexionCompleta(coordenadas));
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {

		return superficie.esTierra();
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarACiudad(this);
		mapa.agregarUnidadDaniable(this);
	}
	
	/*Persistencia*/
	@Override
	public Element getElement(Document doc) {
		
		Element unidad = doc.createElement("UnidadComercial");
		
		Element costo = doc.createElement("costo");
		unidad.appendChild(costo);
		costo.setTextContent(String.valueOf(this.costo));		
		
		Element consumo = doc.createElement("consumo");
		unidad.appendChild(consumo);
		consumo.setTextContent(String.valueOf(this.consumo));
		
		Element coordenadas = doc.createElement("coordenadas");
		unidad.appendChild(coordenadas);
		coordenadas.setTextContent((String.valueOf((int)this.coordenadas.getX()) +","+ String.valueOf((int)this.coordenadas.getY())));
		
		Element porcentajeDanios = doc.createElement("porcentajeDanios");
		unidad.appendChild(porcentajeDanios);
		porcentajeDanios.setTextContent(String.valueOf(this.porcentajeDanios));
		
		return unidad;
	}

	public static UnidadComercial fromElement(Node hijoDeNodo) {
		
		UnidadComercial uc = new UnidadComercial();
		NodeList hijosDeUnidadComercial = hijoDeNodo.getChildNodes();

		for (int i = 0; i < hijosDeUnidadComercial.getLength(); i++) {		
			Node hijoDeUnidad = hijosDeUnidadComercial.item(i);
			if(hijoDeUnidad.getNodeName().equals("costo")){
				uc.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if(hijoDeUnidad.getNodeName().equals("consumo")){
				uc.consumo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if(hijoDeUnidad.getNodeName().equals("porcentajeDanios")){
				uc.porcentajeDanios = Double.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeUnidad.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				uc.coordenadas = punto;
			}
		}	
		return uc;		
	}


}