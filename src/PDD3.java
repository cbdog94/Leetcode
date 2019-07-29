import java.util.*;

public class PDD3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt();
        int[] time = new int[N + 1];
        int[][] pre = new int[M][2];
        for (int i = 1; i <= N; i++) {
            time[i] = scanner.nextInt();
        }
        for (int i = 0; i < M; i++) {
            pre[i][0] = scanner.nextInt();
            pre[i][1] = scanner.nextInt();
        }
        int[] order = findOrder(time, pre);
        for (int i = 0; i < order.length; i++) {
            if (i == 0) {
                System.out.print(order[i]);
            } else {
                System.out.print(" " + order[i]);
            }
        }
    }

    public static int[] findOrder(int[] time, int[][] prerequisites) {
        int numCourses = time.length - 1;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }
        int[] result = new int[numCourses];
        int i = 0;
        while (!graph.isEmpty()) {
            List<Integer> t = new ArrayList<>();
            for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                if (entry.getValue().isEmpty()) {
                    t.add(entry.getKey());
                }
            }
            t.sort((x, y) -> {
                if (time[x] == time[y]) {
                    return x - y;
                }
                return time[x] - time[y];
            });
//            for (int k : t) {
//                graph.remove(k);
//            }
            graph.remove(t.get(0));
            for (int k : graph.keySet()) {
                graph.get(k).remove(t.get(0));
            }
//            System.out.println(t);

            //for (int k : t) {
            result[i++] = t.get(0);
            //}
        }
//        for (int i = 1; i <= numCourses; i++) {
//            System.out.println(graph[i]);
//        }
//        for (int i = 1; i <= numCourses; i++) {
//            // graph[i]=new ArrayList<>();
//            graph[i].sort((x, y) -> {
//                if (time[x - 1][1] == time[y - 1][1]) {
//                    return x - y;
//                }
//                return time[x - 1][1] - time[y - 1][1];
//            });
//        }
//        for (int i = 1; i <= numCourses; i++) {
//            System.out.println(graph[i]);
//        }

        return result;
    }


}
/*
5 6
1 2 1 1 1
1 2
1 3
1 4
2 5
3 5
4 5
 */