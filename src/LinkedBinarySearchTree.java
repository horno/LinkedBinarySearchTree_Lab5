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
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean containsKey(K key) { //TODO 2 First attempt
        Node<K,V> current = root;
        while(current != null){
            if(comparator.compare(current.key,key) == 0){
                return true;
            }else if(comparator.compare(current.key,key)>0){
                current = current.left;
            }else{
                current = current.left;
            }
        }
        return false;
    }
    //*TODO 2 Implement method that given a key returns its node, with that auxiliary method the functions containsKey
    // and get will be more polite.

    @Override
    public V get(K key) {
        Node<K,V> current = root;
        while(current != null){
            if(comparator.compare(current.key,key) == 0){
                return current.value;
            }else if(comparator.compare(current.key,key)>0){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return null;
    }

    @Override
    public LinkedBinarySearchTree<K, V> put(K key, V value) {
        LinkedBinarySearchTree<K,V> newTree = new LinkedBinarySearchTree<>(this.comparator,root);

        return newTree;
    }
    private Node<K,V> recursiveTree(K key, V value, Node<K,V> current){//TODO isEmpty case
        if(current == null){        //Simple case                      //TODO key or value null case
            return new Node<>(key,value,null,null);
        }else if(comparator.compare(current.key,key)>0) {
            return new Node<>(current.key,current.value,recursiveTree(key,value,current.left),current.right);
        }else if(comparator.compare(current.key,key)<0){
            return new Node<>(current.key,current.value,current.left,recursiveTree(key,value,current.left));
        }else/*if(comparator.compare(current.key,key) == 0)*/{     //TODO this else if could be else, check that
            return new Node<>(current.key,current.value,current.left,current.right);
        }
        }

    @Override
    public LinkedBinarySearchTree<K, V> remove(K key) { //TODO 1 Implement
        return null;
    }
}
