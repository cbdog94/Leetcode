import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q130 {

    public static void main(String[] args) {
//        char[][] test = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
//        char[][] test = new char[][]{{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        char[][] test = new char[][]{
                {'X', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O', 'O'}};
        new Q130().solve(test);
        for (char[] row : test) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !flag[i][j]) {
                    List<int[]> result = new ArrayList<>();
                    result.add(new int[]{i, j});
                    dfs(board, flag, i, j, result);
                    for (int[] item : result) {
                        board[item[0]][item[1]] = 'X';
                    }
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] flag, int i, int j, List<int[]> result) {
        if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
            result.clear();
        } else if (result.size() != 0) {
            result.add(new int[]{i, j});
        }
        flag[i][j] = true;
        if (j < board[0].length - 1 && board[i][j + 1] == 'O' && !flag[i][j + 1]) {
            dfs(board, flag, i, j + 1, result);
        }
        if (j > 0 && board[i][j - 1] == 'O' && !flag[i][j - 1]) {
            dfs(board, flag, i, j - 1, result);
        }
        if (i > 0 && board[i - 1][j] == 'O' && !flag[i - 1][j]) {
            dfs(board, flag, i - 1, j, result);
        }
        if (i < board.length - 1 && board[i + 1][j] == 'O' && !flag[i + 1][j]) {
            dfs(board, flag, i + 1, j, result);
        }

    }

}
