import java.util.ArrayList;
import java.util.List;

public class Q417 {

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, i, 0, pacific, -1);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, 0, i, pacific, -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, i, matrix[0].length - 1, atlantic, -1);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, matrix.length - 1, i, atlantic, -1);
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, int i, int j, boolean[][] flag, int pre) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] < pre) {
            return;
        }
        if (flag[i][j]) {
            return;
        }
        flag[i][j] = true;
        int cur = matrix[i][j];
        dfs(matrix, i + 1, j, flag, cur);
        dfs(matrix, i - 1, j, flag, cur);
        dfs(matrix, i, j + 1, flag, cur);
        dfs(matrix, i, j - 1, flag, cur);
    }


}
