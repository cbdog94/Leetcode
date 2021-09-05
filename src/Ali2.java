import java.util.Scanner;

public class Ali2 {

    private static double pointToLine(double[] a, double[] b, double[] p) {
        double ap_ab = (b[0] - a[0]) * (p[0] - a[0]) + (b[1] - a[1]) * (p[1] - a[1]);
        if (ap_ab <= 0)
            return Math.sqrt((p[0] - a[0]) * (p[0] - a[0]) + (p[1] - a[1]) * (p[1] - a[1]));

        double d2 = (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
        if (ap_ab >= d2) return Math.sqrt((p[0] - b[0]) * (p[0] - b[0]) + (p[1] - b[1]) * (p[1] - b[1]));

        double r = ap_ab / d2;
        double px = a[0] + (b[0] - a[0]) * r;
        double py = a[1] + (b[1] - a[1]) * r;
        return Math.sqrt((p[0] - px) * (p[0] - px) + (p[1] - py) * (p[1] - py));
    }


    private static boolean isInSimple(double[][] p, int n, double[] po) {
        int i, j = n - 1;
        boolean oddNodes = false;
        for (i = 0; i < n; i++) {
            if ((p[i][1] < po[1] && p[j][1] >= po[1]
                    || p[j][1] < po[1] && p[i][1] >= po[1])
                    && (p[i][0] <= po[0] || p[j][0] <= po[0])) {
                if (p[i][0] + (po[1] - p[i][1]) / (p[j][1] - p[i][1]) * (p[j][0] - p[i][0]) < po[0]) {
                    oddNodes = !oddNodes;
                }
            }
            j = i;
        }
        return oddNodes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String p = scanner.next();
        String edge = scanner.next();
        String[] ps = p.split(",");
        String[] edges = edge.split(",");
        double[] pp = new double[]{Double.parseDouble(ps[0]), Double.parseDouble(ps[1])};
        int n = edges.length / 2;
        double[][] ep = new double[n + 1][2];
        for (int i = 0; i < n; i++) {
            ep[i][0] = Double.parseDouble(edges[i * 2]);
            ep[i][1] = Double.parseDouble(edges[i * 2 + 1]);
        }

        if (isInSimple(ep, n, pp)) {
            System.out.println("yes,0");
            return;
        }

        double ans = pointToLine(ep[0], ep[1], pp);
        ep[n] = ep[0];
        for (int i = 1; i < n; ++i)
            ans = Math.min(ans, pointToLine(ep[i], ep[i + 1], pp));
        System.out.println("no," + Math.round(ans));
    }
}
/*
输入：
1,1
0,0,0,2,2,2,2,0
输出：
yes,0

输入：
2,2
0,0,0,2,2,2,2,0
输出：
yes,0

输入：
3,0
0,0,0,2,2,2,2,0
输出：
no,1

输入：
3,4
0,0,0,2,2,2,2,0
输出：
no,2


 */