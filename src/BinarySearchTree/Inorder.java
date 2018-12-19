import java.util.ArrayList;

public class Inorder {


    public static <K,V> ArrayList<Pair<K,V>> toInorder(LinkedBinarySearchTree<K,V> tree) {
        ArrayList<Pair<K, V>> array = new ArrayList<>();
        LinkedStack<LinkedBinarySearchTree<K, V>> stack = new LinkedStack<>();
        LinkedBinarySearchTree<K,V> current = tree;

        stackLeft(current,stack);

        while (!stack.isEmpty()){
            current = stack.top();
            stack.pop();
            array.add(current.root());
            current = current.right();

            stackLeft(current,stack);
        }

        return array;
    }

    public static <K,V> void stackLeft(LinkedBinarySearchTree<K,V> current,LinkedStack<LinkedBinarySearchTree<K,V>> stack) {
        while(!current.isEmpty()){
            stack.push(current);
            current = current.left();
        }

    }

}


  /*  public static <K,V> ArrayList<Pair<K,V>> toInorder(LinkedBinarySearchTree<K,V> tree){
        ArrayList<Pair<K,V>> array = new ArrayList<>();
        LinkedStack<Pair<LinkedBinarySearchTree<K,V>,Boolean>> stack = new LinkedStack<>();

        stack.push(new Pair<>(tree,false));

        while(!stack.isEmpty()){
            if(tree.hasLeft()){
                tree = tree.left();
                stack.push(new Pair<>(tree.left(),false));
            }else{
                array.add(tree.root());
                if(tree.hasRight()){



                }
            }
        }



        return null;
    }

    public static <K,V> ArrayList<Pair<K,V>> preorder(LinkedBinarySearchTree<K,V> tree){
        ArrayList<Pair<K,V>> array = new ArrayList<>();
        LinkedStack<LinkedBinarySearchTree<K,V>> stack = new LinkedStack<>();
        stack.push(tree);
        while (!stack.isEmpty()){
            LinkedBinarySearchTree<K,V> current = stack.top();
            stack.pop();
            if(!current.isEmpty()){
                array.add(current.root());
                stack.push(current.right());
                stack.push(current.left());
            }
        }
        return  array;
    }

    private static <K,V> void addLeft(LinkedStack<LinkedBinarySearchTree<K,V>> stack, //TODO mutable?
                                        LinkedBinarySearchTree<K,V> tree, ArrayList<Pair<K,V>> array){
        while(tree.hasLeft()){
            stack.push(tree);
            tree = tree.left();
        }

    }

    private static <K,V> void stackRight(LinkedStack<LinkedBinarySearchTree<K,V>> stack,
                                        LinkedBinarySearchTree<K,V> tree, ArrayList<Pair<K,V>> array){


    }*/
