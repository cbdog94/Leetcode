import java.util.Arrays;

public class Q943 {

    public static void main(String[] args) {
        System.out.println(new Q943().shortestSuperstring(new String[]{"alex", "loves", "leetcode"}));
        System.out.println(new Q943().shortestSuperstring(new String[]{"ift", "efd", "dnete", "tef", "fdn"}));
        System.out.println(new Q943().shortestSuperstring(new String[]{"catg", "ctaagt", "gcta", "ttca", "atgcatc"}));
        System.out.println(new Q943().shortestSuperstring(new String[]{"ymv", "lpkp", "ajelp", "kpx"}));
    }

    public String shortestSuperstring(String[] A) {
        int n = A.length;
        int[][] overlap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                overlap[i][j] = maxOverlap(A[i], A[j]);
            }
        }
//        Stream.of(overlap).forEach(x -> System.out.println(Arrays.toString(x)));
        int[][] dp = new int[1 << n][n];
        int[][] path = new int[1 << n][n];
        for (int i = 1; i < 1 << n; i++) {
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    if (i == 1 << j) {
                        dp[i][j] = 0;
                        path[i][j] = -1;
                        continue;
                    }
                    for (int k = 0; k < n; k++) {
                        if (j != k && dp[i - (1 << j)][k] != -1 && dp[i - (1 << j)][k] + overlap[k][j] > dp[i][j]) {
                            dp[i][j] = dp[i - (1 << j)][k] + overlap[k][j];
                            path[i][j] = k;
                        }
                    }
                }
            }
        }
        int maxLast = 0;
        for (int j = 0; j < n; j++) {
            if (dp[(1 << n) - 1][j] > dp[(1 << n) - 1][maxLast]) {
                maxLast = j;
            }
        }
//        System.out.println("=====");
//        Stream.of(dp).forEach(x -> System.out.println(Arrays.toString(x)));
//        System.out.println(maxLast);
//        System.out.println("=====");
//        Stream.of(path).forEach(x -> System.out.println(Arrays.toString(x)));
        String result = A[maxLast];
        int lastMask = (1 << n) - 1, next = maxLast, last = maxLast;
        while (lastMask != -0) {
//            System.out.println(lastMask);
            next = path[lastMask][next];
            lastMask -= (1 << last);
            if (next != -1) {
                result = A[next].substring(0, A[next].length() - overlap[next][last]) + result;
            }
            last = next;
        }
        return result;
    }

    private int maxOverlap(String a, String b) {
        for (int i = Math.min(b.length() - 1, a.length() - 1); i >= 0; i--) {
            if (b.charAt(i) == a.charAt(a.length() - 1) && b.substring(0, i + 1).equals(a.substring(a.length() - i - 1))) {
                return i + 1;
            }
        }
        return 0;
    }
}
