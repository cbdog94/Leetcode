import java.util.Arrays;

public class Q685 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q685().findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        System.out.println(Arrays.toString(new Q685().findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}})));
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }

    class UnionFind {

        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
//            if (rank[rootX] < rank[rootY]) {
//                parent[rootX] = rootY;
//                rank[rootY] += rank[rootX];
//            } else {
            parent[rootY] = rootX;
            rank[rootX] += rank[rootY];
//            }
            return true;
        }
    }
}
