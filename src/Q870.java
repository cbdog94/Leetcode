import java.util.Arrays;
import java.util.Comparator;

public class Q870 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q870().advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        System.out.println(Arrays.toString(new Q870().advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
    }

    public int[] advantageCount(int[] A, int[] B) {
        int length = A.length;
        Arrays.sort(A);
        int[][] b = new int[length][2];
        for (int i = 0; i < length; i++) {
            b[i][0] = B[i];
            b[i][1] = i;
        }
        Arrays.sort(b, Comparator.comparingInt(x -> x[0]));
        int left = 0, right = length - 1;
        int[] result = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            if (A[right] > b[i][0]) {
                result[b[i][1]] = A[right];
                right--;
            } else {
                result[b[i][1]] = A[left];
                left++;
            }
        }
        return result;
    }
}
