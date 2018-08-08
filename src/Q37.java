import java.util.Arrays;

public class Q37 {

    public static void solveSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] column = new int[9][10];
        boolean[][] flag = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int rowNum = board[i][j] - '0';
                int colNum = board[j][i] - '0';
                if (rowNum > 0) {
                    row[i][rowNum]++;
                    flag[i][j] = true;
                }
                if (colNum > 0) {
                    column[i][colNum]++;
                }
            }
        }
        int[][] square = new int[9][10];
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        int num = board[i + r][j + c] - '0';
                        if (num > 0) {
                            square[i + j / 3][num]++;
                        }
                    }
                }
            }
        }

        int i = 0, j = 0;
        while (i < 9 && j < 9) {
            if (!flag[i][j]) {
                int k;
                if (board[i][j] == '.') {
                    k = 1;
                } else {
                    k = board[i][j] - '0' + 1;
                    row[i][k - 1]--;
                    column[j][k - 1]--;
                    square[i / 3 * 3 + j / 3][k - 1]--;
                }
                for (; k <= 9; k++) {
                    if (row[i][k] == 0 && column[j][k] == 0 && square[i / 3 * 3 + j / 3][k] == 0) {
                        board[i][j] = (char) ('0' + k);
                        row[i][k]++;
                        column[j][k]++;
                        square[i / 3 * 3 + j / 3][k]++;
                        j++;
                        if (j == 9) {
                            i++;
                            j = 0;
                        }
                        break;
                    }
                }
                if (k == 10) {
                    board[i][j] = '.';
                    do {
                        j--;
                        if (j == -1) {
                            j = 8;
                            i--;
                        }
//                        System.out.println(i+" "+j);
                    } while (flag[i][j]);
                }
            } else {
                j++;
                if (j == 9) {
                    i++;
                    j = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
//        char[][] test = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] test = new char[][]{
                {'.', '.', '7', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '2', '3', '8', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '5', '.'},
                {'.', '.', '3', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '1', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '5', '.', '9', '.'},
                {'6', '.', '.', '.', '4', '.', '8', '.', '3'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '9', '.', '.', '.', '6', '.', '.', '.'}};
        solveSudoku(test);
        for (char[] row : test) {
            System.out.println(Arrays.toString(row));
        }
    }
}
