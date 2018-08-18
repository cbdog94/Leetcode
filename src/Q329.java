public class Q329 {
//    int max = 0;

    public static void main(String[] args) {
        int[][] test = new int[][]{{9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
//        int[][] test = new int[][]{{3, 4, 5},
//                {3, 2, 6},
//                {2, 2, 1}
//        };
        System.out.println(new Q329().longestIncreasingPath(test));
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
//                if ((i == 0 || matrix[i][j] <= matrix[i - 1][j]) && (j == 0 || matrix[i][j] <= matrix[i][j - 1])) {
                int tmp = dfs(matrix, i, j, cache, Integer.MIN_VALUE);
//                    cache[i][j] = tmp;
                max = Math.max(tmp, max);
//                }
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache, int pre) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre) {
            return 0;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int max = 0, cur = matrix[i][j];
//        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
        max = Math.max(max, dfs(matrix, i - 1, j, cache, cur));
//        }
//        if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j]) {
        max = Math.max(max, dfs(matrix, i + 1, j, cache, cur));
//        }
//        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
        max = Math.max(max, dfs(matrix, i, j - 1, cache, cur));
//        }
//        if (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1]) {
        max = Math.max(max, dfs(matrix, i, j + 1, cache, cur));
//        }
        cache[i][j] = max;
        return 1 + max;
    }
}
