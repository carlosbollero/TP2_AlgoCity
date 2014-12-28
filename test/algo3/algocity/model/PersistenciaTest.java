package algo3.algocity.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Ocupable;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.EstacionDeBomberos;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.NoSeEncontroElFicheroException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.fabricas.FabricaCentralEolica;
import algo3.algocity.model.fabricas.FabricaConectores;
import algo3.algocity.model.fabricas.FabricaEnergetica;
import algo3.algocity.model.fabricas.FabricaEstacionDeBomberos;
import algo3.algocity.model.fabricas.FabricaRuta;
import algo3.algocity.model.fabricas.FabricaTuberias;
import algo3.algocity.model.fabricas.FabricaUnidadIndustrial;
import algo3.algocity.model.fabricas.FabricaUnidadResidencial;
import algo3.algocity.model.fabricas.FabricaUnidades;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class PersistenciaTest {

	FabricaUnidades fu;
	FabricaEnergetica fe;
	FabricaConectores fc;
	
	@Test
	public void testPersistirDosInstanciasDeJuegoDiferentes()
			throws NoSeEncontroElFicheroException, IOException {

		Usuario user1 = new Usuario("Pepe");
		Usuario user2 = new Usuario("Mari");

		Mapa mapa1 = new Mapa();
		Mapa mapa2 = new Mapa();

		Turno turno1 = new Turno();
		Turno turno2 = new Turno();

		Poblacion p1 = new Poblacion();
		Poblacion p2 = new Poblacion();

		Dinero dinero1 = new Dinero();
		Dinero dinero2 = new Dinero();

		Juego juego1 = new Juego(user1, mapa1, turno1, p1, dinero1);
		Juego juego2 = new Juego(user2, mapa2, turno2, p2, dinero2);

		juego1.persistir();
		juego2.persistir();

		File fichero1 = new File("./saved/" + "Pepe" + ".xml");
		assertTrue(fichero1.exists());

		File fichero2 = new File("./saved/" + "Mari" + ".xml");
		assertNotNull(fichero2);

		if (fichero1.delete() && fichero2.delete()) {
			System.out.println("Los ficheros de prueba fueron eliminados");
		} else {
			System.out
					.println("Los ficheros de prueba no pudieron ser eliminados");
		}

	}
	
	
	
	@Test
	public void testPruebaPersistenciaEstacionBomberos() throws NoSeCumplenLosRequisitosException, FondosInsuficientesException, CapacidadElectricaInsuficienteException, NoHayConexionConTuberias, NoHayConexionConRutas, NoHayConexionConRedElectrica, CoordenadaInvalidaException, SuperficieInvalidaParaConstruir, IOException, SAXException, ParserConfigurationException{
		Usuario user = new Usuario("testUser1");
		Mapa m = new Mapa();
		Turno turno = new Turno();
		Poblacion poblacion = new Poblacion();
		Dinero d = new Dinero();

		m.setTerritorioTierraParaTest();
		
		fu = new FabricaEstacionDeBomberos();
		Unidad eb = fu.construir(m,d,new Coordenada(1,1));
		
		m.agregar(eb);
		
		assertTrue(m.contiene(eb));
		
		Juego juego = new Juego(user, m, turno, poblacion, d);

		// TODO, el sistema electrico no actualiza su capacidad y consumo	
		juego.persistir();
		juego.turno().detener();
		
		
		/* Corroboro que se haya creado el fichero */
		// Asegurarse que exista el directorio saved
		File fichero = new File("./saved/" + "testUser1" + ".xml");
		assertNotNull(fichero);

		/* Recupero una instancia de juego leyendo el fichero */
		Juego juegoRecuperado = new Juego();
		juegoRecuperado = juegoRecuperado.recuperar("testUser1");
		juegoRecuperado.turno().detener();

		if (fichero.delete()) {
			System.out.println("Los ficheros de prueba fueron eliminados");
		} else {
			System.out
					.println("Los ficheros de prueba no pudieron ser eliminados");
		}
		
		/* Corroboro que los datos leidos sean correctos */
		assertEquals(juegoRecuperado.usuario().nombre(), "testUser1");
		//TODO, ver como hacer para que el turno pare
		//assertEquals(juegoRecuperado.turno().getTurno(), 3);
		assertEquals(18500, juegoRecuperado.dinero().getCantidad());
		assertTrue(juegoRecuperado.poblacion().equals(juego.poblacion()));
		
		
		Unidad urRecuperada = juegoRecuperado.mapa().ciudad().getUnidadEn(eb.coordenada());
		assertTrue(((EstacionDeBomberos) urRecuperada).equals(eb));
	}
	
	
//	@Test
//	public void testRecuperarUnaInstanciaDeJuegoPreviamenteCreadaCompleta() throws SAXException, IOException, ParserConfigurationException, NoSeCumplenLosRequisitosException, FondosInsuficientesException, SuperficieInvalidaParaConstruir, CoordenadaInvalidaException, CapacidadElectricaInsuficienteException, NoHayConexionConTuberias, NoHayConexionConRutas, NoHayConexionConRedElectrica{
//		
//		Juego juegoRecuperado = new Juego();
//		juegoRecuperado = juegoRecuperado.recuperar("testUser2");
//		juegoRecuperado.turno().detener();
//		
//		juegoRecuperado.getClass();
//
//	}
	
	
	

	//TODO, los tests viejos no van mas, ya que ahora todas las cosas que se agreguen
	//deben cumplir con los requisitos, hay que hacer tests coherentes con la creacion de unidades
	//ademas, ver que cuando se recupera una instancia del juego, si bien las unidades estan en el mapa
	//la gui no las muestra
	
}
