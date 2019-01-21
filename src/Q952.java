public class Q952 {

    public static void main(String[] args) {
        System.out.println(new Q952().largestComponentSize(new int[]{4, 6, 15, 35}));
        System.out.println(new Q952().largestComponentSize(new int[]{20, 50, 9, 63}));
        System.out.println(new Q952().largestComponentSize(new int[]{2, 3, 6, 7, 4, 12, 21, 39}));
    }

    public int largestComponentSize(int[] A) {
        UnionFind uf = new UnionFind(A.length);
//        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 1) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] != 1) {
                        int gcd = mgcd(A[i], A[j]);
                        if (gcd != 1) {
                            A[j] /= gcd;
                            uf.union(i, j);
                        }
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(uf.parent));
        return uf.max();
    }


    private int mgcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        int max = 1;

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

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) {
                return false;
            }
            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
                rank[pb] += rank[pa];
                max = Math.max(rank[pb], max);
            } else {
                parent[pb] = pa;
                rank[pa] += rank[pb];
                max = Math.max(rank[pa], max);
            }
            return true;
        }

        int max() {
            return max;
        }
    }
}
