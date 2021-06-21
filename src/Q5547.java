import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q5547 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>(l.length);
        for (int i = 0; i < l.length; i++) {
            int[] t = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            if (t.length < 2) {
                res.add(false);
            } else {

                Arrays.sort(t);
                int sub = t[1] - t[0], j = 2;
                System.out.println(Arrays.toString(t));
                for (j = 2; j < t.length; j++) {
                    if (t[j] - t[j - 1] != sub) {
                        break;
                    }
                }
                System.out.println(j);
                res.add(j == t.length);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Q5547().checkArithmeticSubarrays(new int[] { 4, 6, 5, 9, 3, 7 }, new int[] { 0, 0, 2 },
                new int[] { 2, 3, 5 });
    }
}
