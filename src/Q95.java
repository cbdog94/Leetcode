import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q95 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q95().generateTrees(3).size());
    }

    /**
     * G(n)=F(1,n)+F(2,n)+...+F(n,n)
     * F(i,n)=G(i-1)*G(n-i)
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        List<TreeNode>[][] dp = new List[n + 2][n + 2];
        List<TreeNode> NULL = Arrays.asList(new TreeNode[]{null});
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                List<TreeNode> list = new ArrayList<>();
                for (int k = j; k <= j + i; k++) {
                    List<TreeNode> lefts = dp[j][k - 1] == null ? NULL : dp[j][k - 1];
                    List<TreeNode> rights = dp[k + 1][j + i] == null ? NULL : dp[k + 1][j + i];
                    for (TreeNode left : lefts)
                        for (TreeNode right : rights) {
                            TreeNode root = new TreeNode(k);
                            root.left = left;
                            root.right = right;
                            list.add(root);
                        }
                }
                dp[j][j + i] = list;
            }
        }
        return dp[1][n];
    }

//    public List<TreeNode> generateTrees(int n) {
//        if (n == 0)
//            return new ArrayList<>();
//        return generateTrees(1, n);
//    }
//
//    private List<TreeNode> generateTrees(int start, int end) {
//        if (start > end)
//            return Arrays.asList(new TreeNode[]{null});
//        else if (start == end)
//            return Collections.singletonList(new TreeNode(start));
//        List<TreeNode> list = new ArrayList<>();
//        for (int i = start; i <= end; i++) {
//            List<TreeNode> lefts = generateTrees(start, i - 1);
//            List<TreeNode> rights = generateTrees(i + 1, end);
//            for (TreeNode left : lefts)
//                for (TreeNode right : rights) {
//                    TreeNode root = new TreeNode(i);
//                    root.left = left;
//                    root.right = right;
//                    list.add(root);
//                }
//        }
//        return list;
//    }
}
