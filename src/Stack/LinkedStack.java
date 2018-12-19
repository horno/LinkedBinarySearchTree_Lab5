public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;

    private static class Node<E>{

        private E elem;
        private Node<E> next;

        private Node(E elem, Node<E> next){
            this.elem = elem;
            this.next = next;
        }

    }

    public LinkedStack(){
        top = null;     //header
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public E top() {
        return top.elem;
    }

    @Override
    public void pop() {
        top = top.next;
    }

    @Override
    public void push(E e) {
        top = new Node<>(e,top);
    }
}
