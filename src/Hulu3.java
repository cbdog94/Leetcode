import java.util.*;

public class Hulu3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt(), k = scanner.nextInt();
        int[] dergee = new int[m];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < k; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            graph.get(b - 1).add(a - 1);
            dergee[a - 1]++;
        }
        int day = days(graph, dergee, n);
        System.out.println(day == -1 ? "E" : day);
    }

    public static int days(List<List<Integer>> graph, int[] degree, int n) {
        int day = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
//        System.out.println(Arrays.toString(degree));
        while (!queue.isEmpty()) {
            int nn = queue.size();
            day += Math.ceil(nn * 1.0 / n);
//            System.out.println(nn+" "+day);
            for (int i = 0; i < nn; i++) {
                int t = queue.poll();
                degree[t] = -1;
                for (int dep : graph.get(t)) {
                    degree[dep]--;
                }
            }
            for (int i = 0; i < degree.length; i++) {
                if (degree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        for (int d : degree) {
            if (d != -1) {
                return -1;
            }
        }
        return day;
    }


}
