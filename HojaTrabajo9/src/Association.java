

import java.util.Map;
/**
 * @author Javier Carpio
 * @author Ana Lucia Hernandez 
 * @version $Id: Association.java 34 2007-08-09 14:43:44Z bailey $
 * @author, 2001 duane a. bailey
 * @param <K>
 * @param <V>
 */

public class Association<K, V> implements Map.Entry<K,V>{
    /**
     * The immutable key.  An arbitrary object.
     */
    protected K theKey; // the key of the key-value pair
    /**
     * The mutable value.  An arbitrary object.
     */
    protected V theValue; // the value of the key-value pair
    /**
     * Constructs a pair from a key and value.
     *
     * pre key is non-null
     * post constructs a key-value pair
     * @param key A non-null object.
     * @param value A (possibly null) object.
     */
    public Association(K key, V value)
    {
        
        theKey = key;
        theValue = value;
    }

    /**
     * Constructs a pair from a key; value is null.
     *
     * -pre key is non-null
     * -post constructs a key-value pair; value is null
     * @param key A non-null key value.
     */
    public Association(K key)
    {
        this(key,null);
    }

    /**
     * Standard comparison function.  Comparison based on keys only.
     *
     * -pre other is non-null Association
     * -post returns true if the keys are equal
     * @param other Another association.
     * @return true if the keys are equal.
     */
    @Override
    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
    /**
     * Standard hashcode function.
     *
     * -post return hash code association with this association
     * @return A hash code for association.
     * -see Hashtable
     */
    @Override
    public int hashCode()
    {
        return getKey().hashCode();
    }
    
    /**
     * Fetch value from association.  May return null.
     *
     * -post returns value from association
     * @return The value field of the association.
     */
    @Override
    public V getValue()
    {
        return theValue;
    }

    /**
     * Fetch key from association.  Should not return null.
     *
     * -post returns key from association
     * @return Key of the key-value pair.
     */
    @Override
    public K getKey()
    {
        return theKey;
    }

    /**
     * Sets the value of the key-value pair.
     *
     * -post sets association's value to value
     * @param value The new value.
     */
    @Override
    public V setValue(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }
    
}
