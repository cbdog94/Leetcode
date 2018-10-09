import java.util.Arrays;

public class Q435 {

    public class Interval {
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
    }

    class Solution {
        public int eraseOverlapIntervals(Interval[] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            int count = 0;
            Arrays.sort(intervals, (x, y) -> {
                if (x.end == y.end) {
                    return x.start - y.start;
                }
                return x.end - y.end;
            });
            Interval last = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i].start < last.end) {
                    count++;
                } else {
                    last = intervals[i];
                }
            }
            return count;
        }
    }
}
