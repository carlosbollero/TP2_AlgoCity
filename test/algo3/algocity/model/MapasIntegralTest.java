package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3.algocity.model.conexiones.Conector;
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
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class MapasIntegralTest {

	int alto = 10;
	int ancho = 20;

	FabricaUnidades fu;
	FabricaEnergetica fe;
	FabricaConectores fc;
	
	@Test
	public void testSeCreaUnidadRecidencialSiCumpleConRequisitos(){
		Mapa m = new Mapa();
		m.setTerritorioTierraParaTest();
		
		try{
			//CONSTRUYO UN POZO DE AGUA
			PozoDeAgua p = new PozoDeAgua(4, 2);
			m.agregar(p);
			
			//construyo red de tuberias			
			fc = new FabricaTuberias();
			Conector t = fc.construir(m, 4, 2);
			m.agregar(t);
			t = fc.construir(m, 3, 2);
			m.agregar(t);
			t = fc.construir(m, 2, 2);
			m.agregar(t);

			//CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA			
			fe = new FabricaCentralEolica();
			UnidadEnergetica ue = fe.construir(m, 2, 2);
			m.agregar(ue);
			
			//CONSTRUYO LINEAS DE TENSION
			fc = new FabricaLineaTension();
			for (int i = 2; i <= 4; i++){
				fc = new FabricaLineaTension();
				Conector lt = fc.construir(m, 2, i);
				m.agregar(lt);
				fc = new FabricaRuta();
				Conector r = fc.construir(m, 2, i);
				m.agregar(r);
			}
			
			//CONSTRUYO UNA UNIDAD RESIDENCIAL CONECTADA A LA CENTRAL ENERGETICA
			fu = new FabricaUnidadResidencial();
			Unidad ur = fu.construir(m, 2, 4);
			m.agregar(ur);
			
			assertTrue(m.contiene(ur));
			
		}catch(NoSeCumplenLosRequisitosException e){
			System.out.println(e);
		}
	}

	@Test
	public void testSelanzaExcepcionAlQuererConstruirindustriaYNoCumplirLosRequisitos() {
		Mapa m = new Mapa();
		fu = new FabricaUnidadIndustrial();
		Coordenada p = m.posicionConTierra();

		try {
			Unidad u = fu.construir(m, p.getX(), p.getY());
			m.agregar(u);
			assertTrue(m.contiene(u));

		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}
	@Test
	public void testSelanzaExcepcionAlQuererConstruirResidenciaYNoCumplirLosRequisitos() {
		Mapa m = new Mapa();
		fu = new FabricaUnidadResidencial();
		Coordenada p = m.posicionConTierra();

		try {
			Unidad u = fu.construir(m, p.getX(), p.getY());
			m.agregar(u);
			assertTrue(m.contiene(u));

		} catch (NoSeCumplenLosRequisitosException e) {
			assertNotNull(e);
			System.out.println(e.toString());
		}
	}

	@Test
	public void testAgregarPozoDeAguaSiCumpleConLosRequisitos() {
		Mapa m = new Mapa();
		m.setTerritorioAguaParaTest();

		fu = new FabricaPozoAgua();

		Coordenada p = m.posicionConAgua();

		try {
			PozoDeAgua u = (PozoDeAgua) fu.construir(m, p.getX(), p.getY());
			m.agregar(u);

			assertTrue(m.contiene(u));

		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}

	@Test
	public void testAgregarEstacionDeBomberosSiCumpleConLosRequisitos() {
		Mapa m = new Mapa();

		fu = new FabricaEstacionDeBomberos();

		Coordenada p = m.posicionConTierra();

		try {
			Unidad u = fu.construir(m, p.getX(), p.getY());
			m.agregar(u);

			assertTrue(m.contiene(u));

		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}

	@Test
	public void testAgregarCentralEolicaSiCumpleConLosRequisitos() {
		Mapa m = new Mapa();
		m.setTerritorioTierraParaTest();
			
		
		PozoDeAgua pozo = new PozoDeAgua(1, 1);
		m.agregar(pozo);
			

//		CREAR RED DE TUBERIAS
		try{
			fc= new FabricaTuberias();
			for (int i = 0; i < 10; i++){
				Conector tub = fc.construir(m, 1, 1+i);
				m.agregar(tub);
			}
			
	//		CREAR CENTRAL EOLICA
			fe = new FabricaCentralEolica();

			Unidad u = fe.construir(m, 1, 10);
			m.agregar(u);

			assertTrue(m.contiene(u));
		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}

}
