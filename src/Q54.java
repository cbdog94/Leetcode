import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * For example,
 * Given the following matrix:
 * <p>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class Q54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        int x = 0, y = 0, xDirection = 1, yDirection = 0;
        int xLength = matrix[0].length;
        int yLength = matrix.length;
        boolean[][] flag = new boolean[yLength][xLength];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < xLength * yLength; i++) {
            result.add(matrix[y][x]);
            flag[y][x] = true;
            if (x + xDirection >= xLength || y + yDirection >= yLength || x + xDirection < 0 || y + yDirection < 0 || flag[y + yDirection][x + xDirection]) {
                if (xDirection == 1) {
                    xDirection = 0;
                    yDirection = 1;
                } else if (yDirection == 1) {
                    xDirection = -1;
                    yDirection = 0;
                } else if (xDirection == -1) {
                    xDirection = 0;
                    yDirection = -1;
                } else {
                    xDirection = 1;
                    yDirection = 0;
                }
            }
            x += xDirection;
            y += yDirection;

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}));
        System.out.println(spiralOrder(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(spiralOrder(new int[][]{}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}}));

    }
}
