import java.util.Arrays;

public class Q985 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Q985().sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
        System.out.println(Arrays.toString(new Q985().sumEvenAfterQueries(new int[]{5, 5, 4}, new int[][]{{0, 1}, {1, 0}, {4, 1}})));
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] result = new int[queries.length];
        for (int a : A) {
            if (a % 2 == 0) {
                sum += a;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][1];
            int oldValue = A[index];
            int newValue = oldValue + queries[i][0];
            if (newValue % 2 == 0) {
                if (oldValue % 2 == 0) {
                    result[i] = sum += queries[i][0];
                } else {
                    result[i] = sum += newValue;
                }
            } else {
                if (oldValue % 2 == 0) {
                    result[i] = sum -= oldValue;
                } else {
                    result[i] = sum;
                }
            }
            A[index] = newValue;
        }
        return result;
    }
}
