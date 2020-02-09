public class Q5191 {

    public static void main(String[] args) {
        System.out.println(new Q5191().kConcatenationMaxSum(new int[]{1, 2}, 3));
        System.out.println(new Q5191().kConcatenationMaxSum(new int[]{1, -2, 1}, 5));
        System.out.println(new Q5191().kConcatenationMaxSum(new int[]{1, -5, 2}, 5));
        System.out.println(new Q5191().kConcatenationMaxSum(new int[]{-1, -2}, 7));
    }

    public int kConcatenationMaxSum(int[] arr, int k) {
        long total = 0, maxSum = Integer.MIN_VALUE, tmp = 0, mod = 1_000_000_007;
        for (int a : arr) {
            total += a;
            if (tmp < 0) {
                tmp = a;
            } else {
                tmp += a;
            }
            maxSum = Math.max(maxSum, tmp);
        }
        if (k == 1) {
            return (int) Math.max(maxSum % mod, 0);
        }
        for (int a : arr) {
            if (tmp < 0) {
                tmp = a;
            } else {
                tmp += a;
            }
            maxSum = Math.max(maxSum, tmp);
        }
        maxSum %= mod;
        total %= mod;
        if (maxSum <= 0) {
            return 0;
        } else {
            if (total > 0) {
                return (int) ((maxSum + total * (k - 2)) % mod);
            } else {
                return (int) maxSum;
            }
        }
    }
}
