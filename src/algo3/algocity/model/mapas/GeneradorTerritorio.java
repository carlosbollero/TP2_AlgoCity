package algo3.algocity.model.mapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import algo3.algocity.model.terreno.Superficie;
import algo3.algocity.model.terreno.SuperficieAgua;
import algo3.algocity.model.terreno.SuperficieTierra;

public class GeneradorTerritorio {
	
	Random aleatorio;
	SortedSet<Coordenada> puntosCentrales;
	ArrayList<Coordenada> coordNoOcupadas;
	Map<Coordenada, Superficie> mapa;
	int alto;
	int ancho;
	int tamanio;
	
	public GeneradorTerritorio(int alto, int ancho){
		this.alto = alto;
		this.ancho = ancho;
		tamanio = alto*ancho;
		coordNoOcupadas = new ArrayList<Coordenada>();
		rellenarCoordenadasNoOcupadas();
		puntosCentrales = new TreeSet<Coordenada>();
		mapa = new HashMap<Coordenada, Superficie>();
		aleatorio = new Random();
	}
	
	public Map<Coordenada, Superficie> generarTerritorio(){
		definirPuntosCentrales();
		definirRestoDelMapa();
		return mapa;
	}
	
	public void definirPuntosCentrales() {
		int cantidad = ((tamanio * 10) / 100);
		for(int i = 0; i < cantidad; i++){
			Coordenada c = coordenadaAleatoria();
			Superficie s = superficieAleatoria();
			mapa.put(c, s);
			puntosCentrales.add(c);			
			coordNoOcupadas.remove(c);
		}

	}
	
	private void rellenarCoordenadasNoOcupadas() {
		for (int x = 0; x < alto; x++){
			for (int y = 0; y < ancho; y++){
				coordNoOcupadas.add(new Coordenada(x,y));
			}
		}		
	}
	
	private void definirRestoDelMapa() {

		for (Coordenada coord : coordNoOcupadas){
			Superficie ref = superficieMasCercana(coord);
			Superficie sup;
			if (ref.esAgua()){
				sup = new SuperficieAgua();
			}else{
				sup = new SuperficieTierra();
			}
			mapa.put(coord, sup);
		}
		
	}
	
//	private Nodo generarNodo(Coordenada c) {
//		Superficie s;
//		Superficie ref = superficieMasCercana(c);
//		if(ref.esAgua()){
//			s= new SuperficieAgua();
//		}else{
//			s = new SuperficieTierra();
//		}
//		return new Nodo(c,s);
//	}

	private Superficie superficieMasCercana(Coordenada c) {
		Coordenada ref = puntosCentrales.first();
		int dist = c.distacia(ref);
		for (Coordenada coord : puntosCentrales){
			if (c.distacia(coord) < dist){
				dist = c.distacia(coord);
				ref = coord;
			}
		}
		return mapa.get(ref);
	}

	/*
	 * Genera una Coordenada aleatoria dentro de los limites
	 * del mapa y asegurandose que no repita una generada 
	 * anteriormente como punto central.
	 */
	private Coordenada coordenadaAleatoria(){
		boolean repetido = true;
		Coordenada coord = null;
		while(repetido){
			coord = new Coordenada(aleatorio.nextInt(alto), aleatorio.nextInt(ancho));
			repetido = puntosCentrales.contains(coord);
		}
		return coord;
	}
	
	/*
	 * Genera una supeficie aleatoria, con mayor 
	 * probabilidad de que sea Tierra.
	 */
	private Superficie superficieAleatoria(){
		Superficie s;
		int numero = aleatorio.nextInt(10);
		if( numero > 6){
			s = new SuperficieAgua();
		}else{
			s = new SuperficieTierra();
		}
		return s;
	}
	
	public ArrayList<Coordenada> getPuntonsCentrales(){
		ArrayList<Coordenada> lista = new ArrayList<Coordenada>();
		for (Coordenada coord : puntosCentrales){
			lista.add(coord);
		}
		return lista;
	}
}
