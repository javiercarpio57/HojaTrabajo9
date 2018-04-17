/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo9;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author javie
 */
public class RedBlackTreeTest {
    
    public RedBlackTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of size method, of class RedBlackTree.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        RedBlackTree instance = new RedBlackTree();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class RedBlackTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        RedBlackTree instance = new RedBlackTree();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class RedBlackTree.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        String key = "";
        RedBlackTree instance = new RedBlackTree();
        String expResult = "";
        String result = instance.get(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class RedBlackTree.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        String key = "";
        RedBlackTree instance = new RedBlackTree();
        boolean expResult = false;
        boolean result = instance.contains(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of put method, of class RedBlackTree.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        String key = "";
        String val = "";
        RedBlackTree instance = new RedBlackTree();
        instance.put(key, val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
