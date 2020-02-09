import java.util.*;

public class EA2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), coin = scanner.nextInt();
//        Map<Integer, List<int[]>> graph = new HashMap<>();
        List<int[]> edges = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt(), to = scanner.nextInt(), l = scanner.nextInt(), c = scanner.nextInt();
//            if (!graph.containsKey(from)) {
//                graph.put(from, new ArrayList<>());
//            }
//            graph.get(from).add(new int[]{to, l, c});
            edges.add(new int[]{from, to, l, c});
        }
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
//        int[][] dp = new int[n][coin + 1];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        dp[0][0] = 0;
//        Map<>
        Map<Integer, Integer> zero = new HashMap<>();
        zero.put(0, 0);
        dp.put(0, zero);
        for (int i = 1; i < n; i++) {
            for (int[] edge : edges) {
                for (int c : new HashSet<>(dp.get(edge[0]).keySet())) {
                    if (!dp.containsKey(edge[1])) {
                        dp.put(edge[1], new HashMap<>());
                    }
                    if (c + edge[3] <= coin) {
                        if (dp.get(edge[1]).containsKey(c + edge[3])) {
                            dp.get(edge[1]).put(c + edge[3], Math.min(dp.get(edge[0]).get(c) + edge[2], dp.get(edge[1]).get(c + edge[3])));
                        } else {
                            dp.get(edge[1]).put(c + edge[3], dp.get(edge[0]).get(c) + edge[2]);

                        }
                    }
                }
//                for (int j = 0; j <= coin; j++) {
//                    if (dp[edge[0]][j] != -1 && j + edge[3] <= coin) {
//                        dp[edge[1]][j + edge[3]] = dp[edge[1]][j + edge[3]] == -1 ? dp[edge[0]][j] + edge[2] : Math.min(dp[edge[0]][j] + edge[2], dp[edge[1]][j + edge[3]]);
//                    }
//                }
            }
        }

        if (!dp.containsKey(n - 1)) {
            System.out.println(-1);
        } else {
            int min = Integer.MAX_VALUE;
            for (int l : dp.get(n - 1).values()) {
                min = Math.min(l, min);
            }
            System.out.println(min);
        }
    }
}