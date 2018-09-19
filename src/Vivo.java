import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Vivo {

    public List<Integer> klevelOrder(Node root, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            count++;
            for (int i = 0; i < n; i++) {
                Node tmp = queue.poll();
                if (count == k) {
                    result.add(tmp.val);
                }
                for (Node child : tmp.children) {
                    queue.offer(child);
                }
            }
            if (count == k) {
                return result;
            }
        }
        return result;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
