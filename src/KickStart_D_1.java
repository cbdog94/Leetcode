import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KickStart_D_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int O = scanner.nextInt();
            long D = scanner.nextLong();
            long X1 = scanner.nextLong();
            long X2 = scanner.nextLong();
            long A = scanner.nextLong();
            long B = scanner.nextLong();
            long C = scanner.nextLong();
            long M = scanner.nextLong();
            long L = scanner.nextLong();
            System.out.println("Case #" + (i + 1) + ": " + f(N, O, D, X1, X2, A, B, C, M, L));
        }
    }

    private static String f(int N, int O, long D, long X1, long X2, long A, long B, long C, long M, long L) {
        long[] s = new long[N];
        s[0] = X1 + L;
        s[1] = X2 + L;
        for (int i = 2; i < N; i++) {
            long Xt = (A * X1 + B * X2 + C) % M;
            s[i] = Xt + L;
            X1 = X2;
            X2 = Xt;
        }
//        System.out.println(Arrays.toString(s));
        long[] sum = new long[N + 1];
        int[] odd = new int[N + 1];
//        sum[0]=s[0];
//        odd[0]=s[0]%2==0?0:1;
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + s[i - 1];
            odd[i] = odd[i - 1] + (s[i - 1] % 2 == 0 ? 0 : 1);
        }
//        System.out.println(Arrays.toString(sum));

//        System.out.println(Arrays.toString(odd));

        long maxsum = Long.MIN_VALUE;
//        int maxodd=0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                long tsum = sum[j] - sum[i];
                int todd = odd[j] - odd[i];
                if (tsum > maxsum && tsum <= D && todd <= O) {
                    maxsum = tsum;
                }
            }
        }
        return maxsum == Long.MIN_VALUE ? "IMPOSSIBLE" : maxsum + "";
    }
}
