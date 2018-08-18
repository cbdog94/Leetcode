import java.util.Stack;

public class Q430 {

    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node result = null, pre = null;
        while (head != null) {
            if (result == null) {
                result = new Node(head.val, null, null, null);
                pre = result;
            } else {
                Node tmp = new Node(head.val, pre, null, null);
                pre.next = tmp;
                pre = tmp;
            }
            if (head.child != null) {
                stack.push(head.next);
                head = head.child;
            } else if (head.next != null) {
                head = head.next;
            } else if (!stack.empty()) {
                head = stack.pop();
            } else {
                head = null;
            }
        }
        return result;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }


}
