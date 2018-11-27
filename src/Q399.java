import java.util.*;

public class Q399 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q399().calcEquation(new String[][]{{"a", "b"}, {"b", "c"}}, new double[]{2.0, 3.0}, new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}})));
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String[] equation = equations[i];
            if (!graph.containsKey(equation[0])) {
                graph.put(equation[0], new HashMap<>());
            }
            if (!graph.containsKey(equation[1])) {
                graph.put(equation[1], new HashMap<>());
            }
            graph.get(equation[0]).put(equation[1], values[i]);
            graph.get(equation[1]).put(equation[0], 1 / values[i]);
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = dfs(graph, queries[i][0], queries[i][1], 1, new HashSet<>());
            result[i] = result[i] == Double.MAX_VALUE ? -1 : result[i];
        }
        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String s, String d, double tmp, Set<String> visited) {
        if (!graph.containsKey(s) || !graph.containsKey(d)) {
            return Double.MAX_VALUE;
        }
        if (s.equals(d)) {
            return 1;
        }
        if (graph.get(s).containsKey(d)) {
            return tmp * graph.get(s).get(d);
        }
        visited.add(s);
        for (Map.Entry<String, Double> entry : graph.get(s).entrySet()) {
            if (!visited.contains(entry.getKey())) {
                double t = dfs(graph, entry.getKey(), d, tmp * entry.getValue(), visited);
                if (t != Double.MAX_VALUE) {
                    return t;
                }
            }
        }
        visited.remove(s);
        return Double.MAX_VALUE;
    }

}
