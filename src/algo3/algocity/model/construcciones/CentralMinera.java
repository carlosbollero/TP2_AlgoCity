package algo3.algocity.model.construcciones;

import java.awt.Point;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class CentralMinera extends UnidadEnergetica {

	public CentralMinera() {
		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
	}

	public CentralMinera(int x, int y) {
		coordenadas = new Point(x, y);
		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
	}

	public CentralMinera(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
		this.coordenadas = new Point(x, y);
		if (!(esConstruibleEn(mapa.superficie(coordenadas)) && hayConexionesEn(mapa))) {
			throw new NoSeCumplenLosRequisitosException();
		}
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarACiudad(this);
		mapa.agregarUnidadDaniable(this);
		mapa.agregarPuntoRelevanteEnRedElectrica(coordenadas);
	}
	
	
	/*Persistencia*/
	//TODO falta probarlo
	@Override
	public Element getElement(Document doc) {
		
		Element unidad = doc.createElement("CentralMinera");
		
		Element costo = doc.createElement("costo");
		unidad.appendChild(costo);
		costo.setTextContent(String.valueOf(this.costo));		
		
		Element consumo = doc.createElement("consumo");
		unidad.appendChild(consumo);
		consumo.setTextContent(String.valueOf(this.consumo));
		
		Element capacidad = doc.createElement("capacidad");
		unidad.appendChild(capacidad);
		capacidad.setTextContent(String.valueOf(this.capacidad));
		
		Element coordenadas = doc.createElement("coordenadas");
		unidad.appendChild(coordenadas);
		coordenadas.setTextContent((String.valueOf((int)this.coordenadas.getX()) +","+ String.valueOf((int)this.coordenadas.getY())));
		
		Element porcentajeDanios = doc.createElement("porcentajeDanios");
		unidad.appendChild(porcentajeDanios);
		porcentajeDanios.setTextContent(String.valueOf(this.porcentajeDanios));
		
		Element radioDeInfluencia = doc.createElement("radioDeInfluencia");
		unidad.appendChild(radioDeInfluencia);
		radioDeInfluencia.setTextContent(String.valueOf(this.radioDeInfluencia));
		
		return unidad;
	}		
}
