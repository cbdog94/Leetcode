import java.util.ArrayList;
import java.util.List;

public class Q89 {

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(1 << n);
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }

}
