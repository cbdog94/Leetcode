/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Follow up:
 * Could you do this in-place?
 */
public class Q48 {
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length - i - 1; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][length - 1 - i];
                matrix[length - 1 - j][length - 1 - i] = t;
            }
        for (int i = 0; i < length / 2; i++)
            for (int j = 0; j < length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - i][j];
                matrix[length - 1 - i][j] = t;
            }
//        for (int i = 0; i < length; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
    }

    public static void main(String[] args) {
        rotate(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        rotate(new int[][]{{1}});
    }
}
