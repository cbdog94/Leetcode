import java.util.HashMap;
import java.util.Map;

public class Q992 {

    public static void main(String[] args) {
        System.out.println(new Q992().atMostK(new int[]{1, 2, 1, 2, 3}, 3));
        System.out.println(new Q992().atMostK(new int[]{1, 2, 1, 2, 3}, 2));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    private int atMostK(int[] A, int K) {
        int result = 0, i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < A.length; j++) {
            if (map.getOrDefault(A[j], 0) == 0) {
                K--;
            }
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                map.put(A[i], map.getOrDefault(A[i], 0) - 1);
                if (map.getOrDefault(A[i], 0) == 0) {
                    K++;
                }
                i++;
            }
            result += j - i + 1;
//            System.out.println(i+" "+j);
        }
        return result;
    }
}
