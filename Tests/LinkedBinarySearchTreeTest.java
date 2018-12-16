import org.junit.Test;

import javax.naming.InsufficientResourcesException;
import java.util.Comparator;

import static org.junit.Assert.*;

public class LinkedBinarySearchTreeTest {

    @Test
    public void isEmpty() {
    }

    @Test
    public void containsKey() {
    }

    @Test
    public void get() {
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