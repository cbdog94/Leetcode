import java.util.Scanner;

public class TT2 {

    int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[][] map = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        System.out.println(new TT2().numIslands(map));
    }

    public int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                            int id1 = i * cols + j;
                            int id2 = x * cols + y;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

    class UnionFind {
        int[] father;
        int m, n;
        int count = 0;

        UnionFind(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            father = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int id = i * n + j;
                        father[id] = id;
                        count++;
                    }
                }
            }
        }

        public void union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if (find1 != find2) {
                father[find1] = find2;
                count--;
            }
        }

        public int find(int node) {
            if (father[node] == node) {
                return node;
            }
            father[node] = find(father[node]);
            return father[node];
        }
    }
//
//    public static int numIslands(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int count = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    count++;
//                    dfs(grid, i, j);
//                }
//            }
//        }
//        return count;
//    }
//
//    private static void dfs(int[][] grid, int i, int j) {
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
//            return;
//        }
//        grid[i][j] = 0;
//        dfs(grid, i - 1, j);
//        dfs(grid, i + 1, j);
//        dfs(grid, i, j - 1);
//        dfs(grid, i, j + 1);
//    }
}
