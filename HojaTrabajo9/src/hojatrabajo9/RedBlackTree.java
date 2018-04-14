package hojatrabajo9;

/**
 *
 * @author javie
 */
public class RedBlackTree<E> implements arbol{
    
    private Node root;
    
    private static final boolean RED   = true;
    private static final boolean BLACK = false;
    
    public RedBlackTree() {
    }
    /***************************************************************************
    *  Node helper methods.
    ***************************************************************************/
    // is node x red; false if x is null ?
    private boolean isRed(Node x) {
        if (x == null) 
            return false;
        return x.color == RED;
    }

    // number of node in subtree rooted at x; 0 if x is null
    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    } 


    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

   /**
     * Is this symbol table empty?
     * @return {@code true} if this symbol table is empty and {@code false} otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /***************************************************************************
    *  Standard BST search.
    ***************************************************************************/

    /**
     * Returns the value associated with the given key.
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public String get(String key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }
    // value associated with the given key in subtree rooted at x; null if no such key
    private String get(Node x, String key) {
        while (x != null) {
            int cmp = key.compareTo(x.getKey());
            if      (cmp < 0) x = x.getLeft();
            else if (cmp > 0) x = x.getRight();
            else              
                return x.getValue().getValue().toString();
        }
        return null;
    }
    /**
     * Does this symbol table contain the given key?
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *     {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public boolean contains(String key) {
        return get(key) != null;
    }
    /***************************************************************************
    *  Red-black tree insertion.
    ***************************************************************************/

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public void put(String key, String val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
          /**  delete(key);**/
            return;
        }

        root = put(root, key, val);
        root.color = BLACK;
        // assert check();
    }

    // insert the key-value pair in the subtree rooted at h
    private Node put(Node h, String key, String val) { 
        if (h == null) 
            return new Node(key, val, RED, 1);

        int cmp = key.compareTo(h.getKey());
        if      (cmp < 0) 
            h.setLeft(put(h.getLeft(),  key, val)); 
        else if (cmp > 0) 
            h.setRight(put(h.getRight(), key, val)); 
        else              
            h.setVal(val);

        // fix-up any right-leaning links
        if (isRed(h.getRight()) && !isRed(h.getLeft()))      
            h = rotateLeft(h);
        if (isRed(h.getLeft())  &&  isRed(h.getLeft().getLeft())) 
            h = rotateRight(h);
        if (isRed(h.getLeft())  &&  isRed(h.getRight()))     
            flipColors(h);
        h.size = size(h.getLeft()) + size(h.getRight()) + 1;

        return h;
    }
    
    /***************************************************************************
    *  Red-black tree helper functions.
    ***************************************************************************/

    // make a left-leaning link lean to the right
    private Node rotateRight(Node h) {
        // assert (h != null) && isRed(h.left);
        Node x = h.getLeft();
        h.setLeft(x.getRight());
        x.setRight(h);
        x.color = x.getRight().color;
        x.getRight().color = RED;
        x.size = h.size;
        h.size = size(h.getLeft()) + size(h.getRight()) + 1;
        return x;
    }

    // make a right-leaning link lean to the left
    private Node rotateLeft(Node h) {
        // assert (h != null) && isRed(h.right);
        Node x = h.getRight();
        h.setRight(x.getLeft());
        x.setLeft(h);
        x.color = x.getLeft().color;
        x.getLeft().color = RED;
        x.size = h.size;
        h.size = size(h.getLeft()) + size(h.getRight()) + 1;
        return x;
    }

    // flip the colors of a node and its two children
    private void flipColors(Node h) {
        // h must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        h.color = !h.color;
        h.getLeft().color = !h.getLeft().color;
        h.getRight().color = !h.getRight().color;
    }

    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    private Node moveRedLeft(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);

        flipColors(h);
        if (isRed(h.getRight().getLeft())) { 
            h.setRight(rotateRight(h.getRight()));
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    private Node moveRedRight(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
        flipColors(h);
        if (isRed(h.getLeft().getLeft())) { 
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    // restore red-black tree invariant
    private Node balance(Node h) {
        // assert (h != null);

        if (isRed(h.getRight()))                      
            h = rotateLeft(h);
        if (isRed(h.getLeft()) && isRed(h.getLeft().getLeft())) 
            h = rotateRight(h);
        if (isRed(h.getLeft()) && isRed(h.getRight()))     
            flipColors(h);
        h.size = size(h.getLeft()) + size(h.getRight()) + 1;
        return h;
    }
}
