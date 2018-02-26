import java.util.Arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class Q74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int[] first = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            first[i] = matrix[i][0];
        int rowResult = Arrays.binarySearch(first, target);
        System.out.println(rowResult);
        return rowResult != -1 && (rowResult >= 0 || Arrays.binarySearch(matrix[-rowResult - 2], target) > 0);
    }

    public static void main(String[] args) {
//        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 10));
//        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 0));
//        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 50));
//        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 60));
//        System.out.println(searchMatrix(new int[][]{}, 10));
//        System.out.println(searchMatrix(new int[][]{{}}, 10));
//        System.out.println(searchMatrix(new int[][]{{1}}, 10));
        System.out.println(searchMatrix(new int[][]{{1}}, 1));
    }
}
