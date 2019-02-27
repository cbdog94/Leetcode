import java.util.Arrays;

public class Q826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int[][] pair = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            pair[i][0] = difficulty[i];
            pair[i][1] = profit[i];
        }
        Arrays.sort(pair, (o1, o2) -> o1[0] - o2[0]);
        int result = 0;
        for (int i = 0, j = 0, maxProfit = 0; i < worker.length; ++i) {
            while (j < pair.length && pair[j][0] <= worker[i]) {
                maxProfit = Math.max(maxProfit, pair[j][1]);
                j++;
            }
            result += maxProfit;
        }
        return result;
    }
}
