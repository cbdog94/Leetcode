import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q974 {

    public static void main(String[] args) {
//        System.out.println((-5) % 5);
        System.out.println(new Q974().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(new Q974().subarraysDivByK(new int[]{0, -5}, 5));
        System.out.println(new Q974().subarraysDivByK(new int[]{5, 0}, 5));
        System.out.println(new Q974().subarraysDivByK(new int[]{5}, 5));
        System.out.println(new Q974().subarraysDivByK(new int[]{-2}, 6));
    }

    public int subarraysDivByK(int[] A, int K) {
        List<Integer>[] map = new List[K];
        int sum = 0;
        int[] sums = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int tmp = sum % K >= 0 ? sum % K : sum % K + K;
            if (map[tmp] == null) {
                map[tmp] = new ArrayList<>();
            }
            map[tmp].add(i);
            sums[i] = sum;
        }
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int tmp = sums[i] % K >= 0 ? sums[i] % K : sums[i] % K + K;
            List<Integer> cur = map[tmp];
            int index = Collections.binarySearch(cur, i);
            if (index >= 0) {
                result += index;
            } else {
                result += -index - 1;
            }
            if (sums[i] % K == 0) {
                result++;
            }
        }
        return result;
    }

}
