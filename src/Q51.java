import java.util.ArrayList;
import java.util.List;

public class Q51 {

    public static void main(String[] args) {
        System.out.println(new Q51().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] map = new char[n][n];
        List<List<String>> result = new ArrayList<>();
        backtrack(result, map, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] map, int r) {
        if (r == map.length) {
            StringBuilder sb;
            List<String> tmp = new ArrayList<>();
            for (char[] row : map) {
                sb = new StringBuilder();
                for (int j = 0; j < map.length; j++) {
                    sb.append(row[j] == 'Q' ? 'Q' : '.');
                }
                tmp.add(sb.toString());
            }
            result.add(tmp);
            return;
        }
        for (int i = 0; i < map.length; i++) {
            map[r][i] = 'Q';
            if (check(map, r, i)) {
                backtrack(result, map, r + 1);
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
