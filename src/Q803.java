import java.util.Arrays;

public class Q803 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q803().hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}}, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(new Q803().hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 0, 0}}, new int[][]{{1, 1}, {1, 0}})));
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int r = grid.length, c = grid[0].length;
        UnionFind uf = new UnionFind(r * c + 1);
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) {
                grid[hit[0]][hit[1]] = 2;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    unionAround(i, j, grid, uf);
                }
            }
        }
        int count = uf.rank[uf.find(0)];
//        System.out.println(count);
//        System.out.println(Arrays.toString(uf.parent));
        int[] result = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int[] hit = hits[i];
            if (grid[hit[0]][hit[1]] == 2) {
                unionAround(hit[0], hit[1], grid, uf);
                grid[hit[0]][hit[1]] = 1;
            }
            result[i] = uf.rank[uf.find(0)] - count;
            result[i] = result[i] > 0 ? result[i] - 1 : 0;
            count = uf.rank[uf.find(0)];
        }
        return result;
    }

    private void unionAround(int i, int j, int[][] grid, UnionFind uf) {
        int[] x = new int[]{1, -1, 0, 0}, y = new int[]{0, 0, 1, -1};
        int r = grid.length, c = grid[0].length;
        for (int n = 0; n < 4; n++) {
            int nx = i + x[n], ny = j + y[n];
            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            }
            if (grid[nx][ny] == 1) {
                uf.union(i * c + j + 1, nx * c + ny + 1);
            }
        }
        if (i == 0) {
            uf.union(i * c + j + 1, 0);
        }
    }

    class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int n) {
            if (parent[n] == n) {
                return n;
            }
            return parent[n] = find(parent[n]);
        }

        boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) {
                return false;
            }
            if (rank[px] > rank[py]) {
                rank[px] += rank[py];
                parent[py] = px;
            } else {
                rank[py] += rank[px];
                parent[px] = py;
            }
            return true;
        }
    }
}
