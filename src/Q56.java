import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * <p>
 * [1,3][4,5][6,8][2,7]
 * 我的：
 * 首先对start排序，接着对end进行调整，直到选出没有重复的end，将其保存到结果集
 */
public class Q56 {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0)
            return result;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int next = 1;
        int min = intervals.get(0).start;
        int max = intervals.get(0).end;
        while (next < intervals.size()) {
            if (max < intervals.get(next).start) {
                result.add(new Interval(min, max));
                min = intervals.get(next).start;
                max = intervals.get(next).end;
            } else {
                max = Math.max(max, intervals.get(next).end);
            }
            next++;
        }
        result.add(new Interval(min, max));
        return result;

    }

    public static void main(String[] args) {
        System.out.println(merge(Arrays.asList(new Interval(1, 3), new Interval(4, 5), new Interval(6, 8), new Interval(2, 7))));
        System.out.println(merge(Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18))));
        System.out.println(merge(Arrays.asList(new Interval(1, 3), new Interval(4, 5), new Interval(10, 11), new Interval(6, 8), new Interval(2, 7))));
        System.out.println(merge(Arrays.asList(new Interval(1, 3))));
    }

}
