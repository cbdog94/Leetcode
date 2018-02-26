/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * <p>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * <p>
 * 回溯法
 */
public class Q79 {
    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == word.charAt(0)) {
//                    boolean[][] flag = new boolean[board.length][board[0].length];
//                    flag[i][j] = true;
//                    优化: 直接把使用之后的字母置0
                    char c = board[i][j];
                    board[i][j] = 0;
                    if (traceback(board, word, 1, i, j))
                        return true;
                    board[i][j] = c;
                }
        return false;
    }

    private static boolean traceback(char[][] board, String word, int start, int i, int j) {
        if (word.length() == start)
            return true;
        char c = word.charAt(start);
        //up
        if (i > 0 && board[i - 1][j] == c) {
            board[i - 1][j] = 0;
            if (traceback(board, word, start + 1, i - 1, j))
                return true;
            board[i - 1][j] = c;
        }
        //down
        if (i < board.length - 1 && board[i + 1][j] == word.charAt(start)) {
            board[i + 1][j] = 0;
            if (traceback(board, word, start + 1, i + 1, j))
                return true;
            board[i + 1][j] = c;
        }
        //left
        if (j > 0 && board[i][j - 1] == word.charAt(start)) {
            board[i][j - 1] = 0;
            if (traceback(board, word, start + 1, i, j - 1))
                return true;
            board[i][j - 1] = c;
        }
        //right
        if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(start)) {
            board[i][j + 1] = 0;
            if (traceback(board, word, start + 1, i, j + 1))
                return true;
            board[i][j + 1] = c;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()}, "ABCCED"));
        System.out.println(exist(new char[][]{"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()}, "SEE"));
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
        System.out.println(exist(new char[][]{}, "ABCCED"));
        System.out.println(exist(new char[][]{{}}, "ABCCED"));
        System.out.println(exist(new char[][]{{'A', 'A'}}, "AAA"));
    }
}
