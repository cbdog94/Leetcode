import java.util.Arrays;

public class Q685 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q685().findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        System.out.println(Arrays.toString(new Q685().findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}})));
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        int[] parents = new int[edges.length + 1];
        int[] can1 = null, can2 = null;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (parents[edge[1]] != 0) {
                can1 = new int[]{parents[edge[1]], edge[1]};
                can2 = new int[]{edge[0], edge[1]};
                edges[i][0] = 0;
                break;
            } else {
                parents[edge[1]] = edge[0];
            }
        }
        for (int[] edge : edges) {
            if (edge[0] != 0) {
                if (!uf.union(edge[0], edge[1])) {
                    if (can1 == null) {
                        return edge;
                    } else {
                        return can1;
                    }
                }
            }
        }
        return can2;
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
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX];
            } else {
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY];
            }
            return true;
        }
    }
}
