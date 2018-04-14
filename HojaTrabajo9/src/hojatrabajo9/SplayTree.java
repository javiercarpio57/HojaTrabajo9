package hojatrabajo9;

/**
 *
 * @author javie
 */
public class SplayTree<E> implements arbol //ya que se usará factory, se necesita que implemente la interfaz arbol 
{
    public Node root;
    private int count = 0;
    
    /** Constructor **/
    public SplayTree(){
        root = null;
    }
    
    /** Function to check if tree is empty **/
    public boolean isEmpty(){
        return root == null;
    }
    
    /** clear tree **/
    public void clear(){
        root = null;
    }
    /***************************************************************************
    *  Splay tree insertion.
    ***************************************************************************/
    /** function to insert element
     * @param ele */
    public void insert(Node ele){
        Node z = root;
        z = insertRec(root, ele);
     }
    
    private Node insertRec(Node root, Node nodo){
        Node p = null;
        while (root != null){
            p = root;
            if (root.getKey().compareTo(p.getKey()) < 0){
                root = root.right;
            }else{
                z = z.left;
            }
        }
        z = new Node();
        z.element = ele;
        z.parent = p;
        if (p == null){     
            root = z;
        }else if (ele < p.element){
            p.right = z;
        }else{
            p.left = z;
        }
        Splay(z);
        count++;
    }
    
     /** rotate **/
     public void makeLeftChildParent(Node c, Node p)
     {
         if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))
             throw new RuntimeException("WRONG");
 
         if (p.parent != null)
         {
             if (p == p.parent.left)
                 p.parent.left = c;
             else 
                 p.parent.right = c;
         }
         if (c.right != null)
             c.right.parent = p;
 
         c.parent = p.parent;
         p.parent = c;
         p.left = c.right;
         c.right = p;
     }
 
     /** rotate **/
     public void makeRightChildParent(Node c, Node p)
     {
         if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
             throw new RuntimeException("WRONG");
         if (p.parent != null)
         {
             if (p == p.parent.left)
                 p.parent.left = c;
             else
                 p.parent.right = c;
         }
         if (c.left != null)
             c.left.parent = p;
         c.parent = p.parent;
         p.parent = c;
         p.right = c.left;
         c.left = p;
     }
 
     /** function splay **/
     private void Splay(Node x)
     {
         while (x.parent != null)
         {
             Node Parent = x.parent;
             Node GrandParent = Parent.parent;
             if (GrandParent == null)
             {
                 if (x == Parent.left)
                     makeLeftChildParent(x, Parent);
                 else
                     makeRightChildParent(x, Parent);                 
             } 
             else
             {
                 if (x == Parent.left)
                 {
                     if (Parent == GrandParent.left)
                     {
                         makeLeftChildParent(Parent, GrandParent);
                         makeLeftChildParent(x, Parent);
                     }
                     else 
                     {
                         makeLeftChildParent(x, x.parent);
                         makeRightChildParent(x, x.parent);
                     }
                 }
                 else 
                 {
                     if (Parent == GrandParent.left)
                     {
                         makeRightChildParent(x, x.parent);
                         makeLeftChildParent(x, x.parent);
                     } 
                     else 
                     {
                         makeRightChildParent(Parent, GrandParent);
                         makeRightChildParent(x, Parent);
                     }
                 }
             }
         }
         root = x;
     }
 
 
     /** Functions to count number of nodes **/
     public int countNodes()
     {
         return count;
     }
 
     /** Functions to search for an element **/
     public boolean search(int val)
     {
         return findNode(val) != null;
     }
     private Node findNode(int ele)
     {
         Node z = root;
         while (z != null)
         {
             if (ele < z.element)
                 z = z.right;
             else if (ele > z.element)
                 z = z.left;
             else
                 return z;
         }
         return null;
     }
 
     /** Function for inorder traversal **/ 
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(Node r)
     {
         if (r != null)
         {
             inorder(r.left);
             System.out.print(r.element +" ");
             inorder(r.right);
         }
     }
 
     /** Function for preorder traversal **/
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(Node r)
     {
         if (r != null)
         {
             System.out.print(r.element +" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
 
     /** Function for postorder traversal **/
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(Node r)
     {
         if (r != null)
         {
             postorder(r.left);             
             postorder(r.right);
             System.out.print(r.element +" ");
         }
     }

     

     //splaytree funcional:
     
     
    /**
    public boolean contains(String key) {
        return get(key) != null;
    }

    // return value associated with the given key
    // if no such value, return null
    public String get(String key) {
        root = splay(root, key);
        int cmp = key.compareTo(root.getKey());
        if (cmp == 0) return root.getValue().getValue().toString();
        else          return null;
    }    

   //       ************ Splay tree insertion. ***************
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

        /** It was a duplicate key. Simply replace the value
        else {
            root.value = value;
        }

    }
    
   // *************** Splay tree deletion. ***************
    
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
    public int height() { return height(root); }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.getLeft()), height(x.getRight()));
    }

    
    public int size() {
        return size(root);
    }
    
    private int size(Node x) {
        if (x == null) return 0;
        else return 1 + size(x.getLeft()) + size(x.getRight());
    }
    
    // right rotate
    private Node rotateRight(Node h) {
        Node x = h.getLeft();
        h.setLeft(x.getRight());
        x.setRight(h);
        return x;
    }

    // left rotate
    private Node rotateLeft(Node h) {
        Node x = h.getRight();
        h.setRight(x.getLeft());
        x.setLeft(h);
        return x;
    }
    **/
}