import org.junit.Test;

import javax.naming.InsufficientResourcesException;
import java.util.Comparator;

import static org.junit.Assert.*;

public class LinkedBinarySearchTreeTest {

    private Comparator<Integer> comp  = Comparator.naturalOrder();

    @Test
    public void isEmpty() {
        LinkedBinarySearchTree<Integer,Integer> emptyTree = new LinkedBinarySearchTree<>(comp);
        assertTrue(emptyTree.isEmpty());
        emptyTree = emptyTree.put(20,40);
        assertFalse(emptyTree.isEmpty());
    }

    @Test
    public void containsKey() {
        LinkedBinarySearchTree<Integer,Integer> tree = new LinkedBinarySearchTree<>(comp);
        tree = tree.put(20,6);
        tree = tree.put(30,7);
        tree = tree.put(65,8);
        tree = tree.put(90,9);
        tree = tree.put(200,10);
        tree = tree.put(60,11);

        assertTrue(tree.containsKey(65));
        assertFalse(tree.containsKey(19));
    }

    @Test
    public void get() {
        LinkedBinarySearchTree<Integer,Integer> tree = new LinkedBinarySearchTree<>(comp);
        if (tree.get(20) == null){
            System.out.println("null");
        }else{
            System.out.println("ASD");
        }
        tree = tree.put(20,6);
        int value = tree.get(20);

        assertEquals(value,6);

    }

    @Test
    public void put() {

    }

    @Test
    public void remove() {
        Comparator<Integer> comp = Comparator.naturalOrder();
        LinkedBinarySearchTree<Integer, Integer> newTree = new LinkedBinarySearchTree<>(comp);
        newTree = newTree.put(50,1);
        newTree = newTree.put(25,2);
        newTree = newTree.put(75,3);
        newTree = newTree.put(13,4);
        newTree = newTree.put(7,5);
        newTree = newTree.put(20,6);
        newTree = newTree.put(30,7);
        newTree = newTree.put(65,8);
        newTree = newTree.put(90,9);
        newTree = newTree.put(200,10);
        newTree = newTree.put(60,11);

        newTree = newTree.remove(75);

        if(newTree.isEmpty()){
            System.out.println("Empty tree");
        }else System.out.println(newTree.toString());
    }

    @Test
    public void remove2() {
        Comparator<Integer> comp = Comparator.naturalOrder();
        LinkedBinarySearchTree<Integer, Integer> newTree = new LinkedBinarySearchTree<>(comp);
        newTree = newTree.put(50,1);
        newTree = newTree.put(40,2);
        newTree = newTree.put(70,3);
        newTree = newTree.put(60,4);
        newTree = newTree.put(80,5);

        newTree = newTree.remove(50);

        if(newTree.isEmpty()){
            System.out.println("Empty tree");
        }else System.out.println(newTree.toString());
    }
    @Test
    public void toStringTest(){
        Comparator<Integer> comp = Comparator.naturalOrder();
        LinkedBinarySearchTree<Integer, Integer> newTree = new LinkedBinarySearchTree<>(comp);
        newTree = newTree.put(50,1);
        newTree = newTree.put(25,2);
        newTree = newTree.put(75,3);
        newTree = newTree.put(13,4);
        newTree = newTree.put(7,5);
        newTree = newTree.put(20,6);
        newTree = newTree.put(30,7);
        newTree = newTree.put(65,8);
        newTree = newTree.put(90,9);
        newTree = newTree.put(200,10);
        newTree = newTree.put(60,11);

        if(newTree.isEmpty()){
            System.out.println("Empty tree");
        }else System.out.println(newTree.toString());
    }
}