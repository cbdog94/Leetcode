import java.util.ArrayList;
import java.util.List;

public class Q514 {

    public static int findRotateSteps(String ring, String key) {
        List<Integer>[] map = new List[26];
        char[] rc = ring.toCharArray(), kc = key.toCharArray();
        for (int i = 0; i < rc.length; i++) {
            if (map[rc[i] - 'a'] == null) {
                map[rc[i] - 'a'] = new ArrayList<>();
            }
            map[rc[i] - 'a'].add(i);
        }
        int[] last = new int[rc.length], cur = new int[rc.length];
        for (int i = 0; i < kc.length; i++) {
            List<Integer> list = map[kc[i] - 'a'];
            if (i == 0) {
                for (int item : list) {
                    cur[item] = item <= rc.length / 2 ? item : rc.length - item;
                }
            } else {
                List<Integer> lastList = map[kc[i - 1] - 'a'];
//                System.out.println(lastList);
//                System.out.println(list);
                for (int item : list) {
                    int min = Integer.MAX_VALUE;
                    for (int lastItem : lastList) {
                        int tmp = Math.abs(lastItem - item);
                        min = Math.min(min, last[lastItem] + (tmp <= rc.length / 2 ? tmp : rc.length - tmp));
                    }
                    cur[item] = min;
                }
            }
//            System.out.println(Arrays.toString(cur));
            last = cur;
            cur = new int[rc.length];
        }
        int min = Integer.MAX_VALUE;
        for (int item : map[kc[kc.length - 1] - 'a']) {
            min = Math.min(min, last[item]);
        }
        return min + kc.length;
    }

    public static void main(String[] args) {
        System.out.println(findRotateSteps("godding", "didn"));
    }

}
