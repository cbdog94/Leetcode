import java.util.Arrays;

public class Q240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = Arrays.binarySearch(matrix[0], target);
        if (row >= 0) {
            return true;
        }
        for (int[] aMatrix : matrix) {
            if (aMatrix[0] > target) {
                break;
            }
            if (Arrays.binarySearch(aMatrix, 0, -row - 1, target) >= 0) {
                return true;
            }
        }
        return false;
    }
}
