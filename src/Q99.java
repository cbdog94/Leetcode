import java.util.LinkedList;
import java.util.List;

public class Q99 {

    public static void main(String[] args) {
        Q99 q = new Q99();
        TreeNode r = q.new TreeNode(2);
        TreeNode t2 = q.new TreeNode(3);
        TreeNode t3 = q.new TreeNode(1);
        r.right = t2;
        t2.left = t3;
        q.recoverTree(r);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public void recoverTree(TreeNode root) {
        TreeNode cur = root, prev;
        TreeNode swap1 = null, swap2 = null, last = new TreeNode(Integer.MIN_VALUE);

        while (cur != null) {
            if (cur.left == null) {
                //sout
                if (swap1 == null && cur.val < last.val)
                    swap1 = last;
                if (swap1 != null && cur.val < last.val)
                    swap2 = cur;
                last = cur;
                //
                cur = cur.right;
            } else {
                prev = cur.left;
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = cur;//加链后向左遍历
                    cur = cur.left;
                } else {//左子树已经遍历完回到根节点
                    prev.right = null;//断链
                    //sout
                    if (swap1 == null && cur.val < last.val)
                        swap1 = last;
                    if (swap1 != null && cur.val < last.val)
                        swap2 = cur;
                    last = cur;
                    //
                    cur = cur.right;//左边加根节点已经遍历完
                }
            }
        }

        int tmp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = tmp;
    }


}
