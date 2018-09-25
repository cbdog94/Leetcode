import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q909 {

    public static void main(String[] args) {
//        for (int i = 1; i <= 169; i++) {
//            System.out.println(Arrays.toString(new Q909().map(i, 13)) + " " + Arrays.toString(new Q909().getCord(13, i)));
//        }
//        Set<Integer> visited = new HashSet<>();
//        visited.add(1);
//        System.out.println(visited.contains(1));
        System.out.println(new Q909().snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}}));
        System.out.println(new Q909().snakesAndLadders(new int[][]{
                {-1, -1, -1, 30, -1, 144, 124, 135, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, 167, 93, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, 77, -1, -1, 90, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 122, -1},
                {-1, -1, -1, 23, -1, -1, -1, -1, -1, 155, -1, -1, -1},
                {-1, -1, 140, 29, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, 115, -1, -1, -1, 109, -1, -1, 5},
                {-1, 57, -1, 99, 121, -1, -1, 132, -1, -1, -1, -1, -1},
                {-1, 48, -1, -1, -1, 68, -1, -1, -1, -1, 31, -1, -1},
                {-1, 163, 147, -1, 77, -1, -1, 114, -1, -1, 80, -1, -1},
                {-1, -1, -1, -1, -1, 57, 28, -1, -1, 129, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, 87, -1, -1, -1}}));
        System.out.println(new Q909().snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, 48, 5, -1},
                {12, 29, 13, 9, -1, 2, 32},
                {-1, -1, 21, 7, -1, 12, 49},
                {42, 37, 21, 40, -1, 22, 12},
                {42, -1, 2, -1, -1, -1, 6},
                {39, -1, 35, -1, -1, 39, -1},
                {-1, 36, -1, -1, -1, -1, 5}}));

    }

    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(1);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int tmp = queue.poll();
                visited.add(tmp);
                for (int j = 1; j <= 6; j++) {

                    if (tmp + j == N * N) {
                        return count;
                    }
                    int[] pos1 = map(tmp + j, N);
                    if (pos1[0] >= 0 && pos1[0] < N && pos1[1] >= 0 && pos1[1] < N) {
                        int next = tmp + j;
                        if (board[pos1[0]][pos1[1]] != -1) {
                            next = board[pos1[0]][pos1[1]];
                        }
                        if (next == N * N) {
                            return count;
                        }
                        //一定要跳转之后再判断
                        if (!visited.contains(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private int[] map(int p, int n) {
        int row, col;
        row = n - (p - 1) / n - 1;
        if ((p - 1) / n % 2 == 0) {
            col = (p - 1) % n;
        } else {
            col = n - (p - 1) % n - 1;
        }
        return new int[]{row, col};
    }

}
