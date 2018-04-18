

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Javier Carpio
 * @author Ana Lucia Hernandez 
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
        if (result != expResult)
        {
            fail("La prueba size ha fallado.");
        }
    }

    /**
     * Test of isEmpty method, of class RedBlackTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        RedBlackTree instance = new RedBlackTree();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        if (result != expResult)
        {
            fail("La prueba isEmpty ha fallado.");
        }
    }

    /**
     * Test of get method, of class RedBlackTree.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        String key = "dog";
        RedBlackTree instance = new RedBlackTree();
        instance.put("dog", "perro");
        String expResult = "perro";
        String result = instance.get(key);
        assertEquals(expResult, result);
        if (!result.equals(expResult))
        {
            fail("La prueba get ha fallado.");
        }
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
        if (result != expResult)
        {
            fail("La prueba contains ha fallado.");
        }
    }

    /**
     * Test of put method, of class RedBlackTree.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        RedBlackTree instance = new RedBlackTree();
        String key = "cat";
        String val = "gato";
        instance.put(key,val);
        String expResult = "gato";
        String result = instance.get(key);
        assertEquals(expResult, result);
        instance.put(key, val);
        if (!result.equals(expResult))
        {
            fail("La prueba contains ha fallado.");
        }
    }
    
}
