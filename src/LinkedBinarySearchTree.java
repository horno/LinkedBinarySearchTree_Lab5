import java.util.Comparator;

public class LinkedBinarySearchTree<K,V> implements BinarySearchTree<K,V>{


    private final Node<K,V> root;
    private final Comparator<K> comparator;


    private static class Node<K,V>{
        private final K key;
        private final V value;
        private final Node<K,V> left;
        private final Node<K,V> right;


        private Node(K key, V value,Node<K,V> left, Node<K,V> right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    public LinkedBinarySearchTree(Comparator<K> comparator){
        this(comparator,null);
    }
    private LinkedBinarySearchTree(Comparator<K> comparator, Node<K,V> root){
        this.comparator = comparator;
        this.root = root;
    }


    @Override
    public boolean isEmpty() { //TODO Implement
        return false;
    }

    @Override
    public boolean containsKey() { //TODO Implement
        return false;
    }

    @Override
    public V get(K key) { //TODO Implement
        return null;
    }

    @Override
    public LinkedBinarySearchTree<K, V> put(K key, V value) { //TODO Implement
        return null;
    }

    @Override
    public LinkedBinarySearchTree<K, V> remove(K key) { //TODO Implement
        return null;
    }
}
