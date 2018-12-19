import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class LinkedStackTest {

    @Test
    public void isEmptyStack() {
        LinkedStack<Integer> stack = new LinkedStack<>();

        assertTrue(stack.isEmpty());
    }
    @Test
    public void isNotEmptyStack() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(5);

        assertFalse(stack.isEmpty());
    }

    @Test
    public void top() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("Foo");

        assertEquals("Foo",stack.top());
        assertFalse(stack.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void topEmpty() {
        LinkedStack<String> stack = new LinkedStack<>();

        stack.top();
    }

    @Test
    public void pop() {
        LinkedStack<Integer> stack = new LinkedStack<>();

        assertTrue(stack.isEmpty());

        stack.push(3);

        assertFalse(stack.isEmpty());

        stack.pop();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void push() {
        LinkedStack<String> stack = new LinkedStack<>();

        assertTrue(stack.isEmpty());

        stack.push("Foo");
        stack.push("Bar");

        assertFalse(stack.isEmpty());

        assertEquals("Bar",stack.top());

        stack.push("Eggplant");

        assertEquals("Eggplant",stack.top());

        stack.pop();
        stack.pop();
        stack.pop();

        assertTrue(stack.isEmpty());
    }
}