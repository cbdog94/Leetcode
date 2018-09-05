import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q632 {

    public int[] smallestRange(List<List<Integer>> nums) {
        Queue<Tripe> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            queue.offer(new Tripe(i, 0, nums.get(i).get(0)));
            max = Math.max(max, nums.get(i).get(0));
        }
        int range = Integer.MAX_VALUE, start = -1, end = -1;
        while (queue.size() == nums.size()) {
            Tripe tmp = queue.poll();
            if (max - tmp.val < range) {
                start = tmp.val;
                end = max;
            }
            if (tmp.index < nums.get(tmp.row).size() - 1) {
                int val = nums.get(tmp.row).get(tmp.index + 1);
                queue.offer(new Tripe(tmp.row, tmp.index + 1, val));
                max = Math.max(max, val);
            }
        }
        return new int[]{start, end};
    }

    class Tripe {
        int row;
        int index;
        int val;

        Tripe(int row, int index, int val) {
            this.row = row;
            this.index = index;
            this.val = val;
        }
    }

}
