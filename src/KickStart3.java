import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class KickStart3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            long K = scanner.nextLong();
            long x1 = scanner.nextLong();
            long y1 = scanner.nextLong();
            long C = scanner.nextLong();
            long D = scanner.nextLong();
            long E1 = scanner.nextLong();
            long E2 = scanner.nextLong();
            long F = scanner.nextLong();
            System.out.println("Case #" + (i + 1) + ": " + f(N, K, x1, y1, C, D, E1, E2, F));
        }
    }

    private static String f(int n, long k, long x1, long y1, long c, long d, long e1, long e2, long f) {
        long[] s = new long[n];
        s[0] = (x1 + y1) % f;
        for (int i = 1; i < n; i++) {
            long xt = (c * x1 + d * y1 + e1) % f;
            long yt = (d * x1 + c * y1 + e2) % f;
            s[i] = (xt + yt) % f;
            x1 = xt;
            y1 = yt;
        }
        BigInteger[] dp = new BigInteger[n];

        BigInteger bi = BigInteger.ZERO;
        for (int i = 1; i <= k; i++) {

            for (int j = 0; j < n; j++) {
                dp[j] = BigInteger.valueOf(s[j]);
                bi = bi.add(dp[j]);
                for (int p = j + 1; p < n; p++) {
                    dp[p] = dp[p - 1].add(BigInteger.valueOf(s[p]).multiply(BigInteger.valueOf(p - j + 1).pow(i)));
                    bi = bi.add(dp[p]);
                }
            }
        }
        return bi.mod(BigInteger.valueOf(1000000007)).toString();
    }
}
