public class Q5173 {

    public static void main(String[] args) {
        System.out.println(new Q5173().numPrimeArrangements(100));
    }

    public int numPrimeArrangements(int n) {
        int m = numberOfPrime(n);
        long count = 1, mod = 1_000_000_007;
        for (int i = 1; i <= m; i++) {
            count = (count * i) % mod;
        }
        for (int i = 1; i <= n - m; i++) {
            count = (count * i) % mod;
        }
        return (int) count;
    }

    private int numberOfPrime(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] flag = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!flag[i]) {
                count++;
            }
            for (int j = i + i; j <= n; j += i) {
                flag[j] = true;
            }
        }
        return count;
    }
}
