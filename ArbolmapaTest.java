/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo Arriaza y Sebastian Galindo
 */
public class ArbolmapaTest {
    
    public ArbolmapaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of get and put method, of class Arbolmapa.
     */
    @Test
    public void testPutAndGet() {
        System.out.println("Put and Get");
        String key = "llave1";
        String value = "valor1";
        Arbolmapa instance = new Arbolmapa();
        instance.put(key, value); //se inserta la llave con su valor correspondiente
        Object expResult = "valor1"; //el valor esperado es valor1
        Object result = instance.get(key); // el resultado se obtiene utilizando el otro metodo que se quiere probar
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
