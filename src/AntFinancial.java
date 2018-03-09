public class AntFinancial {

    public static void main(String[] args) {
        int num = 5000;
        String[] sample = new String[num];
        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
//                sample[i] = "";
                StringBuilder sb=new StringBuilder();
                for (int j = 0; j < num / 2; j++)
                    sb.append("YN");
                sample[i]=sb.toString();
//                    sample[i] += "YN";
            } else {
//                sample[i] = "";
                StringBuilder sb=new StringBuilder();
                for (int j = 0; j < num / 2; j++)
                    sb.append("NY");
//                    sample[i] += "NY";
                sample[i]=sb.toString();
            }
        }
        System.out.println("--");
        System.out.println(group(sample));
    }

    private static int group(String[] S) {
        int r = S.length;
        int c = S[0].length();
        boolean[][] flag = new boolean[r][c];
        int count = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                if (S[i].charAt(j) == 'Y' && !flag[i][j]) {
                    dfs(S, flag, i, j, r, c);
                    count++;
                }
            }
        int res = 1;
        for (int i = 0; i < count - 1; i++) {
            res = res * 2 % 1000000007;
        }
        return res;
    }

    private static void dfs(String[] s, boolean[][] flag, int i, int j, int r, int c) {
        flag[i][j] = true;
        if (j > 0 && !flag[i][j - 1] && s[i].charAt(j - 1) == 'Y') {
            dfs(s, flag, i, j - 1, r, c);
        }
        if (i > 0 && !flag[i - 1][j] && s[i - 1].charAt(j) == 'Y') {
            dfs(s, flag, i - 1, j, r, c);
        }
        if (j < c - 1 && !flag[i][j + 1] && s[i].charAt(j + 1) == 'Y') {
            dfs(s, flag, i, j + 1, r, c);
        }
        if (i < r - 1 && !flag[i + 1][j] && s[i + 1].charAt(j) == 'Y') {
            dfs(s, flag, i + 1, j, r, c);
        }
    }
}
