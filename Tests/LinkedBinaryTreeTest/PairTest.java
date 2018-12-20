import org.junit.Test;

import static org.junit.Assert.*;

public class PairTest {


    @Test
    public void first() {
        Pair<Integer,Integer> pair = new Pair<>(1,2);

        assertEquals((Integer)1,pair.first());
    }

    @Test
    public void second() {
        Pair<Integer,Integer> pair = new Pair<>(1,2);

        assertEquals((Integer)2,pair.second());
    }

    @Test
    public void toStringTest() {
        Pair<Integer,Integer> pair = new Pair<>(13,17);

        assertEquals("{13, 17}",pair.toString());
    }
}