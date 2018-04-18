


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Javier Carpio
 * @author Ana Lucia Hernandez 
 */
public class SplayTreeTest {
    
    public SplayTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
    /**
     * Test of get method, of class SplayTree.
     */
    @Test
    public void testGet() {
        System.out.println("GET");
        String key = "dog";
        String value = "perro";
        
        SplayTree instance = new SplayTree();
        instance.put(key, value);
        
        String a = instance.get("dog");
        a = a.toLowerCase();
        assertEquals("dog", key);
    }

    /**
     * Test of put method, of class SplayTree.
     */
    @Test
    public void testPut() {
        System.out.println("PUT");
        String key = "dog";
        String value = "perro";
        
        SplayTree instance = new SplayTree();
        instance.put(key, value);
        
        String a = instance.root.getKey();
        a = a.toLowerCase();
        assertEquals("dog", key);
    }
}
