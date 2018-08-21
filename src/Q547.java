public class Q547 {

    public static void main(String[] args) {
        System.out.println(new Q547().findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(new Q547().findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    public int findCircleNum(int[][] M) {
        int[] group = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (group[i] == 0) {
                group[i] = ++count;
                dfs(M, group, i, count);
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] group, int i, int count) {
        for (int j = i + 1; j < M.length; j++) {
            if (M[i][j] == 1 && group[j] == 0) {
                group[j] = count;
                dfs(M, group, j, count);
            }
        }
    }
}
