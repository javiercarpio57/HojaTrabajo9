

/**
 * Clase que demuestra la utilizacion del patron de diseño factory.
 * @author Javier Carpio
 * @author Ana Lucia Hernandez 
 */
class Factory<E> {
    arbol implementacion;
    /**
     * Constructor vacio.
     */
    public Factory(){}
    /**
     * Selecciona la implementacion a utilizar para un stack o una lista.
     * @param entry el tipo de árbol que se desea usar
     * @return la instanciacion correspondiente
     */
   public arbol getTree(String entry) {
    // seleccion de la implementacion a utilizar:
        
        if(entry.equals("Red-Black Tree"))
        {
            implementacion =  new RedBlackTree<>();
        }else if(entry.equals("Splay Tree"))
        {
            implementacion = new SplayTree<>();
        }
        
        return implementacion;      
   }
}
