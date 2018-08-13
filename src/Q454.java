import java.util.HashMap;
import java.util.Map;

public class Q454 {
    /*
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum1 = A[i] + B[j];
                int sum2 = C[i] + D[j];
                map1.put(sum1, map1.getOrDefault(sum1, 0) + 1);
                map2.put(sum2, map2.getOrDefault(sum2, 0) + 1);
            }
        }
        if (map1.size() < map2.size()) {
            for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                result += entry.getValue() * map2.getOrDefault(-entry.getKey(), 0);
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
                result += entry.getValue() * map1.getOrDefault(-entry.getKey(), 0);
            }
        }
        return result;
    }*/

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = C[i] + C[j];
                result += map.getOrDefault(-sum, 0);
            }
        }
        return result;
    }
}
