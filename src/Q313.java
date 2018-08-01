public class Q313 {

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] pointer = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < primes.length; j++) {
                if (ugly[pointer[j]] * primes[j] < min) {
                    min = ugly[pointer[j]] * primes[j];
                    minIndex = j;
                } else if (ugly[pointer[j]] * primes[j] == min) {
                    pointer[j]++;
                }
            }

            pointer[minIndex]++;
            ugly[i] = min;
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
