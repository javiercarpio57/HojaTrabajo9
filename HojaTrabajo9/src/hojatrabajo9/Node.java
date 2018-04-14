
package hojatrabajo9;
/**
 * @author Ana Lucia Hernandez
 * @author Javier Carpio
 * @version 15.03.2018
 * @param <E> Generico
 */
public class Node<E> {
    private Association<String, String> value; // valor del nodo
    private Node<E> parent; // padre de nodo
    private Node<E> left, right; // hijos laterales de nodo
    public boolean color; //se usa solamente para el Red-Black Tree
    public int size; //se usa solamente para el Red-Black Tree
    
    /**
     * Constructor que crea la raiz. Se utiliza para el SplayTree
     * @param ingles Palabra en ingles
     * @param espanol Palabra en espanol
     */
    public Node(String ingles, String espanol)
    {
        value = new Association<>(ingles, espanol);
        parent = null; 
        left = right = null;
    }
    
    /**
     * Constructor que crea la raiz. Se usa para el Red-Black Tree
     * @param ingles
     * @param espanol
     * @param color
     * @param size 
     */
    public Node(String ingles, String espanol, boolean color, int size)
    {
        value = new Association<>(ingles, espanol);
        parent = null; 
        left = right = null;
        this.color = color;
        this.size = size;
    }

    /**
     * Constructor que llama el nodo
     */
    public Node() {
        
    }
    /**
     * Obtiene el valor contenido en el nodo.
     * @return Association : valor que contiene el nodo (un association con la palabra en inglés como key y la de español como value)
     */
    public Association<String, String> getValue()
    {
        return value; //devuelve la palabra en español
    }
    public void setVal(String nuevo)
    {
        this.value.setValue(nuevo);
    }
    /**
     * Obtiene la palabra en español.
     * @return String palabra en español que contiene el nodo
     */
    public String getEspanol()
    {
        return value.theValue;
    }
    /**
     * Obtiene la palabra en inglés
     * @return String palabra en inglés que contiene el nodo
     */
    public String getKey()
    {
        return value.getKey(); //devuelve la palabra en ingles
    }
    /**
     * Obtiene referencia a hijo izquierdo.
     * @return Node hijo izquierdo del nodo
     */
    public Node<E> getLeft()
    {
        return left;
    }
    /**
     * Obtiene referencia a hijo derecho.
     * @return Node hijo derecho del nodo
     */
    public Node<E> getRight()
    {
        return right;
    }
    /**
     * Obtiene referencia a padre
     * @return Node padre del nodo
     */
    public Node<E> getParent()
    {
        return parent;
    }
    /**
     * Establece referencia a hijo izquierdo.
     * @param left: nueva referencia a hijo derecho del nodo
     */
    public void setLeft(Node left)
    {
        this.left = left;
    }
    /**
     * Establece referencia a hijo derecho.
     * @param right: nueva referencia a hijo izquierdo del nodo
     */
    public void setRight(Node right)
    {
        this.right = right;
    }
    /**
     * Establece referencia a padre.
     * @param newParent: nuevo padre del nodo
     */
    public void setParent(Node newParent)
    // post: re-parents this node to parent reference, or null
    {
            parent = newParent;
    }
    /**
     * Obtiene descripción en String del presente objeto.
     * @return String de los valores que contiene el nodo
     */
    @Override
    public String toString()
    {
       String hilo = "\t("+ value.theKey + ", " + value.theValue + ")";
       return hilo;
    }
    
    /**
     * Metodo que busca la palabra en ingles en el arbol creado.
     * @param value Palabra en ingles a buscar
     * @return Palabra traducida.
     */
    public String search(String value){
        if (value.equals(this.value.getKey())){
            
            return this.value.theValue;
        }else if (value.compareTo(this.value.getKey()) < 0) {
            
            if (left == null){
                return "*" + value + "*";
            }else{
                return left.search(value);
            }
        }else if(value.compareTo(this.value.getKey()) > 0) {
            
            if (right == null){
                return "*" + value + "*";
            }else{
                return right.search(value);

            }
        }
        
        return "*" + value + "*";
    }
    
    
}
