import java.util.Map;
import java.util.TreeMap;

public class Q975 {

    public static void main(String[] args) {
        System.out.println(new Q975().oddEvenJumps(new int[]{10, 13, 12, 14, 15}));
        System.out.println(new Q975().oddEvenJumps(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Q975().oddEvenJumps(new int[]{5, 1, 3, 4, 2}));
    }

    public int oddEvenJumps(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int result = 1;
        map.put(A[A.length - 1], A.length - 1);
        boolean[] odd = new boolean[A.length], even = new boolean[A.length];
        odd[A.length - 1] = even[A.length - 1] = true;
        for (int i = A.length - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> high = map.ceilingEntry(A[i]), low = map.floorEntry(A[i]);
            if (high != null) {
                odd[i] = even[high.getValue()];
                if (odd[i]) {
                    result++;
                }
            }
            if (low != null) {
                even[i] = odd[low.getValue()];
            }
            map.put(A[i], i);
        }
//        System.out.println(Arrays.toString(odd));
//        System.out.println(Arrays.toString(even));
        return result;
    }

}
