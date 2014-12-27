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
		//assertEquals(juegoRecuperado.turno().getTurno(), 3);
		assertEquals(18500, juegoRecuperado.dinero().getCantidad());
		assertTrue(juegoRecuperado.poblacion().equals(juego.poblacion()));
		
		
		Unidad urRecuperada = juegoRecuperado.mapa().ciudad().getUnidadEn(eb.coordenada());
		assertTrue(((EstacionDeBomberos) urRecuperada).equals(eb));
	}
	
	
	

	//TODO, estos tests no van mas, ya que ahora todas las cosas que se agreguen
	//deben cumplir con los requisitos
//	@Test
//	public void testPruebaPersistencia1() throws IOException, NoSeCumplenLosRequisitosException, FondosInsuficientesException, SuperficieInvalidaParaConstruir, CoordenadaInvalidaException, NoHayConexionConTuberias, CapacidadElectricaInsuficienteException, NoHayConexionConRutas, NoHayConexionConRedElectrica, SAXException, ParserConfigurationException{
//		
//		Usuario usuario = new Usuario("Martin");
//		Mapa m = new Mapa();
//		Turno turno = new Turno();
//		Poblacion poblacion = new Poblacion();
//		Dinero d = new Dinero();
//
//		m.setTerritorioTierraParaTest();
//		
//		// CONSTRUYO AlGUNAS UNIDADES
//		PozoDeAgua p = new PozoDeAgua(new Coordenada(4, 2));
//		m.agregar(p);
//
//		// construyo red de tuberias
//		fc = new FabricaTuberias();
//		Conector t = fc.construir(m, d, new Coordenada(4, 2));
//		m.agregar(t);
//		t = fc.construir(m, d, new Coordenada(3, 2));
//		m.agregar(t);
//		t = fc.construir(m, d, new Coordenada(2, 2));
//		m.agregar(t);
//
//		fc = new FabricaRuta();
//		Conector r = fc.construir(m, d, new Coordenada(4, 2));
//		m.agregar(r);
//		r = fc.construir(m, d, new Coordenada(3, 2));
//		m.agregar(r);
//		r = fc.construir(m, d, new Coordenada(2, 2));
//		m.agregar(r);
//
//		// CONSTRUYO UNA UNIDAD ENERGETICA CONECTADA AL POZO DE AGUA
//		fe = new FabricaCentralEolica();
//		UnidadEnergetica ue = fe.construir(m, d, new Coordenada(2, 2));
//		m.agregar(ue);
//
//		assertTrue(m.contiene(ue));
//
//		// CONSTRUYO UNA UNIDAD RESIDENCIAL QUE DEBE TENER ELECTRICIDAD
//		// POR ESTAR DENTRO DEL RADIO DE LA UNIDAD ENERGETICA
//		fu = new FabricaUnidadResidencial();
//		Unidad ur = fu.construir(m, d, new Coordenada(3, 2));
//		m.agregar(ur);
//
//		assertTrue(m.contiene(ur));
//
//		Juego juego = new Juego(usuario, m, turno, poblacion, d);
//
//		juego.persistir();
//		juego.turno().detener();
//		
//		
//		/* Corroboro que se haya creado el fichero */
//		// Asegurarse que exista el directorio saved
//		File fichero = new File("./saved/" + "Martin" + ".xml");
//		assertNotNull(fichero);
//
//		/* Recupero una instancia de juego leyendo el fichero */
//		Juego juegoRecuperado = new Juego();
//		juegoRecuperado = juegoRecuperado.recuperar("Martin");
//
//		if (fichero.delete()) {
//			System.out.println("Los ficheros de prueba fueron eliminados");
//		} else {
//			System.out
//					.println("Los ficheros de prueba no pudieron ser eliminados");
//		}		
//		
//		/* Corroboro que los datos leidos sean correctos */
//		assertEquals(juegoRecuperado.usuario().nombre(), "Martin");
//		assertEquals(juegoRecuperado.turno().getTurno(), 1);
//		assertEquals(juegoRecuperado.dinero().getCantidad(), 18940);
//		assertTrue(juegoRecuperado.poblacion().equals(juego.poblacion()));
//
//		// Chequea la ciudad
//		Unidad urRecuperada = juegoRecuperado.mapa().ciudad().getUnidadEn(ur.coordenada());
//		assertTrue(((UnidadResidencial) urRecuperada).equals(ur));	
//	}
	

//	@Test
//	public void testPersistirUnJuegoCompleto()
//			throws NoSeCumplenLosRequisitosException, SAXException,
//			IOException, ParserConfigurationException,
//			NoSeEncontroElFicheroException, FondosInsuficientesException, SuperficieInvalidaParaConstruir, CoordenadaInvalidaException, CapacidadElectricaInsuficienteException, NoHayConexionConTuberias, NoHayConexionConRutas, NoHayConexionConRedElectrica {
//		/* Creacion de un usuario */
//		Usuario usuario = new Usuario("Juan");
//
//		/* Creacion de un mapa */
//		Mapa mapa = new Mapa();
//
//		/* Creacion de algunas unidades en el mapa */
//		// agregando de esta forma no se validan requisitos
//		UnidadResidencial ur = new UnidadResidencial(new Coordenada(10, 10));
//		ur.agregarseA(mapa);
//
//		UnidadComercial uc = new UnidadComercial(new Coordenada(2, 2));
//		uc.agregarseA(mapa);
//
//		UnidadIndustrial ui = new UnidadIndustrial(new Coordenada(4, 8));
//		ui.agregarseA(mapa);
//
//		PozoDeAgua pa = new PozoDeAgua(new Coordenada(5, 5));
//		pa.agregarseA(mapa);
//
//		// TODO, si la estacion de bomberos se agrega antes que otras unidades,
//		// a estas unidades que fueron agregadas despues no las tiene en su
//		// lista de objetivos
//		EstacionDeBomberos eb = new EstacionDeBomberos(new Coordenada(6, 6));
//		eb.agregarseA(mapa);
//
//		CentralNuclear cn = new CentralNuclear(new Coordenada(4, 1));
//		cn.agregarseA(mapa);
//
//		CentralMinera cm = new CentralMinera(new Coordenada(7, 1));
//		cm.agregarseA(mapa);
//
//		UnidadEnergetica ce = new CentralEolica(new Coordenada(1, 9));
//		ce.agregarseA(mapa);
//
//		LineaTension lt = new LineaTension(new Coordenada(7, 2));
//		lt.agregarseA(mapa);
//
//		Ruta rt = new Ruta(new Coordenada(9, 1));
//		rt.agregarseA(mapa);
//
//		Tuberia tb = new Tuberia(new Coordenada(4, 7));
//		tb.agregarseA(mapa);
//
//		// EstacionDeBomberos eb = new EstacionDeBomberos(new Coordenada(6, 6));
//		// eb.agregarseA(mapa);
//		/* Creacion de Turno */
//		Turno turno = new Turno();
//
//		/* Creacion de Poblacion */
//		Poblacion poblacion = new Poblacion();
//
//		/* Creacion de dinero */
//		Dinero dinero = new Dinero();
//
//		/* Creacion de Juego */
//		Juego juego = new Juego(usuario, mapa, turno, poblacion, dinero);
//
//		// TODO, el sistema electrico no actualiza su capacidad y consumo	
//		juego.persistir();
//		juego.turno().detener();
//
//		/* Corroboro que se haya creado el fichero */
//		// Asegurarse que exista el directorio saved
//		File fichero = new File("./saved/" + "Juan" + ".xml");
//		assertNotNull(fichero);
//
//		/* Recupero una instancia de juego leyendo el fichero */
//		Juego juegoRecuperado = new Juego();
//		juegoRecuperado = juegoRecuperado.recuperar("Juan");
//
//		if (fichero.delete()) {
//			System.out.println("Los ficheros de prueba fueron eliminados");
//		} else {
//			System.out
//					.println("Los ficheros de prueba no pudieron ser eliminados");
//		}
//
//		
//		
//		
//		
//		/* Corroboro que los datos leidos sean correctos */
//		assertEquals(juegoRecuperado.usuario().nombre(), "Juan");
//		assertEquals(juegoRecuperado.turno().getTurno(), 1);
//		assertEquals(juegoRecuperado.dinero().getCantidad(), 20000);
//		assertTrue(juegoRecuperado.poblacion().equals(juego.poblacion()));
////
//		// Chequea la ciudad
//		Unidad urRecuperada = juegoRecuperado.mapa().ciudad().getUnidadEn(ur.coordenada());
//		assertTrue(((UnidadResidencial) urRecuperada).equals(ur));
//
//		Unidad uiRecuperada = juegoRecuperado.mapa().ciudad().getUnidadEn(ui.coordenada());
//		assertTrue(((UnidadIndustrial) uiRecuperada).equals(ui));
//
//		Unidad ucRecuperada = juegoRecuperado.mapa().ciudad().getUnidadEn(uc.coordenada());
//		assertTrue(((Daniable) ucRecuperada).equals(uc));
//
//		Unidad paRecuperado = juegoRecuperado.mapa().ciudad().getUnidadEn(pa.coordenada());
//		assertTrue(((PozoDeAgua) paRecuperado).equals(pa));
//
//		Unidad ebRecuperada = juegoRecuperado.mapa().ciudad().getUnidadEn(eb.coordenada());
//		assertTrue(((EstacionDeBomberos) ebRecuperada).equals(eb));
//
//		Unidad cnRecuperada = juegoRecuperado.mapa().ciudad().getUnidadEn(cn.coordenada());
//		assertTrue(((CentralNuclear) cnRecuperada).equals(cn));
//
//		Unidad cmRecuperada = juegoRecuperado.mapa().ciudad().getUnidadEn(cm.coordenada());
//		assertTrue(((CentralMinera) cmRecuperada).equals(cm));
//
//		Unidad ceRecuperada = juegoRecuperado.mapa().ciudad().getUnidadEn(ce.coordenada());
//		assertTrue(((UnidadEnergetica) ceRecuperada).equals(ce));
//
//		// Chequea unidades con poblacion
//		ArrayList<UnidadResidencial> uConPoblacionRecuperadas = juegoRecuperado
//				.mapa().ciudad().unidadesResidenciales();
//		ArrayList<UnidadResidencial> uConPoblacion = juego.mapa().ciudad()
//				.unidadesResidenciales();
//		Iterator<UnidadResidencial> itUConPoblacionRecuperadas = uConPoblacionRecuperadas
//				.iterator();
//		Iterator<UnidadResidencial> itUConPoblacion = uConPoblacion.iterator();
//		while (itUConPoblacionRecuperadas.hasNext()
//				&& itUConPoblacion.hasNext()) {
//			UnidadResidencial uRes = (UnidadResidencial) itUConPoblacion.next();
//			UnidadResidencial uResRec = (UnidadResidencial) itUConPoblacionRecuperadas
//					.next();
//			assertTrue(uRes.equals(uResRec));
//		}
//
//		// Chequea unidades con empleo
//		ArrayList<UnidadIndustrial> uConEmpleoRecuperadas = juegoRecuperado.mapa()
//				.ciudad().unidadesIndustriales();
//		ArrayList<UnidadIndustrial> uConEmpleo = juego.mapa().ciudad()
//				.unidadesIndustriales();
//		Iterator<UnidadIndustrial> itUConEmpleoRecuperadas = uConEmpleoRecuperadas
//				.iterator();
//		Iterator<UnidadIndustrial> itUConEmpleo = uConEmpleo.iterator();
//		while (itUConEmpleoRecuperadas.hasNext() && itUConEmpleo.hasNext()) {
//			UnidadIndustrial uInd = (UnidadIndustrial) itUConEmpleo.next();
//			UnidadIndustrial uIndRec = (UnidadIndustrial) itUConEmpleoRecuperadas
//					.next();
//			assertTrue(uInd.equals(uIndRec));
//		}
//
////		// Chequea unidades daniables
////		ArrayList<Daniable> uDaniablesRecuperadas = juegoRecuperado.mapa()
////				.ciudad().unidadesDaniables();
////		ArrayList<Daniable> uDaniables = juego.mapa().ciudad()
////				.unidadesDaniables();
////		Iterator<Daniable> itUDaniablesRecuperadas = uDaniablesRecuperadas
////				.iterator();
////		Iterator<Daniable> itUDaniables = uDaniables.iterator();
////		while (itUDaniablesRecuperadas.hasNext() && itUDaniables.hasNext()) {
////			Daniable u = itUDaniables.next();
////			Daniable uRec = itUDaniablesRecuperadas.next();
////			assertTrue(u.equals(uRec));
////		}
//
//		// Chequea tuberias
//		Conector tbRecuperada = juegoRecuperado.mapa().tuberias()
//				.getConectorEn(tb.coordenada().getX(), tb.coordenada().getY());
//		assertTrue(((Tuberia) tbRecuperada).equals(tb));
//
//		// Chequea rutas
//		Conector rtRecuperada = juegoRecuperado.mapa().rutas()
//				.getConectorEn(rt.coordenada().getX(), rt.coordenada().getY());
//		assertTrue(((Ruta) rtRecuperada).equals(rt));
//
//		// Chequea la red electrica
//		Conector ltRecuperada = juegoRecuperado.mapa().redElectrica()
//				.getConectorEn(lt.coordenada().getX(), lt.coordenada().getY());
//		assertTrue(((LineaTension) ltRecuperada).equals(lt));
//
//		// Chequea el reparador
//		assertTrue(juego.mapa().reparador()
//				.equals(juegoRecuperado.mapa().reparador()));
//	}

}
