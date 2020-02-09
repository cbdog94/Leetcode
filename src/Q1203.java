import java.util.*;

public class Q1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        List<Integer>[] groups = new List[m];
        int[] groupDegree = new int[n];
        Set<Integer>[] groupGraph = new Set[m];
        int[] itemDegree = new int[m];
        Set<Integer>[] itemGraph = new Set[n];
        for (int i = 0; i < n; i++) {
            int g = group[i];
            List<Integer> before = beforeItems.get(i);
            if (groups[g] == null) {
                groups[g] = new ArrayList<>();
            }
            groups[g].add(i);
            for (int item : before) {
                int gi = group[item];
                if (gi == g) {
                    if (itemGraph[item] == null) {
                        itemGraph[item] = new HashSet<>();
                    }
                    itemGraph[item].add(i);
                    itemDegree[i]++;
                } else {
                    if (groupGraph[gi] == null) {
                        groupGraph[gi] = new HashSet<>();
                    }
                    groupGraph[gi].add(g);
                    groupDegree[g]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> groupOrder = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            if (groupDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int g = queue.poll();
            groupOrder.add(g);
            if (groupGraph[g] != null) {
                for (int gi : groupGraph[g]) {
                    groupDegree[gi]--;
                    if (groupDegree[gi] == 0) {
                        queue.offer(gi);
                    }
                }
            }
        }
        if (groupOrder.size() != m) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>(n);
        for (int g : groupOrder) {
            List<Integer> itemOrder = new ArrayList<>(groups[g].size());
            for (int item : groups[g]) {
                if (itemDegree[item] == 0) {
                    queue.offer(item);
                }
            }
            while (!queue.isEmpty()) {
                int item = queue.poll();
                itemOrder.add(item);
                if (itemGraph[item] != null) {
                    for (int i : itemGraph[item]) {
                        itemDegree[i]--;
                        if (itemDegree[i] == 0) {
                            queue.offer(i);
                        }
                    }
                }
            }
            if (itemOrder.size() != groups[g].size()) {
                return new int[0];
            }
            result.addAll(itemOrder);
        }
        return result.stream().mapToInt(x -> x).toArray();
    }
}
