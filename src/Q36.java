public class Q36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] row = new int[10];
            int[] column = new int[10];
            for (int j = 0; j < 9; j++) {
                int rowNum = board[i][j] - '0';
                int colNum = board[j][i] - '0';
                if (row[rowNum] != 0) {
                    return false;
                } else {
                    row[rowNum]++;
                }
                if (column[colNum] != 0) {
                    return false;
                } else {
                    column[colNum]++;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int[] fre = new int[10];
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        int num = board[i + r][j + c] - '0';
                        if (fre[num] != 0) {
                            return false;
                        } else {
                            fre[num]++;
                        }
                    }
                }
            }
        }
        return true;
    }
}
