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
    // and get will be more polite (think of a recursive search)

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
        LinkedBinarySearchTree<K,V> newTree = new LinkedBinarySearchTree<>(this.comparator,recursiveTree(key,value,root));
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
    public LinkedBinarySearchTree<K, V> remove(K key) { //TODO do I really need to pass comparator as parameter?(is global)
        LinkedBinarySearchTree<K,V> newTree = new LinkedBinarySearchTree<>(comparator,recurRem(key,root));
        return newTree;
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
    @Override
    public String toString(){
        String string = "";
        return recurString(string, root);
    }
    private String recurString(String string,Node<K,V> current){ //TODO string parameter really useful?
        if(current.left == null){
            return "[" + current.key.toString()+
                    ", "+current.value.toString()+"] ";
        }else{
            return string + recurString(string,current.left) + "[" + current.key.toString()+
                    ", "+current.value.toString()+"] "+ recurString(string,current.right);
        }

        
    }

}














