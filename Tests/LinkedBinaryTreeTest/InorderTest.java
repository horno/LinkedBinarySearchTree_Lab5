import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;

import static org.junit.Assert.*;

public class InorderTest {

    @Test
    public void iteratorTest() {
        Comparator<Integer> cmp = Comparator.naturalOrder();
        LinkedBinarySearchTree<Integer,Integer> tree = new LinkedBinarySearchTree<>(cmp);
        tree = tree.put(1,1);
        tree = tree.put(3,3);
        tree = tree.put(18,18);
        tree = tree.put(21,21);
        tree = tree.put(30,30);
        tree = tree.put(2,2);

        Iterator<Pair<Integer,Integer>> it = tree.iterator();
        Pair<Integer,Integer> integer;
        if (it.hasNext()){
            integer = it.next();
            System.out.println(integer.toString());
        }
    }
}