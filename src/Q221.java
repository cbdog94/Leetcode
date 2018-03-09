import java.util.Arrays;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * For example, given the following matrix:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 */


public class Q221 {


    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{{'1', '0', '1', '0', '0' },
                {'1', '0', '1', '1', '1' },
                {'1', '1', '1', '1', '1' },
                {'1', '0', '0', '1', '0' }}));
    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int r = matrix.length, c = matrix[0].length;
        int[] height = new int[c];
        int[] left = new int[c];
        int[] right = new int[c];
        Arrays.fill(right, c);
        int maxArea = 0;
        for (int i = 0; i < r; i++) {
            int curLeft = 0, curRight = c;
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    curLeft = j + 1;
                }
                if (matrix[i][c - j - 1] == '1') {
                    right[c - j - 1] = Math.min(right[c - j - 1], curRight);
                } else {
                    right[c - j - 1] = c;
                    curRight = c - j - 1;
                }
            }
//            System.out.println(Arrays.toString(height));
//            System.out.println(Arrays.toString(left));
//            System.out.println(Arrays.toString(right));
//            System.out.println();
            for (int j = 0; j < c; j++) {
                int edge = Math.min(right[j] - left[j], height[j]);
                maxArea = Math.max(edge * edge, maxArea);
            }
        }
        return maxArea;
    }

}
