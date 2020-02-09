import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q5199 {
    public static void main(String[] args) {
        System.out.println(new Q5199().smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0, 2))));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] sc = s.toCharArray();
        UnionFind uf = new UnionFind(sc.length);
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
//        System.out.println(Arrays.toString(uf.parent));
        List<Integer>[] group = new List[sc.length];
        for (int i = 0; i < sc.length; i++) {
            int p = uf.find(i);
            if (group[p] == null) {
                group[p] = new ArrayList<>();
            }
            group[p].add(i);
        }
//        System.out.println(Arrays.toString(group));

        for (int i = 0; i < sc.length; i++) {
            if (group[i] != null) {
                int[] map = new int[26];
                for (int k : group[i]) {
                    map[sc[k] - 'a']++;
                }
                for (int j = 0, k = 0; j < 26; j++) {
                    while (map[j] > 0) {
                        sc[group[i].get(k++)] = (char) ('a' + j);
                        map[j]--;
                    }
                }
            }
        }
        return new String(sc);
    }

    class UnionFind {
        int[] parent, root;

        UnionFind(int n) {
            parent = new int[n];
            root = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                root[i] = 1;
            }
        }

        int find(int m) {
            if (parent[m] == m) {
                return m;
            }
            return parent[m] = find(parent[m]);
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) {
                return false;
            }
            if (root[pa] > root[pb]) {
                parent[pb] = pa;
                root[pa] += root[pb];
            } else {
                parent[pa] = pb;
                root[pb] += root[pa];
            }
            return true;
        }
    }
}
