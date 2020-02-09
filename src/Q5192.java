import java.util.*;

public class Q5192 {
    public static void main(String[] args) {
        System.out.println(new Q5192().criticalConnections(5, Arrays.asList(Arrays.asList(1, 0), Arrays.asList(2, 0), Arrays.asList(3, 2), Arrays.asList(4, 2), Arrays.asList(4, 3), Arrays.asList(3, 0), Arrays.asList(4, 0))));
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> connect = connections.get(i);
            if (!graph.containsKey(connect.get(0))) {
                graph.put(connect.get(0), new ArrayList<>());
            }
            if (!graph.containsKey(connect.get(1))) {
                graph.put(connect.get(1), new ArrayList<>());
            }
            graph.get(connect.get(0)).add(new int[]{connect.get(1), i});
            graph.get(connect.get(1)).add(new int[]{connect.get(0), i});
        }
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[n];
        dfs(graph, -1, 0, visited, set, new HashMap<>());
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < connections.size(); i++) {
            if (!set.contains(i)) {
                result.add(connections.get(i));
            }
        }
        return result;
    }

    private void dfs(Map<Integer, List<int[]>> graph, int pre, int cur, boolean[] visited, Set<Integer> set, Map<Integer, int[]> tmp) {
        if (visited[cur]) {
            int t = cur;
            while (tmp.get(t)[0] != cur) {
//                System.out.println(t+" "+tmp.get(t)[0]);
                set.add(tmp.get(t)[1]);
                t = tmp.get(t)[0];
            }
            set.add(tmp.get(t)[1]);
            System.out.println(t + " " + tmp.get(t)[0]);
            System.out.println("---");
            return;
        }
        for (int[] edge : graph.get(cur)) {
            if (edge[0] != pre) {
                visited[cur] = true;
                tmp.put(cur, edge);
                dfs(graph, cur, edge[0], visited, set, tmp);
//                tmp.remove(cur);
            }
        }
    }
}
