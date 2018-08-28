import java.util.ArrayList;
import java.util.List;

public class Q894 {

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList<>();
        if (N == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        N--;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(N - i);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = left;
                    cur.right = right;
                    result.add(cur);
                }
            }
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
