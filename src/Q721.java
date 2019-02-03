import java.util.*;

public class Q721 {

    public static void main(String[] args) {
        System.out.println(new Q721().accountsMerge(Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"), Arrays.asList("John", "johnnybravo@mail.com"), Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"), Arrays.asList("Mary", "mary@mail.com"))));
        System.out.println(new Q721().accountsMerge(Arrays.asList(Arrays.asList("David", "David0@m.co", "David1@m.co"), Arrays.asList("David", "David3@m.co", "David4@m.co"), Arrays.asList("David", "David4@m.co", "David5@m.co"), Arrays.asList("David", "David2@m.co", "David3@m.co"), Arrays.asList("David", "David1@m.co", "David2@m.co"))));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> map = new HashMap<>();
        int index = 0;
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!map.containsKey(email)) {
                    map.put(email, new ArrayList<>());
                }
                map.get(email).add(index);
            }
            index++;
        }
        UnionFind uf = new UnionFind(accounts.size());
        for (List<Integer> list : map.values()) {
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    uf.union(list.get(0), list.get(i));
                }
            }
        }
        Set<String>[] emailList = new Set[accounts.size()];
        String[] nameList = new String[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            int p = uf.find(i);
            nameList[p] = accounts.get(i).get(0);
            accounts.get(i).remove(0);
            if (emailList[p] == null) {
                emailList[p] = new HashSet<>();
            }
            emailList[p].addAll(accounts.get(i));
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (nameList[i] != null) {
                List<String> item = new ArrayList<>(emailList[i]);
                Collections.sort(item);
                item.add(0, nameList[i]);
                result.add(item);
            }
        }
        return result;
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
