import java.util.PriorityQueue;

public class Q502 {

    public static void main(String[] args) {
        System.out.println(new Q502().findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        System.out.println(new Q502().findMaximizedCapital(1, 2, new int[]{1, 2, 3}, new int[]{1, 1, 2}));
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> cap = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        PriorityQueue<int[]> pro = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int i = 0; i < Profits.length; i++) {
            cap.offer(new int[]{Profits[i], Capital[i]});
        }
        for (int i = 0; i < k; i++) {
            while (!cap.isEmpty() && cap.peek()[1] <= W) {
                pro.offer(cap.poll());
            }
            if (pro.isEmpty()) {
                return W;
            }
            int profit = pro.poll()[0];
            W += profit;
        }
        return W;
    }

}
