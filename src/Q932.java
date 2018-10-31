import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q932 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q932().beautifulArray(5)));
        System.out.println(Arrays.toString(new Q932().beautifulArray(6)));
    }

    public int[] beautifulArray(int N) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        while (result.size() < N) {
            List<Integer> tmp = new ArrayList<>();
            for (int i : result) {
                if (2 * i - 1 <= N) {
                    tmp.add(2 * i - 1);
                }
            }
            for (int i : result) {
                if (2 * i <= N) {
                    tmp.add(2 * i);
                }
            }
            result = tmp;
        }
        return result.stream().mapToInt(x -> x).toArray();
    }
}
