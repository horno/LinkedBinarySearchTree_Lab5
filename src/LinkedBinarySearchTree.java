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
    public boolean containsKey(K key) {
        return searchKey(key,root) != null;
    }

    @Override
    public V get(K key) {
        Node<K,V> node = searchKey(key,root);
        if (node == null){
            return null;
        }else{
            return node.value;
        }
    }

    private Node<K,V> searchKey(K key, Node<K,V> current){
        if(current == null || comparator.compare(current.key,key) == 0){
            return current;
        }else if(comparator.compare(current.key,key) > 0){
            return searchKey(key,current.left);
        }else{
            return searchKey(key,current.right);
        }
    }

    @Override
    public LinkedBinarySearchTree<K, V> put(K key, V value) {
        if (key == null || value == null){
            throw new NullPointerException();
        }else{
            return new LinkedBinarySearchTree<>(this.comparator,recursiveTree(key,value,root));
        }
    }

    private Node<K,V> recursiveTree(K key, V value, Node<K,V> current){
        if(current == null){        //Simple case
            return new Node<>(key,value,null,null);
        }else if(comparator.compare(current.key,key)>0) {
            return new Node<>(current.key,current.value,recursiveTree(key,value,current.left),current.right);
        }else if(comparator.compare(current.key,key)<0){
            return new Node<>(current.key,current.value,current.left,recursiveTree(key,value,current.right));
        }else/*if(comparator.compare(current.key,key) == 0)*/{     //TODO this else if could be else, check that
            return new Node<>(current.key,current.value,current.left,current.right);
        }
        }

    @Override
    public LinkedBinarySearchTree<K, V> remove(K key) { //TODO do I really need to pass comparator as parameter?(is global)
        return new LinkedBinarySearchTree<>(comparator,recurRem(key,root));
    }

    private Node<K,V> recurRem(K key, Node<K,V> current){ //TODO 2 first implementation, needs revision
        if(comparator.compare(current.key,key)>0){
            return new Node<>(current.key,current.value,recurRem(key,current.left),current.right);
        }else if(comparator.compare(current.key,key)<0){
            return new Node<>(current.key,current.value,current.left,recurRem(key,current.right));
        }else/*if(comparator.compare(current.key,key) == 0)*/{
            if(current.left == null && current.right == null){  //TODO join conditionals
                return null;
            }else if(current.left == null && current.right != null){    //TODO unnecessary conditionals
                return current.right;
            }else if(current.left != null && current.right == null){
                return current.left;
            }else/*if(current.left != null && current.right != null)*/{
                Node<K,V> minOfRight = searchMin(current.right);
                return new Node<>(minOfRight.key,minOfRight.value,current.left,recurRem(minOfRight.key,current.right));
            }
        }
    }
    private Node<K,V> searchMin(Node<K,V> current){
        Node<K,V> min = current;
        while(min.left != null){
            min = current.left;
        }
        return min;
    }
    //TODO implement hasLeft() and hasRight() (?)
    @Override
    public String toString(){
        return recurString(root);
    }
    private String recurString(Node<K,V> current){ //TODO string parameter really useful?
        if(current != null ){
            return  recurString(current.left) + "[" + current.key.toString()+
                    ", "+current.value.toString()+"] "+ recurString(current.right);
        }else{
            return "";
        }
    }

}
