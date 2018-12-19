import java.util.Comparator;

public class LinkedBinarySearchTree<K, V> implements BinarySearchTree<K, V>, BinaryTree<Pair<K,V>>{


    private final Node<K, V> root;
    private final Comparator<K> comparator;
    
    private static class Node<K, V>{
        private final K key;
        private final V value;
        private final Node<K, V> left;
        private final Node<K, V> right;


        private Node(K key, V value, Node<K, V> left, Node<K, V> right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    public LinkedBinarySearchTree(Comparator<K> comparator){
        this(comparator, null);
    }
    private LinkedBinarySearchTree(Comparator<K> comparator, Node<K, V> root){
        this.comparator = comparator;
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Pair<K, V> root() {
        if(!this.isEmpty()){
            return new Pair<>(root.key,root.value);
        }else{
            throw new NullPointerException();
        }
    }

    @Override
    public LinkedBinarySearchTree<K,V> left() {
        if(!this.isEmpty()){
            return new LinkedBinarySearchTree<>(comparator,root.left);
        }else{
            throw new NullPointerException();
        }
    }

    @Override
    public LinkedBinarySearchTree<K,V> right() {
        if(!this.isEmpty()){
            return new LinkedBinarySearchTree<>(comparator,root.right);
        }else{
            throw new NullPointerException();
        }
    }

    @Override
    public boolean containsKey(K key) {
        return key != null && searchKey(key, root) != null;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = searchKey(key, root);
        if (node == null){
            return null;
        }else{
            return node.value;
        }
    }

    private Node<K, V> searchKey(K key, Node<K, V> current){
        if(current == null || comparator.compare(current.key, key) == 0){
            return current;
        }else if(comparator.compare(current.key, key) > 0){
            return searchKey(key, current.left);
        }else{
            return searchKey(key, current.right);
        }
    }

    @Override
    public LinkedBinarySearchTree<K, V> put(K key, V value) {
        if (key != null && value != null){
            return new LinkedBinarySearchTree<>(this.comparator, recurPut(key, value, root));
        }else{
            throw new NullPointerException();
        }
    }

    private Node<K, V> recurPut(K key, V value, Node<K, V> current){
        if(current == null){        //Simple case
            return new Node<>(key, value, null, null);
        }else if(comparator.compare(current.key, key)>0) {
            return new Node<>(current.key, current.value, recurPut(key, value, current.left), current.right);
        }else if(comparator.compare(current.key, key)<0){
            return new Node<>(current.key, current.value, current.left, recurPut(key, value, current.right));
        }else{
            return new Node<>(key, value, current.left, current.right);
        }
    }

    @Override
    public LinkedBinarySearchTree<K, V> remove(K key) {
        if(key == null){
            throw new NullPointerException();
        }else if(!containsKey(key)){
            return this;            //TODO clear if is returned this or the new LBST
//            return new LinkedBinarySearchTree<>(comparator, root);
        }else{
            return new LinkedBinarySearchTree<>(comparator, recurRem(key, root));
        }
    }

    private Node<K, V> recurRem(K key, Node<K, V> current){
        if(comparator.compare(current.key, key)>0){
            return new Node<>(current.key, current.value, recurRem(key, current.left), current.right);
        }else if(comparator.compare(current.key, key)<0){
            return new Node<>(current.key, current.value, current.left, recurRem(key, current.right));
        }else if(!hasLeft(current) && !hasRight(current)){
            return null;
        }else if(!hasLeft(current)){
            return current.right;
        }else if(!hasRight(current)){
            return current.left;
        }else{
            Node<K, V> minOfRight = searchMin(current.right);
            return new Node<>(minOfRight.key, minOfRight.value, current.left, recurRem(minOfRight.key, current.right));
        }
    }

    private Node<K, V> searchMin(Node<K, V> current){
        Node<K, V> min = current;
        while(hasLeft(min)){
            min = min.left;
        }
        return min;
    }

    private boolean hasLeft(Node<K, V> node){
        return node.left != null;
    }
    private boolean hasRight(Node<K, V> node){
        return node.right != null;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof LinkedBinarySearchTree){
            LinkedBinarySearchTree<?, ?> tree = (LinkedBinarySearchTree<?, ?>) o; //TODO unchecked cast
            return equals(this.root, tree.root);
        }
        return false;
    }

    private boolean equals(Node<K, V> node1, Node<?, ?> node2){
        if (node1 != null && node2 != null){
            return node1.key.equals(node2.key)   &&
                   node1.value.equals(node2.value) &&
                   equals(node1.left, node2.left) &&
                   equals(node1.right, node2.right);
        }else{
            return node1 == null && node2 == null;
        }
    }

    private String recurString(Node<K, V> current){ //TODO string append really inefficient
        if(current != null ){
            return  recurString(current.left) + "[" + current.key.toString()+
                    ", "+current.value.toString()+"] "+ recurString(current.right);
        }else{
            return "";
        }
    }


    private void recurString2(Node<K, V> current, StringBuilder sb){ //TODO decide if string is global
        if(current != null ){
             recurString2(current.left,sb);
             sb.append("[").append(current.key.toString()).append(", ").append(current.value.toString()).append("] ");
             recurString2(current.right,sb);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        recurString2(root,sb);
        return sb.toString();
    }
}
