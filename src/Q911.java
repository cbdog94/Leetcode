import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q911 {

    public static void main(String[] args) {
        Q911 q = new Q911();
        TopVotedCandidate t = q.new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(t.q(3));
        System.out.println(t.q(12));
        System.out.println(t.q(25));
        System.out.println(t.q(15));
        System.out.println(t.q(24));
        System.out.println(t.q(8));
    }

    class TopVotedCandidate {

        Map<Integer, Integer> map;
        int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;
            map = new HashMap<>();
            int top = -1;
            int[] count = new int[persons.length + 1];
            for (int i = 0; i < persons.length; i++) {
                count[persons[i]]++;
                if (i == 0 || count[persons[i]] >= count[top]) {
                    top = persons[i];
                }
                map.put(times[i], top);
            }
        }

        public int q(int t) {
            int index = Arrays.binarySearch(times, t);
            return index < 0 ? map.get(times[-index - 2]) : map.get(times[index]);
        }
    }
}

