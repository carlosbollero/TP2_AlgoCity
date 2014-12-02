package algo3.algocity.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.fabricas.FabricaCentralEolica;
import algo3.algocity.model.fabricas.FabricaConectores;
import algo3.algocity.model.fabricas.FabricaEnergetica;
import algo3.algocity.model.fabricas.FabricaEstacionDeBomberos;
import algo3.algocity.model.fabricas.FabricaLineaTension;
import algo3.algocity.model.fabricas.FabricaPozoAgua;
import algo3.algocity.model.fabricas.FabricaRuta;
import algo3.algocity.model.fabricas.FabricaTuberias;
import algo3.algocity.model.fabricas.FabricaUnidadIndustrial;
import algo3.algocity.model.fabricas.FabricaUnidadResidencial;
import algo3.algocity.model.fabricas.FabricaUnidades;
import algo3.algocity.model.mapas.Mapa;

public class MapasIntegralTest {

	int alto = 20;
	int ancho = 20;

	FabricaUnidades fu;
	FabricaEnergetica fe;
	FabricaConectores fc;
	
	@Test
	public void testSeCreaUnidadRecidencialSiCumpleConRequisitos(){
		Mapa m = new Mapa(alto, ancho);
		m.setTerritorioTierraParaTest();
		
		try{
			//CONSTRUYO UN POZO DE AGUA
			PozoDeAgua p = new PozoDeAgua(4, 2);
			m.agregar(p, 4, 2);
			
			//construyo red de tuberias			
			fc = new FabricaTuberias();
			Conector t = fc.construir(m, 4, 2);
			m.agregarTuberia((Tuberia)t, 4, 2);
			t = fc.construir(m, 3, 2);
			m.agregarTuberia((Tuberia)t, 3, 2);
			t = fc.construir(m, 2, 2);
			m.agregarTuberia((Tuberia)t, 2, 2);

			//CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA			
			fe = new FabricaCentralEolica();
			UnidadEnergetica ue = fe.construir(m, 2, 2);
			m.agregar(ue, 2, 2);
			
			//CONSTRUYO LINEAS DE TENSION
			fc = new FabricaLineaTension();
			for (int i = 2; i <= 4; i++){
				fc = new FabricaLineaTension();
				Conector lt = fc.construir(m, 2, i);
				m.agregarLineaTension((LineaTension)lt, 2, i);
				fc = new FabricaRuta();
				Conector r = fc.construir(m, 2, i);
				m.agregarRuta((Ruta)r, 2, i);
			}
			
			//CONSTRUYO UNA UNIDAD RESIDENCIAL CONECTADA A LA CENTRAL ENERGETICA
			fu = new FabricaUnidadResidencial();
			Unidad ur = fu.construir(m, 2, 4);
			m.agregar(ur, 2, 4);
			
			assertTrue(m.contiene(ur));
			
		}catch(NoSeCumplenLosRequisitosException e){
			System.out.println(e);
		}
	}

	@Test
	public void testSelanzaExcepcionAlQuererConstruirindustriaYNoCumplirLosRequisitos() {
		Mapa m = new Mapa(alto, ancho);
		fu = new FabricaUnidadIndustrial();
		Point p = m.posicionConTierra();

		try {
			Unidad u = fu.construir(m, p.x, p.y);
			m.agregar(u, p.x, p.y);
			assertTrue(m.contiene(u));

		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}
	@Test
	public void testSelanzaExcepcionAlQuererConstruirResidenciaYNoCumplirLosRequisitos() {
		Mapa m = new Mapa(alto, ancho);
		fu = new FabricaUnidadResidencial();
		Point p = m.posicionConTierra();

		try {
			Unidad u = fu.construir(m, p.x, p.y);
			m.agregar(u, p.x, p.y);
			assertTrue(m.contiene(u));

		} catch (NoSeCumplenLosRequisitosException e) {
			assertNotNull(e);
			System.out.println(e.toString());
		}
	}

	@Test
	public void testAgregarPozoDeAguaSiCumpleConLosRequisitos() {
		Mapa m = new Mapa(alto, ancho);
		m.setTerritorioAguaParaTest();

		fu = new FabricaPozoAgua();

		Point p = m.posicionConAgua();

		try {
			PozoDeAgua u = (PozoDeAgua) fu.construir(m, p.x, p.y);
			m.agregar(u, p.x, p.y);

			assertTrue(m.contiene(u));

		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}

	@Test
	public void testAgregarEstacionDeBomberosSiCumpleConLosRequisitos() {
		Mapa m = new Mapa(alto, ancho);

		fu = new FabricaEstacionDeBomberos();

		Point p = m.posicionConTierra();

		try {
			Unidad u = fu.construir(m, p.x, p.y);
			m.agregar(u, p.x, p.y);

			assertTrue(m.contiene(u));

		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}

	@Test
	public void testAgregarCentralEolicaSiCumpleConLosRequisitos() {
		Mapa m = new Mapa(alto, ancho);
		m.setTerritorioTierraParaTest();
		
		
		
		PozoDeAgua pozo = new PozoDeAgua(1, 1);
		m.agregar(pozo, 1, 1);

//		CREAR RED DE TUBERIAS
		try{
			fc= new FabricaTuberias();
			for (int i = 0; i < 10; i++){
				Conector tub = fc.construir(m, 1, 1+i);
				m.agregarTuberia((Tuberia)tub, 1, 1+i);
			}		
			
	//		CREAR CENTRAL EOLICA
			fe = new FabricaCentralEolica();

			Unidad u = fe.construir(m, 1, 10);
			m.agregar(u, 1, 10);

			assertTrue(m.contiene(u));
		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}

}
