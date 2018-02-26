import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 */
public class Q119 {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++)
            result.add(combination(rowIndex, i));
        return result;

    }

    private static int combination(int n, int m) {
        m = (m > n - m) ? n - m : m;
        double result = 1;
        for (int i = 0; i < n - m; i++) {
            result = result * (n - i) / (n - m - i);
        }
        return (int) Math.round(result);
    }


    public static void main(String[] args) {
        System.out.println(getRow(34));
        System.out.println(getRow(30));
        System.out.println(getRow(13));
        System.out.println(getRow(13));
        System.out.println(getRow(7));
        System.out.println(getRow(6));
        System.out.println(getRow(5));
        System.out.println(getRow(4));
        System.out.println(getRow(3));
        System.out.println(getRow(2));
        System.out.println(getRow(1));
        System.out.println(getRow(0));
    }

}
