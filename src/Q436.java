import java.util.Arrays;

public class Q436 {

    public static void main(String[] args) {
        Q436 q = new Q436();
        System.out.println(Arrays.toString(q.findRightInterval(new Interval[]{q.new Interval(1, 2)})));
        System.out.println(Arrays.toString(q.findRightInterval(new Interval[]{q.new Interval(3, 4), q.new Interval(2, 3), q.new Interval(1, 2)})));
        System.out.println(Arrays.toString(q.findRightInterval(new Interval[]{q.new Interval(1, 4), q.new Interval(2, 3), q.new Interval(3, 4)})));
    }

    public int[] findRightInterval(Interval[] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return new int[0];
        }
        IntervalExtend[] intervalExtends = new IntervalExtend[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            intervalExtends[i] = new IntervalExtend(intervals[i], i);
        }
        Arrays.sort(intervalExtends);
        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(intervalExtends, new IntervalExtend(intervals[i].end));
            if (index < 0) {
                index = -index - 1;
            }
            result[i] = index == n ? -1 : intervalExtends[index].index;
        }
        return result;
    }

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

    public class IntervalExtend implements Comparable<IntervalExtend> {
        int index;
        Interval interval;

        IntervalExtend(Interval interval, int index) {
            this.interval = interval;
            this.index = index;
        }

        IntervalExtend(int start) {
            this.interval = new Interval(start, 0);
        }

        @Override
        public int compareTo(IntervalExtend o) {
            return this.interval.start - o.interval.start;
        }
    }
}
