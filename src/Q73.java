import java.util.ArrayList;
import java.util.List;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * <p>
 * <p>
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class Q73 {
    public static void setZeroes(int[][] matrix) {
        List<Integer[]> waitToSet = new ArrayList<>();
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        for (int i = 0; i < rowLength; i++)
            for (int j = 0; j < columnLength; j++) {
                if (matrix[i][j] == 0)
                    waitToSet.add(new Integer[]{i, j});
            }

        for (Integer[] item : waitToSet) {
            int row = item[0];
            int column = item[1];
            for (int i = 0; i < columnLength; i++)
                matrix[row][i] = 0;
            for (int i = 0; i < rowLength; i++)
                matrix[i][column] = 0;
        }
    }
}
