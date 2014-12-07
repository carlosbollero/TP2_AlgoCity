package algo3.algocity.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.GeneradorTerritorio;
import algo3.algocity.model.terreno.Superficie;

public class GeneradorTerritorioTest {
	
	int alto = 10;
	int ancho = 50;

	@Test
	public void testSePuedeGenerarPuntosCentrales() {
		GeneradorTerritorio gt = new GeneradorTerritorio(alto, ancho);
		
		gt.definirPuntosCentrales();
		
		ArrayList<Coordenada> lista = gt.getPuntonsCentrales();
		System.out.println("tamaño = " + lista.size());
		for (Coordenada coord : lista){
			System.out.print("[" + coord.getX() + ", " + coord.getY() + "]");
		}
		
		assertTrue(lista != null);		
	}
	
	@Test
	public void testSePuedeGenerarUnMapaCopado(){
		GeneradorTerritorio gt = new GeneradorTerritorio(alto, ancho);
		Map<Coordenada, Superficie> mapa = gt.generarTerritorio();
		Superficie[][] m = new Superficie[alto][ancho];
		
		System.out.println("tamaño mapa = " + mapa.size());
		System.out.println("tamaño m    = " + m.length);
		for(Entry<Coordenada, Superficie> entry : mapa.entrySet()){
			System.out.print("[" + entry.getKey().getX() + entry.getKey().getY() + "]");
		}
		
		for (int i = 0; i < alto; i++){
			for (int j = 0; j < ancho; j++){
				if (mapa.get(new Coordenada(i,j)).getSuperficie().esAgua()){
					System.out.print("\u2593");
				}else{
					System.out.print("\u2591");					
				}
			}
			System.out.println();
		}
	}

}
