package algo3.algocity.model;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.fabricas.FabricaCentralEolica;
import algo3.algocity.model.fabricas.FabricaEstacionDeBomberos;
import algo3.algocity.model.fabricas.FabricaPozoAgua;
import algo3.algocity.model.fabricas.FabricaUnidades;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.mapas.MapaConexiones;
import algo3.algocity.model.mapas.MapaEdilicio;
import algo3.algocity.model.mapas.MapaTerritorio;

public class MapasIntegralTest {
	
	int alto = 10;
	int ancho = 10;
	
	MapaTerritorio mt;
	MapaEdilicio me;
	MapaConexiones tuberias;
	MapaConexiones rutas;
	MapaConexiones cables;
	FabricaUnidades f;

	@Test
	public void testAgregarPozoDeAguaSiCumpleConLosRequisitos() {
		mt = new MapaTerritorio(alto, ancho);
		me = new MapaEdilicio(alto, ancho);
		ArrayList<Mapa> lista = new ArrayList<Mapa>();
		
		f = new FabricaPozoAgua();
		
		lista.add(mt);
		Point p = mt.getPosicionDeUnaSuperficieDeAgua();
		
		try{
			Unidad u = f.construir(lista, p.x, p.y);			
			me.agregar(u, p.x, p.y);
			
			assertTrue(me.contiene(u));
			
		}catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testAgregarEstacionDeBomberosSiCumpleConLosRequisitos(){
		mt = new MapaTerritorio(alto, ancho);
		me = new MapaEdilicio(alto, ancho);
		ArrayList<Mapa> lista = new ArrayList<Mapa>();
		f = new FabricaEstacionDeBomberos();
		
		lista.add(mt);
		Point p = mt.getPosicionDeUnaSuperficieDeTierra();
		
		try{
			Unidad u = f.construir(lista, p.x, p.y);			
			me.agregar(u, p.x, p.y);
			
			assertTrue(me.contiene(u));
			
		}catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}		
	}
	
	@Test
	public void testAgregarCentralEolicaSiCumpleConLosRequisitos(){
		mt = new MapaTerritorio(alto, ancho);
		me = new MapaEdilicio(alto, ancho);
		ArrayList<Mapa> lista = new ArrayList<Mapa>();
		f = new FabricaCentralEolica();
		
		lista.add(mt);
		Point p = mt.getPosicionDeUnaSuperficieDeTierra();
		
		try{
			Unidad u = f.construir(lista, p.x, p.y);			
			me.agregar(u, p.x, p.y);
			
			assertTrue(me.contiene(u));
			
		}catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}		
	}
	
//	@Test
//	public void testAgregarUnidadIndustrialSiSeCumpleConLosRequisitos(){
//		mt = new MapaTerritorio(alto, ancho);
//		tuberias = new MapaConexiones(alto, ancho);
//		me = new MapaEdilicio(alto, ancho);
//		ArrayList<Mapa> listaMapas = new ArrayList<Mapa>();
//		ArrayList<Point> listaTierra = new ArrayList<Point>();
//		listaTierra = mt.posicionesConTierra();
//		Iterator i = listaTierra.iterator();
//		
//		if (i.hasNext()){
//			Point p = (Point)i.next();
//		}		
//		
////		Point p = mt.getPosicionDeUnaSuperficieDeTierra();
//		f = new FabricaCentralEolica();
//		
//		listaMapas.add(mt);
//		
//		try{
//			Unidad u = f.construir(listaMapas, p.x, p.y);			
//			me.agregar(u, p.x, p.y);
//			
//			assertTrue(me.contiene(u));
//			
//		}catch (NoSeCumplenLosRequisitosException e) {
//			System.out.println(e);
//		}
//		
//		f = new FabricaLineaTension();
//		// continuar
//		//fabricar una "red" de tension y luego agregar una residencia
//		
//	}

}
