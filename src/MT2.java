import java.util.*;

public class MT2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Set<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int height = -1;
        int result = 0;
        boolean[] v = new boolean[n + 1];
        while (!queue.isEmpty()) {
            int t = queue.size();
            height++;
            for (int i = 0; i < t; i++) {
                int p = queue.poll();
                v[p] = true;
                result += 2;
                for (int pp : graph.get(p)) {
                    if (!v[pp]) {
                        queue.offer(pp);
                    }
                }
            }
        }
        System.out.println(result - 2 - height);
    }

    /*
    11
    1 2
    1 3
    1 10
    10 11
    2 4
    2 5
    2 6
    3 7
    7 8
    8 9
    */
}
