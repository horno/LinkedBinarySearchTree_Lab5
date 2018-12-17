import org.junit.Test;
import java.util.Comparator;

import static org.junit.Assert.*;

public class LinkedBinarySearchTreeTest {

    private Comparator<Integer> comp  = Comparator.naturalOrder();

    @Test
    public void isEmpty() {
        LinkedBinarySearchTree<Integer, Integer> emptyTree = new LinkedBinarySearchTree<>(comp);

        assertTrue(emptyTree.isEmpty());

        emptyTree = emptyTree.put(20, 40);

        assertFalse(emptyTree.isEmpty());
    }

    @Test
    public void containsKey() {
        LinkedBinarySearchTree<Integer, String> tree = new LinkedBinarySearchTree<>(comp);
        tree = tree.put(20, "Twenty");
        tree = tree.put(30, "Thirty");
        tree = tree.put(65, "Sixty-five");
        tree = tree.put(90, "Ninety");
        tree = tree.put(200, "Two hundred");
        tree = tree.put(60, "Sixty");

        assertTrue(tree.containsKey(65));
        assertFalse(tree.containsKey(19));
    }
    @Test
    public void containsKeyNull() {
        LinkedBinarySearchTree<Integer, String> tree = new LinkedBinarySearchTree<>(comp);

        assertFalse(tree.containsKey(null));

        tree = tree.put(20, "Twenty");
        tree = tree.put(65, "Sixty-five");
        tree = tree.put(30, "Thirty");

        assertFalse(tree.containsKey(null));
    }

    @Test
    public void get() {
        LinkedBinarySearchTree<Integer, String> tree = new LinkedBinarySearchTree<>(comp);
        tree = tree.put(20, "Twenty");

        assertEquals(tree.get(20), "Twenty");
    }
    @Test
    public void getNotExist() {
        LinkedBinarySearchTree<Integer, String> tree = new LinkedBinarySearchTree<>(comp);
        tree = tree.put(20, "Twenty");

        assertNull(tree.get(45));
    }

    @Test
    public void putImmutability() {
        LinkedBinarySearchTree<Integer, String> tree1 = new LinkedBinarySearchTree<>(comp);
        LinkedBinarySearchTree<Integer, String> tree2;

        tree1 = tree1.put(20, "Hello");
        tree1 = tree1.put(30, "Hi");
        tree1 = tree1.put(10, "What's up");
        tree1 = tree1.put(25, "Hey");

        tree2 = tree1;

        assertEquals(tree1, tree2);

        tree2 = tree1.put(20, "Goodbye");

        assertNotEquals(tree1, tree2);
    }

    @Test
    public void putExistingKey() {
        LinkedBinarySearchTree<Integer, String> tree1 = new LinkedBinarySearchTree<>(comp);
        LinkedBinarySearchTree<Integer, String> tree2 = new LinkedBinarySearchTree<>(comp);

        tree1 = tree1.put(20, "Hello");
        tree1 = tree1.put(30, "Hi");
        tree1 = tree1.put(25, "Hey");

        tree2 = tree2.put(20, "Bye");
        tree2 = tree2.put(30, "Hi");
        tree2 = tree2.put(25, "Hey");

        assertNotEquals(tree1, tree2);

        tree1 = tree1.put(20, "Bye");

        assertEquals(tree1, tree2);
    }

    @Test (expected = NullPointerException.class)
    public void putNllKey() {
        LinkedBinarySearchTree<Integer, Integer> tree = new LinkedBinarySearchTree<>(comp);

        tree.put(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void putNullValue(){
        LinkedBinarySearchTree<Integer, Integer> tree = new LinkedBinarySearchTree<>(comp);

        tree.put(4, null);
    }

    @Test(expected = NullPointerException.class)
    public void putNullKeyValue(){
        LinkedBinarySearchTree<Integer, Integer> tree = new LinkedBinarySearchTree<>(comp);

        tree.put(null, null);
    }

    @Test
    public void removeAll() {
        LinkedBinarySearchTree<Integer, Integer> newTree = new LinkedBinarySearchTree<>(comp);
        newTree = newTree.put(50, 1);
        newTree = newTree.put(25, 2);
        newTree = newTree.put(75, 3);
        newTree = newTree.put(13, 4);

        assertFalse(newTree.isEmpty());

        newTree = newTree.remove(25);
        newTree = newTree.remove(50);
        newTree = newTree.remove(13);
        newTree = newTree.remove(75);

        assertTrue(newTree.isEmpty());
    }

    @Test
    public void removeNothing() {
        LinkedBinarySearchTree<Integer, Integer> newTree = new LinkedBinarySearchTree<>(comp);
        LinkedBinarySearchTree<Integer, Integer> toRemoveTree;

        newTree = newTree.put(52, 1);
        newTree = newTree.put(40, 2);
        newTree = newTree.put(70, 3);
        newTree = newTree.put(60, 4);
        newTree = newTree.put(80, 5);

        toRemoveTree = newTree.remove(50);

        assertEquals(newTree, toRemoveTree);
    }
    @Test
    public void removeEmpty() {
        LinkedBinarySearchTree<Integer, Integer> newTree = new LinkedBinarySearchTree<>(comp);
        newTree = newTree.remove(50);
        assertTrue(newTree.isEmpty());
    }
    @Test(expected = NullPointerException.class)
    public void removeNull(){
        LinkedBinarySearchTree<Integer,Integer> tree = new LinkedBinarySearchTree<>(comp);
        tree.remove(null);
    }

    @Test
    public void toStringTest(){
        LinkedBinarySearchTree<Integer, Integer> newTree = new LinkedBinarySearchTree<>(comp);
        newTree = newTree.put(50, 1);
        newTree = newTree.put(25, 2);
        newTree = newTree.put(75, 3);
        newTree = newTree.put(13, 4);
        newTree = newTree.put(7, 5);
        newTree = newTree.put(20, 6);
        newTree = newTree.put(30, 7);
        newTree = newTree.put(65, 8);
        newTree = newTree.put(90, 9);
        newTree = newTree.put(200, 10);
        newTree = newTree.put(60, 11);

        String expected = "[7, 5] [13, 4] [20, 6] [25, 2] [30, 7] [50, 1] [60, 11] [65, 8] [75, 3] [90, 9] [200, 10] ";

        assertEquals(newTree.toString(), expected);
    }
    @Test
    public void toStringString(){
        LinkedBinarySearchTree<Integer, String> tree = new LinkedBinarySearchTree<>(comp);
        tree = tree.put(1,"This");
        tree = tree.put(2,"is");
        tree = tree.put(3,"toString");

        String expected = "[1, This] [2, is] [3, toString] ";
        assertEquals(tree.toString(),expected);
    }
    
    @Test
    public void toStringEmpty(){
        LinkedBinarySearchTree<Integer, Integer> emptyTree = new LinkedBinarySearchTree<>(comp);
        
        String string = "";
        
        assertEquals(emptyTree.toString(), string);
    }
    
    @Test
    public void equalsEmptyTest(){
        Comparator<Integer> comp = Comparator.naturalOrder();
        LinkedBinarySearchTree<Integer, Integer> emptyTree1 = new LinkedBinarySearchTree<>(comp);
        LinkedBinarySearchTree<Integer, Integer> emptyTree2 = new LinkedBinarySearchTree<>(comp);

        assertEquals(emptyTree1, emptyTree2);
    }

    @Test
    public void equalsNotEmptyTest(){
        Comparator<Integer> comp = Comparator.naturalOrder();
        LinkedBinarySearchTree<Integer, Integer> emptyTree1 = new LinkedBinarySearchTree<>(comp);
        emptyTree1 = emptyTree1.put(50, 32);
        emptyTree1 = emptyTree1.put(20, 12);
        emptyTree1 = emptyTree1.put(70, 7);
        emptyTree1 = emptyTree1.put(59, 3);

        LinkedBinarySearchTree<Integer, Integer> emptyTree2 = new LinkedBinarySearchTree<>(comp);
        emptyTree2 = emptyTree2.put(50, 32);
        emptyTree2 = emptyTree2.put(20, 12);
        emptyTree2 = emptyTree2.put(70, 7);

        assertNotEquals(emptyTree1, emptyTree2);

        emptyTree2 = emptyTree2.put(59, 3);

        assertEquals(emptyTree1, emptyTree2);
    }
}












