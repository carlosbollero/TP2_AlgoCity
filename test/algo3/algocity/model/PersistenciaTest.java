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
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.NoSeEncontroElFicheroException;
import algo3.algocity.model.mapas.Mapa;

public class PersistenciaTest {

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

		Juego juego1 = new Juego(user1, mapa1, turno1, p1);
		Juego juego2 = new Juego(user2, mapa2, turno2, p2);

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
	public void testPersistirUnJuegoCompleto()
			throws NoSeCumplenLosRequisitosException, SAXException,
			IOException, ParserConfigurationException,
			NoSeEncontroElFicheroException {
		/* Creacion de un usuario */
		Usuario usuario = new Usuario("Juan");

		/* Creacion de un mapa */
		Mapa mapa = new Mapa();

		/* Creacion de algunas unidades en el mapa */
		// agregando de esta forma no se validan requisitos
		UnidadResidencial ur = new UnidadResidencial(10, 10);
		ur.agregarseA(mapa);

		UnidadComercial uc = new UnidadComercial(2, 2);
		uc.agregarseA(mapa);

		UnidadIndustrial ui = new UnidadIndustrial(4, 8);
		ui.agregarseA(mapa);

		PozoDeAgua pa = new PozoDeAgua(5, 5);
		pa.agregarseA(mapa);

		EstacionDeBomberos eb = new EstacionDeBomberos(6, 6);
		eb.agregarseA(mapa);

		CentralNuclear cn = new CentralNuclear(4, 1);
		cn.agregarseA(mapa);

		CentralMinera cm = new CentralMinera(7, 1);
		cm.agregarseA(mapa);

		CentralEolica ce = new CentralEolica(1, 9);
		ce.agregarseA(mapa);

		LineaTension lt = new LineaTension(7, 2);
		lt.agregarseA(mapa);

		Ruta rt = new Ruta(9, 1);
		rt.agregarseA(mapa);

		Tuberia tb = new Tuberia(4, 7);
		tb.agregarseA(mapa);

		/* Creacion de Turno */
		Turno turno = new Turno();

		/* Creacion de Poblacion */
		Poblacion poblacion = new Poblacion();

		/* Creacion de Juego */
		Juego juego = new Juego(usuario, mapa, turno, poblacion);

		juego.persistir();

		/* Corroboro que se haya creado el fichero */
		// Asegurarse que exista el directorio saved
		File fichero = new File("./saved/" + "Juan" + ".xml");
		assertNotNull(fichero);

		/* Recupero una instancia de juego leyendo el fichero */
		Juego juegoRecuperado = new Juego();
		juegoRecuperado = juegoRecuperado.recuperar("Juan");

		if (fichero.delete()) {
			System.out.println("Los ficheros de prueba fueron eliminados");
		} else {
			System.out
					.println("Los ficheros de prueba no pudieron ser eliminados");
		}

		/* Corroboro que los datos leidos sean correctos */
		assertEquals(juegoRecuperado.altoMapaJuego, 100);
		assertEquals(juegoRecuperado.anchoMapaJuego, 100);
		assertEquals(juegoRecuperado.usuario().nombre(), "Juan");
		assertEquals(juegoRecuperado.turno().getTurno(), 1);
		assertTrue(juegoRecuperado.poblacion().equals(juego.poblacion()));

		// Chequea la ciudad
		Unidad urRecuperada = juegoRecuperado.mapa().ciudad()
				.getUnidadEn(ur.coordenadas().getX(), ur.coordenadas().getY());
		assertTrue(((UnidadResidencial) urRecuperada).equals(ur));

		Unidad uiRecuperada = juegoRecuperado.mapa().ciudad()
				.getUnidadEn(ui.coordenadas().getX(), ui.coordenadas().getY());
		assertTrue(((UnidadIndustrial) uiRecuperada).equals(ui));

		Unidad ucRecuperada = juegoRecuperado.mapa().ciudad()
				.getUnidadEn(uc.coordenadas().getX(), uc.coordenadas().getY());
		assertTrue(((UnidadComercial) ucRecuperada).equals(uc));

		Unidad paRecuperado = juegoRecuperado.mapa().ciudad()
				.getUnidadEn(pa.coordenadas().getX(), pa.coordenadas().getY());
		assertTrue(((PozoDeAgua) paRecuperado).equals(pa));

		Unidad ebRecuperada = juegoRecuperado.mapa().ciudad()
				.getUnidadEn(eb.coordenadas().getX(), eb.coordenadas().getY());
		assertTrue(((EstacionDeBomberos) ebRecuperada).equals(eb));

		Unidad cnRecuperada = juegoRecuperado.mapa().ciudad()
				.getUnidadEn(cn.coordenadas().getX(), cn.coordenadas().getY());
		assertTrue(((CentralNuclear) cnRecuperada).equals(cn));

		Unidad cmRecuperada = juegoRecuperado.mapa().ciudad()
				.getUnidadEn(cm.coordenadas().getX(), cm.coordenadas().getY());
		assertTrue(((CentralMinera) cmRecuperada).equals(cm));

		Unidad ceRecuperada = juegoRecuperado.mapa().ciudad()
				.getUnidadEn(ce.coordenadas().getX(), ce.coordenadas().getY());
		assertTrue(((CentralEolica) ceRecuperada).equals(ce));

		// Chequea unidades con poblacion
		ArrayList<Ocupable> uConPoblacionRecuperadas = juegoRecuperado.mapa()
				.ciudad().unidadesConPoblacion();
		ArrayList<Ocupable> uConPoblacion = juego.mapa().ciudad()
				.unidadesConPoblacion();
		Iterator<Ocupable> itUConPoblacionRecuperadas = uConPoblacionRecuperadas
				.iterator();
		Iterator<Ocupable> itUConPoblacion = uConPoblacion.iterator();
		while (itUConPoblacionRecuperadas.hasNext()
				&& itUConPoblacion.hasNext()) {
			UnidadResidencial uRes = (UnidadResidencial) itUConPoblacion.next();
			UnidadResidencial uResRec = (UnidadResidencial) itUConPoblacionRecuperadas
					.next();
			assertTrue(uRes.equals(uResRec));
		}

		// Chequea unidades con empleo
		ArrayList<Ocupable> uConEmpleoRecuperadas = juegoRecuperado.mapa()
				.ciudad().unidadesConEmpleo();
		ArrayList<Ocupable> uConEmpleo = juego.mapa().ciudad()
				.unidadesConEmpleo();
		Iterator<Ocupable> itUConEmpleoRecuperadas = uConEmpleoRecuperadas
				.iterator();
		Iterator<Ocupable> itUConEmpleo = uConEmpleo.iterator();
		while (itUConEmpleoRecuperadas.hasNext() && itUConEmpleo.hasNext()) {
			UnidadIndustrial uInd = (UnidadIndustrial) itUConEmpleo.next();
			UnidadIndustrial uIndRec = (UnidadIndustrial) itUConEmpleoRecuperadas
					.next();
			assertTrue(uInd.equals(uIndRec));
		}

		// Chequea unidades daniables
		ArrayList<Daniable> uDaniablesRecuperadas = juegoRecuperado.mapa()
				.ciudad().unidadesDaniables();
		ArrayList<Daniable> uDaniables = juego.mapa().ciudad()
				.unidadesDaniables();
		Iterator<Daniable> itUDaniablesRecuperadas = uDaniablesRecuperadas
				.iterator();
		Iterator<Daniable> itUDaniables = uDaniables.iterator();
		while (itUDaniablesRecuperadas.hasNext() && itUDaniables.hasNext()) {
			Daniable u = itUDaniables.next();
			Daniable uRec = itUDaniablesRecuperadas.next();
			assertTrue(u.equals(uRec));
		}

		// Chequea tuberias
		Conector tbRecuperada = juegoRecuperado
				.mapa()
				.tuberias()
				.getConectorEn(tb.coordenadas().getX(), tb.coordenadas().getY());
		assertTrue(((Tuberia) tbRecuperada).equals(tb));

		// Chequea posiciones relevantes de tuberias
		ArrayList<Unidad> uRelevantesRecuperadas = juegoRecuperado.mapa()
				.tuberias().posicionesRelevantes();
		ArrayList<Unidad> uRelevantes = juego.mapa().tuberias()
				.posicionesRelevantes();
		Iterator<Unidad> itURelevantesRecuperadas = uRelevantesRecuperadas
				.iterator();
		Iterator<Unidad> itURelevantes = uRelevantes.iterator();
		while (itURelevantesRecuperadas.hasNext() && itURelevantes.hasNext()) {
			Unidad uRec = itURelevantesRecuperadas.next();
			Unidad u = itURelevantes.next();
			assertTrue(((PozoDeAgua) u).equals((PozoDeAgua) uRec));
		}

		// Chequea rutas
		Conector rtRecuperada = juegoRecuperado
				.mapa()
				.rutas()
				.getConectorEn(rt.coordenadas().getX(), rt.coordenadas().getY());
		assertTrue(((Ruta) rtRecuperada).equals(rt));
		// rutas no tiene posiciones relevantes

		// Chequea la red electrica
		Conector ltRecuperada = juegoRecuperado
				.mapa()
				.redElectrica()
				.getConectorEn(lt.coordenadas().getX(), lt.coordenadas().getY());
		assertTrue(((LineaTension) ltRecuperada).equals(lt));

		// Chequea posiciones relevantes en red electrica
		ArrayList<Unidad> uRelevantesRecuperadasElect = juegoRecuperado.mapa()
				.redElectrica().posicionesRelevantes();
		ArrayList<Unidad> uRelevantesElect = juego.mapa().redElectrica()
				.posicionesRelevantes();
		Iterator<Unidad> itURelevantesRecuperadasElect = uRelevantesRecuperadasElect
				.iterator();
		Iterator<Unidad> itURelevantesElect = uRelevantesElect.iterator();
		while (itURelevantesRecuperadasElect.hasNext()
				&& itURelevantesElect.hasNext()) {
			Unidad uRec = itURelevantesRecuperadasElect.next();
			Unidad u = itURelevantesElect.next();
			assertTrue(((UnidadEnergetica) u).equals((UnidadEnergetica) uRec));
		}
	}

}
