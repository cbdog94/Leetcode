import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1015 {
    public static void main(String[] args) {
        System.out.println(new Q1015().numDupDigitsAtMostN(1000));
    }

    public int numDupDigitsAtMostN(int N) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = N + 1; i > 0; i /= 10) {
            list.add(0, i % 10);
        }
        int n = list.size();
        for (int i = 1; i < list.size(); i++) {
            result += 9 * A(9, n - i - 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i > 0 ? 0 : 1; j < list.get(i); j++) {
                if (!set.contains(j)) {
                    result += A(9 - i, n - i - 1);
                }
            }
            if (set.contains(list.get(i))) {
                break;
            }
            set.add(list.get(i));
        }
        return N - result;
    }

    private int A(int m, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= (m - i);
        }
        return result;
    }

}
