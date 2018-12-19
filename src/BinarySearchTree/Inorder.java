import java.util.ArrayList;

public class Inorder {


    public static <K,V> ArrayList<Pair<K,V>> toInorder(LinkedBinarySearchTree<K,V> tree) {
        ArrayList<Pair<K, V>> array = new ArrayList<>();
        LinkedStack<LinkedBinarySearchTree<K, V>> stack = new LinkedStack<>();
        LinkedBinarySearchTree<K,V> current = tree;

        stackLeft(current,stack);

        while (!stack.isEmpty()){
            current = stack.top();
            array.add(current.root());
            stack.pop();
            current = current.right();
            stackLeft(current,stack);
        }

        return array;
    }

     private static <K,V> void stackLeft(LinkedBinarySearchTree<K,V> current,LinkedStack<LinkedBinarySearchTree<K,V>> stack) {
        while(!current.isEmpty()){
            stack.push(current);
            current = current.left();
        }

    }

}