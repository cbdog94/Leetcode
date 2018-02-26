import java.util.Arrays;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * For example,
 * Given n = 3,
 * <p>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class Q59 {

    public static int[][] generateMatrix(int n) {
        int x = 0, y = 0, xDirection = 1, yDirection = 0;
        int[][] result = new int[n][n];
        for (int i = 1; i <= n * n; i++) {
            result[y][x] = i;
            if (x + xDirection >= n || y + yDirection >= n || x + xDirection < 0 || y + yDirection < 0 || result[y + yDirection][x + xDirection] != 0) {
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
//        System.out.println(Arrays.toString(generateMatrix(0)[0]));

        System.out.println(Arrays.toString(generateMatrix(1)[0]));

        System.out.println(Arrays.toString(generateMatrix(2)[0]));
        System.out.println(Arrays.toString(generateMatrix(2)[1]));

        System.out.println(Arrays.toString(generateMatrix(3)[0]));
        System.out.println(Arrays.toString(generateMatrix(3)[1]));
        System.out.println(Arrays.toString(generateMatrix(3)[2]));

        System.out.println(Arrays.toString(generateMatrix(4)[0]));
        System.out.println(Arrays.toString(generateMatrix(4)[1]));
        System.out.println(Arrays.toString(generateMatrix(4)[2]));
        System.out.println(Arrays.toString(generateMatrix(4)[3]));

    }
}
