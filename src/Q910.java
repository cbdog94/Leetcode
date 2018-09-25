import java.util.Arrays;

public class Q910 {

    public static int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int res = A[A.length - 1] - A[0];
        int right = A[A.length - 1] - K, left = A[0] + K;
        for (int i = 0; i < A.length - 1; i++) {
            int max = Math.max(A[i] + K, right), min = Math.min(A[i + 1] - K, left);
            res = Math.min(max - min, res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(smallestRangeII(new int[]{1, 3, 6}, 3));
        System.out.println(smallestRangeII(new int[]{1}, 0));
        System.out.println(smallestRangeII(new int[]{0, 10}, 2));
    }
}
