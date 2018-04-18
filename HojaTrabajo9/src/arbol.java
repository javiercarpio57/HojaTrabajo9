
/**
 * @author Javier Carpio
 * @author Ana Lucia Hernandez 
 */
public interface arbol<E> {
    
   /**
   * pre: value is not null<p>
   * post: returns true if list contains an object equal to value
   * @param key el valor que se quiere encontrar
   * @return true o false
   */
    public boolean contains(String key);
    
    /**
     * post: returns the value associated with the key provided
     * @param key
     * @return valor asociado con el key
     */
    public String get(String key);
    
    /**
     * post: inserts a new node into the tree
     * @param key
     * @param val 
     */
    public void put(String key, String val);
    
}
