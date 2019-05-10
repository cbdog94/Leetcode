public class Q1028 {

    public static void main(String[] args) {
        System.out.println(new Q1028().recoverFromPreorder("1-2--3---4-5--6---7"));
        System.out.println(new Q1028().recoverFromPreorder("1-401--349---90--88"));
    }

    public TreeNode recoverFromPreorder(String S) {
        return recoverFromPreorder(S, 1);
    }

    public TreeNode recoverFromPreorder(String S, int d) {
        if (S.length() == 0) {
            return null;
        }
        int num = 0, i;
        for (i = 0; i < S.length() && Character.isDigit(S.charAt(i)); i++) {
            num = num * 10 + S.charAt(i) - '0';
        }
        TreeNode node = new TreeNode(num);
        if (i == S.length()) {
            return node;
        }
        int i1 = find(S.substring(i), d), i2 = find(S.substring(i + i1), d);
        if (i2 == -1) {
            node.left = recoverFromPreorder(S.substring(i + i1), d + 1);
        } else {
            node.left = recoverFromPreorder(S.substring(i + i1, i + i1 + i2 - d), d + 1);
            node.right = recoverFromPreorder(S.substring(i + i1 + i2), d + 1);
        }
        return node;
    }

    private int find(String s, int n) {
        boolean flag = false;
        int last = -1;
        for (int j = 0; j < s.length(); j++) {
            if (Character.isDigit(s.charAt(j))) {
                if (flag) {
                    last = j;
                } else {
                    if (j - last - 1 == n) {
                        return j;
                    }
                    flag = true;
                    last = j;
                }
            } else {
                flag = false;
            }
        }
        return -1;
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
