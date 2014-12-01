package algo3.algocity.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

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

	int alto = 10;
	int ancho = 10;

	FabricaUnidades fu;
	FabricaEnergetica fe;
	FabricaConectores fc;
	
	@Test
	public void testSeCreaUnidadRecidencialSiCumpleConRequisitos(){
		Mapa m = new Mapa(alto, ancho);
		m.setTerritorioTest();
		
		try{
			fe = new FabricaCentralEolica();
			UnidadEnergetica ue = fe.construir(m, 2, 2);
			m.agregar(ue, 2, 2);
			fc = new FabricaLineaTension();
			for (int i = 2; i <= 4; i++){
				fc = new FabricaLineaTension();
				fc.construir(m, 2, i);
				fc = new FabricaRuta();
				fc.construir(m, 2, i);
				fc = new FabricaTuberias();
				fc.construir(m, 2, i);
			}
			fu = new FabricaUnidadResidencial();
			Unidad ur = fu.construir(m, 2, 4);
			m.agregar(ue, 2, 4);
			
			assertTrue(m.contiene(ur));
			
		}catch(NoSeCumplenLosRequisitosException e){
			System.out.println(e);
		}
	}

	@Test
	public void testSelanzaExcepcionAlQuererConstruirindustriaYNoCumplirLosRequisitos() {
		Mapa m = new Mapa(alto, ancho);
		fu = new FabricaUnidadIndustrial();
		Point p = m.getPosicionConTierra();

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
		Point p = m.getPosicionConTierra();

		try {
			Unidad u = fu.construir(m, p.x, p.y);
			m.agregar(u, p.x, p.y);
			assertTrue(m.contiene(u));

		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}

	@Test
	public void testAgregarPozoDeAguaSiCumpleConLosRequisitos() {
		Mapa m = new Mapa(alto, ancho);

		fu = new FabricaPozoAgua();

		Point p = m.getPosicionConAgua();

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

		Point p = m.getPosicionConTierra();

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
		fe = new FabricaCentralEolica();
		Point p = m.getPosicionConTierra();

		try {
			Unidad u = fe.construir(m, p.x, p.y);
			m.agregar(u, p.x, p.y);

			assertTrue(m.contiene(u));

		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
		}
	}

}
