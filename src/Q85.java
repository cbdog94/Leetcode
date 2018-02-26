import java.util.Arrays;

public class Q85 {

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{{'0', '0', '0', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '1', '0', '0'},
                {'0', '1', '1', '1', '1', '1', '0'}}));
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    curLeft = j + 1;
                }
                if (matrix[i][n - j - 1] == '1') {
                    right[n - j - 1] = Math.min(right[n - j - 1], curRight);
                } else {
                    right[n - j - 1] = n;
                    curRight = n - j - 1;
                }
            }
//            System.out.println(Arrays.toString(height));
//            System.out.println(Arrays.toString(left));
//            System.out.println(Arrays.toString(right));
            for (int j = 0; j < n; j++)
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
        }
        return maxArea;
    }
}
