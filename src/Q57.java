import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p>
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 我的：
 * 首先对start排序，接着对end进行调整，直到选出没有重复的end，将其保存到结果集
 */
public class Q57 {

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

//    public static List<Interval> merge(List<Interval> intervals) {
//        List<Interval> result = new ArrayList<>();
//        if (intervals.size() == 0)
//            return result;
//        intervals.sort(new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });
//        int next = 1;
//        int min = intervals.get(0).start;
//        int max = intervals.get(0).end;
//        while (next < intervals.size()) {
//            if (max < intervals.get(next).start) {
//                result.add(new Interval(min, max));
//                min = intervals.get(next).start;
//                max = intervals.get(next).end;
//            } else {
//                max = Math.max(max, intervals.get(next).end);
//            }
//            next++;
//        }
//        result.add(new Interval(min, max));
//        return result;
//
//    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0)
            return Collections.singletonList(newInterval);
        int i = 0;
        for (; i < intervals.size(); i++) {
            if (newInterval.start < intervals.get(i).start) {
                break;
            }
        }
        intervals.add(i, newInterval);
        System.out.println(intervals);
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
        System.out.println(insert(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(6, 9))), new Interval(2, 5)));
        System.out.println(insert(new ArrayList<>(Arrays.asList(new Interval(1, 5))), new Interval(2, 3)));
    }

}
