import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q363 {
    public static void main(String[] args) {
        System.out.println(new Q363().maxSumArray(new int[]{5, 4, -10, 2, 9}, 5));
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length, colmun = matrix[0].length;
        long max = Long.MIN_VALUE;
        if (row > colmun) {
            for (int i = 0; i < colmun; i++) {
                int[] dp = new int[row];
                for (int j = i; j < colmun; j++) {
                    for (int n = 0; n < row; n++) {
                        dp[n] += matrix[n][j];
                    }
                    long sum = maxSumArray(dp, k);
                    max = Math.max(max, sum);
                }
            }
        } else {

            for (int i = 0; i < row; i++) {
                int[] dp = new int[colmun];
                for (int j = i; j < row; j++) {
                    for (int n = 0; n < colmun; n++) {
                        dp[n] += matrix[j][n];
                    }
                    long sum = maxSumArray(dp, k);
                    max = Math.max(max, sum);
                }
            }
        }
        return max == Long.MIN_VALUE ? 0 : (int) max;
    }

    private long maxSumArray(int[] a, int k) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        long max = Long.MIN_VALUE;
        list.add(0);
        for (int i : a) {

            sum += i;
//            System.out.println(sum);
//            System.out.println(list);
            int index = Collections.binarySearch(list, sum - k);
            if (index >= 0) {
                return k;
            } else if (-index - 1 < list.size()) {
                max = Math.max(max, sum - list.get(-index - 1));
            }
//            System.out.println(max);
            int insert = Collections.binarySearch(list, sum);
            if (insert < 0) {
                list.add(-insert - 1, sum);
            }
        }
        return max;
    }
}
