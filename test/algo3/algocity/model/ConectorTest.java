package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test; 

public class ConectorTest {
	
@Test 
public void testConectorCosto (){
	
	Conector con = new Conector (5); 
	
	assertTrue (con.tieneCosto() ); 
}
	
@Test
public void testTieneDanios (){
	Conector con = new Conector (5); 
	
	con.aplicarDanio(40);
	
	assertTrue (con.tieneDanios ()); 
	
}


}
