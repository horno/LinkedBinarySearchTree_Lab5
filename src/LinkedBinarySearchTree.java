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
        if (key != null && value != null){
            return new LinkedBinarySearchTree<>(this.comparator, recurPut(key,value,root));
        }else{
            throw new NullPointerException();
        }
    }

    private Node<K,V> recurPut(K key, V value, Node<K,V> current){
        if(current == null){        //Simple case
            return new Node<>(key,value,null,null);
        }else if(comparator.compare(current.key,key)>0) {
            return new Node<>(current.key,current.value, recurPut(key,value,current.left),current.right);
        }else if(comparator.compare(current.key,key)<0){
            return new Node<>(current.key,current.value,current.left, recurPut(key,value,current.right));
        }else{
            return new Node<>(key,value,current.left,current.right);
        }
    }

    @Override
    public LinkedBinarySearchTree<K, V> remove(K key) {
        if(!containsKey(key)){
            return this;            //TODO clear if is returned this or the new LBST
//            return new LinkedBinarySearchTree<>(comparator,root);
        }else if(key != null){
            return new LinkedBinarySearchTree<>(comparator,recurRem(key,root));
        }else{
            throw new NullPointerException();
        }
    }

    private Node<K,V> recurRem(K key, Node<K,V> current){
        if(comparator.compare(current.key,key)>0){
            return new Node<>(current.key,current.value,recurRem(key,current.left),current.right);
        }else if(comparator.compare(current.key,key)<0){
            return new Node<>(current.key,current.value,current.left,recurRem(key,current.right));
        }else if(!hasLeft(current) && !hasRight(current)){
            return null;
        }else if(!hasLeft(current)){
            return current.right;
        }else if(!hasRight(current)){
            return current.left;
        }else{
            Node<K,V> minOfRight = searchMin(current.right);
            return new Node<>(minOfRight.key,minOfRight.value,current.left,recurRem(minOfRight.key,current.right));
        }
    }

    private Node<K,V> searchMin(Node<K,V> current){
        Node<K,V> min = current;
        while(hasLeft(min)){
            min = min.left;
        }
        return min;
    }

    private boolean hasLeft(Node<K,V> node){
        return node.left != null;
    }
    private boolean hasRight(Node<K,V> node){
        return node.right != null;
    }

    @Override
    public String toString(){
        return recurString(root);
    }
    private String recurString(Node<K,V> current){ //TODO string append really inefficient
        if(current != null ){
            return  recurString(current.left) + "[" + current.key.toString()+
                    ", "+current.value.toString()+"] "+ recurString(current.right);
        }else{
            return "";
        }
    }

}
