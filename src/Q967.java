import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q967 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q967().numsSameConsecDiff(1, 0)));
        System.out.println(Arrays.toString(new Q967().numsSameConsecDiff(1, 1)));
        System.out.println(Arrays.toString(new Q967().numsSameConsecDiff(3, 0)));
        System.out.println(Arrays.toString(new Q967().numsSameConsecDiff(3, 1)));
        System.out.println(Arrays.toString(new Q967().numsSameConsecDiff(3, 2)));
    }

    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        List<Integer> result = new ArrayList<>();
        backtrack(result, 0, N, K);
        return result.stream().mapToInt(x -> x).toArray();
    }

    private void backtrack(List<Integer> result, int tmp, int N, int K) {
        if (N == 0) {
            result.add(tmp);
            return;
        }
        if (tmp == 0) {
            for (int i = 1; i <= 9; i++) {
                backtrack(result, i, N - 1, K);
            }
        } else {
            int last = tmp % 10;
            if (K == 0) {
                backtrack(result, tmp * 10 + last, N - 1, K);
            } else {
                if (last + K < 10) {
                    backtrack(result, tmp * 10 + last + K, N - 1, K);
                }
                if (last - K >= 0) {
                    backtrack(result, tmp * 10 + last - K, N - 1, K);
                }
            }
        }
    }
}
