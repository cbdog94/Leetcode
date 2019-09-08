import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class XiaoHong4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), T = scanner.nextInt(), M = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(attack(N, T, M, nums));


    }

    private static int attack(int n, int t, int m, int[] nums) {
        if (t < n) {
            return -1;
        }
        Arrays.sort(nums);
        int i;
        for (i = 0; nums[i] == 1; i++) {
            t--;
        }
        if (n - i > m) {
            return -1;
        } else if (n - i == 0) {
            return 0;
        }
        m = m - (n - i);
        Queue<int[]> queue = new PriorityQueue<>((x, y) -> {
            if (y[0] != x[0]) {
                return y[0] - x[0];
            } else {
                return y[1] - x[1];
            }
        });
        for (; i < n; i++) {
            queue.offer(new int[]{nums[i], 1, nums[i]});
        }
        while (m > 0) {
            int[] tmp = queue.poll();
            tmp[1]++;
            tmp[0] = (int) Math.ceil(tmp[2] * 1.0 / tmp[1]);
            queue.offer(tmp);
            m--;
        }
        return queue.peek()[0];
    }
}
