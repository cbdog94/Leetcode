import java.util.Arrays;

public class Q1005 {
    public static void main(String[] args) {
        System.out.println(new Q1005().largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(new Q1005().largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(new Q1005().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
        System.out.println(new Q1005().largestSumAfterKNegations(new int[]{2, 3, 4, 5}, 2));
    }

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                if (i < K) {
                    if ((K - i) % 2 == 0) {
                        sum += A[i];
                    } else {
                        if (i == 0 || -A[i - 1] > A[i]) {
                            sum -= A[i];
                        } else {
                            sum = sum + 2 * A[i - 1] + A[i];
                        }
                    }
                    K = 0;
                } else {
                    sum += A[i];
                }
            } else {
                if (i < K) {
                    sum += -A[i];
                } else {
                    sum += A[i];
                }
            }
        }
        return sum;
    }
}
