import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q559 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node tmp = queue.poll();
                for (Node node : tmp.children) {
                    queue.offer(node);
                }
            }
        }
        return depth;
    }

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
