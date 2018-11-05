import java.util.Arrays;

public class Q933 {

    class RecentCounter {

        int[] record;
        int index = 0;

        public RecentCounter() {
            record = new int[10005];
        }

        public int ping(int t) {
            record[index++] = t;
            int n = Arrays.binarySearch(record, 0, index, t - 3000);
            if (n < 0) {
                n = -n - 1;
            }
            return index - n;
        }
    }

}
