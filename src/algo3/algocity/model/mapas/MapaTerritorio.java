package algo3.algocity.model.mapas;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.terreno.Superficie;
import algo3.algocity.model.terreno.SuperficieAgua;
import algo3.algocity.model.terreno.SuperficieTierra;

public class MapaTerritorio {

	int alto;
	int ancho;
	final boolean tierra = true;
	final boolean agua = false;
	HashMap<Point, Superficie> mapa;
	Random aleatorio;

	public MapaTerritorio(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.aleatorio = new Random();
		this.mapa = new HashMap<Point, Superficie>();
		this.inicializar();
	}
	
	// CONSTRUCTOR PARA TESTS
	/*************************************************************/
	public MapaTerritorio(int alto, int ancho, boolean test) {
		this.alto = alto;
		this.ancho = ancho;
		this.mapa = new HashMap<Point, Superficie>();
		if (test) {
			inicializarConTierraParaTest();
		} else {
			inicializarConAguaParaTest();
		}
	}
	public MapaTerritorio() {
		this.mapa = new HashMap<Point, Superficie>();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************/

	private void inicializar() {
		for (int x = 0; x < alto; x++) {
			for (int y = 0; y < ancho; y++) {
				Superficie posicion;
				if (aleatorio.nextBoolean()) {
					posicion = new SuperficieAgua();
				} else {
					posicion = new SuperficieTierra();
				}
				agregar(posicion, x, y);
			}
		}
	}

	public boolean agregar(Superficie superficie, int x, int y) {
		Point coord = new Point(x, y);
		mapa.put(coord, superficie);
		return (mapa.containsKey(coord) && mapa.containsValue(superficie));
	}

	public boolean esAgua(Point punto) {
		return (superficie(punto).esAgua());
	}

	public boolean esTierra(Point punto) {
		return (superficie(punto).esTierra());
	}
	
	public boolean posicionConAgua(Point punto) {
		return (superficie(punto).esAgua());
	}

	public boolean posicionConTierra(Point punto) {
		return (superficie(punto).esTierra());
	}

	public Superficie superficie(Point punto) {
		return (this.mapa.get(punto));
	}

	public boolean sePuedeConstruir(Unidad unidad) {
		return unidad.esConstruibleEn(superficie(unidad.coordenadas())
				.getSuperficie());
	}

	public boolean sePuedeConstruir(Conector conector) {
		return conector
				.esConstruibleEn(superficie(conector.coordenadas())
						.getSuperficie());
	}
	
	// METODOS UTILIZADOS POR TESTS PARA NO TRABAJAR SOBRE RANDOM
	/****************************************************************/	
	private void inicializarConTierraParaTest(){
		for (int x = 0; x < alto; x++) {
			for (int y = 0; y < ancho; y++) {
				Superficie posicion = new SuperficieTierra();
				agregar(posicion, x, y);
			}
		}
	}
	
	private void inicializarConAguaParaTest(){
		for (int x = 0; x < alto; x++) {
			for (int y = 0; y < ancho; y++) {
				Superficie posicion = new SuperficieAgua();
				agregar(posicion, x, y);
			}
		}
	}
	
	public Point posicionConAgua() {
		for (Entry<Point, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esAgua()) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	public Point posicionConTierra() {
		
		for (Entry<Point, Superficie> entry : mapa.entrySet()) {
			if (entry.getValue().esTierra()) {
				return entry.getKey();
			}
		}
		return null;
	}
	/****************************************************************/

	/*Persistencia*/
	@SuppressWarnings("rawtypes")
	public Element getElement(Document doc, Element territorio) {
		
		Element alto = doc.createElement("alto");
		territorio.appendChild(alto);
		alto.setTextContent(String.valueOf(this.alto));

		Element ancho = doc.createElement("ancho");
		territorio.appendChild(ancho);
		ancho.setTextContent(String.valueOf(this.ancho));	
		
		Element mapa = doc.createElement("mapa");
		territorio.appendChild(mapa);
		/*Recorrido del hashmap*/
        for (Map.Entry e : this.mapa.entrySet()) {
        	Point clave = (Point) e.getKey();
        	Superficie valor = (Superficie) e.getValue();
        	
        	Element nodo = doc.createElement("Nodo");
        	mapa.appendChild(nodo);
        	
        	Element point = doc.createElement("Point");
        	nodo.appendChild(point);
        	point.setTextContent(String.valueOf((int)clave.getX()) +","+ String.valueOf((int)clave.getY()));
        	
        	Element superficie = doc.createElement("Superficie");
        	nodo.appendChild(superficie);
        	String sup;
        	if(valor.esTierra()){
        		sup = "T";
        	}else{
        		sup = "A";
        	}
           	superficie.setTextContent(sup);       	
        }
		return territorio;
	}

	public static MapaTerritorio fromElement(Node territorio) {
		
		MapaTerritorio mapaTerritorio = new MapaTerritorio();
		//TODO
		//PROBAR DE RECORRER RECIBIENDO EL NODO territorio
		//...
		
		
		/*
		NodeList childs = territorio.getChildNodes();
		for (int i = 1; i < childs.getLength(); i++) {
			Node child = childs.item(i);
			
			if (child.getNodeName().equals("alto")) {
				territorio.alto = Integer.valueOf(child.getTextContent());
			} else if (child.getNodeName().equals("ancho")) {
				territorio.ancho = Integer.valueOf(child.getTextContent());
			} else if (child.getNodeName().equals("mapa")){
				NodeList hijosDeMapa = child.getChildNodes();
				for(int j = 0; j < hijosDeMapa.getLength(); j++){
					Node hijoDeMapa = hijosDeMapa.item(j);
					if(hijoDeMapa.getNodeName().equals("Nodo")){
						String punto = hijoDeMapa.getFirstChild().getTextContent();
						String superficie = hijoDeMapa.getLastChild().getTextContent();
						
						Superficie superficieAAgregar;
						Point puntoAAgregar;
						
						if(superficie == "T"){
							superficieAAgregar = new SuperficieTierra();
						}else{
							superficieAAgregar = new SuperficieAgua();
						}
						
						String[] arrayPunto = punto.split(",");
						puntoAAgregar = new Point(Integer.valueOf(arrayPunto[0]),Integer.valueOf(arrayPunto[1]));
													
						territorio.mapa.put(puntoAAgregar, superficieAAgregar);	
						
						
						
						
						/*
						NodeList hijosDeNodo = hijoDeMapa.getChildNodes();
						for(int k = 0; k < hijosDeNodo.getLength();k++){
							Node hijoDeNodo = hijosDeNodo.item(k);
							String punto = "";
							String superficie = "";
							if(hijoDeNodo.getNodeName().equals("Point")){
								punto = hijoDeNodo.getTextContent();
							}
							if(hijoDeNodo.getNodeName().equals("Superficie")){
								superficie = hijoDeNodo.getTextContent();
							}
							
							Superficie superficieAAgregar;
							Point puntoAAgregar;
							
							if(superficie == "T"){
								superficieAAgregar = new SuperficieTierra();
							}else{
								superficieAAgregar = new SuperficieAgua();
							}
							
							String[] arrayPunto = punto.split(",");
							puntoAAgregar = new Point(Integer.valueOf(arrayPunto[0]),Integer.valueOf(arrayPunto[1]));
														
							territorio.mapa.put(puntoAAgregar, superficieAAgregar);									
							
						}
						*/
						
					}
					
				}
				
			}
						
		}	
				
		return mapaTerritorio;
		
	}
	
	
	/*Pruebas*/
	
	public void imprimirTerritorio(){
		 for (Map.Entry e : this.mapa.entrySet()) {
	        	Point clave = (Point) e.getKey();
	        	Superficie valor = (Superficie) e.getValue();
	        	
	        	System.out.println(String.valueOf(clave.getX()));
	        	System.out.println(String.valueOf(clave.getY()));
	        	if(valor.esTierra()){
	        		System.out.println("T");
	        	}else {
	        		System.out.println("A");
	        	}        	
		 }   	
	}
	
	
}



