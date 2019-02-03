import java.util.Arrays;

public class Q977 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q977().sortedSquares(new int[]{1})));
        System.out.println(Arrays.toString(new Q977().sortedSquares(new int[]{-1})));
        System.out.println(Arrays.toString(new Q977().sortedSquares(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new Q977().sortedSquares(new int[]{-3, -2, -1})));
        System.out.println(Arrays.toString(new Q977().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(new Q977().sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    public int[] sortedSquares(int[] A) {
        int pos = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            pos = A.length;
        }
        int neg = pos - 1, index = 0;
        int[] result = new int[A.length];
        while (index < A.length) {
            if (neg < 0) {
                result[index++] = A[pos] * A[pos];
                pos++;
            } else if (pos >= A.length) {
                result[index++] = A[neg] * A[neg];
                neg--;
            } else {
                if (A[pos] < -A[neg]) {
                    result[index++] = A[pos] * A[pos];
                    pos++;
                } else {
                    result[index++] = A[neg] * A[neg];
                    neg--;
                }
            }
        }
        return result;
    }
}
