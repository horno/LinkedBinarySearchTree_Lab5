public interface BinarySearchTree<K,V> {
    boolean isEmpty();
    boolean containsKey(K key);
    V get(K key);
    LinkedBinarySearchTree<K,V> put(K key, V value);
    LinkedBinarySearchTree<K,V> remove(K key);
}
