import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import static org.junit.Assert.*;

public class InorderTest {


    @Test
    public void inorderTest(){
        Comparator<Integer> comp = Comparator.naturalOrder();
        LinkedBinarySearchTree<Integer, Integer> tree = new LinkedBinarySearchTree<>(comp);

        tree = tree.put(200,1);
        tree = tree.put(104,2);
        tree = tree.put(48,3);
        tree = tree.put(79,4);
        tree = tree.put(215,5);
        tree = tree.put(94,6);
        tree = tree.put(14,7);
        tree = tree.put(27,8);
        tree = tree.put(38,8);
        tree = tree.put(60,8);
        tree = tree.put(206,8);
        tree = tree.put(205,8);
        tree = tree.put(204,8);
        tree = tree.put(203,8);

        ArrayList<Pair<Integer,Integer>> array = Inorder.toInorder(tree);
        assertEquals("[{14, 7}, {27, 8}, {38, 8}, {48, 3}, {60, 8}, {79, 4}," +
                    " {94, 6}, {104, 2}, {200, 1}, {203, 8}, {204, 8}, {205, 8}, {206, 8}, {215, 5}]",array.toString());
    }

    @Test
    public void inorderEmpty() {
        Comparator<Integer> comp = Comparator.naturalOrder();
        LinkedBinarySearchTree<Integer, Integer> tree = new LinkedBinarySearchTree<>(comp);
        ArrayList<Pair<Integer, Integer>> array = Inorder.toInorder(tree);
        assertTrue(array.isEmpty());
    }
}