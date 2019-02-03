import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q952 {

    public static void main(String[] args) {
        System.out.println(new Q952().largestComponentSize(new int[]{4, 6, 15, 35}));
        System.out.println(new Q952().largestComponentSize(new int[]{20, 50, 9, 63}));
        System.out.println(new Q952().largestComponentSize(new int[]{2, 3, 6, 7, 4, 12, 21, 39}));
    }

    public int largestComponentSize(int[] A) {
        final int maxPrime = 100001;
        boolean[] isPrime = new boolean[maxPrime];
        Arrays.fill(isPrime, true);
        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i < maxPrime; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = 2; i * j < maxPrime; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        UnionFind uf = new UnionFind(A.length);
        int[] index = new int[maxPrime];
        Arrays.fill(index, -1);
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            for (int prime : primes) {
                // Optimization
                if (primes.contains(a)) {
                    prime = a;
                }
                if (a % prime == 0) {
                    if (index[prime] == -1) {
                        index[prime] = i;
                    } else {
                        uf.union(index[prime], i);
                    }
                    while (a % prime == 0) {
                        a /= prime;
                    }
                }
                if (a == 1) {
                    break;
                }
            }
        }
        return uf.max();
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
