public class Q52 {

    int count = 0;

    public static void main(String[] args) {
        System.out.println(new Q52().totalNQueens(4));
    }

    public int totalNQueens(int n) {
        char[][] map = new char[n][n];
        backtrack(map, 0);
        return count;
    }

    private void backtrack(char[][] map, int r) {
        if (r == map.length) {
            count++;
            return;
        }
        for (int i = 0; i < map.length; i++) {
            map[r][i] = 'Q';
            if (check(map, r, i)) {
                backtrack(map, r + 1);
            }
            map[r][i] = 0;
        }
    }

    private boolean check(char[][] map, int r, int c) {
        for (int i = 0; i < map.length; i++) {
            if (i != r && map[i][c] == 'Q') {
                return false;
            }
        }
        for (int i = 0; i < map.length; i++) {
            int c1 = r - i + c, c2 = c - (r - i);
            if (c1 >= 0 && c1 < map.length && i != r && map[i][c1] == 'Q') {
                return false;
            }
            if (c2 >= 0 && c2 < map.length && i != r && map[i][c2] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
