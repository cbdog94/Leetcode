import java.util.HashMap;
import java.util.Map;

public class Q930 {

    public static void main(String[] args) {
        System.out.println(new Q930().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }

    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[A.length + 1];
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < A.length; i++) {
            sum[i + 1] = sum[i] + A[i];
            count += map.getOrDefault(sum[i + 1] - S, 0);
            map.put(sum[i + 1], map.getOrDefault(sum[i + 1], 0) + 1);
        }
        return count;
    }
}
