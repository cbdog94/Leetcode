import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Q118 {
    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        if (numRows == 1)
            return result;
        result.add(Arrays.asList(1, 1));
        for (int i = 2; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            List<Integer> last = result.get(result.size() - 1);
            for (int j = 0; j < last.size() - 1; j++)
                current.add(last.get(j) + last.get(j + 1));
            current.add(1);
            result.add(current);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(6));
        System.out.println(generate(5));
        System.out.println(generate(4));
        System.out.println(generate(3));
        System.out.println(generate(2));
        System.out.println(generate(1));
        System.out.println(generate(0));
    }

}
