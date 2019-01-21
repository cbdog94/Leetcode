import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q954 {

    public static void main(String[] args) {
        System.out.println(new Q954().canReorderDoubled(new int[]{1, 2, 1, -8, 8, -4, 4, -4, 2, -2, 0}));
    }

    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (int a : A) {
            if (map.getOrDefault(a, 0) != 0) {
                map.put(a, map.get(a) - 1);
                if (a < 0) {
                    if (a % 2 != 0) {
                        return false;
                    }
                    if (map.getOrDefault(a / 2, 0) == 0) {
                        return false;
                    }
                    map.put(a / 2, map.get(a / 2) - 1);
                } else {
                    if (map.getOrDefault(a * 2, 0) == 0) {
                        return false;
                    }
                    map.put(a * 2, map.get(a * 2) - 1);
                }
            }
        }
        return true;
    }

}
