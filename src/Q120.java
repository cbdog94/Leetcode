import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

public class Q120 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] sum = new int[length];
        int min = 0;
        for (int i = 0; i < length; i++) {
            min = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (j == 0)
                    sum[j] = triangle.get(i).get(0) + sum[0];
                else if (j != i)
                    sum[j] = triangle.get(i).get(j) + Math.min(sum[j], sum[j - 1]);
                else
                    sum[j] = triangle.get(i).get(j) + sum[j - 1];
                min = Math.min(sum[j], min);
            }
            System.out.println(Arrays.toString(sum));
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minimumTotal(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3))));
    }

}
