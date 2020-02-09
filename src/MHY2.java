import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MHY2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        char[][] graph = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            graph[i] = s.toCharArray();
        }
        int r1 = sc.nextInt(), c1 = sc.nextInt();
        int r2 = sc.nextInt(), c2 = sc.nextInt();

        System.out.println(numberOf(graph, r1, c1, r2, c2));
    }

    private static int numberOf(char[][] graph, int r1, int c1, int r2, int c2) {
        char t = graph[r1][c1];
        graph[r1][c1] = graph[r2][c2];
        graph[r2][c2] = t;
        int num = 0, inc;
        do {
            inc = check(graph);
            down(graph);
            num += inc;
        } while (inc != 0);
        return num;
    }

    private static void down(char[][] graph) {
        for (int i = 0; i < graph[0].length; i++) {
            int k = graph.length - 1;
            for (int j = graph.length - 1; j >= 0; j--) {
                if (graph[j][i] != '0') {
                    graph[k--][i] = graph[j][i];
                }
            }
        }
    }

    private static int check(char[][] graph) {
        int num = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == '0') {
                    continue;
                }
                char t = graph[i][j];

                int vh = i, vl = i, hl = j, hr = j;
                for (int k = i; k >= 0; k--) {
                    if (graph[k][j] != t) {
                        break;
                    }
                    vl = k;
                }
                for (int k = i; k < graph.length; k++) {
                    if (graph[k][j] != t) {
                        break;
                    }
                    vh = k;
                }
                if (vh - vl + 1 >= 3) {

//                    num += vh - vl + 1;
                    for (int k = vl; k <= vh; k++) {
                        set.add(k + "," + j);
//                        graph[k][j] = '0';
                    }
                }
                //
                for (int k = j; k >= 0; k--) {
                    if (graph[i][k] != t) {
                        break;
                    }
                    hl = k;
                }
                for (int k = j; k < graph[0].length; k++) {
                    if (graph[i][k] != t) {
                        break;
                    }
                    hr = k;
                }
                if (hr - hl + 1 >= 3) {
//                    num += (num == 0) ? hr - hl + 1 : hr - hl;
                    for (int k = hl; k <= hr; k++) {
                        set.add(i + "," + k);
//                        graph[i][k] = '0';
                    }
                }
            }
        }
        for (String s : set) {
            String[] sps = s.split(",");
            graph[Integer.parseInt(sps[0])][Integer.parseInt(sps[1])] = '0';
        }
        return set.size();
    }
}
