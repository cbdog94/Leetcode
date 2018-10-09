import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q406 {
    public static void main(String[] args) {
        int[][] res = new Q406().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            }
            return y[0] - x[0];
        });
        List<int[]> result = new ArrayList<>();
        for (int[] p : people) {
            result.add(p[1], p);
        }
        return result.toArray(new int[people.length][]);
    }
}
