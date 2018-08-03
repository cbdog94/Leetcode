import java.util.Iterator;

public class Test {


    public static void main(String[] args) {
        Stack<Double> stack = new Stack<>();
        stack.push(1.0);
        stack.push(2.0);
        System.out.println(stack.size);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
        for (Double d : stack) {
            System.out.println(d);
        }
    }

    private static class Stack<Item> implements Iterable<Item> {

        private Node cur;
        private int size;

        Stack() {
            size = 0;
//            head=new Node<>(null);
//            a= (Item[]) new Object[n];
        }

        public void push(Item i) {
//            Node<Item> tmp=new Node<>(i);
            Node newNode = new Node(i);
            newNode.next = cur;
            cur = newNode;
            size++;
        }

        public Item pop() {
            Node tmp = cur;
            cur = cur.next;
            size--;
            return tmp.val;
        }

        public int size() {
            return size;
        }

        @Override
        public Iterator<Item> iterator() {
            return new StackIterator();
        }

        private class Node {
            public Node next;
            private Item val;

            Node(Item item) {
                this.val = item;
            }
        }

        private class StackIterator implements Iterator<Item> {

            Node iter = cur;

            @Override
            public boolean hasNext() {
                return iter != null;
            }

            @Override
            public Item next() {
                Item item = iter.val;
                iter = iter.next;
                return item;
            }
        }

    }

}
