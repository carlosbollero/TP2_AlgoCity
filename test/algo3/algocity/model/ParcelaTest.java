package algo3.algocity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParcelaTest {

@Test 
public void testDevolverContenidoParcela (){

Conector con = new Conector(10);

Parcela par =new Parcela(con,0, 0); 

assertTrue (par.getContenido () instanceof Conector ); 


}


@Test 
public void testParcelaTieneContenido () {

Conector con = new Conector (10); 

Parcela par = new Parcela (con , 1, 1); 

assertTrue (par.tieneContenido ());  


}


@Test 
public void testParcelaTieneCoordenadas ()  {

Conector con = new Conector (10); 

Parcela par = new Parcela (con , 1, 1); 

assertTrue (par.tieneCoordenadas(1, 1)); 

}

}
