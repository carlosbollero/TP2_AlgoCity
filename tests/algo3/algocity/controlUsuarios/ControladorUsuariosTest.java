package algo3.algocity.controlUsuarios;

import static org.junit.Assert.*;

import org.junit.Test;




public class ControladorUsuariosTest {

	@Test
	public void testCreacionNuevoUsuario() {
		
		Usuario unUsuario = new Usuario();
		assertNotNull(unUsuario);
	}
	
	
	@Test
	public void testRegistroNuevoUsuario(){
		
		Usuario unUsuario = new Usuario();
		unUsuario.setNombre("Pedro");
		assertEquals("Pedro",unUsuario.getNombre());
	}
	
	
	@Test
	public void testRegistroUsuarioYaExistente(){
		
		Usuario unUsuario = new Usuario();
		unUsuario.setNombre("Julian");
		Usuario otroUsuario = new Usuario();
		otroUsuario.setNombre("Julian");
		Usuario otroUsuarioMas = new Usuario();
		otroUsuarioMas.setNombre("Julian");
		
		ControladorUsuarios unControladorUsuarios = new ControladorUsuarios();
		
		unControladorUsuarios.addUsuario(unUsuario);
		unControladorUsuarios.addUsuario(otroUsuario);
		unControladorUsuarios.addUsuario(otroUsuarioMas);
		
		assertFalse(unControladorUsuarios.existeUsuario(otroUsuario));
		assertFalse(unControladorUsuarios.existeUsuario(otroUsuarioMas));
		
		
	}
	
	
	
}
