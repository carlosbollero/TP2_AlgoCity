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
	
	private void rellenarCoordenadasNoOcupadas() {
		for (int x = 0; x < alto; x++){
			for (int y = 0; y < ancho; y++){
				coordNoOcupadas.add(new Coordenada(x,y));
			}
		}
		for (Coordenada c : coordNoOcupadas){
			System.out.print("[" + c.getX() + c.getY() + "]");
		}
		System.out.println();
		
	}

	public Map<Coordenada, Superficie> generarTerritorio(){
		definirPuntosCentrales();
		definirRestoDelMapa();
		return mapa;
	}
	
	public void definirPuntosCentrales() {
		int cantidad = ((tamanio * 10) / 100);
		System.out.println(coordNoOcupadas.size());
		for(int i = 0; i < cantidad; i++){
			Coordenada c = coordenadaAleatoria();
			Superficie s = superficieAleatoria();
			mapa.put(c, s);
			puntosCentrales.add(c);			
			coordNoOcupadas.remove(c);
			System.out.print("[" + c.getX() + c.getY() + "]");
		}
		System.out.println();
		for (Coordenada c : coordNoOcupadas){
			System.out.print("[" + c.getX() + c.getY() + "]");
		}
		System.out.println();
		System.out.println(coordNoOcupadas.size());
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

//	private boolean coordenadaNoRepetida(Coordenada c) {
//		boolean resultado = true; 
//		for( Entry<Coordenada, Superficie> entry : mapa.entrySet()){
//			if (c.equals(entry.getKey())){
//				resultado = false;
//			}
//		}
//		return resultado;
//	}

	private Coordenada coordenadaAleatoria(){
		boolean repetido = true;
		Coordenada coord = null;
		while(repetido){
			coord = new Coordenada(aleatorio.nextInt(alto), aleatorio.nextInt(ancho));
			repetido = puntosCentrales.contains(coord);
		}
		return coord;
	}
	
	private Superficie superficieAleatoria(){
		Superficie s;
		if (aleatorio.nextBoolean()){
			s = new SuperficieTierra();
		}else{
			s = new SuperficieAgua();
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
