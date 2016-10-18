/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
public class RedBlackBSTTest {
    
    public RedBlackBSTTest() {
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
     * Test of get method, of class RedBlackBST.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        String key = "llave";
        String val = "valor";
        RedBlackBST instance = new RedBlackBST();
        instance.put(key, val);
        String expResult = "valor";
        Object result = instance.get(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of put method, of class RedBlackBST.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        String key = "lallave";
        String val = "elvalor";
        RedBlackBST instance = new RedBlackBST();
        instance.put(key, val);
        Object expResult = true;
        Object result = instance.contains(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
        //Ahora revisa si el metodo de la clase del JCF funciona igual que el de la implementacion de RBT
        TreeMap instanceJCF = new TreeMap();
        String key2 = "otrallave";
        String value2 = "otrovalor";
        
        instance.put(key2, value2);
        instanceJCF.put(key2, value2);
        // con esto se comprueba que funciona tanto el metodo put como el get de ambas implementaciones
        Object expResult2 = instanceJCF.get(key2);
        Object result2 = instance.get(key2);
        assertEquals(expResult2, result2);
    }
    
     
    
}
