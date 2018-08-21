import java.util.Arrays;

public class Q529 {

    int[][] next = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) {
        char[][] test = new char[][]
                {{'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'M', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E'}};
        new Q529().updateBoard(test, new int[]{3, 0});
        for (char[] row : test) {
            System.out.println(Arrays.toString(row));
        }
        new Q529().updateBoard(test, new int[]{1, 2});
        for (char[] row : test) {
            System.out.println(Arrays.toString(row));
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        boolean[] flag = new boolean[8];
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            int nextX = x + next[i][0], nextY = y + next[i][1];
            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length) {
                if (board[nextX][nextY] == 'M' || board[nextX][nextY] == 'X') {
                    sum++;
                } else if (board[nextX][nextY] == 'E') {
                    flag[i] = true;
                }
            }
        }
        if (sum != 0) {
            board[x][y] = (char) ('0' + sum);
            return;
        }
        board[x][y] = 'B';
        for (int i = 0; i < 8; i++) {
            if (flag[i]) {
                dfs(board, x + next[i][0], y + next[i][1]);
            }
        }
    }
}
