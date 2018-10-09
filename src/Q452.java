import java.util.Arrays;
import java.util.Comparator;

public class Q452 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        int count = 1;
        Arrays.sort(points, Comparator.comparingInt(x -> x[1]));
        int last = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > last) {
                count++;
                last = points[i][1];
            }
        }
        return count;
    }

}
