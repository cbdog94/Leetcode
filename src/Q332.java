import java.util.*;

public class Q332 {
    public static void main(String[] args) {
        System.out.println(new Q332().findItinerary(new String[][]{{"EZE", "AXA"}, {"TIA", "ANU"}, {"ANU", "JFK"}, {"JFK", "ANU"}, {"ANU", "EZE"}, {"TIA", "ANU"}, {"AXA", "TIA"}, {"TIA", "JFK"}, {"ANU", "TIA"}, {"JFK", "TIA"}}));
//        System.out.println(new Q332().findItinerary(new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}}));
//        System.out.println(new Q332().findItinerary(new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}}));
//        System.out.println(new Q332().findItinerary(new String[][]{{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}}));
    }

    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] pair : tickets) {
            String from = pair[0], to = pair[1];
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            List<String> list = map.get(from);
            int index = Collections.binarySearch(list, to);
            if (index < 0) {
                list.add(-index - 1, to);
            } else {
                list.add(index, to);
            }
        }
        return dfs(map, "JFK", tickets.length);
    }

    private List<String> dfs(Map<String, List<String>> graph, String from, int remain) {
        List<String> list = graph.getOrDefault(from, new ArrayList<>()), result = new ArrayList<>();
//        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            String tmp = list.remove(i);
            List<String> tmpResult = dfs(graph, tmp, remain - 1);
            list.add(i, tmp);
            if (tmpResult.size() == remain) {
                result = tmpResult;
                break;
            }
        }
        result.add(0, from);
        return result;
    }
}
