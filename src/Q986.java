import java.util.ArrayList;
import java.util.List;

public class Q986 {

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> list = new ArrayList<>();
        int a = 0, b = 0;
        while (a < A.length && b < B.length) {
            if (A[a].end > B[b].end) {
                if (A[a].start > B[b].start) {
                    if (A[a].start <= B[b].end) {
                        list.add(new Interval(A[a].start, B[b].end));
                    }
                } else {
                    list.add(new Interval(B[b].start, B[b].end));
                }
                b++;
            } else {
                if (B[b].start > A[a].start) {
                    if (B[b].start <= A[a].end) {
                        list.add(new Interval(B[b].start, A[a].end));
                    }
                } else {
                    list.add(new Interval(A[a].start, A[a].end));
                }
                a++;
            }
        }
        return (Interval[]) list.toArray(new Interval[list.size()]);
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
}
