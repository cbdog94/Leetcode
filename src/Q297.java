
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q297 {

    public static void main(String[] args) {
        Q297 q297 = new Q297();
        TreeNode n1 = q297.new TreeNode(1);
        TreeNode n2 = q297.new TreeNode(2);
        TreeNode n3 = q297.new TreeNode(3);
        TreeNode n4 = q297.new TreeNode(4);
        TreeNode n5 = q297.new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        Codec codec = q297.new Codec();
        System.out.println(codec.serialize(n1));
//        new Q297().new Codec().deserialize("[1, 2, 3, null, null, 4, 5]");
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public List<Integer> serialize(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                int cnt = queue.size();
                for (int i = 0; i < cnt; i++) {
                    TreeNode tmp = queue.poll();
                    if (tmp == null) {
                        result.add(null);
                    } else {
                        result.add(tmp.val);
                        queue.offer(tmp.left);
                        queue.offer(tmp.right);
                    }
                }
            }
            return result;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(List<Integer> data) {
            if (data.size() == 0) {
                return null;
            }
            TreeNode root = new TreeNode(data.get(0));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 1;
            while (index < data.size()) {
                int cnt = queue.size();
                for (int i = 0; i < cnt; i++) {
                    TreeNode tmp = queue.poll();
                    if (tmp != null) {
                        if (data.get(index) == null) {
                            tmp.left = null;
                        } else {
                            tmp.left = new TreeNode(data.get(index));
                            queue.offer(tmp.left);
                        }
                        index++;
                        if (data.get(index) == null) {
                            tmp.right = null;
                        } else {
                            tmp.right = new TreeNode(data.get(index));
                            queue.offer(tmp.right);
                        }
                        index++;
                    }
                }
            }
            return root;
        }
    }

}
