

/**
 * @author Javier Carpio
 * @author Ana Lucia Hernandez 
 * @param <E>
 */
public class SplayTree<E> implements arbol //ya que se usará factory, se necesita que implemente la interfaz arbol 
{

    
    public Node root;
    private final int count = 0;
    /** Constructor **/
    public SplayTree(){
        
    }

    //splaytree funcional:
    
    /**
     * Revisa si el árbol contiene una llave específica
     * @param key: palabra clave
     * @return boolean 
     */
    
    @Override
    public boolean contains(String key) {
        return get(key) != null;
    }

    
    /**
     * return value associated with the given key if no such value, return null
     * @param key
     * @return 
     */
    @Override
    public String get(String key) {
        root = splay(root, key);
        int cmp = key.compareTo(root.getKey());
        if (cmp == 0) return root.getValue().getValue().toString();
        else          return null;
    }    

   //       ************ Splay tree insertion. ***************
    /**
     * 
     * @param key: palabra clave del nuevo nodo
     * @param value: valor del nodo
     */
    @Override
    public void put(String key, String value) {
        // splay key to root
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        
        root = splay(root, key);

        int cmp = key.compareTo(root.getKey());
        
        // Insert new node at root
        if (cmp < 0) {
            Node n = new Node(key, value);
            n.setLeft(root.getLeft());
            n.setRight(root);
            root.setLeft(null);
            root = n;
        }

        // Insert new node at root
        else if (cmp > 0) {
            Node n = new Node(key, value);
            n.setRight(root.getRight());
            n.setLeft(root);
            root.setRight(null);
            root = n;
        }
    }
    
   // *************** Splay tree deletion. ***************
    /**
     * 
     * @param key palabra clave con la cual se identifica el nodo
     */
    public void remove(String key) {
        if (root == null) return; // empty tree
        
        root = splay(root, key);

        int cmp = key.compareTo(root.getKey());
        
        if (cmp == 0) {
            if (root.getLeft() == null) {
                root = root.getRight();
            } 
            else {
                Node x = root.getRight();
                root = root.getLeft();
                splay(root, key);
                root.setRight(x);
            }
        }

        // else: it wasn't in the tree to remove
    }
    
    
   //  *************** Splay tree function. ***************
    // splay key in the tree rooted at Node h. If a node with that key exists,
    //   it is splayed to the root of the tree. If it does not, the last node
    //   along the search path for the key is splayed to the root.
    /**
     * 
     * @param h: nodo a revisar
     * @param key: llave a buscar
     * @return nodo resultante
     */
    private Node splay(Node h, String key) {
        if (h == null) return null;

        int cmp1 = key.compareTo(h.getKey());

        if (cmp1 < 0) {
            // key not in tree, so we're done
            if (h.getLeft() == null) {
                return h;
            }
            int cmp2 = key.compareTo(h.getLeft().getKey());
            if (cmp2 < 0) {
                h.getLeft().setLeft(splay(h.getLeft().getLeft(), key));
                h = rotateRight(h);
            }
            else if (cmp2 > 0) {
                h.getLeft().setRight(splay(h.getLeft().getRight(), key));
                if (h.getLeft().getRight() != null)
                    h.setLeft(rotateLeft(h.getLeft()));
            }
            
            if (h.getLeft() == null) return h;
            else                return rotateRight(h);
        }

        else if (cmp1 > 0) { 
            // key not in tree, so we're done
            if (h.getRight() == null) {
                return h;
            }

            int cmp2 = key.compareTo(h.getRight().getKey());
            if (cmp2 < 0) {
                h.getRight().setLeft(splay(h.getRight().getLeft(), key));
                if (h.getRight().getLeft() != null)
                    h.setRight(rotateRight(h.getRight()));
            }
            else if (cmp2 > 0) {
                h.getRight().setRight(splay(h.getRight().getRight(), key));
                h = rotateLeft(h);
            }
            
            if (h.getRight() == null) return h;
            else                 return rotateLeft(h);
        }

        else return h;
    }


   // *************** Helper functions. ***************

    // height of tree (1-node tree has height 0)
    /**
     * 
     * @return tamaño
     */
    public int height() { return height(root); }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.getLeft()), height(x.getRight()));
    }
    
    /**
     * 
     * @return tamaño de arbol
     */
    
    public int size() {
        return size(root);
    }
    /**
     * 
     * @param x: nodo a revisar
     * @return tamaño del subtree que contiene el nodo en cuestión
     */
    private int size(Node x) {
        if (x == null) return 0;
        else return 1 + size(x.getLeft()) + size(x.getRight());
    }
    
    // right rotate
    /**
     * 
     * @param h: nodo a revisar
     * @return nodo resultante
     */
    private Node rotateRight(Node h) {
        Node x = h.getLeft();
        h.setLeft(x.getRight());
        x.setRight(h);
        return x;
    }

    // left rotate
    /**
     * 
     * @param h: nodo a revisar
     * @return nodo resultante
     */
    private Node rotateLeft(Node h) {
        Node x = h.getRight();
        h.setRight(x.getLeft());
        x.setLeft(h);
        return x;
    }
    
}
