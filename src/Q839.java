import java.util.ArrayList;
import java.util.List;

public class Q839 {

    public static void main(String[] args) {
        System.out.println(new Q839().numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
    }

    public int numSimilarGroups(String[] A) {
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (isConnected(A[i], A[j])) {
                    edges.add(new int[]{i, j});
                }
            }
        }
        UnionFind uf = new UnionFind(A.length);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.groups();
    }

    private boolean isConnected(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if (count > 2) {
                return false;
            }
        }
        return true;
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

        int groups() {
            int count = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    count++;
                }
            }
            return count;
        }
    }
}
