import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MS2 {

    public static void main(String[] args) {
        System.out.println(new MS2().minDays(10, 1));
        System.out.println(new MS2().minDays(11, 3));
        System.out.println(new MS2().isPrime(2));
        System.out.println(new MS2().isPrime(3));
        System.out.println(new MS2().isPrime(4));
        System.out.println(new MS2().isPrime(5));
        System.out.println(new MS2().isPrime(6));
    }

    public int minDays(int input1, int input2) {
        List<Integer> primes = generatePrimes(input2);
        int[] dp = new int[input1 + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int p : primes) {
            for (int i = p; i <= input1; i++) {
                if (dp[i - p] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[i - p] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - p] + 1);
                    }
                }
            }
        }
        return dp[input1];
    }

    public List<Integer> generatePrimes(int total) {
        List<Integer> primes = new ArrayList<>(total);
        int s = 2;
        while (true) {
            if (isPrime(s)) {
                primes.add(s);
                if (primes.size() == total) {
                    break;
                }
            }
            s++;
        }
        return primes;
    }

    public boolean isPrime(int num) {
        int i, k = (int) Math.sqrt(num);
        for (i = 2; i <= k; i++) {
            if (num % i == 0) {
                break;
            }
        }
        return i > k;
    }
}