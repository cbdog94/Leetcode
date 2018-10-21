import java.util.Arrays;

public class Q757 {
    public static void main(String[] args) {
        System.out.println(new Q757().intersectionSizeTwo(new int[][]{{6, 21}, {1, 15}, {15, 20}, {10, 21}, {0, 7}}));
    }

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            if (x[0] == y[0]) {
                return y[1] - x[1];
            }
            return x[0] - y[0];
        });
//        for (int[] interval : intervals) {
//            System.out.println(Arrays.toString(interval));
//        }
        int left = intervals[intervals.length - 1][0], result = 2;
        for (int i = intervals.length - 2; i >= 0; i--) {
            if (intervals[i][0] < intervals[i + 1][0]) {
                if (intervals[i][1] == left) {
                    if (i > 0 && intervals[i - 1][0] < intervals[i][0] && intervals[i - 1][1] >= left) {
                        result += 1;
                        left--;
                    } else {
                        result += 2;
                        left = intervals[i][0];
                    }
                } else if (intervals[i][1] < left) {
                    result += 2;
                    left = intervals[i][0];
                }
            }
        }
        return result;
    }
}
