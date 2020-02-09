import java.util.Arrays;

public class Q5321 {
    public static void main(String[] args) {
        System.out.println(new Q5321().findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        System.out.println(new Q5321().findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));

    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] e = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(e[i], 1000000);
            e[i][i] = 0;
        }
        for (int[] edge : edges) {
            e[edge[0]][edge[1]] = edge[2];
            e[edge[1]][edge[0]] = edge[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (e[i][j] > e[i][k] + e[k][j]) {
                        e[i][j] = e[i][k] + e[k][j];
                    }
                }
            }
        }
        int[] count = new int[n];
        int min = Integer.MAX_VALUE, minI = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (e[i][j] <= distanceThreshold) {
                    count[i]++;
                }
            }
            if (count[i] <= min) {
                min = count[i];
                minI = i;
            }
        }
        return minI;
    }
}
