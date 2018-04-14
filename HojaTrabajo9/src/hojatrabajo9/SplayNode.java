/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo9;

/**
 *
 * @author javie
 */
public class SplayNode<E> implements Comparable<String>{
    private SplayNode<E> left, right, parent;
    private Association<String, String> element;
    
    /** Constructor **/
    public SplayNode (){
        this(null, null, null, null);
    }
    /** Constructor
     * @param ele **/
    public SplayNode (Association<String, String> ele){
        this(ele, null, null, null);
    }
    /** Constructor
     * @param ele
     * @param left
     * @param right
     * @param parent **/
    public SplayNode (Association<String, String> ele, SplayNode left, SplayNode right, SplayNode parent){
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.element = ele;
    }  

    @Override
    public int compareTo(String o) {
        int resultado;
        if(this.element.getKey().compareTo(o) < 0){
            resultado = -1;
        }else if(this.element.getKey().compareTo(o) > 0){
            resultado = 1;
        }else{
            resultado = 0;
        }
        return resultado;
    }
    
    public Association<String, String> getValue()
    {
        return element; 
    }
    /**
     * Obtiene la palabra en español.
     * @return String palabra en español que contiene el nodo
     */
    public String getEspanol()
    {
        return element.theValue;
    }
    /**
     * Obtiene la palabra en inglés
     * @return String palabra en inglés que contiene el nodo
     */
    public String getKey()
    {
        return element.getKey(); //devuelve la palabra en ingles
    }
    
}
