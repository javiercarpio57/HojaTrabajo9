
package hojatrabajo9;

/**
 * Clase que demuestra la utilizacion del patron de diseño factory.
 * @author Javier Carpio
 * @author Ana Lucia Hernandez 17138
 */
class Factory<E> {
    arbol implementacion;
    /**
     * Constructor vacio.
     */
    public Factory(){}
    /**
     * Selecciona la implementacion a utilizar para un stack o una lista.
     * @param entryStack el stack que se quiere usar (vector, arraylist)
     * @param entryLista la lista que se quiere usar (simply, doubly o circular)
     * @return la instanciacion correspondiente
     */
   public arbol getTree(String entry) {
    // seleccion de la implementacion a utilizar:
        
        if(entry.equals("Red-Black Tree"))
        {
            implementacion =  new RedBlackTree<Node<Association<String, String>>>();
        }
       /** else if(entry.equals("Splay Tree"))
        {
            implementacion = new SplayTree<Node<Association<String, String>>>();
        }
        **/
        return implementacion;      
   }
}
