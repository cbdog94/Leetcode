import java.util.Arrays;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * <p>
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class Q289 {

    public void gameOfLife(int[][] board) {
        if (board.length == 0)
            return;

        int M = board.length;
        int N = board[0].length;
        int t[][] = new int[M + 2][N + 2];
        for (int i = 1; i <= M; i++)
            System.arraycopy(board[i - 1], 0, t[i], 1, N);
//            System.arraycopy(board[i], 0, t[i], 1, N);
        for (int i = 1; i <= M; i++)
            for (int j = 1; j <= N; j++) {
                if (t[i][j] == 1) {
                    int live = t[i - 1][j - 1] + t[i - 1][j] + t[i - 1][j + 1] + t[i][j - 1] + t[i][j + 1] + t[i + 1][j - 1] + t[i + 1][j] + t[i + 1][j + 1];
                    if (live < 2 || live > 3)
                        board[i - 1][j - 1] = 0;
                } else {
                    int live = t[i - 1][j - 1] + t[i - 1][j] + t[i - 1][j + 1] + t[i][j - 1] + t[i][j + 1] + t[i + 1][j - 1] + t[i + 1][j] + t[i + 1][j + 1];
                    if (live == 3)
                        board[i - 1][j - 1] = 1;
                }
            }
        for (int[] aBoard : board) System.out.println(Arrays.toString(aBoard));
    }

    public static void main(String[] args) {
//        new Q289().gameOfLife(new int[][]{new int[]{}});
        new Q289().gameOfLife(new int[][]{new int[]{1, 0, 1, 0}, new int[]{0, 1, 0, 1}});
    }
}
